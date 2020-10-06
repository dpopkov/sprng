package learn.spr.sh4b.hb04eagervslazydemo;

import learn.spr.sh4b.hb04eagervslazydemo.entity.Course;
import learn.spr.sh4b.hb04eagervslazydemo.entity.Instructor;
import learn.spr.sh4b.hb04eagervslazydemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            // Option #2: query with HQL
            long theId = 1L;
            Query<Instructor> query = session.createQuery("select i from Instructor i "
                    + "join fetch i.courses "
                    + "where i.id = :theId", Instructor.class);
            query.setParameter("theId", theId);
            Instructor instructor = query.getSingleResult();

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
