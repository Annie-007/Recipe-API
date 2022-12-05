import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class recipe_test1
{

    // main code for getting recipe
    public static void main(String[] args) throws SQLException {
        ArrayList<String> recipeList = new ArrayList<>();
        Scanner in = new Scanner(System.in);


        System.out.println("PLEASE ENTER FIRST AND LAST NAME:");
        String client_FirstName = in.nextLine();
        String client_LastName = in.nextLine();

        Random random = new Random();
        int client_Id = random.nextInt(100);

        client client1 = new client(client_Id, client_FirstName, client_LastName);
        client1.setClient_Id(client_Id);
        client1.setClient_FirstName(client_FirstName);
        client1.setClient_LastName(client_LastName);

        System.out.println("Enter Command!");
        String command = in.nextLine();
        if (command.equalsIgnoreCase("insert client")) {
            CRUD.createClient(client1.getClient_Id(), client1.getClient_FirstName(), client1.getClient_LastName());
        }

        System.out.println("Client ID: " + client1.getClient_Id());
        System.out.println( "Client Full Name " + client1.getClient_FirstName() + " " + client1.getClient_LastName());


        System.out.println("WHAT IS THE RECIPE NAME:");
        String recipe_Name = in.nextLine();

        int recipe_Id = random.nextInt(100);

        System.out.println("Enter recipe and say fin when done");
        String recipe_Line = in.nextLine();
        while(!recipe_Line.equalsIgnoreCase("fin"))
        {
            recipeList.add(recipe_Line);
            recipe_Line = in.nextLine();
        }

        recipe recipe1 = new recipe(recipe_Id, recipe_Name);
        recipe1.setRecipe_Id(recipe_Id);
        recipe1.setRecipe_Name(recipe_Name);
        recipe1.setRecipeList(recipeList);

        System.out.println("Enter Task!");
        String publish = in.nextLine();
        if (publish.equalsIgnoreCase("insert recipe")) {
            CRUD.createRecipe(recipe1.getRecipe_Id(), recipe1.getRecipe_Name(), recipe1.getRecipeList());
        }

        CRUD.insertReference(client1.getClient_Id(), recipe1.getRecipe_Id());


        System.out.println("Recipe ID: " + recipe1.getRecipe_Id());
        System.out.println(recipe1.getRecipe_Name());
        System.out.println(recipe1.getRecipeList());

        System.out.println("Enter recipe ID for recipe:");
        int id = in.nextInt();
        if(id != 0){
            CRUD.readRecipe(id);
        }


        System.out.println("what function do you want to perform");
        String function = in.next();
        if (function.equalsIgnoreCase("update")) {
            System.out.println("What is the new recipe_Name or recipe_list");
            String update = in.next();
            System.out.println("What is your recipe_id?");
            int ID = in.nextInt();
            System.out.println("What do you want to update? recipe_Name or recipe_list");
            String choose = in.next();

            CRUD.updateRecipe(choose, ID, update);
        }


        System.out.println("enter recipe name to delete: ");
        String delName = in.next();
        CRUD.deleteRecipe(delName);

    }
}
