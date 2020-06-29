package at.htl.boundary;

import at.htl.control.FoodRepository;
import at.htl.entity.Food;

import javax.inject.Inject;
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

    @Inject
    FoodRepository foodRepository;

    //hello - test
    @GET
    @Path("/hello")
    @Consumes(MediaType.APPLICATION_JSON)
    public String hello() {
        return "hello (Food)";
    }

    //find all food words
    @GET
    /*public List<Food> findAllFood(){
        return foodRepository.listAll();
    } ODER: */
    public Response findAllFood() {
        List<Food> findAllFood = foodRepository.listAll();
        return Response.ok(findAllFood).build();
    }

    //find food word by id
    @GET
    @Path("/{id}")
    public Response findFoodById(@PathParam("id") Long id) {
        Food food = foodRepository.findFoodById(id);
        return Response.ok(food.getENword()).build();
    }

    //create food words -> Repo
    @POST
    @Path("/createFood")
    public Response createFood(Food food) {
        foodRepository.createFood(food);
        return Response.ok().build();
    }

    //update food word by id -> Repo
    @PUT
    @Path("/updateFood/{id}")
    public Response updateFood(Food food, @PathParam("id") Long id) {
        return Response.ok().build();
    }

    //delete food word by id
    @DELETE
    @Path("/deleteFood/{id}")
    public Response deleteFoodById(@PathParam("id") Long id) {
        foodRepository.delete("id", id);
        return Response.ok().build();
    }

    //delete all food words
    @DELETE
    @Path("/deleteFood")
    public Response deleteFood() {
        foodRepository.deleteAll();
        return Response.ok().build();
    }

    //send answer
    @POST
    @Path("/{id}")
    public Response sendFoodAnswer(@PathParam("id") Long id, @QueryParam("answer") String answer) {
        Food food = foodRepository.findFoodById(id);
        if (answer.equals(food.getGERword())) {
            return Response.ok(false).build();
        } else {
            return Response.ok(true).build();
        }
        //return Response.ok(answer).build();
    }
}
