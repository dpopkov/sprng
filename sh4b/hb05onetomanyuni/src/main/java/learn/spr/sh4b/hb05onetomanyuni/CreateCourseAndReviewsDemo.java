package learn.spr.sh4b.hb05onetomanyuni;

import learn.spr.sh4b.hb05onetomanyuni.entity.Course;
import learn.spr.sh4b.hb05onetomanyuni.entity.Instructor;
import learn.spr.sh4b.hb05onetomanyuni.entity.InstructorDetail;
import learn.spr.sh4b.hb05onetomanyuni.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            Course cs101 = new Course("CS101");
            cs101.add(new Review("This course is great!"));
            cs101.add(new Review("This course sucks!"));
            cs101.add(new Review("I'm not sure"));
            session.save(cs101);
            System.out.println("Saved: " + cs101);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
