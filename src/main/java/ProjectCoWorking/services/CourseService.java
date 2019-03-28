package ProjectCoWorking.services;

import ProjectCoWorking.dao.CourseDao;
import ProjectCoWorking.models.Course;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/courses")
public class CourseService {
    //--------- get course ----------
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Course> getCourse_JSON() {
        List<Course> courses = CourseDao.getAllCourse();
        return courses;
    }
    //--------- get course by id----------
    // URI:
    // contextPath/servletPath/course/{courseId}
    @GET
    @Path("/{courseId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Course getCourse(@PathParam("courseId") Integer courseId){
        return CourseDao.getCourse(courseId);
    }
    //--------- add course ----------
    // URI:
    // contextPath/servletPath/courses
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Course addCourse(Course course) {
        return CourseDao.addCourse(course);
    }
    //--------- update course ----------

    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Course updateCourse(Course course) {
        return CourseDao.updateCourse(course);
    }
    //--------- delete course ----------
    @DELETE
    @Path("/{courseId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteCourse(@PathParam("courseId") Integer courseId) {
        CourseDao.deleteCourse(courseId);
    }
}
