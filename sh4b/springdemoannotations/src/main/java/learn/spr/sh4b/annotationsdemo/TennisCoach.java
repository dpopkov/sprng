package learn.spr.sh4b.annotationsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("TennisCoach: within default constructor");
    }

    /*@Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }*/

    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("TennisCoach: inside method doMyStartupStuff()");
    }

    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("TennisCoach: inside method doMyCleanupStuff()");
    }

    /*@Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("TennisCoach: within method setFortuneService");
        this.fortuneService = fortuneService;
    }*/

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
