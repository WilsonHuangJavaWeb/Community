package service;

import java.util.List;

import domain.Information;

/**
 * Created by ki264 on 2017/2/17.
 */
public interface IInfoService {

    //新增一條發佈資訊資料庫
    public void addInfo(Information information);

    //取得所有資訊清單
    public List<Information> getAllInfo();

}
