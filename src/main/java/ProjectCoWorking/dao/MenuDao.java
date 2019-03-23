package ProjectCoWorking.dao;

import ProjectCoWorking.database.DatabaseConnector;
import ProjectCoWorking.models.Course;
import ProjectCoWorking.models.Menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDao {
    static DatabaseConnector db = new DatabaseConnector();
    public static Menu getMenu(int id){
        String SQL = "select id, dishes, price from menu where id = " + id;
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL);
                ResultSet rs = stmt.executeQuery()
        ){
            Menu menu;
            if(rs.next()){
                menu = new Menu(rs.getInt("id"),
                        rs.getString("dishes"),
                        rs.getDouble("price"));
            }

            else{
                return null;
            }
            System.out.println("getting menu by id = " + id);
            return menu;
        }
        catch(SQLException ex){
            System.out.println("getting menu UNSUCCESSFUL!");
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static Menu addMenu(Menu menu){
        String SQL = "insert into menu(id, dishes, price) values(?,?,?)";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1,menu.getId());
            stmt.setString(2, menu.getDishes());
            stmt.setDouble(3, menu.getPrice());
            stmt.executeUpdate();
            System.out.println("adding menu");
            return menu;
        }
        catch (SQLException ex){
            System.out.println("adding menu UNSUCCESSFUL");
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static Menu updateMenu(Menu menu){
        String SQL = "update menu set price = ? where id = ?";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)
        ){
            stmt.setDouble(1, menu.getPrice());
            stmt.setInt(2, menu.getId());
            stmt.executeUpdate();
            System.out.println("updating menu");
            return menu;
        }
        catch(SQLException ex){
            System.out.println("updating menu UNSUCCESSFUL");
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static void deleteMenu(int id){
        String SQL = "delete from menu where id = ?";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)
        ){
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("deleted menu by id = " + id);
        }
        catch(SQLException ex) {
            System.out.println("Couldn't delete menu by id = " + id);
            System.out.println(ex.getMessage());
        }

    }
    public static List<Menu> getAllMenu(Menu menu){
        List<Menu> menuList = new ArrayList<>();
        String SQL = "select id, dishes, price from menu";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL);
                ResultSet rs = stmt.executeQuery()
        ){
            while(rs.next()){
                menuList.add(new Menu(rs.getInt("id"),
                        rs.getString("dishes"),
                        rs.getDouble("price")));
            }
            System.out.println("getting all menu");
        }
        catch(SQLException ex){
            System.out.println("getting all menu UNSUCCESSFUL");
            System.out.println(ex.getMessage());
        }
        return menuList;
    }
}
