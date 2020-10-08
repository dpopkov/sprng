package learn.spr.sh4b.springdemoaop;

import learn.spr.sh4b.springdemoaop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean(AccountDAO.class);

        accountDAO.addAccount();

        System.out.println("Calling accountDAO.addAccount() again...");
        accountDAO.addAccount();

        context.close();
    }
}
