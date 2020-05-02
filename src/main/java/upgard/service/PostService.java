package upgard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upgard.Model.Post;
import upgard.repository.PostRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Post> getAllPost(){
        return postRepository.getAllPost();
    }


    public Post getOnePost(){
       return postRepository.getOnePost();
    }

    public Post getOnePost(Integer postId){
        return postRepository.getOnePost(postId);
    }

    public void CreatePost(Post post){
        postRepository.createPost(post);
    }

    public void editPost(Post post){
        postRepository.editPost(post);
    }

    public void deletePost(Integer postId){ postRepository.deletePost(postId);}

}
