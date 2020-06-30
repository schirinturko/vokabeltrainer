package at.htl.boundary;

import at.htl.control.TrafficRepository;
import at.htl.entity.Traffic;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/traffic")
@Transactional
public class TrafficEndpoint {

    @Inject
    TrafficRepository trafficRepository;

    //hello - test
    @GET
    @Path("/hello")
    @Consumes(MediaType.APPLICATION_JSON)
    public String hello() {
        return "hello (Traffic)";
    }

    //findAllFood
    @GET
    @Path("/findAllTraffic")
    /*public List<Traffic> findAllTraffic(){
        return trafficRepository.listAll();
    } ODER: */
    public Response findAllTraffic(){
        List<Traffic> findAllTraffic = trafficRepository.listAll();
        return Response.ok(findAllTraffic).build();
    }

    //find traffic word by id
    @GET
    @Path("/{id}")
    public Response findTrafficById(@PathParam("id") Long id){
        Traffic traffic = trafficRepository.findById(id);
        return Response.ok(traffic.getENword()).build();
    }

    //create traffic word -> Repo
    @POST
    @Path("/createTraffic")
    public Response createTraffic(Traffic traffic){
        trafficRepository.createTraffic(traffic);
        return Response.ok().build();
    }

    //update traffic word by id -> Repo
    @PUT
    @Path("/updateTraffic/{id}")
    public Response updateTraffic(Traffic traffic, @PathParam("id") Long id){
        return Response.ok().build();
    }

    //delete traffic word by id
    @DELETE
    @Path("/deleteTraffic/{id}")
    public Response deleteTrafficById(@PathParam("id") Long id){
        trafficRepository.delete("id", id);
        return Response.ok().build();
    }

    //delete all traffic words
    @DELETE
    @Path("/deleteTraffic")
    public Response deleteTraffic() {
        trafficRepository.deleteAll();
        return Response.ok().build();
    }

    //send answer
    @POST
    @Path("/{id}")
    public Response sendTrafficAnswer(@PathParam("id") Long id, @QueryParam("answer") String answer) {
        Traffic traffic = trafficRepository.findTrafficById(id);
        if (answer.equalsIgnoreCase(traffic.getGERword())) {
            traffic.setNumberOfRightAnswers(traffic.getNumberOfRightAnswers() + 1);
            return Response.ok("TRUE \n No. of right answers: " + traffic.getNumberOfRightAnswers()).build();

        } else {
            traffic.setNumberOfWrongAnswers(traffic.getNumberOfWrongAnswers() + 1);
            return Response.ok("FALSE \n No. of wrong answers: " + traffic.getNumberOfWrongAnswers()).build();

        }
        //return Response.ok(answer).build();
    }
}
