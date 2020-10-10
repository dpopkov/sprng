package learn.spr.sh4b.springdemoaopafterreturning;

import learn.spr.sh4b.springdemoaopafterreturning.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainAfterReturningDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean(AccountDAO.class);

        List<Account> accounts = accountDAO.findAccounts();
        System.out.println("\nMain Program: MainAfterReturningDemoApp");
        System.out.println("----------------");
        System.out.println(accounts);

        context.close();
    }
}
