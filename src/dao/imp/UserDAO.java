package dao.imp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDatabaseDAO;
import dao.IUserDAO;
import domain.User;

/**
 * Created by ki264 on 2017/2/17.
 */
public class UserDAO implements IUserDAO {

    public UserDAO() {
    }

    /**
     * 往資料庫中新增使用者
     *
     * @param user
     */
    @Override
    public void addUser(User user) {
        IDatabaseDAO myDB = new DatabaseDAO();

        String sql = "insert into users(UserName,Password,RealName,Gender,Age,PersonalSignature) values(" +
                "'" + user.getUserName() + "'," +
                "'" + user.getPassword() + "'," +
                "'" + user.getRealName() + "'," +
                "'" + user.getGender() + "'," +
                "'" + user.getAge() + "'," +
                "'" + user.getPersonalSignature() + "')";

        try {
            myDB.executeSQL(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 依據使用者ID來查詢使用者資料
     *
     * @param id 使用者ID
     * @return User物件
     */
    @Override
    public User getUserById(String id) {
        IDatabaseDAO myDB = new DatabaseDAO();
        User user = new User();
        String sql = "select * from user where ID='" + id + "'";

        try {
            ResultSet resultSet = myDB.getResultSet(sql);
            while (resultSet.next()) {
                user.setId(resultSet.getString("ID"));
                user.setUserName(resultSet.getString("UserName"));
                user.setPassword(resultSet.getString("Password"));
                user.setRealName(resultSet.getString("RealName"));
                user.setGender(resultSet.getString("Gender"));
                user.setAge(resultSet.getInt("Age"));
                user.setPersonalSignature(resultSet.getString("PersonalSignature"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                myDB.releaseConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    @Override
    public List<User> getUserByUserName(String userName) {
        IDatabaseDAO myDB = new DatabaseDAO();
        User user = new User();
        List<User> list = new ArrayList<User>();
        String sql = "";
        try {
            ResultSet resultSet = myDB.getResultSet(sql);

            while (resultSet.next()) {
                user.setId(resultSet.getString("ID"));
                user.setUserName(resultSet.getString("UserName"));
                user.setPassword(resultSet.getString("Password"));
                user.setRealName(resultSet.getString("RealName"));
                user.setGender(resultSet.getString("Gender"));
                user.setAge(resultSet.getInt("Age"));
                user.setPersonalSignature(resultSet.getString("PersonalSignature"));
                list.add(user);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                myDB.releaseConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }


    public static void main(String[] args) {
        User user = new User("name", "password", "realname", "m", 15, "personalsignature");
        new UserDAO().addUser(user);
    }
}
