package learn.spr.sh4b.hibernatetutor;

import learn.spr.sh4b.hibernatetutor.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        long studentId = 5L;
        Student student;
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            student = session.get(Student.class, studentId);
            System.out.println("Retrieved student = " + student);

            if (student != null) {
                System.out.println("Deleting student...");
                session.delete(student);
                student.setLastName("Student deleted");
            }

            session.getTransaction().commit();
        }

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            Student readStudent = session.get(Student.class, studentId);
            System.out.println("Read deleted student: " + readStudent);

            session.getTransaction().commit();
        }

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            System.out.println("Deleting students using HQL");
            session.createQuery("delete from Student where id = 4")
                .executeUpdate();

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
