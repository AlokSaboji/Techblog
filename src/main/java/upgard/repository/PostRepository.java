package upgard.repository;

import org.springframework.stereotype.Repository;
import upgard.Model.Post;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Repository
public class PostRepository {

    @PersistenceUnit(unitName = "techblog")
    EntityManagerFactory emf;

    public void createPost(Post post){
        post.setDate(new Date());
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try{
            entityTransaction.begin();
            entityManager.persist(post);
            entityTransaction.commit();
        }catch(Exception e){
            entityTransaction.rollback();
        }
    }

    public List<Post> getAllPost(){
        EntityManager entityManager = emf.createEntityManager();
        TypedQuery<Post> query = entityManager.createQuery("SELECT p from Post p",Post.class);
        List<Post> postList = query.getResultList();
        return postList;
    }

    public Post getOnePost(){
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(Post.class,10);
    }

    public Post getOnePost(Integer postId){
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(Post.class,postId);
    }


    public void editPost(Post post) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction =entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.merge(post);
            transaction.commit();

        }catch(Exception e){
            transaction.rollback();
        }
    }

    public void deletePost(Integer postId){
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction =entityManager.getTransaction();
        try{
            transaction.begin();
            Post post = entityManager.find(Post.class,postId);
            entityManager.remove(post);
            transaction.commit();

        }catch(Exception e){
            transaction.rollback();
        }
    }
}
