package learn.spr.sh4b.springbootdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String hello() {
        return "Hello World! Current time on server is " + LocalDateTime.now();
    }
}
