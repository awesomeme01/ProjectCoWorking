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
//    public static Hotel getHotel(int id){
//        String SQL = "select id, name, address, price, rating, freeWifi, breakfast, pool, parking, bar, " +
//                "airConditioning, spa, fitness, restaurant from hotel where id = " + id;
//        try(
//                Connection conn = db.connect();
//                PreparedStatement stmt = conn.prepareStatement(SQL);
//                ResultSet rs = stmt.executeQuery()
//        ){
//            Hotel hotel;
//            if(rs.next()){
//                hotel = new Hotel(rs.getInt("id"),
//                        rs.getString("name"),
//                        rs.getString("address"),
//                        rs.getDouble("price"),
//                        rs.getInt("rating"),
//                        rs.getBoolean("freeWifi"),
//                        rs.getBoolean("breakfast"),
//                        rs.getBoolean("pool"),
//                        rs.getBoolean("parking"),
//                        rs.getBoolean("bar"),
//                        rs.getBoolean("airConditioning"),
//                        rs.getBoolean("spa"),
//                        rs.getBoolean("fitness"),
//                        ));
//            }
//            else{
//                return null;
//            }
//            System.out.println("getting user by id = " + id);
//            return hotel;
//        }
//        catch(SQLException ex){
//            System.out.println("getting user UNSUCCESSFUL!");
//            System.out.println(ex.getMessage());
//            return null;
//        }
//    }

//    public static Restaurant getRestsaurant(int id){
//            String SQL = "select id = ? from restaurant;";
//
//            Restaurant restaurant = new Restaurant();
//        try(
//                Connection conn = db.connect();
//                PreparedStatement stmt = conn.prepareStatement(SQL)) {
//           id = stmt.setInt(1, restaurant.getId());
//            stmt.executeUpdate();
//            return ;
//        }
//        catch (SQLException ex){
//            System.out.println(ex.getMessage());
//            return null;
//        }
//        }

    public static User addUser(User user){
        String SQL = "insert into users(name, password) values(?,?)";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.executeUpdate();
            System.out.println("adding user");
            return user;
        }
        catch (SQLException ex){
            System.out.println("adding user UNSUCCESSFUL");
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static User updateUser(User user){
        String SQL = "update users set name = ?, password = ? where id = ?";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)
        ){
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getId());
            stmt.executeUpdate();
            System.out.println("updating user");
            return user;
        }
        catch(SQLException ex){
            System.out.println("updating user UNSUCCESSFUL");
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static void deleteUser(int id){
        String SQL = "delete from users where id = ?";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)
        ){
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("deleted user by id = " + id);
        }
        catch(SQLException ex) {
            System.out.println("Couldn't delete user by id = " + id);
            System.out.println(ex.getMessage());
        }

    }
    public static List<User> getAllUsers(){
        List<User> userList = new ArrayList<>();
        String SQL = "select id, name, password, cast(datecreated as varchar(50)) from users";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL);
                ResultSet rs = stmt.executeQuery()
        ){
            while(rs.next()){
                userList.add(new User(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("datecreated")));
            }
            System.out.println("getting all users");
        }
        catch(SQLException ex){
            System.out.println("getting all users UNSUCCESSFUL");
            System.out.println(ex.getMessage());
        }
        return userList;
    }
}
