package ma.fstbm.easyshoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*@Configuration
@ComponentScan(basePackages= {"ma.fstbm.easyshoppingbackend"})
@EnableTransactionManagement
public class ConfigJDBC {	
	
	private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/easyshopping_db";
	private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
	private final static String DATABASE_USERNAME = "root";
	private final static String DATABASE_PASSWORD = "";
	
	
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("ma.fstbm.easyshoppingbackend.domain");
        sessionFactory.setHibernateProperties(hibernateProperties());
 
        return sessionFactory;
    }
 
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(DATABASE_DRIVER);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DATABASE_USERNAME);
        dataSource.setPassword(DATABASE_PASSWORD);
 
        return dataSource;
    }
       
    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
    
    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
      
        hibernateProperties.setProperty( "hibernate.dialect", DATABASE_DIALECT);
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.format_sql", "true");
      
        return hibernateProperties;
    }
    */


@Configuration
@ComponentScan(basePackages={"ma.fstbm.easyshoppingbackend.domain"})
@EnableTransactionManagement
public class AppJDBCConfig {

	// Change the below based on the DBMS you choose
	private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/easyshopping_db";
	private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";
	private final static String DATABASE_USERNAME = "root";
	private final static String DATABASE_PASSWORD = "";
	
	// dataSource bean will be available
	@Bean("dataSource")
	public DataSource getDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		
		// Providing the database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
				
		
		return dataSource;
		
	}
	
	// sessionFactory bean will be available
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("ma.fstbm.easyshoppingbackend.domain");
		
		return builder.buildSessionFactory();
		
	}

	
	
	// All the hibernate properties will be returned in this method	
	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);		
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		properties.put("hibernate.hbm2ddl.auto", "update");
		
		
		return properties;
	}
	
	// transactionManager bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}


}