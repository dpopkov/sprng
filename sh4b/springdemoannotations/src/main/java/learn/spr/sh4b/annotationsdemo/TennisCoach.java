package learn.spr.sh4b.annotationsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    @Autowired
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("TennisCoach: within default constructor");
    }

    /*@Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }*/

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
