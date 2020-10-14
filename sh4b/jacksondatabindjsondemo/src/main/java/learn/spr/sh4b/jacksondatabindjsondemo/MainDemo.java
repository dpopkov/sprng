package learn.spr.sh4b.jacksondatabindjsondemo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class MainDemo {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
            System.out.println("student = " + student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
