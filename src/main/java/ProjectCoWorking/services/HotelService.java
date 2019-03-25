package ProjectCoWorking.services;

import ProjectCoWorking.dao.HotelDao;
import ProjectCoWorking.models.Hotel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hotels")
public class HotelService {
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Hotel> getAllHotels(){
        return HotelDao.getAllHotels();

    }

    @GET
    @Path("/{hotelId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Hotel getHotel(@PathParam("hotelId") Integer hotelId){
        return HotelDao.getHotel(hotelId);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Hotel createHotel(Hotel hotel){
        return HotelDao.addHotel(hotel);
    }

    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Hotel updateHotel(Hotel hotel){
        return HotelDao.updateHotel(hotel);
    }

    @DELETE
    @Path("/{hotelId}")
    public void deleteHotel(@PathParam("hotelId") Integer hotelId){
        HotelDao.deleteHotel(hotelId);
    }

}
