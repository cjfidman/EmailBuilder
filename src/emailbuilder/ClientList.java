package emailbuilder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.StringTokenizer;
import junit.framework.Test;

/**
 *
 * @author Cornell Hall III
 */
public class ClientList{
    
    //ArrayList for Client data
    public ArrayList<Client> cArray = new ArrayList<>();

    public ClientList() throws FileNotFoundException{
    this.loadFile();
}
    public ClientList(String file) throws FileNotFoundException{
    this.loadFile(file);
}
    public void addArrayEntry(Client c) {
        //Add new Client object to Array
        cArray.add(c);
    }    

    private void loadFile() throws FileNotFoundException{
        //Define file as variable
            String fileLine; 
        try{
        //Create File reader and encase in Buffered reader
            String path = Test.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String decodedPath = URLDecoder.decode(path.substring(1, path.lastIndexOf("/")+1), "UTF-8");
            String customerFile = decodedPath+"Resources/clients.csv";
            System.out.println(customerFile);
         //   try (InputStream is = this.getClass().getResourceAsStream(decodedPath+"/customers.csv")) {
            try (FileInputStream fileInput = new FileInputStream(customerFile)){
                BufferedReader br = new BufferedReader(new InputStreamReader(fileInput)); 
                    //Add Client entries to list and array
                    while ((fileLine = br.readLine()) != null) {
                        Client customer = newClient(fileLine);
                       // System.out.println(fileLine);
                        addArrayEntry(customer);
                    }
                    String success = "\n***Client Data Loaded Successfully***\n";
                    System.out.println(starLine(success.length()-2) + success + starLine(success.length()-2));
                }
        //cArray.forEach((item)->{System.out.println(item.toString());});
        }
        catch (IOException e) {
            System.out.println(e.toString());
            }
    }
    private void loadFile(String fileLocation) throws FileNotFoundException{
        //Define file as variable
            String fileLine; 
        try{
            String customerFile = fileLocation;
            System.out.println("Client File Location: "+customerFile);
         //   try (InputStream is = this.getClass().getResourceAsStream(decodedPath+"/customers.csv")) {
            try (FileInputStream fileInput = new FileInputStream(customerFile)){
                BufferedReader br = new BufferedReader(new InputStreamReader(fileInput)); 
                    //Add Client entries to list and array
                    while ((fileLine = br.readLine()) != null) {
                        Client customer = newClient(fileLine);
                       // System.out.println(fileLine);
                        addArrayEntry(customer);
                    }
                    String success = "\n***Client Data Loaded Successfully***\n";
                    System.out.println(starLine(success.length()-2) + success + starLine(success.length()-2));
                }
        //cArray.forEach((item)->{System.out.println(item.toString());});
        }
        catch (IOException e) {
            System.out.println(e.toString());
            }
  
    }

    private static Client newClient(String input) {
        StringTokenizer line;
        int Num = 0;
        Client c = new Client();
        line = new StringTokenizer(input, ",");
        while(line.hasMoreTokens()){
        switch (Num) {
        case 0: c.setfName(line.nextToken());
        break;
        case 1: c.setlName(line.nextToken());
        break;
        case 2: c.setEmail(line.nextToken());
        break;
        }
        Num++;
        }
        return c;
    }   
    public static String starLine(int b){  
        String s="";
        for(int a=0;a<b;a++){
        s= s +"*";
        }
    return s;
    }

}


