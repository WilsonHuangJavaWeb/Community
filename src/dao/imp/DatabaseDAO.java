package dao.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.IDatabaseDAO;

/**
 * Created by ki264 on 2017/2/16.
 */
public class DatabaseDAO implements IDatabaseDAO {
    private Connection conn = null;

    /**
     * 取得資料庫連線物件
     *
     * @return 資料庫連線物件
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;

        //載入資料庫驅動
        Class.forName("com.mysql.jdbc.Driver");

        //初始化資料庫連接字串並指定字元編碼集
        String connStr = "jdbc:mysql://localhost:3306/community?useUnicode=true&characterEncoding=utf-8";

        //宣告並初始化料庫使用者名稱和密碼
        String user = "root";
        String password = "root";

        //連接資料庫並驗證資料
        conn = DriverManager.getConnection(connStr, user, password);
        System.out.println("connection created!");

        return conn;
    }

    /**
     * 關閉類別中的連線物件
     *
     * @throws SQLException
     */
    public void releaseConnection() throws SQLException {
        this.conn.close();
        this.conn = null;
    }

    /**
     * 執行一個 SQL 查詢語句，並傳回查詢的結果集
     *
     * @param querySQL SQL查詢語句
     * @return 資料庫查詢結果集
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ResultSet getResultSet(String querySQL) throws SQLException, ClassNotFoundException {
        if (conn == null) {
            this.conn = getConnection();
        }
        Statement stm = conn.createStatement();
        ResultSet thisRST = stm.executeQuery(querySQL);
        return thisRST;
    }

    /**
     * 直接執行一條對資料庫修改(包括增刪改)的SQL語句
     *
     * @param SQL SQL語句
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void executeSQL(String SQL) throws SQLException, ClassNotFoundException {
        if (conn == null) {
            this.conn = getConnection();
            Statement stm = conn.createStatement();

            //執行給定的SQL語句
            stm.executeUpdate(SQL);

            //關閉連線物件
            this.conn.close();
            this.conn = null;
        }
    }

    /**
     * 測試主函數
     *
     * @param args
     */
    public static void main(String[] args) {

        //宣告資料庫連線物件
        DatabaseDAO databaseDAO = new DatabaseDAO();

        try {
            //取得資料庫連線物件
            databaseDAO.conn = databaseDAO.getConnection();

            //釋放連線物件
            databaseDAO.releaseConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




























