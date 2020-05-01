package upgard.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import upgard.Model.Post;
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

    @RequestMapping("/createPost")
    public String createPost(){
        return "/CreatePost";
    }


    @RequestMapping(value ="/createPost",method = RequestMethod.POST)
    public String CreatePost(Post post){
      postService.CreatePost(post);
      return "redirect:/posts";
    }

}
