package dao;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by ki264 on 2017/2/17.
 */
public interface IDatabaseDAO {
    //取得資料庫連線物件
    public Connection getConnection() throws Exception;

    //關閉類別中的連線物件
    public void releaseConnection() throws Exception;

    //執行一個 SQL 查詢語句，並傳回查詢的結果集
    public ResultSet getResultSet(String querySQL) throws Exception;

    //直接執行一條對資料庫修改(包括增刪改)的SQL語句
    public void executeSQL(String SQL) throws Exception;
}
