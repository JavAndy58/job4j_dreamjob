package ru.job4j.dream.store;

import ru.job4j.dream.model.Post;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PostStore {

    private static final PostStore INST = new PostStore();
    private Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private PostStore() {
        posts.put(1, new Post(1, "Junior Java Job", "Job", LocalDate.now()));
        posts.put(2, new Post(2, "Middle Java Job", "Job", LocalDate.now()));
        posts.put(3, new Post(3, "Senior Java Job", "Job", LocalDate.now()));
    }

    public static PostStore instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public void postsAdd(Post post) {
        posts.put(posts.size() + 1, new Post(posts.size() + 1, post.getName(), post.getDescription(), LocalDate.now()));
    }

    public Post findById(int id) {
        Post returnPost = null;
        Collection<Post> postList = findAll();
        for (Post post : postList) {
            if(post.getId() == id) {
                returnPost = post;
            }
        }
        return returnPost;
    }
}
