package ProjectCoWorking.dao;

import ProjectCoWorking.database.DatabaseConnector;
import ProjectCoWorking.models.Course;
import ProjectCoWorking.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {
    //id, name, rating, address, price, time
    static DatabaseConnector db = new DatabaseConnector();
    public static Course getCourse(int id){
        String SQL = "select id, name, rating, address, price, cast(time as varchar(50)) from course where id = " + id;
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL);
                ResultSet rs = stmt.executeQuery()
        ){
            Course course;
            if(rs.next()){
                course = new Course(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("rating"),
                        rs.getString("address"),
                        rs.getDouble("price"),
                        rs.getString("time"));
            }

            else{
                return null;
            }
            System.out.println("getting course by id = " + id);
            return course;
        }
        catch(SQLException ex){
            System.out.println("getting course UNSUCCESSFUL!");
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static Course addCourse(Course course){
        String SQL = "insert into course(id, name, rating, address, price, time) values(?,?,?,?,?,?)";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1,course.getId());
            stmt.setString(2, course.getName());
            stmt.setInt(3, course.getRating());
            stmt.setString(4, course.getAddress());
            stmt.setDouble(5, course.getPrice());
            stmt.setString(6, course.getTime());
            stmt.executeUpdate();
            System.out.println("adding course");
            return course;
        }
        catch (SQLException ex){
            System.out.println("adding course UNSUCCESSFUL");
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static Course updateCourse(Course course){
        String SQL = "update course set name = ? where id = ?";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)
        ){
            stmt.setString(1, course.getName());
            stmt.setInt(2, course.getId());
            stmt.executeUpdate();
            System.out.println("updating course");
            return course;
        }
        catch(SQLException ex){
            System.out.println("updating course UNSUCCESSFUL");
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static void deleteCourse(int id){
        String SQL = "delete from course where id = ?";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)
        ){
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("deleted course by id = " + id);
        }
        catch(SQLException ex) {
            System.out.println("Couldn't delete course by id = " + id);
            System.out.println(ex.getMessage());
        }

    }
    public static List<Course> getAllCourse(){
        List<Course> courseList = new ArrayList<>();
        String SQL = "select id, name, rating, address, price, cast(time as varchar(50)) from course";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL);
                ResultSet rs = stmt.executeQuery()
        ){
            while(rs.next()){
                courseList.add(new Course(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("rating"),
                        rs.getString("address"),
                        rs.getDouble("price"),
                        rs.getString("time")));
            }
            System.out.println("getting all courses");
        }
        catch(SQLException ex){
            System.out.println("getting all course UNSUCCESSFUL");
            System.out.println(ex.getMessage());
        }
        return courseList;
    }
}
