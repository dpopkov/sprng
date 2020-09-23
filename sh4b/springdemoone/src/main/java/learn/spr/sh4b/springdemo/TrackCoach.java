package learn.spr.sh4b.springdemo;

public class TrackCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }
}
