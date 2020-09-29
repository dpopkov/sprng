package learn.spr.sh4b.annotationsdemo;

public class ArcheryFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Never miss";
    }
}
