package learn.spr.sh4b.annotationsdemo;

public class ArcheryCoach implements Coach {
    private final FortuneService fortuneService;

    public ArcheryCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Meditate";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
