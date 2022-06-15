package com.schedule.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.transaction.TransactionDefinition.ISOLATION_DEFAULT;

/**
 * @author xiaolong
 * @description:
 * @date 2022/6/14-11:12 下午
 */
/*
@Component
@MapperScan(basePackages = {DataSourceConstants.SINGLE_MAPPER_PACKAGE}, sqlSessionFactoryRef = "mybatisSqlSessionFactory")
*/
public class SingleSqlSessionFactoryConfig {

/*    @Bean(name = "mybatisTransactionManager")
    public DataSourceTransactionManager mybatisTransactionManager(@Qualifier("mybatisDataSource") DataSource shardingDataSource) {
        return new DataSourceTransactionManager(shardingDataSource);
    }

    @Bean(name = "mybatisSqlSessionFactory")
    public SqlSessionFactory mybatisSqlSessionFactory(@Qualifier("mybatisDataSource") DataSource shardingDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(shardingDataSource);

        Resource[] localMapperResources = new PathMatchingResourcePatternResolver()
                .getResources(DataSourceConstants.SINGLE_MAPPER_LOCATION);

        List<Resource> resourceList = new ArrayList<>(localMapperResources.length);
        resourceList.addAll(Arrays.asList(localMapperResources));

        Resource[] resources = new Resource[resourceList.size()];
        sessionFactory.setMapperLocations(resourceList.toArray(resources));
        return sessionFactory.getObject();
    }

    @Bean(name = "phoenixTransactionTemplate")
    public TransactionTemplate transactionTemplate(@Qualifier("mybatisTransactionManager") DataSourceTransactionManager mybatisTransactionManager) {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setIsolationLevel(ISOLATION_DEFAULT);
        transactionTemplate.setTimeout(10000);
        transactionTemplate.setTransactionManager(mybatisTransactionManager);
        return transactionTemplate;
    }*/
}
