package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;


// BEGIN
@Getter
@AllArgsConstructor
public class PostsPage {
    private final List<Post> posts;
    private int page;
}
// END
