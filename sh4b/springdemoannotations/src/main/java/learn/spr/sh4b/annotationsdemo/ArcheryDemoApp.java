package learn.spr.sh4b.annotationsdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ArcheryDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ArcheryConfig.class);
        Coach coach = context.getBean("archeryCoach", Coach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        context.close();
    }
}
