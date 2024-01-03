package exercise.controller;

import exercise.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("") // Список страниц
    public List<Comment> index() {
        return commentRepository.findAll();
    }

    @PostMapping("") // Создание страницы
    @ResponseStatus(HttpStatus.CREATED)
    public Comment create(@RequestBody Comment comment) {
        commentRepository.save(comment);
        return comment;
    }

    @GetMapping("/{id}") // Вывод страницы
    public Optional<Comment> show(@PathVariable Long id) {
        var post = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + " not found"));;
        return Optional.ofNullable(post);
    }

    @PutMapping("/{id}") // Обновление страницы
    public Comment update(@PathVariable Long id, @RequestBody Comment data) {
        var maybePage = commentRepository.findById(id);
        if (maybePage.isPresent()) {
            var post = maybePage.get();
            post.setBody(data.getBody());
        }
        return data;
    }

    @DeleteMapping("/{id}") // Удаление страницы
    public void destroy(@PathVariable Long id) {
        commentRepository.deleteAll();
    }
}
// END
