package at.htl.control;

import at.htl.entity.Food;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class FoodRepository implements PanacheRepository<Food> {

    @PersistenceContext
    EntityManager em;

    //findById
    public Food findById(){
        return null;
    }

    //findByName
    public Food findByName(String name){
        return find("name", name).firstResult();
    }

    //findAllFood
    public List<Food> findAllFood(){
        return listAll();
    }

}
