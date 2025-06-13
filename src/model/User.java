package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {

    private String userName;
    private String userEmail;
    private final int userRollNo;
    private final LocalDateTime dateTime;

    public User(String userEmail, String userName, int userRollNo) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userRollNo = userRollNo;
        this.dateTime = LocalDateTime.now();
    }

    public void setUserName(String newUserName) {
        this.userName = newUserName;
    }

    public void setUserEmail(String newUserEmail) {
        this.userEmail = newUserEmail;
    }

    public int getUserRollNo(){
        return userRollNo;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return "RollNO: " + userRollNo + ", Name: " + userName + ", Email: " + userEmail + ", Registered on: " + "[" + dateTime.format(formatter) + "] ";
                
    }
}
