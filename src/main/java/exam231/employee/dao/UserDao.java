package exam231.employee.dao;

import exam231.employee.model.User;

import java.util.List;

public interface UserDao {

    List<User> allUsers();
    void addUser(User user);
    void removeUser(User user);
    void editUser(User user);
    User getById(int id);
}
