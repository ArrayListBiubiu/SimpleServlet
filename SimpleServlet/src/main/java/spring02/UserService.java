package spring02;

public class UserService{


    private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }


    public void reg() {
        System.out.println("UserService.reg()");
        userDao.findUserByUsername();
    }



}
