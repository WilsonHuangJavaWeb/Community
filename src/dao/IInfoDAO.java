package dao;

import java.util.List;

import domain.Information;

/**
 * Created by ki264 on 2017/2/17.
 */
public interface IInfoDAO {

    //增加一條資訊到資料庫中
    public void addInfo(Information information);

    //取得所以資訊
    public List<Information> getAllInfo();
}
