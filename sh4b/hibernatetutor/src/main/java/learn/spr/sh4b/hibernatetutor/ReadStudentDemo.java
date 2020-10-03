package learn.spr.sh4b.hibernatetutor;

import learn.spr.sh4b.hibernatetutor.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Student savedStudent;
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            savedStudent = new Student("Daffy", "Duck", "daffy2@example.org");
            session.save(savedStudent);

            session.getTransaction().commit();
        }
        System.out.println("Saved student: " + savedStudent);

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            Student readStudent = session.get(Student.class, savedStudent.getId());
            System.out.println("Read student: " + readStudent);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
