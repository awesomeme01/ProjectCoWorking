package ProjectCoWorking.dao;

import ProjectCoWorking.database.DatabaseConnector;
import ProjectCoWorking.models.Course;
import ProjectCoWorking.models.Feedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDao {
    //id, message, recallTime, userId
   static DatabaseConnector db = new DatabaseConnector();
    public static Feedback getFeedback(int id){
        String SQL = "select id, message, user_id from feedback where id = " + id;
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL);
                ResultSet rs = stmt.executeQuery()
        ){
            Feedback feedback;
            if(rs.next()){
                feedback = new Feedback(rs.getInt("id"),
                        rs.getString("message"),
//                        rs.getString("recallTime"),
                        rs.getInt("user_id"));
            }

            else{
                return null;
            }
            System.out.println("getting feedback by id = " + id);
            return feedback;
        }
        catch(SQLException ex){
            System.out.println("getting feedback UNSUCCESSFUL!");
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static Feedback addFeedback(Feedback feedback){
        String SQL = "insert into feedback(id, message, user_id) values(?,?,?)";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, feedback.getId());
            stmt.setString(2, feedback.getMessage());
//            stmt.setString(3, feedback.getRecallTime());
            stmt.setInt(4, feedback.getUserId());

            stmt.executeUpdate();
            System.out.println("adding feedback");
            return feedback;
        }
        catch (SQLException ex){
            System.out.println("adding feedback UNSUCCESSFUL");
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static Feedback updateFeedback(Feedback feedback){
        String SQL = "update feedback set message = ? where id = ?";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)
        ){
            stmt.setString(1, feedback.getMessage());
            stmt.setInt(2, feedback.getId());
            stmt.executeUpdate();
            System.out.println("updating feedback");
            return feedback;
        }
        catch(SQLException ex){
            System.out.println("updating feedback UNSUCCESSFUL");
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static void deleteFeedback(int id){
        String SQL = "delete from feedback where id = ?";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL)
        ){
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("deleted feedback by id = " + id);
        }
        catch(SQLException ex) {
            System.out.println("Couldn't delete feedback by id = " + id);
            System.out.println(ex.getMessage());
        }

    }
    public static List<Feedback> getAllFeedback(){
        List<Feedback> feedbackList = new ArrayList<>();
        String SQL = "select id, message, user_id  from feedback";
        try(
                Connection conn = db.connect();
                PreparedStatement stmt = conn.prepareStatement(SQL);
                ResultSet rs = stmt.executeQuery()
        ){
            while(rs.next()){
                feedbackList.add(new Feedback(rs.getInt("id"),
                        rs.getString("message"),
//                        rs.getString("recallTime"),
                        rs.getInt("user_id")));
            }
            System.out.println("getting all reviews");
        }
        catch(SQLException ex){
            System.out.println("getting all feedback UNSUCCESSFUL");
            System.out.println(ex.getMessage());
        }
        return feedbackList;
    }
}
