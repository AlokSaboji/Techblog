package upgard.repository;


import org.springframework.stereotype.Repository;
import upgard.Model.User;

import javax.persistence.*;
import javax.transaction.Transaction;

@Repository
public class UserRepository {
    @PersistenceUnit(unitName = "techblog")
    EntityManagerFactory emf;

    public void registerUser(User user){
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
    }

    public User getUser(User user){
        EntityManager entityManager = emf.createEntityManager();
        TypedQuery<User> query  = entityManager.createQuery("SELECT u from User u where u.username=:userToFind",User.class);
        query.setParameter("userToFind",user.getUsername());
        return query.getSingleResult();
    }
}
