// setting up the recipe class
class client{
    int client_Id;
    String client_FirstName;
    String client_LastName;

    public client(int client_Id, String client_FirstName, String client_LastName){
        this.client_Id = client_Id;
        this.client_FirstName = client_FirstName;
        this.client_LastName = client_LastName;
    }

    public int getClient_Id(){
        return this.client_Id;
    }

    public void setClient_Id(int client_Id){
        this.client_Id = client_Id;
    }

    public String getClient_FirstName(){
        return this.client_FirstName;
    }

    public void setClient_FirstName(String client_FirstName){
        this.client_FirstName = client_FirstName;
    }

    public String getClient_LastName() {
        return this.client_LastName;
    }

    public void setClient_LastName(String client_LastName){
        this.client_LastName = client_LastName;
    }
}