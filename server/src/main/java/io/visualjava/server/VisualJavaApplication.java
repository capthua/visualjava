package io.visualjava.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author CaptHua
 */
@SpringBootApplication(scanBasePackages = "io.visualjava")
public class VisualJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(VisualJavaApplication.class, args);
    }

}
