package lv.raitiss.blog.configuration;

import lv.raitiss.blog.model.Account;
import lv.raitiss.blog.model.Post;
import lv.raitiss.blog.service.AccountService;
import lv.raitiss.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Override
    public void run(String ... args) throws Exception {
        List<Post> posts = postService.getAll();

        if (posts.size() == 0) {

            Account account1 = new Account();
            Account account2 = new Account();
            Account account3 = new Account();

            account1.setFirstName("John");
            account1.setLastName("Doe");
            account1.setEmail("a1@mymail.com");

            account2.setFirstName("Bob");
            account2.setLastName("Smith");
            account2.setEmail("a2@mymail.com");


            account3.setFirstName("Richard");
            account3.setLastName("Anderson");
            account3.setEmail("a3@mymail.com");

            accountService.save(account1);
            accountService.save(account2);
            accountService.save(account3);


            Post post1 = new Post();
            post1.setTitle("title of post 1");
            post1.setBody("Body of post 1");
            post1.setAccount(account1);

            Post post2 = new Post();
            post2.setTitle("title of post 2");
            post2.setBody("Body of post 2. Some more text here");
            post2.setAccount(account2);

            Post post3 = new Post();
            post3.setTitle("Third post");
            post3.setBody("You are seeing the text body of the third post.");
            post3.setAccount(account3);

            postService.save(post1);
            postService.save(post2);
            postService.save(post3);
        }
    }
}
