import java.sql.*;

// Demo for how to talk to DBMS from java application
public class Demo {
    public static void main(String[] args) {
        // Imagine you are trying to call someone(DB) to ask information(data)
        // The process consists of 6 steps

        // Hardcoding values due to lack of libraries
        String url="jdbc:postgresql://localhost:5432/dvdrental";
        String username="postgres";
        String password="admin";

        // what information needs to be requested
        String query = "SELECT * from payment where customer_id='1'";

        try {
            // creating a connection with DB by defining the DBMS URL server user password etc.
            // just like a person connecting to Wi-Fi for calling online
            Connection connection = DriverManager.getConnection(url, username, password);

            // after connection now we need to call the person
            // prepare the statement before calling the person
            Statement statement = connection.createStatement();

            // call the person with the query using the statement you prepared
            ResultSet result = statement.executeQuery(query);
            System.out.println(result);

            // the previous result showed row=0 :: column names hote hai jis row mei
            result.next();
            Array correctResult = result.getArray(1); // specify the column index
            System.out.println(correctResult.toString());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}