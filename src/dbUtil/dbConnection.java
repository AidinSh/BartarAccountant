package dbUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

    private static final String sqliteConnection = "jdbc:sqlite:bartarDB.sqlite";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(sqliteConnection);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

}
