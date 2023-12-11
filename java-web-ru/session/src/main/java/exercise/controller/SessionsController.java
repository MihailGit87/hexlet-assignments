package exercise.controller;

import java.util.Collections;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import io.javalin.http.Context;
import org.checkerframework.checker.units.qual.C;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) {
        var user = ctx.sessionAttribute("user");
        var page = new MainPage(user);
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        var page = new LoginPage("", "");
        ctx.render("build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");

        var user = UsersRepository.findByName(name);

        if (user != null && user.getPassword().equals(encrypt(password))) {
            ctx.sessionAttribute("user", user.getName());
            ctx.redirect("/");
        } else {
            var errorMessage = "Wrong username or password";
            var page = new LoginPage(name, errorMessage);
            ctx.render("build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("user", null);
        ctx.redirect("/");
    }
    // END
}
