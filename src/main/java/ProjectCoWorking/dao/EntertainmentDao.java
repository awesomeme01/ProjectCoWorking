package ProjectCoWorking.dao;

import ProjectCoWorking.database.DatabaseConnector;
import ProjectCoWorking.models.Entertainment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntertainmentDao {
    static DatabaseConnector db = new DatabaseConnector();
//    get, add, update, delete, getAll
    public static Entertainment getEntertainment(int id){
        String SQL = "select id, name, price, adress, agerestrictions from entertainment where id = ?";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL);
                ResultSet rs = stmt.executeQuery();
        ){
            while(rs.next()){
                return new Entertainment(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("adress"),
                        rs.getInt("agerestrictions"));
            }
            System.out.println("Getting entertainments");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Getting entertainments UNSUCCESSFUL");
        }
        return null;
    }
    public static Entertainment addEntertainment(Entertainment entertainment){
        String SQL = "insert into entertainment values(?,?,?,?,?)";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)
                ){
            stmt.setInt(1, entertainment.getId());
            stmt.setString(2,entertainment.getName());
            stmt.setDouble(3,entertainment.getPrice());
            stmt.setString(4,entertainment.getAddress());
            stmt.setInt(5,entertainment.getAgeRestriction());
            stmt.executeUpdate();
            System.out.println("Adding entertainment");
            return entertainment;
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Adding entertainment UNSUCCESSFUL");
            return null;
        }
    }
    public static Entertainment updateEntertainment(Entertainment entertainment){
        String SQL = "update entertainment set name = ?,price = ?,address = ?, agerestrictions = ? where id = ?";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL);
                ){
            stmt.setInt(5,entertainment.getId());
            stmt.setString(1,entertainment.getName());
            stmt.setDouble(2,entertainment.getPrice());
            stmt.setString(3,entertainment.getAddress());
            stmt.setInt(4,entertainment.getAgeRestriction());
            stmt.executeUpdate();
            System.out.println("Updating entertainments");
            return entertainment;
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Updating entertainment UNSUCCESSFUL");
            return null;
        }
    }
    public static void deleteEntertainment(int id){
        String SQL = "delete from entertainment where id = ?";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL);
                ){
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Deleted entertainment");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Deleting entertainment under id = " + id + " was UNSUCCESSFUL");
        }
    }
    public static List<Entertainment> getAllEntertainment(){
        String SQL = "select id, name, price, address, agerestrictions from entertainment";
        try(
                Connection conn = db.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);
                ){
            ArrayList<Entertainment> list = new ArrayList<>();
            while(rs.next()){
                list.add(new Entertainment(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("address"),
                        rs.getInt("agerestrictions")
                ));
            }
            System.out.println("Getting all from entertainment");
            return list;
        }
        catch(SQLException ex ){
            System.out.println(ex.getMessage());
            System.out.println("Getting all from entertainment UNSUCCESSFUL");
            return null;
        }
    }
}
