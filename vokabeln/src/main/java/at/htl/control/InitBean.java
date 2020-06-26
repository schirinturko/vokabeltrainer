package at.htl.control;

import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.logging.Logger;

public class InitBean {

    private static final Logger LOGGER = Logger.getLogger(InitBean.class.getSimpleName());

    @Transactional
    private  void init(@Observes StartupEvent ev) throws IOException {
        LOGGER.info("The application is starting...");
    }
}
