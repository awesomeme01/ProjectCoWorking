package ProjectCoWorking.dao;

import ProjectCoWorking.database.DatabaseConnector;
import ProjectCoWorking.models.Hotel;
import ProjectCoWorking.models.Restaurant;
import ProjectCoWorking.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelDao {
//    private int id; name; address; price; rating; freeWifi; breakfast; pool; parking;
// bar; airConditioning; spa; fitness; restaurant;
    static DatabaseConnector db = new DatabaseConnector();
    public static Hotel getHotel(int id){
        String SQL = "select id, name, address, price, rating, freeWifi, breakfast, pool, parking, bar, " +
                "airConditioning, spa, fitness, restaurant from hotel where id = " + id;
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL);
                ResultSet rs = stmt.executeQuery()
        ){
            Hotel hotel;
            if(rs.next()){
                hotel = new Hotel(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getDouble("price"),
                        rs.getInt("rating"),
                        rs.getBoolean("freeWifi"),
                        rs.getBoolean("breakfast"),
                        rs.getBoolean("pool"),
                        rs.getBoolean("parking"),
                        rs.getBoolean("bar"),
                        rs.getBoolean("airConditioning"),
                        rs.getBoolean("spa"),
                        rs.getBoolean("fitness"),
                        rs.getInt("restaurantId")
                        );
            }
            else{
                return null;
            }
            System.out.println("getting hotel by id = " + id);
            return hotel;
        }
        catch(SQLException ex){
            System.out.println("getting hotel UNSUCCESSFUL!");
            System.out.println(ex.getMessage());
            return null;
        }
    }


    public static Hotel addHotel(Hotel hotel){
        return null;
    }
    public static Hotel updateHotel(Hotel hotel){
        return null;
    }
    public static void deleteUserHotel(int id){


    }
    public static List<User> getAllUsers(){
        return null;
    }
}
