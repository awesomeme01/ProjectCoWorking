package ProjectCoWorking.dao;

import ProjectCoWorking.database.DatabaseConnector;
import ProjectCoWorking.models.User;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {
    static DatabaseConnector db = new DatabaseConnector();
    public static User getUser(int id){
        String SQL = "select id, name, password, cast(datecreated as varchar(50)) from users where id = " + id;
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL);
                ResultSet rs = stmt.executeQuery()
        ){
            User user;
            if(rs.next()){
                user = new User(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("datecreated"));}
            else{
                return null;
            }
            System.out.println("getting user by id = " + id);
            return user;
        }
        catch(SQLException ex){
            System.out.println("getting user UNSUCCESSFUL!");
            System.out.println(ex.getMessage());
            return null;
        }
    }
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
