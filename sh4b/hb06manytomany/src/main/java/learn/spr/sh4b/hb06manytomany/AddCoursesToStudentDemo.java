package learn.spr.sh4b.hb06manytomany;

import learn.spr.sh4b.hb06manytomany.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesToStudentDemo {
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

            Student jane = session.get(Student.class, 1L);
            System.out.println("Retrieved: " + jane);
            Course js301 = new Course("JS301");
            Course py401 = new Course("PY401");
            js301.addStudent(jane);
            py401.addStudent(jane);
            System.out.println("Saving courses...");
            session.save(js301);
            session.save(py401);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
