package web.AppWithSpringBoot.dao;


import web.AppWithSpringBoot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User showUserId(long id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(long id);
}
