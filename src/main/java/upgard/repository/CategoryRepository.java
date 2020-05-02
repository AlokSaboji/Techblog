package upgard.repository;

import org.springframework.stereotype.Repository;
import upgard.Model.Categories;

import javax.persistence.*;

@Repository
public class CategoryRepository {
    @PersistenceUnit(unitName = "techblog")
    EntityManagerFactory emf;
    public Categories create(Categories category){
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.persist(category);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }
        return category;
     }


    public Categories getCategory(String name){
        try {
            EntityManager entityManager = emf.createEntityManager();
            TypedQuery<Categories> query = entityManager.createQuery("Select c from Categories c where c.name= :name", Categories.class);
            query.setParameter("name", name);
            return query.getSingleResult();
        }catch(NoResultException nre){
            return  null;
        }
    }
}
