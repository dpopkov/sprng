package learn.spr.sh4b.annotationsdemo;

import org.springframework.stereotype.Component;

@Component
public class CrossfitCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Do 1000 push ups";
    }
}
