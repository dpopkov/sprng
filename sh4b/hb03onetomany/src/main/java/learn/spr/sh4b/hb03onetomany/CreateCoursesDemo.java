package learn.spr.sh4b.hb03onetomany;

import learn.spr.sh4b.hb03onetomany.entity.Course;
import learn.spr.sh4b.hb03onetomany.entity.Instructor;
import learn.spr.sh4b.hb03onetomany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {
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
            System.out.println("Retrieved: " + instructor);
            Course cs101 = new Course("CS101");
            Course alg201 = new Course("ALG201");
            instructor.add(cs101);
            instructor.add(alg201);
            session.save(cs101);
            session.save(alg201);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
