package ProjectCoWorking.dao;

import ProjectCoWorking.database.DatabaseConnector;
import ProjectCoWorking.models.Course;
import ProjectCoWorking.models.FlyTickets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlyTicketsDao {
    //id, price, categories, time
    static DatabaseConnector db = new DatabaseConnector();
    public static FlyTickets getFlyTickets(int id){
        String SQL = "select id, price, categories, cast(time as varchar(50)) where id = " + id;
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL);
                ResultSet rs = stmt.executeQuery()
        ){
            FlyTickets flyTickets;
            if(rs.next()){
                flyTickets = new FlyTickets(rs.getInt("id"),
                        rs.getDouble("price"),
                        rs.getString("categories"),
                        rs.getString("time"));
            }

            else{
                return null;
            }
            System.out.println("getting flyTickets by id = " + id);
            return flyTickets;
        }
        catch(SQLException ex){
            System.out.println("getting flyTickets UNSUCCESSFUL!");
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static FlyTickets addFlyTickets(FlyTickets flyTickets){
        String SQL = "insert into flyTickets(id, price, categories, time) values(?,?,?,?)";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, flyTickets.getId());
            stmt.setDouble(2, flyTickets.getPrice());
            stmt.setString(3, flyTickets.getCategories());
            stmt.setString(4, flyTickets.getTime());
            stmt.executeUpdate();
            System.out.println("adding flyTickets");
            return flyTickets;
        }
        catch (SQLException ex){
            System.out.println("adding flyTickets UNSUCCESSFUL");
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static FlyTickets updateFlyTickets(FlyTickets flyTickets){
        String SQL = "update flyTickets set price = ? where id = ?";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)
        ){
            stmt.setDouble(1, flyTickets.getPrice());
            stmt.setInt(2, flyTickets.getId());
            stmt.executeUpdate();
            System.out.println("updating flyTickets");
            return flyTickets;
        }
        catch(SQLException ex){
            System.out.println("updating flyTickets UNSUCCESSFUL");
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static void deleteFlyTickets(int id){
        String SQL = "delete from flyTickets where id = ?";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)
        ){
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("deleted flyRickets by id = " + id);
        }
        catch(SQLException ex) {
            System.out.println("Couldn't delete flyTickets by id = " + id);
            System.out.println(ex.getMessage());
        }

    }
    public static List<FlyTickets> getAllFlyTickets(){
        List<FlyTickets> flyTicketsList = new ArrayList<>();
        String SQL = "select id, price, categories cast(time as varchar(50)) from flyTickets";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL);
                ResultSet rs = stmt.executeQuery()
        ){
            while(rs.next()){
                flyTicketsList.add(new FlyTickets(rs.getInt("id"),
                        rs.getDouble("price"),
                        rs.getString("categories"),
                        rs.getString("time")));
            }
            System.out.println("getting all flyTickets");
        }
        catch(SQLException ex){
            System.out.println("getting all flyTickets UNSUCCESSFUL");
            System.out.println(ex.getMessage());
        }
        return flyTicketsList;
    }
}
