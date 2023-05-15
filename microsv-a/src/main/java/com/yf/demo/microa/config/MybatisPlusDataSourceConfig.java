package com.yf.demo.microa.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @Description
 * @Author yvan
 * @CreateDate 2023/5/4 12:45
 */
@Configuration
@MapperScan(basePackages = MybatisPlusDataSourceConfig.PACKAGE_DAO, sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisPlusDataSourceConfig {

    // dao层所在路径
    static final String PACKAGE_DAO = "com.yf.demo.microa.business.mapper";
    // *mapper.xml文件所在路径
    static final String MAPPER_LOCATION = "classpath*:mybatis/mapper/*.xml";

    //Mybatis 插件扩展
    //@Autowired
    //private MybatisPlusConfig plusConfig;

    @Bean("dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        final MybatisSqlSessionFactoryBean sessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);

        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);
        configuration.setLogImpl(StdOutImpl.class);

        //sessionFactoryBean.setPlugins(new Interceptor[]{plusConfig.paginationInterceptor()}); //Mybatis 插件扩展
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MybatisPlusDataSourceConfig.MAPPER_LOCATION));
        return sessionFactoryBean.getObject();
    }
}
