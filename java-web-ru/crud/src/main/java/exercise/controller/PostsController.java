package exercise.controller;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void index(Context ctx) {
        var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var per = 5;
        var offset = (page - 1) * per;
        var posts = PostRepository.getEntities();
        List<Post> sliceOfPosts;
        try {
            sliceOfPosts = posts.subList(offset, offset + per);
        } catch (IndexOutOfBoundsException e) {
            sliceOfPosts = new ArrayList<>();
        }

        var postPage = new PostsPage(sliceOfPosts, page);
        ctx.render("posts/index.jte", Collections.singletonMap("page", postPage));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
    // END
}
