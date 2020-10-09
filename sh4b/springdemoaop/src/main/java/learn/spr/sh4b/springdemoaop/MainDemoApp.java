package learn.spr.sh4b.springdemoaop;

import learn.spr.sh4b.springdemoaop.dao.AccountDAO;
import learn.spr.sh4b.springdemoaop.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean(AccountDAO.class);
        accountDAO.addAccount(new Account(), true);

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        membershipDAO.addMembershipAccount();

        context.close();
    }
}
