package at.htl.boundary;

import at.htl.control.TagRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Path;

@Path("/tag")
@Transactional
public class TagEndpoint {

    @Inject
    TagRepository tagRepository;
}
