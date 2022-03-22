package ru.job4j.dream.persistence;

import org.springframework.stereotype.Repository;
import ru.job4j.dream.model.Post;
import java.time.LocalDate;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostStore {

    private AtomicInteger ids = new AtomicInteger(3);
//    private Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, Post> posts = new ConcurrentHashMap<>();

    private PostStore() {
        posts.put(1, new Post(1, "Junior Java Job", "Job", LocalDate.now()));
        posts.put(2, new Post(2, "Middle Java Job", "Job", LocalDate.now()));
        posts.put(3, new Post(3, "Senior Java Job", "Job", LocalDate.now()));
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public void create(Post post) {
        post.setId(ids.incrementAndGet());
        posts.put(post.getId(), post);
    }

    public void update(Post post) {
        posts.put(post.getId(), new Post(post.getId(), post.getName(), post.getDescription(), LocalDate.now()));
    }

    public Post findById(int id) {
        Post returnPost = null;
        Collection<Post> postList = findAll();
        for (Post post : postList) {
            if (post.getId() == id) {
                returnPost = post;
            }
        }
        return returnPost;
    }
}
