package at.htl.control;

import at.htl.entity.Food;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class FoodRepository implements PanacheRepository<Food> {

    //findById
    public Food findFoodById(Long id){
        return findById(id);
    }

    //findByName
    public Food findByName(String name){
        return find("name", name).firstResult();
    }

    //findAllFood
    public List<Food> findAllFood(){
        return listAll();
    }

    //createFood
    public Food createFood(Food food){
        persist(food);
        return food;
    }

    /*public Food updateFood(Food food){

    }*/

}
