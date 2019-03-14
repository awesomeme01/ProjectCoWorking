package ProjectCoWorking.dao;

import ProjectCoWorking.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {
    private static final Map<Integer, User> userMap = new HashMap<>();
    static {
        initUsers();
    }
    private static void initUsers(){
        User user1 = new User(1,"Shabdan","password","");
        User user2 = new User(2,"Aidana","password","");
        User user3 = new User(3,"Astan","password","");
        User user4 = new User(4,"Danil","password","");
        userMap.put(user1.getId(), user1);
        userMap.put(user2.getId(), user2);
        userMap.put(user3.getId(), user3);
        userMap.put(user4.getId(), user4);

    }
    public static User getUser(Integer id){
        return userMap.get(id);
    }

    public static User addUser(User user) {
        userMap.put(user.getId(), user);
        return user;
    }

    public static User updateUser(User user) {
        userMap.put(user.getId(), user);
        return user;
    }

    public static void deleteUser(Integer id){
        userMap.remove(id);
    }

    public static List<User> getAllUsers() {
        return new ArrayList<User>(userMap.values());
    }
    public static boolean authorize(String login, String password){
        for(User user: userMap.values()){
            if(user.getName().equals(login) && user.getPassword().equals((password)));
            return true;
        }
        return false;
    }
}
