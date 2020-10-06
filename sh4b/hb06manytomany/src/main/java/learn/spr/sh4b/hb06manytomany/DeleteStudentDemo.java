package learn.spr.sh4b.hb06manytomany;

import learn.spr.sh4b.hb06manytomany.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            Student jane = session.get(Student.class, 1L);
            System.out.println("Deleting: " + jane);
            session.delete(jane);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
