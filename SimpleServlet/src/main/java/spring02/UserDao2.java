package spring02;

public class UserDao2 implements IUserDao{

    String username;
    String password;



    public void findUserByUsername() {
        System.out.println("UserDao2.findUserByUsername()");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
