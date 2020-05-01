package upgard.service;

import org.springframework.stereotype.Service;
import upgard.Model.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    public List<Post> getAllPost(){
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("Alok", "is a good man", new Date()));
        posts.add(new Post("Adisha", "is a good woman", new Date()));
        posts.add(new Post("Amol", "is a good brother", new Date()));
        return posts;
    }


    public List<Post> getUserPost(){
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("Logged in", "this is when a user logs in", new Date()));
        return posts;
    }

    public void CreatePost(Post post){

    }

}
