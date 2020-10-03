package learn.spr.sh4b.hibernatetutor;

import learn.spr.sh4b.hibernatetutor.entity.Student;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            Query<Student> queryAll = session.createQuery("from Student", Student.class);
            printList(queryAll.getResultList(), "All students:");

            Query<Student> queryDuck = session.createQuery("from Student s where s.lastName='Duck'", Student.class);
            printList(queryDuck.getResultList(), "Duck students:");

            Query<Student> queryOr = session.createQuery("from Student s where s.firstName='Mary' "
                    + "OR s.lastName='Snow'", Student.class);
            printList(queryOr.getResultList(), "Mary or Snow complex query students:");

            Query<Student> queryLike = session.createQuery("from Student s where s.firstName LIKE 'J%'", Student.class);
            printList(queryLike.getResultList(), "J-Like query students:");

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }

    private static void printList(List<Student> students, String title) {
        System.out.println(title);
        for (Student st : students) {
            System.out.println(st);
        }
    }
}
