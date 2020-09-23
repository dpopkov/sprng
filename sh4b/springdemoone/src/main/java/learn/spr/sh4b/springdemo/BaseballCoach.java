package learn.spr.sh4b.springdemo;

public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }
}
