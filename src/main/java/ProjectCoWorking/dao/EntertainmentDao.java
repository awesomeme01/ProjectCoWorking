package ProjectCoWorking.dao;

import ProjectCoWorking.database.DatabaseConnector;
import ProjectCoWorking.models.Course;
import ProjectCoWorking.models.Entertainment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntertainmentDao {
    static DatabaseConnector db = new DatabaseConnector();
    public static Entertainment getEntertainment(int id){
        String SQL = "select id, name, price, address, ageRestrictions from entertainment where id = " + id;
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL);
                ResultSet rs = stmt.executeQuery()
        ){
            Entertainment entertainment;
            if(rs.next()){
                entertainment = new Entertainment(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("address"),
                        rs.getInt("ageRestrictions"));
            }

            else{
                return null;
            }
            System.out.println("getting entertainment by id = " + id);
            return entertainment;
        }
        catch(SQLException ex){
            System.out.println("getting entertainment UNSUCCESSFUL!");
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static Entertainment addentertainment(Entertainment entertainment){
        String SQL = "   insert into entertainment(name, price, address, ageRestrictions) values(?,?,?,?)";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, entertainment.getName());
            stmt.setDouble(2, entertainment.getPrice());
            stmt.setString(1, entertainment.getAddress());
            stmt.setInt(2, entertainment.getAgeRestriction());
            stmt.executeUpdate();
            System.out.println("adding entertainment");
            return entertainment;
        }
        catch (SQLException ex){
            System.out.println("adding entertainment UNSUCCESSFUL");
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static Entertainment updateEntertainment(Entertainment entertainment){
        String SQL = "update entertainment set name = ? where id = ?";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)
        ){
            stmt.setString(1, entertainment.getName());
            stmt.setInt(3, entertainment.getId());
            stmt.executeUpdate();
            System.out.println("updating entertainment");
            return entertainment;
        }
        catch(SQLException ex){
            System.out.println("updating entertainment UNSUCCESSFUL");
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static void deleteEntertainment(int id){
        String SQL = "delete from entertainment where id = ?";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)
        ){
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("deleted entertainment by id = " + id);
        }
        catch(SQLException ex) {
            System.out.println("Couldn't delete entertainment by id = " + id);
            System.out.println(ex.getMessage());
        }

    }
    public static List<Entertainment> getAllEntertainment(){
        List<Entertainment> entertainmentList = new ArrayList<>();
        String SQL = "select name, price, address, ageRestrictions from entertainment";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL);
                ResultSet rs = stmt.executeQuery()
        ){
            while(rs.next()){
                entertainmentList.add(new Entertainment(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("address"),
                        rs.getInt("ageRestrictions")));
            }
            System.out.println("getting all entertainment");
        }
        catch(SQLException ex){
            System.out.println("getting all entertainment UNSUCCESSFUL");
            System.out.println(ex.getMessage());
        }
        return entertainmentList;
    }
}
