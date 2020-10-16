package learn.spr.sh4b.springcrmrest.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("learn.spr.sh4b.springcrmrest")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
    private final Logger log = LogManager.getLogger();

    /** Spring helper that holds data read from the properties file. */
    @Autowired
    private Environment environment;

    @Bean
    public DataSource myDataSource() {
        // connection pool
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        // set the jdbc driver class
        try {
            dataSource.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        String url = environment.getProperty("jdbc.url");
        String user = environment.getProperty("jdbc.user");
        log.debug(">>> jdbc.url={}", url);
        log.debug(">>> jdbc.user={}", user);

        // set db connection props
        dataSource.setJdbcUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(environment.getProperty("jdbc.password"));

        // set connection pool props
        dataSource.setInitialPoolSize(readIntProperty("connection.pool.initialPoolSize"));
        dataSource.setMinPoolSize(readIntProperty("connection.pool.minPoolSize"));
        dataSource.setMaxPoolSize(readIntProperty("connection.pool.maxPoolSize"));
        dataSource.setMaxIdleTime(readIntProperty("connection.pool.maxIdleTime"));

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(myDataSource());
        sessionFactory.setPackagesToScan(environment.getProperty("hibernate.packagesToScan"));
        sessionFactory.setHibernateProperties(getHibernateProperties());
        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

    private Properties getHibernateProperties() {
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        props.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        return props;
    }

    private int readIntProperty(String propertyName) {
        String value = environment.getProperty(propertyName);
        if (value == null) {
            throw new IllegalArgumentException("Cannot read property " + propertyName);
        }
        return Integer.parseInt(value);
    }
}
