package com.cdq.blog.config;

import com.cdq.blog.unit.EncryptionUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * 代替ssm框架中dao层配置文件
 * @author cdq
 * created on 2019.08.19
 */

@Configuration
//给出需要扫描Dao接口包
@MapperScan("com.cdq.blog.dao")
public class DataSouceConfigurer {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.data-username}")
    private String username;
    @Value("${spring.datasource.data-password}")
    private String password;

    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource(){
        //生成dataSource实例
        ComboPooledDataSource datasource=new ComboPooledDataSource();
        //添加配置信息
        try {
            datasource.setDriverClass(driver);
        } catch (PropertyVetoException e) {
            System.out.println("加载驱动失败，错误信息如下:"+e.getMessage());
        }
        datasource.setJdbcUrl(url);
        datasource.setUser(EncryptionUtil.getDecryptStr(username));
        datasource.setPassword(EncryptionUtil.getDecryptStr(password));
        //配置c3p0配置信息
        //连接池最大连接数
        datasource.setMaxPoolSize(30);
        //连接池最小连接数
        datasource.setMinPoolSize(0);
        //连接超时时间
        datasource.setCheckoutTimeout(5000);
        //关闭连接后不自动commit
        datasource.setAutoCommitOnClose(false);
        //连接失败重连次数
        datasource.setAcquireRetryAttempts(2);
        return datasource;
    }

}
