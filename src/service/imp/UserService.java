package service.imp;

import domain.User;
import service.IUserService;

/**
 * Created by ki264 on 2017/2/17.
 */
public class UserService implements IUserService {


    @Override
    public void addUser(User user) {

    }

    @Override
    public User getUserById(String id) {
        return null;
    }

    @Override
    public User validateUser(String userName, String password) {
        return null;
    }

    @Override
    public boolean isUserExist(String userName) {
        return false;
    }
}
