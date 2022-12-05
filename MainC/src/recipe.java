import java.util.ArrayList;

// setting up the recipe class
class recipe{
    int recipe_Id;
    String recipe_Name;
    ArrayList<String> recipeList;

    public recipe(int recipe_Id, String recipe_Name){
        this.recipe_Id = recipe_Id;
        this.recipe_Name = recipe_Name;
        recipeList = new ArrayList<>();
    }

    public int getRecipe_Id(){
        return this.recipe_Id;
    }

    public void setRecipe_Id(int recipe_Id){
        this.recipe_Id = recipe_Id;
    }

    public String getRecipe_Name(){
        return this.recipe_Name;
    }

    public void setRecipe_Name(String recipe_Name){
        this.recipe_Name = recipe_Name;
    }

    public ArrayList<String> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(ArrayList<String> recipeList){
        this.recipeList = recipeList;
    }
}