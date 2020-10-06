package learn.spr.sh4b.hb05onetomanyuni;

import learn.spr.sh4b.hb05onetomanyuni.entity.Course;
import learn.spr.sh4b.hb05onetomanyuni.entity.Instructor;
import learn.spr.sh4b.hb05onetomanyuni.entity.InstructorDetail;
import learn.spr.sh4b.hb05onetomanyuni.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetCourseAndReviewsDemo {
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

            long theId = 10;
            Course cs101 = session.get(Course.class, theId);
            System.out.println("Retrieved: " + cs101);
            if (cs101 != null) {
                List<Review> reviews = cs101.getReviews();
                for (Review rv : reviews) {
                    System.out.println(rv);
                }
            }

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
