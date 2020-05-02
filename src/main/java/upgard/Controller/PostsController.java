package upgard.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import upgard.Model.Categories;
import upgard.Model.Post;
import upgard.Model.User;
import upgard.service.CategoryService;
import upgard.service.PostService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PostsController {
    @Autowired
    PostService postService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/posts")
    public String getOnePost(Model model){
        model.addAttribute("posts",postService.getAllPost());
        return "posts";
    }

    @RequestMapping("/createPost")
    public String createPost(){
        return "/CreatePost";
    }


    @RequestMapping(value ="/createPost",method = RequestMethod.POST)
    public String CreatePost(Post post, HttpSession session){
        User user = (User) session.getAttribute("currentUser");
        post.setUser(user);

        if(post.getJavaBlog()!=null){
                Categories javaCategory = new Categories();
                javaCategory.setName(post.getJavaBlog());

                post.getCategories().add(javaCategory);
            }
        if(post.getSpringBlog()!=null)
        {
                Categories springCategory = new Categories();
                springCategory.setName(post.getSpringBlog());
                post.getCategories().add(springCategory);
        }
        postService.CreatePost(post);
       return "redirect:/posts";
    }

    @RequestMapping("/editPost")
    public String editpost(@RequestParam(name ="postId") Integer postId,Model model){
        model.addAttribute("post",postService.getOnePost(postId));
        return "/editPost";
    }

    @RequestMapping(value="/editPost",method = RequestMethod.PUT)
    public String editpost(@RequestParam(name ="postId") Integer postId,Post updatedPost){
        updatedPost.setId(postId);
        updatedPost.setDate(postService.getOnePost(postId).getDate());
        postService.editPost(updatedPost);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/deletePost",method=RequestMethod.DELETE)
    public String deletePost(@RequestParam(name="postId") Integer postId){
        postService.deletePost(postId);
        return "redirect:/posts";
    }

}
