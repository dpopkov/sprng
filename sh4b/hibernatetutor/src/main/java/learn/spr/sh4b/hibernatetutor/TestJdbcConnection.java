package learn.spr.sh4b.hibernatetutor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestJdbcConnection {
    public static void main(String[] args) {
        Properties props = loadProperties();
        String url = props.getProperty("url");
        try (Connection connection = DriverManager.getConnection(url, props)) {
            System.out.println("connection = " + connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Properties loadProperties() {
        Properties props = new Properties();
        try {
            props.load(TestJdbcConnection.class.getResourceAsStream("/db.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props;
    }
}
