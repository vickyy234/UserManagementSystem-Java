package service;

import java.util.List;
import model.User;

public interface UserService {

    public User addUser(String userName, String userEmail, int userRollNo);

    public List<User> getAllUsers();

    public boolean updateUser(int RollNo,String newName, String newEmail);

    public boolean deleteUser(int RollNo);
}
