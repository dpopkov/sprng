package learn.spr.sh4b.annotationsdemo;

public interface Coach {
    @SuppressWarnings("SameReturnValue")
    String getDailyWorkout();

    String getDailyFortune();
}
