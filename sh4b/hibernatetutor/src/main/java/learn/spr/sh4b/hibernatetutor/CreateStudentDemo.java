package learn.spr.sh4b.hibernatetutor;

import learn.spr.sh4b.hibernatetutor.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        try (Session session = factory.getCurrentSession()) {
            Student student = new Student("Jane", "Dow", "jane@example.org", new Date());
            session.beginTransaction();
            session.save(student);
            System.out.println("Saved student.getId() = " + student.getId());
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
