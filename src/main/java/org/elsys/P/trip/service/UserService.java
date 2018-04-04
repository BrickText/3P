package org.elsys.P.trip.service;

import org.elsys.P.trip.entity.Trip;
import org.elsys.P.trip.entity.User;
import org.elsys.P.trip.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

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
            .filter(u -> u.getUsername() == username && u.getPassword() == password)
            .collect(Collectors.toList());
        return  setUsersActive(users, true);
    }

    public boolean loginWithEmail(String email, String password) {
        List<User> users = StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .filter(u -> u.getEmail() == email && u.getPassword() == password)
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
                .filter(u -> u.getUsername() == username)
                .findFirst().get();
        return user;
    }

    public User findByEmail(String email) {
        User user = StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .filter(u -> u.getUsername() == email)
                .findFirst().get();
        return user;
    }
}
