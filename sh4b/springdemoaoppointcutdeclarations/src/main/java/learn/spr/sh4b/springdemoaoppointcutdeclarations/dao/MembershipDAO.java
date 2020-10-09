package learn.spr.sh4b.springdemoaoppointcutdeclarations.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addMembershipAccount() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
        return true;
    }

    public void goToSleep() {
        System.out.println(getClass() + ": Going to sleep");
    }
}
