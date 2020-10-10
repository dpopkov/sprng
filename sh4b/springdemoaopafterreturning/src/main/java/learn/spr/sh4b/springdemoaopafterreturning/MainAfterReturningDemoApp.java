package learn.spr.sh4b.springdemoaopafterreturning;

import learn.spr.sh4b.springdemoaopafterreturning.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainAfterReturningDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean(AccountDAO.class);

        try {
            final boolean tripWire = true;
            List<Account> accounts = accountDAO.findAccounts(tripWire);
            System.out.println("\nMain Program: MainAfterReturningDemoApp");
            System.out.println("----------------");
            System.out.println(accounts);
        } catch (Exception exc) {
            System.out.println("\n\nMain Program caught exception: " + exc);
        } finally {
            System.out.println("\nMain Program block finally.");
        }

        context.close();
    }
}
