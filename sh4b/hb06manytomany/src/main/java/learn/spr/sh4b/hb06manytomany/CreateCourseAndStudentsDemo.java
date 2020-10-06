package learn.spr.sh4b.hb06manytomany;

import learn.spr.sh4b.hb06manytomany.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {
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

            Course cs101 = new Course("CS101");
            session.save(cs101);
            System.out.println("Saved: " + cs101);

            Student jane = new Student("Jane", "Snow", "jsnow@example.org");
            Student mary = new Student("Mary", "Public", "mary@example.org");
            cs101.addStudent(jane);
            cs101.addStudent(mary);

            session.save(jane);
            session.save(mary);
            System.out.println("Saved: " + cs101.getStudents());

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
