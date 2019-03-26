package ProjectCoWorking.services;

import ProjectCoWorking.dao.EntertainmentDao;
import ProjectCoWorking.dao.HotelDao;
import ProjectCoWorking.dao.RestaurantDao;
import ProjectCoWorking.models.Hotel;
import ProjectCoWorking.models.Restaurant;
import ProjectCoWorking.models.Restaurant;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/restaurants")
public class RestaurantService {
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Restaurant> getAllRestaurants(){
        return RestaurantDao.getAllRestaurant();
    }
    @GET
    @Path("/{restId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Restaurant getById(@PathParam("resId") Integer id){
        return RestaurantDao.getRestaurant(id);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Restaurant createRestaurant(Restaurant restaurant){
        return RestaurantDao.addRestaurant(restaurant);
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Restaurant updateRestaurant(Restaurant restaurant){
        return RestaurantDao.updateRestaurant(restaurant);
    }

    @DELETE
    @Path("/{id}")
    public void deleteRestaurant(@PathParam("id") Integer id){
        RestaurantDao.deleteRestaurant(id);
    }
}
//import javax.ws.rs.core.MediaType;
//import java.awt.*;
//import javax.ws.rs.core.MediaType;


  