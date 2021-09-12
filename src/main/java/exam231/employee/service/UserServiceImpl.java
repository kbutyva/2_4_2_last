package exam231.employee.service;

import exam231.employee.model.Role;
import exam231.employee.repository.RoleRepository;
import exam231.employee.repository.UserRepository;
import exam231.employee.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public void removeUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void editUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getById(int id) {

        return userRepository.findUserById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<Role> allRoles() {
        return roleRepository.findAll();
    }


}
