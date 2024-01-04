package exercise.daytime;
import jakarta.annotation.PostConstruct;

public class Night implements Daytime {
    private String name = "night";

    public String getName() {
        return name;
    }

    @PostConstruct
    public void init() {
        this.name = "It is night now! Welcome to Spring!";
        System.out.println(name);
    }
}
