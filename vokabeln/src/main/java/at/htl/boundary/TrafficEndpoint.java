package at.htl.boundary;

import at.htl.control.TrafficRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Path;

@Path("/traffic")
@Transactional
public class TrafficEndpoint {

    @Inject
    TrafficRepository trafficRepository;
}
