package upgard.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import upgard.Model.User;
import upgard.Model.UserProfile;
import upgard.service.PostService;
import upgard.service.UserService;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    PostService postService;
    @Autowired
    UserService userService;

    @RequestMapping("/users/login")
    public String login()
    {
        return "/user/login";
    }
    @RequestMapping(value = "/users/login",method = RequestMethod.POST)
    public String UserLogin(User user, HttpSession session){
        User existingUser = userService.checkUser(user);
        if(existingUser!=null){
            session.setAttribute("currentUser",existingUser);
            return "redirect:/posts";
        }
        else
            return "/user/login";
    }

    @RequestMapping("/users/register")
    public String register(Model model){
        User user = new User();
        UserProfile userProfile = new UserProfile();
        user.setProfile(userProfile);
        model.addAttribute("User",user);
        return "/user/register";
    }



    @RequestMapping(value = "/users/register",method = RequestMethod.POST)
    public String UserRegister(User user){
        userService.registerUser(user);
        return "/user/login";
    }

    @RequestMapping("users/logout")
    public String logout(HttpSession session){

        session.invalidate();
        return "redirect:/";
    }


}
