package learn.spr.sh4b.springdemoaopafterreturning.dao;

import learn.spr.sh4b.springdemoaopafterreturning.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    public List<Account> findAccounts() {
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("John", "Silver"));
        accounts.add(new Account("Jane", "Draper"));
        accounts.add(new Account("Bobby", "Doe"));
        return accounts;
    }
}
