package learn.spr.sh4b.annotationsdemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FileRandomFortuneService implements FortuneService {
    private static final String FORTUNES_RESOURCE_FILE_NAME = "/fortunes.txt";

    private final Random random = new Random();
    private final List<String> fortunes = new ArrayList<>();

    public FileRandomFortuneService() {
        System.out.println("FileRandomFortuneService: within default constructor");
    }

    @PostConstruct
    private void loadFortunes() {
        try {
            try (InputStream in = FileRandomFortuneService.class.getResourceAsStream(FORTUNES_RESOURCE_FILE_NAME);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(in))
            ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    fortunes.add(line);
                }
                System.out.println("FileRandomFortuneService: end of method loadFortunes()");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFortune() {
        return fortunes.get(random.nextInt(fortunes.size()));
    }
}
