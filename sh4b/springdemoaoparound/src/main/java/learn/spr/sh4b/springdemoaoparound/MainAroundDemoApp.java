package learn.spr.sh4b.springdemoaoparound;

import learn.spr.sh4b.springdemoaoparound.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class MainAroundDemoApp {
    private static final Logger log = Logger.getLogger(MainAroundDemoApp.class.getName());
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService service = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        log.info("\nMain Program: MainAroundDemoApp");
        log.info("Calling getFortune");

        String data = service.getFortune();
        log.info("My fortune is: " + data);
        log.info("Finished");

        context.close();
    }
}
