import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/index")
public class LoginServlet extends HttpServlet {

    public static void main(String[]args){
        MyJDBC temp = new MyJDBC();
        temp.queryDatabase("select * from people");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username;
        String password;
        //   super.doPost(req, resp);
        try {
            // Initialize the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/logincredential", "DBuckhana", "@Comp320sql");

            //Prepare statement.
            Statement statement = connection.createStatement();
            username = req.getParameter("username");
            password = req.getParameter("password");

            ResultSet resultSet = statement.executeQuery("select * from people");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }


            // Get PrintWriter
            PrintWriter pw = resp.getWriter();

            // Set content Type
            resp.setContentType("text/html");

            // Read the form values.
            //String username = req.getParameter("username");
            //String password = req.getParameter("password");

            pw.println("Username: " + username);
            pw.println("Password: " + password);

            // Close the stream.
            statement.close();
            connection.close();
            pw.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
