package exam231.employee.service;

import exam231.employee.model.User;
import exam231.employee.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userRepository;

    @Override
    public List<User> allUsers() {
        return userRepository.allUsers();
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public void removeUser(User user) {
        userRepository.removeUser(user);
    }

    @Override
    public void editUser(User user) {
        userRepository.editUser(user);
    }

    @Override
    public User getById(int id) {
        return userRepository.getById(id);
    }
}
