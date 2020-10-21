package be.intecbrussel.classiccars.data.dao;

import be.intecbrussel.classiccars.entity.Productline;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProductlineDaoJpaImpl implements ProductlineDao {
    @Override
    public Productline readProductLine(String id) {
        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager= null;
        Productline productline = null;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_classiccars");
            entityManager = entityManagerFactory.createEntityManager();
            productline = entityManager.find(Productline.class,id);

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            if(entityManager !=null){
                entityManager.close();
            }
            if (entityManagerFactory != null){
                entityManagerFactory.close();
            }
        }

        return productline;
    }
}
