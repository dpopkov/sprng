package learn.spr.sh4b.springdemo;

public class MyOrdinaryApp {
    public static void main(String[] args) {
        Coach coach = new TrackCoach();
        System.out.println(coach.getDailyWorkout());
    }
}
