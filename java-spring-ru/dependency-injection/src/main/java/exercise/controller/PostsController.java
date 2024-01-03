package exercise.controller;

import exercise.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

import exercise.model.Post;
import exercise.repository.PostRepository;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;


    @GetMapping("") // Список страниц
    public List<Post> index() {
        return postRepository.findAll();
    }

    @PostMapping("") // Создание страницы
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
        postRepository.save(post);
        return post;
    }

    @GetMapping("/{id}") // Вывод страницы
    public Optional<Post> show(@PathVariable Long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));;
        return Optional.ofNullable(post);
    }

    @PutMapping("/{id}") // Обновление страницы
    public Post update(@PathVariable Long id, @RequestBody Post data) {
        var maybePage = postRepository.findById(id);
        if (maybePage.isPresent()) {
            var post = maybePage.get();
            post.setTitle(data.getTitle());
            post.setBody(data.getBody());
        }
        return data;
    }

    @DeleteMapping("/{id}") // Удаление страницы
    public void destroy(@PathVariable Long id) {
        postRepository.deleteById(id);

    }
}
// END
