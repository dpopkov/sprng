package learn.spr.sh4b.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CricketCoach coach = context.getBean("myCricketCoach", CricketCoach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        System.out.println("EmailAddress: " + coach.getEmailAddress());
        System.out.println("Team: " + coach.getTeam());
        context.close();
    }
}
