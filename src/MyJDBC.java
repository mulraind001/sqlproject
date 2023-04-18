import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyJDBC {
    public static void main(String[] args) {

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/logincredential", "DBuckhana", "@Comp320sql");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from people");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void queryDatabase(String query){
        String url = "jdbc:mysql://localhost:3306/logincredential";
        String user = "DBuckhana";
        String pw = "@Comp320sql";
        try {

            Connection connection = DriverManager.getConnection(url, user, pw);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
