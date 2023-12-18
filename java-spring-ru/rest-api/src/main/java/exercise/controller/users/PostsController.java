package exercise.controller.users;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {
    List<Post> posts = Data.getPosts();

    @GetMapping("/users/{id}/posts")
    public Optional<Post> show(@PathVariable String id) {
        var post = posts.stream()
                .filter(p -> p.getSlug().equals(id))
                .findFirst();
        return post;
    }

    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
        Post post1 = new Post();
        post1.setUserId(post.getUserId());
        post1.setSlug(post.getSlug());
        post1.setBody(post.getBody());
        post1.setTitle(post.getTitle());
        posts.add(post1);
        return post1;
    }
}
// END
