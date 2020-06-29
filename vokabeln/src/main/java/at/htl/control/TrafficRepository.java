package at.htl.control;

import at.htl.entity.Traffic;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class TrafficRepository implements PanacheRepository<Traffic> {

    //findById
    public Traffic findTrafficById(Long id){
        return findById(id);
    }

    //createFood
    public Traffic createTraffic(Traffic traffic){
        persist(traffic);
        return traffic;
    }
}
