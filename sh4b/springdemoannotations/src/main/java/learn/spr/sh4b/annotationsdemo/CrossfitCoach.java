package learn.spr.sh4b.annotationsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CrossfitCoach implements Coach {
    private FortuneService fortuneService;

    public CrossfitCoach() {
        System.out.println("CrossfitCoach: within default constructor");
    }

    /*@Autowired
    public CrossfitCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }*/

    @Autowired
    public void anyNonSetterNameMayBeUsedForDependencyInjection(FortuneService fortuneService) {
        System.out.println("CrossfitCoach: within method anyNonSetterNameMayBeUsedForDependencyInjection");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Do 1000 push ups";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
