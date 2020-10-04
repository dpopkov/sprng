package learn.spr.sh4b.hb01onetooneuni;

import learn.spr.sh4b.hb01onetooneuni.entity.Instructor;
import learn.spr.sh4b.hb01onetooneuni.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            Instructor instructor = new Instructor("Jane", "Doe", "jane@example.org");
            InstructorDetail detail = new InstructorDetail("HappyCoder", "DIY");
            instructor.setInstructorDetail(detail);

            session.save(instructor);
            System.out.println("Saved: " + instructor);
            System.out.println("Saved: " + detail);

            session.getTransaction().commit();
        }
    }
}
