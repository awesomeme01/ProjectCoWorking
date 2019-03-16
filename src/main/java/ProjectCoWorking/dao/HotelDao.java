package ProjectCoWorking.dao;

import ProjectCoWorking.models.Hotel;
import ProjectCoWorking.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelDao {
    private static final Map<Integer, Hotel> hotelMap = new HashMap<>();
    static {
        initHotels();
    }
    private static void initHotels(){
       Hotel hotel1 = new Hotel();
       Hotel hotel2 = new Hotel();
       Hotel hotel3 = new Hotel();
       Hotel hotel4 = new Hotel();

       hotelMap.put(hotel1.getId(), hotel1);
       hotelMap.put(hotel2.getId(), hotel2);
       hotelMap.put(hotel3.getId(), hotel3);
       hotelMap.put(hotel4.getId(), hotel4);

    }
    public static Hotel getHotel(Integer id){
        return hotelMap.get(id);
    }

    public static Hotel addHotel(Hotel hotel) {
        hotelMap.put(hotel.getId(), hotel);
        return hotel;
    }

    public static Hotel updateHotel(Hotel hotel) {
        hotelMap.put(hotel.getId(), hotel);
        return hotel;
    }

    public static void deleteHotel(Integer id){
        hotelMap.remove(id);
    }

    public static List<Hotel> getAllHotels() {
        return new ArrayList<Hotel>(hotelMap.values());
    }
}
