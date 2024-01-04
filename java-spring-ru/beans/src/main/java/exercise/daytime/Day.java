package exercise.daytime;
import jakarta.annotation.PostConstruct;

public class Day implements Daytime {
    private String name = "day";

    public String getName() {
        return name;
    }

    // BEGIN
    @PostConstruct
    public void init() {
        this.name = "It is day now! Welcome to Spring!";
        System.out.println(name);
    }
    // END
}
