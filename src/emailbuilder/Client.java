package emailbuilder;

/**
 *
 * @author Cornell Hall III
 */
public class Client{

//Define variables    
    String fName,lName, email;
    
//Define Constructors
    public Client(){        
        this.fName = "";
        this.lName = "";
        this.email = "";
    }    
//Parameterized Constructor
  public  Client(String fName, String lName, String city, String phone, String email,int id){
        this.fName = fName;
        this.lName = lName;
        this.email = email;
    }          
//Attribute Getters
    public String getfName(){
        return fName;
    }
    public String getlName(){
        return lName;
    }
    public String getEmail() {
        return email;
    }
//Attribute Setters    
    public void setEmail(String email) {
        this.email = email;
    }
    public void setfName(String fName){
        this.fName=fName;
    }
    public void setlName(String lName){
        this.lName=lName;
    }

//Print Client Data 
    public void printData(){
        String[] dataArray;
        dataArray = new String[]{
            "First Name: " + getfName(),"Last Name: " + getlName(),"Email: "+ getEmail()+"\n"};    

        for(String d:dataArray){
            System.out.println(d);
        }
    } 
    @Override
    public String toString(){
    String output;
    output= "\nFirst Name: " + getfName()+
            "\nLast Name: " + getlName()+
            "\nEmail: "+ getEmail();    
    return output;
    }

}
        
