package model;

import java.time.LocalDateTime;

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
        return "User{"
                + "rollNo='" + userRollNo + '\''
                + ", name='" + userName + '\''
                + ", email='" + userEmail + '\''
                + ", created='" + dateTime + '\''
                + '}';
    }
}
