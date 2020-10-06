package learn.spr.sh4b.hb06manytomany;

import learn.spr.sh4b.hb06manytomany.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
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

            long courseId = 10L;
            Course course = session.get(Course.class, courseId);
            System.out.println("Deleting: " + course);
            session.delete(course);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
