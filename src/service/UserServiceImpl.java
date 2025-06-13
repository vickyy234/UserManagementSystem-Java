package service;

import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserServiceImpl implements UserService {

    private final List<User> users = new ArrayList<>();

    @Override
    public User addUser(String userName, String userEmail, int userRollNo) {
        User user = new User(userName, userEmail, userRollNo);
        users.add(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public boolean updateUser(int rollNo, String newName, String newEmail) {
        for (User user : users) {
            if (user.getUserRollNo() == rollNo) {
                user.setUserName(newName);
                user.setUserEmail(newEmail);
                return true;
            }
        }
        return false; // User not found

    }

    @Override
    public boolean deleteUser(int rollNo) {
        for (User user : users) {
            if (user.getUserRollNo() == rollNo) {
                users.remove(user);
                return true; // User deleted successfully
            }
        }
        return false;
    }
}
