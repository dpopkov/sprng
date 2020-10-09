package learn.spr.sh4b.springdemoaoppointcutdeclarations;

import learn.spr.sh4b.springdemoaoppointcutdeclarations.dao.AccountDAO;
import learn.spr.sh4b.springdemoaoppointcutdeclarations.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean(AccountDAO.class);
        accountDAO.addAccount(new Account(), true);
        accountDAO.doWork();

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        membershipDAO.addMembershipAccount();
        membershipDAO.goToSleep();

        context.close();
    }
}
