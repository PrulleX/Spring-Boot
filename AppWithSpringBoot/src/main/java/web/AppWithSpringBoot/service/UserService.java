package web.AppWithSpringBoot.service;

import web.AppWithSpringBoot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User showUserId(long id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(long id);
}
