package learn.spr.sh4b.hb02onetoonebi;

import learn.spr.sh4b.hb02onetoonebi.entity.Instructor;
import learn.spr.sh4b.hb02onetoonebi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailOnlyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, 3L);
            System.out.println("Retrieved: " + instructorDetail);
            System.out.println("Retrieved: " + instructorDetail.getInstructor());
            System.out.println("Deleting: " + instructorDetail);
            instructorDetail.getInstructor().setInstructorDetail(null);
            session.delete(instructorDetail);

            session.getTransaction().commit();
        }
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            System.out.println("Try to get Instructor...");
            Instructor instructor = session.get(Instructor.class, 3L);
            System.out.println("Retrieved: " + instructor);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
