import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class MyFirstJUnitJupiterTests {

    Scanner in = new Scanner(System.in);


    @Test
    void test() throws SQLException {

        String sql = "delete from recipe_table where recipe_Name = ?";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception se) {
            se.printStackTrace();
        }

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe", user, password);

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, "");

        int detLines = preparedStatement.executeUpdate();
        if (detLines > 0) {
            System.out.println("RECIPE DELETED!!!!");
        }
    }
}
