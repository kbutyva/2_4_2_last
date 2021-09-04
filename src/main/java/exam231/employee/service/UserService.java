package exam231.employee.service;

import exam231.employee.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    void addUser(User user);
    void removeUser(int id);
    void editUser(User user);
    User getById(int id);
}
