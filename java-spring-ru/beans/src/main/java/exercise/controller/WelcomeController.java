package exercise.controller;

import exercise.daytime.Daytime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

// BEGIN
@RestController
public class WelcomeController {

    @Autowired
    private Daytime daytime;

    @GetMapping("/welcome")
    public String getGreeting() {
        return "It is " + daytime.getName() + " now! Welcome to Spring!";
    }
}
// END
