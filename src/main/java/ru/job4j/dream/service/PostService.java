package ru.job4j.dream.service;

import org.springframework.stereotype.Service;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.store.PostDBStore;
import ru.job4j.dream.store.PostStore;
import java.util.Collection;

@Service
public class PostService {

    private final PostDBStore store;

    public PostService(PostDBStore store) {
        this.store = store;
    }

    public Collection<Post> findAll() {
        return store.findAll();
    }

    public void create(Post post) {
        store.add(post);
    }

    public void update(Post post) {
        store.update(post);
    }

    public Post findById(int id) {
        return store.findById(id);
    }
}
