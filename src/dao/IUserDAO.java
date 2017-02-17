package dao;

import java.util.List;

import domain.User;

/**
 * Created by ki264 on 2017/2/17.
 */
public interface IUserDAO {

    //新增一個使用者到資料庫中
    public void addUser(User user);

    //根據使用者編號取得使用者資訊，以User物件傳回
    public User getUserById(String id);

    //根據使用者名稱取得使用者資訊，以User物件的List
    public List<User> getUserByUserName(String userName);
}
