package learn.spr.sh4b.annotationsdemo;

public interface FortuneService {
    @SuppressWarnings("SameReturnValue")
    String getFortune();
}
