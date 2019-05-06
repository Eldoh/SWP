import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {

    private static Connection connection;
    private static DB_Connection db_connection;
    private static String connectionCommand = "jdbc:mysql://Jakob-PC:3333/SWPDB?user=admin&password=admin&serverTimezone=UTC";

    protected DB_Connection(){
        try {
            connection = DriverManager.getConnection(connectionCommand);
            System.out.println("Connected");
        } catch (SQLException e) {
            System.out.println("Failed to Connect");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        if(db_connection == null){
            db_connection = new DB_Connection();
        }
        return connection;
    }

    public static synchronized DB_Connection getInstance(){
        if(db_connection == null){
            db_connection = new DB_Connection();
        }
        return db_connection;
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
