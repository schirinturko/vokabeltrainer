package at.htl.boundary;

import at.htl.control.FoodRepository;
import at.htl.entity.Food;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/food")
@Transactional
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FoodEndpoint {

    @PersistenceContext
    EntityManager em;

    @Inject
    FoodRepository foodRepository;

    //hello - test
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    //findAllFood
    @GET
    @Path("/findAllFood")
    /*public List<Food> findAllFood(){
        return foodRepository.listAll();
    } ODER: */
    public Response findAllFood(){
        List<Food> findAllFood = foodRepository.listAll();
        return Response.ok(findAllFood).build();
    }

    //findById
    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){
        Food food = foodRepository.findById();
        return Response.ok(food).build();
    }

    //createFood
    @POST
    @Path("/createFood")
    public Response createFood(Food food){
        em.persist(food);
        return Response.ok().build();
    }

    @PUT
    @Path("/updateFood/{id}")
    public Response updateFood(Food food, @PathParam("id") Long id){
        Food food1 = em.find(Food.class, id);
        em.merge(food1);
        return Response.ok(food1).build();
    }

    @DELETE
    @Path("/deleteFood/{id}")
    public Response deleteFood(@PathParam("id") Long id){
        foodRepository.delete("id", id);
        return Response.ok().build();
    }
}
