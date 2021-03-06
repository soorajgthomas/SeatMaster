package com.ibsplc.configuration.hibernate;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.ibsplc.*", "com.ibsplc.entities.*" })
@PropertySource({ "classpath:properties/dataSource.properties", "classpath:properties/hibernate.properties" })
public class HibernateConfiguration {

	@Value("${dataSource.driverClass}")
	private String driverClassName;
	@Value("${dataSource.url}")
	private String url;
	@Value("${dataSource.hostname}")
	private String hostName;
	@Value("${dataSource.portNumber}")
	private String portNumber;
	@Value("${dataSource.database}")
	private String databaseName;
	@Value("${dataSource.extraParam}")
	private String extraPram;
	@Value("${dataSource.username}")
	private String userName;
	@Value("${dataSource.password}")
	private String userPwd;

	/* Hibenate properties */
	@Value("${hibernate.dialect}")
	private String hibernateDialect;
	@Value("${hibernate.hbm2ddl.auto}")
	private String hibernateHbmDdlAuto;
	@Value("${hibernate.max_fetch_depth}")
	private String hibernateMaxFetchDepth;
	@Value("${hibernate.batch_size}")
	private String hibernateBatchSize;
	@Value("${hibernate.jdbc.use_scrollable_resultset}")
	private String hibernateScrollableResultSet;
	@Value("${hibernate.generate_statistics}")
	private String hibernateGenerateStatistics;
	@Value("${hibernate.format_sql}")
	private String hibernateFormatSql;
	@Value("${hibernate.show_sql}")
	private String hibernateShowSql;

	@Bean(name = "sessionFactory")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.ibsplc.*" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url + hostName + portNumber + databaseName + extraPram);
		dataSource.setUsername(userName);
		dataSource.setPassword(userPwd);
		//DatabasePopulatorUtils.execute(createDatabasePopulator(), dataSource);
		return dataSource;
	}


	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", hibernateDialect);
		properties.put("hibernate.hbm2ddl.auto", hibernateHbmDdlAuto);
		properties.put("hibernate.show_sql", hibernateShowSql);
		properties.put("hibernate.format_sql", hibernateFormatSql);
		return properties;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}

}
