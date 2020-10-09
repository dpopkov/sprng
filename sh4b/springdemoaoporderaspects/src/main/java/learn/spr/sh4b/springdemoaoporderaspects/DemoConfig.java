package learn.spr.sh4b.springdemoaoporderaspects;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("learn.spr.sh4b.springdemoaoporderaspects")
public class DemoConfig {
}
