package dao.imp;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dao.IDatabaseDAO;
import dao.IInfoDAO;
import domain.Information;

/**
 * Created by ki264 on 2017/2/17.
 */
public class InfoDAO implements IInfoDAO {

    public InfoDAO() {
    }

    /**
     * 往資料庫中新增資料
     *
     * @param information 要新增的資料
     */
    @Override
    public void addInfo(Information information) {

        String format = ("yyyy-MM-dd hh:mm:ss");

        //取得具有特定格式的資料發布時間
        String myTime = new SimpleDateFormat(format).format(information.getPublishingTime());
        IDatabaseDAO myDB = new DatabaseDAO();
        String sql = "insert into information(Title,Content,PublishingTime,PublishingUser,Type) values(" +
                "'" + information.getTitle() + "'," +
                "'" + information.getContent() + "'," +
                "'" + information.getPublishingTime() + "'," +
                "'" + information.getPublishingUser() + "'," +
                "'" + information.getType() + "')";
        try {
            myDB.executeSQL(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 取得所有資訊的清單
     *
     * @return List<information> 資訊的list
     */
    @Override
    public List<Information> getAllInfo() {
        IDatabaseDAO myDB = new DatabaseDAO();
        List<Information> list = new ArrayList<Information>();
        String sql = "select * from information";
        try {
            ResultSet resultSet = myDB.getResultSet(sql);

            while (resultSet.next()) {
                Information information = new Information();
                information.setId(resultSet.getString("ID"));
                information.setTitle(resultSet.getString("Title"));
                information.setContent(resultSet.getString("Content"));
                information.setPublishingTime(resultSet.getString("PublishingTime"));
                information.setPublishingUser(resultSet.getString("PublishingUser"));
                information.setType(resultSet.getString("Type"));
                list.add(information);
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
}




























