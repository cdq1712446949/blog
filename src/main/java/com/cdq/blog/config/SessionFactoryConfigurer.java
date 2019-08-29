package com.cdq.blog.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * 代替ssm框架中dao层配置文件
 * @author cdq
 * created on 2019.08.19
 */
@Configuration
public class SessionFactoryConfigurer {

    //mybatis配置文件
    @Value("${mybatisConfigFile}")
    private String mybatisConfigFile="mybatis-config.xml";
    //mapper文件所在路径
    @Value("${mappserPath}")
    private String mappserPath="/mapper/*.xml";
    //model类所在包名
    @Value("${mybatis.type-aliases-package}")
    private String typeAliasPackage;
    //注入dataSource实体类
    @Autowired
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSessionFactory(){
        //创建实例
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        //配置dataSource
        sqlSessionFactory.setDataSource(dataSource);
        //配置mybatis配置文件
        sqlSessionFactory.setConfigLocation(new ClassPathResource(mybatisConfigFile));
        //配置mapper文件
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver=new PathMatchingResourcePatternResolver();
        String packageSearchPath=ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX+mappserPath;
        try {
            sqlSessionFactory.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //配置model类扫描路径
        sqlSessionFactory.setTypeAliasesPackage(typeAliasPackage);
        return sqlSessionFactory;
    }

}
