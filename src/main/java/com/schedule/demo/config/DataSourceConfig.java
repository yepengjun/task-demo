package com.schedule.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;

/**
 * @author xiaolong
 * @description:
 * @date 2022/6/14-11:12 下午
 */
/*@Component
@PropertySource("classpath:application.properties")*/
public class DataSourceConfig {

    @Value("${schedule.datasource.url}")
    private String url;

    @Value("${schedule.datasource.driver}")
    private String drive;

    @Value("${schedule.datasource.username}")
    private String user;

    @Value("${schedule.datasource.password}")
    private String password;

    @Value("${schedule.datasource.maxActive}")
    private Integer maxActive;
    @Value("${schedule.datasource.maxWait}")
    private Long maxWait;


    @Bean(name = "mybatisDataSource")
    public DataSource mybatisDataSource() {

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(drive);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(true);
        dataSource.setTestWhileIdle(true);
        return dataSource;
    }
}
