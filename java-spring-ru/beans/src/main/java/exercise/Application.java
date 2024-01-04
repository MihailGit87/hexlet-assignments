package exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

import exercise.daytime.Daytime;
import exercise.daytime.Day;
import exercise.daytime.Night;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.RequestScope;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @Bean
    @RequestScope
    public Daytime getName() {
        int hour = LocalDateTime.now().getHour();
        System.out.println("Datetime now = " + hour);
        if (hour >=6 && hour <= 12) {
            return new Day();
        }
        else return new Night();
    }
    // END
}
