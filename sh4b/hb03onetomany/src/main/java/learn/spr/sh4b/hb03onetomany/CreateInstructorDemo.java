package learn.spr.sh4b.hb03onetomany;

import learn.spr.sh4b.hb03onetomany.entity.Course;
import learn.spr.sh4b.hb03onetomany.entity.Instructor;
import learn.spr.sh4b.hb03onetomany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            Instructor instructor = new Instructor("James", "Protected", "games@example.org");
            InstructorDetail detail = new InstructorDetail("First Programmer", "Cats");
            instructor.setInstructorDetail(detail);
            session.save(instructor);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
