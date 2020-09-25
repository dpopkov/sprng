package learn.spr.sh4b.annotationsdemo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {
    private final Random random = new Random();
    private final List<String> fortunes = new ArrayList<>();

    public RandomFortuneService() {
        fortunes.add("Believe it or not but today is your lucky day!!!");
        fortunes.add("Diligence is the mother of good luck");
        fortunes.add("The journey is the reward");
    }

    @Override
    public String getFortune() {
        return fortunes.get(random.nextInt(fortunes.size()));
    }
}
