/*package com.niit.collab.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.niit.collab.dao.*;
import com.niit.collab.model.*;


@Configuration
@ComponentScan("com.niit.collab")
@EnableTransactionManagement
@EnableWebMvc
public class ApplicationContextConfiguration {
	@Bean(name="dataSource")
	 public DataSource getDataSource(){
	DriverManagerDataSource dataSource=new DriverManagerDataSource();	
	dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	dataSource.setUsername("DEEPTHI");
	dataSource.setPassword("oracle");
	return dataSource;
	}

private Properties getHibernateProperties(){
	Properties properties=new Properties();
	properties.put("hibernate.show_sql", "true");
	properties.put("hibernate.dialect","org.hibernate.dialect.OracleDialect");
	properties.put("hibernate.hbm2ddl.auto", "update");
	return properties;
}

@Autowired
@Bean(name="sessionFactory")
public SessionFactory getSessionFactory(DataSource dataSource){
	LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
	sessionBuilder.addProperties(getHibernateProperties());
	sessionBuilder.addAnnotatedClass(Blog.class);
	sessionBuilder.addAnnotatedClass(Forum.class);
    sessionBuilder.addAnnotatedClass(User.class);
	
	sessionBuilder.addAnnotatedClass(Forum.class);
	sessionBuilder.addAnnotatedClass(Job.class);
	return sessionBuilder.buildSessionFactory();
	
}

@Autowired
@Bean(name="transactionManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
HibernateTransactionManager transactionManager=new 	HibernateTransactionManager(sessionFactory);
return transactionManager;
	
}
@Autowired
@Bean(name="blogDAO")
public BlogDAO getBlogDAO(SessionFactory sessionFactory){
return new BlogImpl(sessionFactory);
}
@Autowired
@Bean(name="forumDAO")
public ForumDAO getForumDAO(SessionFactory sessionFactory){
	
	return new ForumImpl(sessionFactory);
}
@Autowired
@Bean(name="userDAO")
public UserImpl getUserDAO(SessionFactory sessionFactory){
	return new UserImpl(sessionFactory);
}
@Autowired
@Bean(name="eventDAO")
public EventDAO getEventDAO(SessionFactory sessionFactory){
	
	return new EventDAOImpl(sessionFactory);
}

@Autowired
@Bean(name="jobDAO")
public JobDAO getJobDAO(SessionFactory sessionFactory){
	
	return new JobDAOImpl(sessionFactory);
}

}*/