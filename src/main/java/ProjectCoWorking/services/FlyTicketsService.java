package ProjectCoWorking.services;

import ProjectCoWorking.dao.FlyTicketsDao;
import ProjectCoWorking.models.FlyTickets;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class FlyTicketsService {
    //--------- get flyTickets ----------
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<FlyTickets> getFlyTickets_JSON() {
        List<FlyTickets> flyTickets = FlyTicketsDao.getAllFlyTickets();
        return flyTickets;
    }
    //--------- get flyTickets by id----------
    // URI:
    // contextPath/servletPath/flyTickets/{flyTicketsId}
    @GET
    @Path("/{flyTicketsId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public FlyTickets getFlyTickets(@PathParam("flyTicketsId") Integer flyTicketsId){
        return FlyTicketsDao.getFlyTickets(flyTicketsId);
    }
    //--------- add flyTickets ----------
    // URI:
    // contextPath/servletPath/flyTickets
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public FlyTickets addFlyTickets(FlyTickets flyTickets) {
        return FlyTicketsDao.addFlyTickets(flyTickets);
    }
    //--------- update flyTickets ----------

    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public FlyTickets updateFlyTickets(FlyTickets flyTickets) {
        return FlyTicketsDao.updateFlyTickets(flyTickets);
    }
    //--------- delete flyTickets ----------
    @DELETE
    @Path("/{flyTicketsId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteFlyTickets(@PathParam("flyTicketsId") Integer flyTicketsId) {
        FlyTicketsDao.deleteFlyTickets(flyTicketsId);
    }
}
