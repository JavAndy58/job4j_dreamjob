package ru.job4j.dream.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.store.PostStore;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
public class PostController {

    private final PostStore postStore = PostStore.instOf();

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
    public String savePost(HttpServletRequest req) {
        String name = req.getParameter("name");
        System.out.println(name);
        postService.add(new Post(1, name));
        return "redirect:/posts";
    }
}
