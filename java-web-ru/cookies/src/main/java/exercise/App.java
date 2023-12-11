package exercise;

import exercise.model.User;
import io.javalin.Javalin;
import exercise.controller.UsersController;
import exercise.util.NamedRoutes;


public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get(NamedRoutes.rootPath(), ctx -> ctx.render("layout/page.jte"));
        app.post(NamedRoutes.usersPath(), UsersController::create);
        app.get(NamedRoutes.buildUserPath(), UsersController::build);
        // END

        app.get(NamedRoutes.userPath("{id}"), UsersController::show);
        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
