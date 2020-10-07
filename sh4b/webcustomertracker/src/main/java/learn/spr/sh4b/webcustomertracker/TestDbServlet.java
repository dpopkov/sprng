package learn.spr.sh4b.webcustomertracker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter writer = resp.getWriter();
        writer.append("Served at: ").append(req.getContextPath()).append("\n");
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String user = "sh4bstudent";
        String pass = "sh4b_Student";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, user, pass)) {
            writer.append("Connection: ").append(connection.toString()).append("\n");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) from customer");
            if (rs.next()) {
                int count = rs.getInt(1);
                writer.append("count(*) from customer = ").append(String.valueOf(count));
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
