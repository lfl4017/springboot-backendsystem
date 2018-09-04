package com.sensetime.study.configurer;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DruidDataSourceConfigurer {

	private static final Logger log = LoggerFactory.getLogger(DruidDataSourceConfigurer.class);

	@Bean(name = "primaryDataSource")
	// 需设置主数据源
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		// 跟之前不一样了
		return new DruidDataSource();
	}

}
