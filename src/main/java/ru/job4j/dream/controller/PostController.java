package ru.job4j.dream.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.store.PostStore;
import java.time.LocalDate;

@Controller
public class PostController {

    private PostStore postStore = PostStore.instOf();

    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("posts", postStore.findAll());
        return "posts";
    }

    @GetMapping("/addPost")
    public String addPost(Model model) {
        model.addAttribute("post", new Post(0, "Заполните поле", "Заполните поле", LocalDate.now()));
        return "addPost";
    }

    @GetMapping("/formAddPost")
    public String formAddPost(Model model) {
        return "addPost";
    }

    @PostMapping("/savePost")
    public String savePost(@ModelAttribute Post post) {
        postStore.postsAdd(post);
        return "redirect:/posts";
    }

    @GetMapping("/formUpdatePost/{postId}")
    public String formUpdatePost(Model model, @PathVariable("postId") int id) {
        model.addAttribute("post", postStore.findById(id));
        return "updatePost";
    }
}
