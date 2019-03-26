package ProjectCoWorking.dao;

import ProjectCoWorking.database.DatabaseConnector;
import ProjectCoWorking.models.Menu;
import ProjectCoWorking.models.Restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDao {
    //id, name, menuId, address, rating
    static DatabaseConnector db = new DatabaseConnector();
    public static Restaurant getRestaurant(int id){
        String SQL = "select id, name, menu, address, rating from restaurant where id = " + id;
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL);
                ResultSet rs = stmt.executeQuery()
        ){
            Restaurant restaurant;
            if(rs.next()){
                restaurant = new Restaurant(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("menu_id"),
                        rs.getString("address"),
                        rs.getInt("rating"));

            }

            else{
                return null;
            }
            System.out.println("getting restaurant by id = " + id);
            return restaurant;
        }
        catch(SQLException ex){
            System.out.println("getting restaurant UNSUCCESSFUL!");
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static Restaurant addRestaurant(Restaurant restaurant){
        String SQL = "insert into restaurant(id, name, menu_id, address, rating) values(?,?,?,?,?)";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1,restaurant.getId());
            stmt.setString(2, restaurant.getName());
            stmt.setInt(3, restaurant.getMenuId());
            stmt.setString(4,restaurant.getAddress());
            stmt.setInt(5,restaurant.getRating());
            stmt.executeUpdate();
            System.out.println("adding restaurant");
            return restaurant;
        }
        catch (SQLException ex){
            System.out.println("adding restaurant UNSUCCESSFUL");
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static Restaurant updateRestaurant(Restaurant restaurant){
        String SQL = "update restaurant set name = ? where id = ?";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)
        ){
            stmt.setString(1, restaurant.getName());
            stmt.setInt(2, restaurant.getId());
            stmt.executeUpdate();
            System.out.println("updating restaurant");
            return restaurant;
        }
        catch(SQLException ex){
            System.out.println("updating restaurant UNSUCCESSFUL");
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static void deleteRestaurant(int id){
        String SQL = "delete from restaurant where id = ?";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)
        ){
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("deleted restaurant by id = " + id);
        }
        catch(SQLException ex) {
            System.out.println("Couldn't delete restaurant by id = " + id);
            System.out.println(ex.getMessage());
        }

    }
    public static List<Restaurant> getAllRestaurant(){
        List<Restaurant> restaurantList = new ArrayList<>();
        String SQL = "select id, name, menu_id, address, rating from restaurant";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL);
                ResultSet rs = stmt.executeQuery()
        ){
            while(rs.next()){
                restaurantList.add(new Restaurant(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("menu_id"),
                        rs.getString("address"),
                        rs.getInt("rating")));
            }
            System.out.println("getting all restaurant");
        }
        catch(SQLException ex){
            System.out.println("getting all restaurant UNSUCCESSFUL");
            System.out.println(ex.getMessage());
        }
        return restaurantList;
    }
}
