package upgard.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import upgard.Model.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TechController {


    @RequestMapping("/")
    public String getAllPosts(Model model){
        List<Post> posts = new ArrayList<>();

        Post post1 = new Post("Alok", "is a good man", new Date());
        Post post2 = new Post("Adisha", "is a good woman", new Date());
        Post post3 = new Post("Amol", "is a good brother", new Date());
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        model.addAttribute("posts",posts);

        return "index";
     }
}
