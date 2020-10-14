package learn.spr.sh4b.springsecuritydemo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "learn.spr.sh4b.springsecuritydemo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

    private final Logger log = LogManager.getLogger();

    /** Spring helper that holds data read from the properties file. */
    @Autowired
    private Environment environment;

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public DataSource securityDataSource() {
        // connection pool
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        // set the jdbc driver class
        try {
            securityDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        // log the connection props
        log.debug(">>> jdbc.url={}", environment.getProperty("jdbc.url"));
        log.debug(">>> jdbc.user={}", environment.getProperty("jdbc.user"));

        // set db connection props
        securityDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        securityDataSource.setUser(environment.getProperty("jdbc.user"));
        securityDataSource.setPassword(environment.getProperty("jdbc.password"));

        // set connection pool props
        securityDataSource.setInitialPoolSize(readIntProperty("connection.pool.initialPoolSize"));
        securityDataSource.setMinPoolSize(readIntProperty("connection.pool.minPoolSize"));
        securityDataSource.setMaxPoolSize(readIntProperty("connection.pool.maxPoolSize"));
        securityDataSource.setMaxIdleTime(readIntProperty("connection.pool.maxIdleTime"));

        return securityDataSource;
    }

    private int readIntProperty(String propertyName) {
        String value = environment.getProperty(propertyName);
        if (value == null) {
            throw new IllegalArgumentException("Cannot read property " + propertyName);
        }
        return Integer.parseInt(value);
    }
}
