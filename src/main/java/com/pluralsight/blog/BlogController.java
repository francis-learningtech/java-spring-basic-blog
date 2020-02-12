package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogController {

    private PostRepository postRepository;

    public BlogController(PostRepository postRepo){
        this.postRepository=postRepo;
    }

    @RequestMapping("/")
    public String listPosts(ModelMap modelMap){
        List<Post> posts= new ArrayList<Post>();
        posts=postRepository.getAllPosts();
        modelMap.put("posts", posts);
        return "home";
    }
}
