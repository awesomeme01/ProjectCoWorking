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
//    private static final Map<Integer, User> userMap = new HashMap<>();
//    static {
//        initUsers();
//    }
//    private static void initUsers(){
//        User user1 = new User(1,"Shabdan","password","");
//        User user2 = new User(2,"Aidana","password","");
//        User user3 = new User(3,"Astan","password","");
//        User user4 = new User(4,"Danil","password","");
//        userMap.put(user1.getId(), user1);
//        userMap.put(user2.getId(), user2);
//        userMap.put(user3.getId(), user3);
//        userMap.put(user4.getId(), user4);
//
//    }
//    public static User getUser(Integer id){
//        return userMap.get(id);
//    }
//
//    public static User addUser(User user) {
//        userMap.put(user.getId(), user);
//        return user;
//    }
//
//    public static User updateUser(User user) {
//        userMap.put(user.getId(), user);
//        return user;
//    }
//
//    public static void deleteUser(Integer id){
//        userMap.remove(id);
//    }
//
//    public static List<User> getAllUsers() {
//        return new ArrayList<User>(userMap.values());
//    }
//    public static boolean authorize(String login, String password){
//        for(User user: userMap.values()){
//            if(user.getName().equals(login) && user.getPassword().equals((password)));
//            return true;
//        }
//        return false;
//
//    }
    static DatabaseConnector db = new DatabaseConnector();
    public static User getUser(int id){
        String SQL = "select id, name, password, cast(datecreated as varchar(50)) from users where id = ?";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL);
                ResultSet rs = stmt.executeQuery()
        ){
            stmt.setInt(1, id);
            User user;
            if(rs.next()){
            user = new User(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("datecreated"));}
            else{
                return null;
            }
            return user;
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static User addUser(User user){
        String SQL = "insert into users(name, password) values('?','?')";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.executeUpdate();
            return user;

        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static User updateUser(User user){
        String SQL = "update users set name = '?', password = '?' where id = ?";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)
                ){
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getId());
            stmt.executeUpdate();
            return user;
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static String deleteUser(int id){
        String SQL = "delete from users where id = ?";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)
                ){
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return "User with id = " + id + " has been deleted!!!!";
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }
    public static List<User> getAllUsers(){
        List<User> userList = new ArrayList<>();
        String SQL = "select id, name, password, cast(datecreated as varchar(50)) from users";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL);
                ResultSet rs = stmt.executeQuery();
        ){
            while(rs.next()){
                userList.add(new User(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("datecreated")));
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return userList;
    }

}
