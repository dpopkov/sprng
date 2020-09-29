package learn.spr.sh4b.annotationsdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArcheryConfig {
    @Bean
    public FortuneService fortuneService() {
        return new ArcheryFortuneService();
    }

    @Bean
    public Coach archeryCoach() {
        return new ArcheryCoach(fortuneService());
    }
}
