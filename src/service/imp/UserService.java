package service.imp;

import java.util.List;

import dao.IUserDAO;
import dao.imp.UserDAO;
import domain.User;
import service.IUserService;

/**
 * Created by ki264 on 2017/2/17.
 */
public class UserService implements IUserService {
    private IUserDAO userDAO = new UserDAO();

    public UserService() {
    }

    /**
     * 新增使用者至資料庫，並驗證使用者名稱是否已存在，若存在則部新增
     *
     * @param user
     */
    @Override
    public void addUser(User user) {

        //若使用者為空，則不新增
        if (user == null)
            return;

        //若使用者ID不為空，則表示該使用者已存在(無須新增)
        if (user.getId() != null)
            return;

        String userName = user.getUserName();
        List<User> users = userDAO.getUserByUserName(userName);

        //若小於等於0，則表示該使用者名稱已存在
        if (users.size() <= 0) {
            userDAO.addUser(user);
        } else {
            throw new RuntimeException("該使用者名稱已存在!");
        }
    }

    /**
     * 依據ID查詢資料庫中的使用者
     *
     * @param id
     * @return 查詢到的使用者
     */
    @Override
    public User getUserById(String id) {
        if (id == null) {
            return null;
        }

        return userDAO.getUserById(id);
    }

    /**
     * 驗證使用者登入的名稱及密碼是否合法
     *
     * @param userName 使用者名稱
     * @param password 登入密碼
     * @return
     */
    @Override
    public User validateUser(String userName, String password) {
        List<User> users = userDAO.getUserByUserName(userName);
        if (users != null && users.size() != 0) {
            if (users.get(0).getPassword().equals(password)) {
                return users.get(0);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 驗證使用者名稱是否存在
     *
     * @param userName
     * @return
     */
    @Override
    public boolean isUserExist(String userName) {
        List<User> userList = userDAO.getUserByUserName(userName);
        if (userList.size() <= 0) {
            return true;
        } else {
            return false;
        }
    }
}
