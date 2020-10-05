package learn.spr.sh4b.hb01onetooneuni;

import learn.spr.sh4b.hb01onetooneuni.entity.Instructor;
import learn.spr.sh4b.hb01onetooneuni.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 1L);
            if (instructor != null) {
                System.out.println("Deleting: " + instructor);
                session.delete(instructor);
            }

            session.getTransaction().commit();
        }
    }
}
