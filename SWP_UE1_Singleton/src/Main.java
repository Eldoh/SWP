
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args){
        System.out.println("My Singleton DB_Connection");

        DB_Connection instance = DB_Connection.getInstance();

        try {
            System.out.println(instance.getConnection().getMetaData());
            Statement stmt = instance.getConnection().createStatement();
            String query = "select * from data ;" ;
            ResultSet rs = stmt.executeQuery(query) ;

            while (rs.next())
            {
                System.out.println(rs.getInt("id") + " / " + rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        instance.closeConnection();


        System.out.println("-----------------------------");
        System.out.println("My Singleton DB_Connection_Static");

        DB_Connection_Static db_connection_static = DB_Connection_Static.getInstance();
        try {
            System.out.println(db_connection_static.getConnection().getMetaData());
            Statement stmt = db_connection_static.getConnection().createStatement();
            String query = "select * from data ;" ;
            ResultSet rs = stmt.executeQuery(query) ;

            while (rs.next())
            {
                System.out.println(rs.getInt("id") + " / " + rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        db_connection_static.closeConnection();

    }


}
