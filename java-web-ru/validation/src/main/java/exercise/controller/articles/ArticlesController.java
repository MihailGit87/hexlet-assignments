package exercise.controller.articles;

import exercise.dto.articles.BuildArticlePage;
import exercise.model.Article;
import exercise.repository.ArticleRepository;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import io.javalin.validation.ValidationException;
import io.javalin.validation.Validator;

import java.util.Collections;

public class ArticlesController {

    private static final int MIN_TITLE_LENGTH = 2;
    private static final int MIN_CONTENT_LENGTH = 10;

    public static void build(Context ctx) {
        var page = new BuildArticlePage();
        ctx.render("articles/build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        var title = ctx.formParamAsClass("title", String.class);
        var content = ctx.formParamAsClass("content", String.class);

        try {
            title.check(item -> item.length() >= ArticlesController.MIN_TITLE_LENGTH,
                            "Название не должно быть короче двух символов")
                    .check(item -> !ArticleRepository.existsByTitle(item),
                            "Статья с таким названием уже существует");

            content.check(item -> item.length() >= ArticlesController.MIN_CONTENT_LENGTH,
                    "Статья должна быть не короче 10 символов");

            Article article = new Article(title.get(), content.get());
            ArticleRepository.save(article);

            ctx.redirect("/articles");
        } catch (ValidationException error) {
            var _title = ctx.formParam("title");
            var _content = ctx.formParam("content");
            var page = new BuildArticlePage(_title, _content, error.getErrors());

            ctx.status(HttpStatus.UNPROCESSABLE_CONTENT);
            ctx.render("articles/build.jte", Collections.singletonMap("page", page));
        }
    }
}