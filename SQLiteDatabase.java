/********************************************************************
 * Name: Rodney Dugger Sr
 * Date: 10/27/23
 * Assignment: CIS319 Week 4 GP - Database Interactions
 * 
 * Class to handle database interactions with a SQLite database. The
 * connect method will either connect to an existing database or 
 * create the database if the database doesn't exist.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDatabase {
    public static Connection connect(String database) {
        String url = "jdbc:sqlite:" + database;
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
