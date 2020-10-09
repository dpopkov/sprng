package learn.spr.sh4b.springdemoaoppointcutdeclarations.dao;

import learn.spr.sh4b.springdemoaoppointcutdeclarations.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public void doWork() {
        System.out.println(getClass() + ": DOING MY WORK");
    }
}
