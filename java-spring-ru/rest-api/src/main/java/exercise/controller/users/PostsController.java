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

    @GetMapping("/users/{userId}/posts")
    public List<Post> show(@PathVariable Integer userId) {
        return posts.stream()
                .filter(p -> p.getUserId() == userId)
                .toList();
    }

    @PostMapping("/users/{userId}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@PathVariable Integer userId, @RequestBody Post post) {
        post.setUserId(userId);
        posts.add(post);
        return post;
    }
}
// END
