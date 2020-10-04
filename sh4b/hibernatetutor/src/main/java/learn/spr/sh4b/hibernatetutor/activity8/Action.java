package learn.spr.sh4b.hibernatetutor.activity8;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.function.Consumer;

public abstract class Action implements Consumer<SessionFactory> {
    @Override
    public void accept(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            doAction(session);
            session.getTransaction().commit();
        }
    }

    public abstract void doAction(Session session);
}
