import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;

public class CRUD{
    public static void createClient( int client_id, String FirstName, String LastName) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/recipe";
        String username = "root";
        String password = "";

        Connection connection = DriverManager.getConnection(url, username, password);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        String sql = "insert into client(client_id, FirstName, LastName)" + "VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, client_id);
        preparedStatement.setString(2, FirstName);
        preparedStatement.setString(3, LastName);

        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            System.out.println("Insertion Successful");
        }
    }


    public static void createRecipe( int recipe_id, String recipe_Name, ArrayList <String> recipe_list) throws SQLException {

        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe", "root", "");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception se) {
            se.printStackTrace();
        }

        String sql = "insert into recipe_table(recipe_id, recipe_Name, recipe_list)" + "VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connect.prepareStatement(sql);
        preparedStatement.setInt(1, recipe_id);
        preparedStatement.setString(2, recipe_Name);
        StringBuilder rl = new StringBuilder();
        for (Object recipeList : recipe_list) {
            if (rl.length() != 0)
                rl.append(',');
            rl.append(recipeList);
        }
        preparedStatement.setString(3, rl.toString());

        int row = preparedStatement.executeUpdate();

        if (row > 0) {
            System.out.println("Insertion Successful");
        }
    }


    public static void insertReference(int clientID, int recipeID) throws SQLException {

        Connection connected = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe", "root", "");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception se) {
            se.printStackTrace();
        }

        String sql = "insert into reference_table(client_id, recipe_id)" + "VALUES (?, ?)";
        PreparedStatement preparedStatement = connected.prepareStatement(sql);
        preparedStatement.setInt(1, clientID);
        preparedStatement.setInt(2, recipeID);

        int line = preparedStatement.executeUpdate();

        if (line > 0) {
            System.out.println("Reference Successful");
        }
    }


    public static void readRecipe(int id) throws SQLException {

        Connection connecting = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe", "root", "");
        Statement statement = connecting.createStatement();

        String sql = "select * from recipe_table where recipe_id = "+id;
        ResultSet resultSet = statement.executeQuery(sql);


        if(resultSet.next()){
            int recipeID = resultSet.getInt("recipe_id");
            String recipeName = resultSet.getString("recipe_Name");
            String recipeList =  resultSet.getString("recipe_list");
            System.out.println(recipeID + "\n" + recipeName + "\n" + recipeList);
        }

    }


    public static void updateRecipe( String choice, int id, String update) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/recipe";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception se) {
            se.printStackTrace();
        }

        Connection connects = DriverManager.getConnection(url, username, password);

        if(choice.equalsIgnoreCase("recipe_Name")){
            String sql = "update recipe_table set recipe_Name = ? where recipe_id = "+id;
            PreparedStatement preparedStatement = connects.prepareStatement(sql);
            preparedStatement.setString(1, update);
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                System.out.println("Update Successful");
            }
        }
        else if (choice.equalsIgnoreCase("recipe_list")) {
            String sql = "update recipe_table set recipe_list  = ? where recipe_id = "+id;
            PreparedStatement preparedStatement = connects.prepareStatement(sql);
            preparedStatement.setString(1, update);
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                System.out.println("Update Successful");
            }
        }

    }


    public static void deleteRecipe( String name) throws SQLException{
        String sqlQ = "delete from recipe_table where recipe_Name = ?";

        String ul = "jdbc:mysql://localhost:3306/recipe";
        String usr = "root";
        String pasword = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception se)
        {
            se.printStackTrace();
        }

        Connection conn = DriverManager.getConnection(ul, usr, pasword);

        PreparedStatement preparedStatement = conn.prepareStatement(sqlQ);
        preparedStatement.setString(1, name);

        int deleteLines = preparedStatement.executeUpdate();
        if(deleteLines > 0)
        {
            System.out.println("RECIPE DELETED!!!!");
        }
    }

}
