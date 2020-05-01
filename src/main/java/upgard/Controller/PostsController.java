package upgard.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import upgard.service.PostService;

@Controller
public class PostsController {
    @Autowired
    PostService postService;

    @RequestMapping("/posts")
    public String getUserPost(Model model){
        model.addAttribute("posts", postService.getUserPost());
        return "posts";
    }

}
