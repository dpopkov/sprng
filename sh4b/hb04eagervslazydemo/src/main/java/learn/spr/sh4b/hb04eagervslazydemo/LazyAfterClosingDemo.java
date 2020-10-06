package learn.spr.sh4b.hb04eagervslazydemo;

import learn.spr.sh4b.hb04eagervslazydemo.entity.Course;
import learn.spr.sh4b.hb04eagervslazydemo.entity.Instructor;
import learn.spr.sh4b.hb04eagervslazydemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LazyAfterClosingDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 1L);
            // Option 1: get all entities before closing session:
            System.out.println("Instructor before closing: " + instructor);
            System.out.println("Called session.get(...)");

            System.out.println("\nCommitting transaction and closing session");
            session.getTransaction().commit();
            session.close();
            System.out.println("Session closed.\n");

            System.out.println("Instructor after closing: " + instructor);
            for (Course c : instructor.getCourses()) {
                System.out.println(c);
            }

        } finally {
            factory.close();
        }
    }
}
