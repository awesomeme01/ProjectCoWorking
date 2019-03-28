package ProjectCoWorking.services;

import ProjectCoWorking.dao.UserDao;
import ProjectCoWorking.models.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class UserService {
    //--------- get users ----------
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<User> getUsers_JSON() {
        List<User> users = UserDao.getAllUsers();
        return users;
    }
    //--------- get user by id----------
    // URI:
    // contextPath/servletPath/users/{userId}
    @GET
    @Path("/{userId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User getUser(@PathParam("userId") Integer userId){
        return UserDao.getUser(userId);
    }
    //--------- add user ----------
    // URI:
    // contextPath/servletPath/users
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User addUser(User user) {
        return UserDao.addUser(user);
    }
    //--------- update user ----------

    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User updateUser(User user) {
        return UserDao.updateUser(user);
    }
    //--------- delete user ----------
    @DELETE
    @Path("/{userId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteUser(@PathParam("userId") Integer userId) {
        UserDao.deleteUser(userId);
    }
}