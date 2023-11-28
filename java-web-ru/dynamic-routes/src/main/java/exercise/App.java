package exercise;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {
            var companyId = ctx.pathParamAsClass("id", String.class).get();
            var size = COMPANIES.size();
            Map<String, String> result = new HashMap<>();
            for (int i = 0; i < size; i++) {
                for (var company: COMPANIES.get(i).entrySet()) {
                    if (company.getKey().equals("id") & company.getValue().equals(companyId)) {
                        result.putAll(COMPANIES.get(i));
                    }
                }
            }
            if (result.isEmpty()) {
                throw new NotFoundResponse("Company not found");
            }
            ctx.json(result);
        });


        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
