package org.elsys.PPP.user.service;

import org.elsys.PPP.user.entity.Role;
import org.elsys.PPP.user.entity.User;
import org.elsys.PPP.user.repository.RoleRepository;
import org.elsys.PPP.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SessionRegistry sessionRegistry;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    public boolean loginWithUsername(String username, String password) {
        List<User> users = StreamSupport.stream(userRepository.findAll().spliterator(), false)
            .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
            .collect(Collectors.toList());
        return  setUsersActive(users, true);
    }

    public boolean loginWithEmail(String email, String password) {
        List<User> users = StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password))
                .collect(Collectors.toList());
        return setUsersActive(users, true);
    }

    public void logout(User user) {
        user.setActive(false);
        userRepository.save(user);
    }

    public void updateUser(int id, User user) {
        if (user.getId() == id) {
            userRepository.save(user);
        }
    }

    public void addOrUpdateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
    private boolean setUsersActive(List<User> users, boolean activeState) {
        if(users.size() > 0) {
            for(User u: users) {
                u.setActive(true);
            }
            return true;
        }
        return false;
    }

    public User findByUsername(String username) {
        User user = StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .filter(u -> u.getUsername().equals(username))
                .findFirst().get();
        return user;
    }

    public User findByEmail(String email) {
        User user = StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .filter(u -> u.getEmail().equals(email))
                .findFirst().get();
        return user;
    }

    public void registerUser(String username, String firstName, String lastName,
                             String password, String email) {
        User user = new User(username, firstName, lastName, passwordEncoder.encode(password), email);
        user.setActive(true);
        List<Role> roles = new ArrayList<>();
        roleRepository.findAll().forEach(roles::add);
        user.setRoles(roles);
        this.addOrUpdateUser(user);
    }

    public List<String> getUsersFromSessionRegistry() {
        return sessionRegistry.getAllPrincipals().stream().filter((u) -> !sessionRegistry.getAllSessions(u, false).isEmpty()).map(Object::toString).collect(Collectors.toList());
    }

}
