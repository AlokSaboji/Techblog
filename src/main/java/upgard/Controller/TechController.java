package upgard.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import upgard.Model.Post;
import upgard.service.PostService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TechController {

    @Autowired
    PostService postService;

    @RequestMapping("/")
    public String getAllPosts(Model model){
        model.addAttribute("posts",postService.getAllPost());
        return "index";
     }
}
