package com.sensetime.study.configurer;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

@Configuration // mybatis的配置类
public class MybatisConfigurer {
	// @Configuration表示该文件是一个配置文件
	// @Bean表示该方法是一个传统xml配置文件中的<Bean id=""></Bean>
	// 其中factory.setTypeAliasesPackage("com.sensetime.study.model")表示项目中model的存储路径；
	// factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));表示mapper.xml存储路径；
	// mapperScannerConfigurer.setBasePackage("com.sensetime.study.dao");表示dao层的存储路径

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
		//DataSource dataSource 会自动从配置文件中加载配置并装载到dataSource中
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(dataSource);
		// 指定包的别名,在该包下都是和数据库表中相对应的实体类
		factory.setTypeAliasesPackage("com.sensetime.study.model");
		// 添加XML目录
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
		return factory.getObject();
	}

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
		mapperScannerConfigurer.setBasePackage("com.sensetime.study.dao");
		return mapperScannerConfigurer;
	}

}
