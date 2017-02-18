package service;

import domain.User;

/**
 * Created by ki264 on 2017/2/17.
 * <p>
 * User對應的業務邏輯介面
 */
public interface IUserService {

    //新增註冊使用者到資料庫
    public void addUser(User user);

    //根據使用者編號取得使用者
    public User getUserById(String id);

    //驗證使用者登錄名稱及密碼是否正確
    public User validateUser(String userName, String password);

    //驗證使用者名稱是否已存在
    public boolean isUserExist(String userName);
}
