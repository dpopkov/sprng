package learn.spr.sh4b.hibernatetutor;

import learn.spr.sh4b.hibernatetutor.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        long studentId = 3L;
        Student student;
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            student = session.get(Student.class, studentId);
            System.out.println("Retrieved student = " + student);

            System.out.println("Updating student...");
            student.setLastName("Protected");

            session.getTransaction().commit();
        }

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            Student readStudent = session.get(Student.class, studentId);
            System.out.println("Read updated student: " + readStudent);

            session.getTransaction().commit();
        }

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            session.createQuery("update Student s set s.lastName = 'Private' where s.lastName = 'Protected'")
                    .executeUpdate();

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
