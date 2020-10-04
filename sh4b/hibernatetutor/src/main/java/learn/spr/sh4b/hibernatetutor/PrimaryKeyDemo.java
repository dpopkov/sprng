package learn.spr.sh4b.hibernatetutor;

import learn.spr.sh4b.hibernatetutor.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class PrimaryKeyDemo {
    /*
    How to change the starting value of the primary key:
    ALTER TABLE student AUTO_INCREMENT=3000;

    How to clear the table and reset the starting value of the primary key:
    TRUNCATE student;
     */
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            Student student1 = new Student("Jane", "Snow", "janesnow@example.org", new Date());
            Student student2 = new Student("Mary", "Public", "mary@example.org", new Date());
            Student student3 = new Student("James", "Private", "james@example.org", new Date());

            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();
            System.out.println("Saved 3 students");
        }
    }
}
