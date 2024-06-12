package lv.raitiss.blog.configuration;

import lv.raitiss.blog.model.Post;
import lv.raitiss.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    private PostService postService;

    @Override
    public void run(String ... args) throws Exception {
        List<Post> posts = postService.getAll();

        if (posts.size() == 0) {
            Post post1 = new Post();
            post1.setTitle("title of post 1");
            post1.setBody("Body of post 1");
            Post post2 = new Post();
            post2.setTitle("title of post 2");
            post2.setBody("Body of post 2. Some more text here");
            Post post3 = new Post();
            post3.setTitle("Third post");
            post3.setBody("You are seeing the text body of the third post.");

            postService.save(post1);
            postService.save(post2);
            postService.save(post3);
        }
    }
}
