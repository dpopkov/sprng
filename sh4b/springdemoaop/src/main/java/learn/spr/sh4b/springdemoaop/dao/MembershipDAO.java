package learn.spr.sh4b.springdemoaop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addMembershipAccount() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
        return true;
    }
}
