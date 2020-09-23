package learn.spr.sh4b.springdemo;

public class MyOrdinaryApp {
    public static void main(String[] args) {
        Coach coach = new TrackCoach(new HappyFortuneService());
        System.out.println(coach.getDailyWorkout());
    }
}
