package learn.spr.sh4b.annotationsdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
        Coach coach = context.getBean("tennisCoach", Coach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        Coach coach2 = context.getBean("crossfitCoach", Coach.class);
        System.out.println(coach2.getDailyWorkout());
        System.out.println(coach2.getDailyFortune());
        context.close();
    }
}
