import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection_Static {

    private static DB_Connection_Static db_connection_static;

    private static Connection connection;
    private String connectionCommand = "jdbc:mysql://Jakob-PC:3333/SWPDB?user=admin&password=admin&serverTimezone=UTC";

    static {
        db_connection_static = new DB_Connection_Static();
    }

    protected DB_Connection_Static(){
        try {
            connection = DriverManager.getConnection(connectionCommand);
            System.out.println("Connected");
        } catch (SQLException e) {
            System.out.println("Failed to Connect");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DB_Connection_Static getInstance() {
        return db_connection_static;
    }

    public void closeConnection(){
        try {
            connection.close();
            connection = null;
            System.out.println("Connection Closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
