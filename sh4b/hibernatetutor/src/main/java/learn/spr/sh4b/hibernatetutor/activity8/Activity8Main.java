package learn.spr.sh4b.hibernatetutor.activity8;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import java.util.EnumMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Activity8Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        EnumMap<Cmd, Consumer<SessionFactory>> actions = initActions();
        try {
            while (true) {
                Cmd command = chooseCommand();
                if (command == Cmd.EXIT) {
                    break;
                }
                actions.get(command).accept(factory);
            }
        } finally {
            factory.close();
        }
    }

    private static EnumMap<Cmd, Consumer<SessionFactory>> initActions() {
        EnumMap<Cmd, Consumer<SessionFactory>> actions = new EnumMap<>(Cmd.class);
        actions.put(Cmd.SAVE, new Action() {
            @Override
            public void doAction(Session session) {
                Employee employee = new Employee(
                        readString("Enter first name: "),
                        readString("Enter last name: "),
                        readString("Enter company name: "));
                session.save(employee);
            }
        });
        actions.put(Cmd.GET_BY_ID, new Action() {
            @Override
            public void doAction(Session session) {
                long id = readInt("Enter ID: ");
                Employee employee = session.get(Employee.class, id);
                System.out.println("Retrieved: " + employee);
            }
        });
        actions.put(Cmd.GET_BY_COMPANY, new Action() {
            @Override
            public void doAction(Session session) {
                String company = readString("Enter company: ");
                Query<Employee> query =  session.createQuery(
                        "from Employee e where e.company=:company", Employee.class);
                query.setParameter("company", company);
                Employee employee = query.uniqueResult();
                System.out.println("Retrieved: " + employee);
            }
        });
        actions.put(Cmd.DELETE, new Action() {
            @Override
            public void doAction(Session session) {
                long id = readInt("Enter ID to delete: ");
                Employee employee = session.get(Employee.class, id);
                if (employee != null) {
                    session.delete(employee);
                    System.out.println("Deleted: " + employee);
                }
            }
        });
        actions.put(Cmd.LIST, new Action() {
            @Override
            public void doAction(Session session) {
                Query<Employee> query = session.createQuery("from Employee", Employee.class);
                List<Employee> employees = query.getResultList();
                System.out.println("Retrieved employees:");
                for (Employee e : employees) {
                    System.out.println(e);
                }
            }
        });
        return actions;
    }

    private static Cmd chooseCommand() {
        System.out.println(Cmd.SAVE);
        System.out.println(Cmd.GET_BY_ID);
        System.out.println(Cmd.GET_BY_COMPANY);
        System.out.println(Cmd.DELETE);
        System.out.println(Cmd.LIST);
        System.out.println(Cmd.EXIT);
        int id = readInt(" > ");
        return Cmd.findById(id);
    }

    private static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int readInt(String prompt) {
        System.out.print(prompt);
        int i = scanner.nextInt();
        scanner.nextLine();
        return i;
    }
}
