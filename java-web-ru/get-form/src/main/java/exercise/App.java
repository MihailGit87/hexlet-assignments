package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import java.util.Collections;
import org.apache.commons.lang3.StringUtils;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var firstName = ctx.queryParam("term");
            List<User> filtredUser = null;
            // Фильтруем, только если была отправлена форма
            if (firstName != null) {
                filtredUser = USERS.stream()
                        .filter(e -> StringUtils.startsWithIgnoreCase(e.getFirstName(), firstName))
                        .toList();
            }

            var page = new UsersPage(filtredUser == null ? USERS : filtredUser, firstName);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
