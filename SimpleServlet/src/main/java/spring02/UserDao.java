package spring02;

import javax.sound.midi.Soundbank;

public class UserDao implements IUserDao{

    String username;
    String password;



    public void findUserByUsername() {
        System.out.println("UserDao.findUserByUsername()");
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
