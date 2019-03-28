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
//    id, name, address, price, rating, freeWifi, breakfast, pool, parking, bar, airConditioning, spa, fitness, restaurant
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
        String SQL = "insert into hotel values(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?)";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)
        ){
            stmt.setInt(1,hotel.getId());
            stmt.setString(2,hotel.getName());
            stmt.setString(3,hotel.getAddress());
            stmt.setDouble(4,hotel.getPrice());
            stmt.setInt(5,hotel.getRating());
            stmt.setBoolean(6,hotel.isFreeWifi());
            stmt.setBoolean(7,hotel.isBreakfast());
            stmt.setBoolean(8,hotel.isPool());
            stmt.setBoolean(9,hotel.isParking());
            stmt.setBoolean(10,hotel.isBar());
            stmt.setBoolean(11,hotel.isAirConditioning());
            stmt.setBoolean(12,hotel.isSpa());
            stmt.setBoolean(13,hotel.isFitness());
            stmt.setInt(14,hotel.getRestaurant());
            stmt.executeUpdate();
            System.out.println("Adding hotel");
        }
        catch(SQLException ex){
            System.out.println("Adding hotel UNSUCCESSFUL");
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static Hotel updateHotel(Hotel hotel){
        String SQL = "update hotel set name = ? where id = ?";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)
        ){
            stmt.setString(1, hotel.getName());
            stmt.setInt(2, hotel.getId());
            stmt.executeUpdate();
            System.out.println("updating hotel");
            return hotel;
        }
        catch(SQLException ex){
            System.out.println("updating hotel UNSUCCESSFUL");
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static void deleteHotel(int id){
        String SQL = "delete from hotel where id = ?";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)
        ){
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("deleted hotel by id = " + id);
        }
        catch(SQLException ex) {
            System.out.println("Couldn't delete hotel by id = " + id);
            System.out.println(ex.getMessage());
        }

    }
    public static List<Hotel> getAllHotels(){
        List<Hotel> hotelList = new ArrayList<>();
        String SQL = "select id, name, address, price, rating, freeWifi, breakfast, pool, parking, bar, " +
                "airConditioning, spa, fitness, restaurant from hotel;";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL);
                ResultSet rs = stmt.executeQuery()
        ){
            while(rs.next()){
                hotelList.add(new Hotel(rs.getInt("id"),
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
                ));
            }
            System.out.println("getting all hotels");
        }
        catch(SQLException ex){
            System.out.println("getting all hotels UNSUCCESSFUL");
            System.out.println(ex.getMessage());
        }
        return hotelList;
    }
}
