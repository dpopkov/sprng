package learn.spr.sh4b.springdemoaoparound;

import learn.spr.sh4b.springdemoaoparound.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAroundDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService service = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\nMain Program: MainAroundDemoApp");
        System.out.println("Calling getFortune");

        String data = service.getFortune();
        System.out.println("My fortune is: " + data);
        System.out.println("Finished");

        context.close();
    }
}
