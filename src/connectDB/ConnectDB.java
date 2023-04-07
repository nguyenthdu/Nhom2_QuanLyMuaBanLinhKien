package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static Connection con = null;
    private static ConnectDB instance = new ConnectDB();
    public static ConnectDB getInstance() {
        return instance;
    }
    public void connect() throws SQLException {
        //kết nối đến sql sever
        String url = "jdbc:sqlsever://localhost:1433;databaseName=QLBH";
        String user = "sa";
        String password = "2222";
        con = DriverManager.getConnection(url, user, password);
    }
    public void disconnect() throws SQLException {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }
    public static Connection getConnection() {
        return con;
    }
}
