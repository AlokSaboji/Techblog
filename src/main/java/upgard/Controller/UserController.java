package upgard.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import upgard.Model.User;
import upgard.service.PostService;

import javax.jws.WebParam;

@Controller
public class UserController {

    @Autowired
    PostService postService;

    @RequestMapping("users/login")
    public String login(){
        return "user/login";
    }

    @RequestMapping("users/register")
    public String register(){
        return "user/register";
    }

    @RequestMapping(value = "users/login",method = RequestMethod.POST)
    public String UserLogin(User user){
        return "redirect:/posts";
    }

    @RequestMapping("users/logout")
    public String logout(){
        return "redirect:/";
    }


}
