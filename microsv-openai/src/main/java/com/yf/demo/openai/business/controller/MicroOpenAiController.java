package com.yf.demo.openai.business.controller;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author yvan
 * @CreateDate 2022/11/15 17:05
 */
@RestController
@RequestMapping("/microsv/openai")
public class MicroOpenAiController {

    private static Logger logger = LoggerFactory.getLogger(MicroOpenAiController.class);

    @GetMapping("/chat/{content}")
    public void chat(@PathVariable("content") String content) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json;charset=UTF-8");

        JSONObject json = new JSONObject();
        //选择模型
        json.put("model", "text-davinci-003");
        //添加我们需要输入的内容
        json.put("prompt",content);
        json.put("temperature", 0.9);
        json.put("max_tokens", 2048);
        json.put("top_p", 1);
        json.put("frequency_penalty", 0.0);
        json.put("presence_penalty", 0.6);

        HttpResponse response = HttpRequest.post("https://api.openai.com/v1/completions")
                .headerMap(headers, false)
                .bearerAuth("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")
                .body(String.valueOf(json))
                .timeout(5 * 60 * 1000)
                .execute();

        System.out.println(response.body());
    }

    @GetMapping("/image")
    public void imageGeneration() {
        String apiKey = "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"; // 替换为你的 OpenAI API 密钥
        String model = "davinci"; // 可以根据你的需求选择其他模型，如 "curie" 或 "babbage"
        String prompt = "A beautiful sunset over the mountains"; // 图片生成的提示语句

        try {
            String apiUrl = "https://api.openai.com/v1/images";
            URL url = new URL(apiUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "Bearer " + apiKey);
            conn.setDoOutput(true);

            String requestBody = "{\"model\": \"" + model + "\", \"prompt\": \"" + prompt + "\"}";
            OutputStream os = conn.getOutputStream();
            os.write(requestBody.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String response;
            while ((response = br.readLine()) != null) {
                System.out.println(response);
                // 在这里处理 API 响应，你可以解析 JSON 数据并提取生成的图片 URL 等信息
            }

            conn.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
