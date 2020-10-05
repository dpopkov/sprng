package learn.spr.sh4b.hb02onetoonebi;

import learn.spr.sh4b.hb02onetoonebi.entity.Instructor;
import learn.spr.sh4b.hb02onetoonebi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, 2L);
            System.out.println("Retrieved: " + instructorDetail);
            if (instructorDetail != null) {
                System.out.println("Retrieved: " + instructorDetail.getInstructor());
            }

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
