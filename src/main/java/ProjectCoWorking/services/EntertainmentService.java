package ProjectCoWorking.services;

import ProjectCoWorking.dao.EntertainmentDao;
import ProjectCoWorking.models.Entertainment;
import com.sun.tools.javac.comp.Enter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.EndpointReference;
import java.util.List;
//import javax.ws.rs.core.MediaType;
//import java.awt.*;
//import javax.ws.rs.core.MediaType;

@Path("/entertainments")
public class EntertainmentService {
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Entertainment> getAllEntertainments(){
        return EntertainmentDao.getAllEntertainment();
    }

    @GET
    @Path("/{enId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Entertainment getById(@PathParam("enId") Integer id){
        return EntertainmentDao.getEntertainment(id);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Entertainment createEntertainment(Entertainment entertainment){
        return EntertainmentDao.addEntertainment(entertainment);
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Entertainment updateEntertainment(Entertainment entertainment){
        return EntertainmentDao.updateEntertainment(entertainment);
    }

    @DELETE
    @Path("/{id}")
    public void deleteEntertainment(@PathParam("id") Integer id){
        EntertainmentDao.deleteEntertainment(id);
    }

}
