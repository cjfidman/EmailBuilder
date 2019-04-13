package emailbuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 *
 * @author Cornell Hall III
 */
public class LetterToEmail {
    
    static String confirmation = "Client Letters Written: ";

    public String readFile(String fileIn, String Client)throws IOException, InvalidFormatException{         
        String fullPath = fileIn;
        System.out.println("Decoded Path: "+fullPath); 
        String outputText ="";
    // This will reference one line at a time
                
        try {           
         //Word file Read
            XWPFDocument docx = new XWPFDocument(new FileInputStream(fullPath));
            XWPFWordExtractor we =new XWPFWordExtractor(docx);
    //Insert Client Name
        outputText= outputText.concat("Hello "+Client+",\n");
        
    //StringTokenizer for seperating Paragraphs    
        StringTokenizer para;
        String input = we.getText();
        para = new StringTokenizer(input, "[]");//   "[]" is tokenizer for paragraphs  
        
    //Insert Text from reference file
        while(para.hasMoreTokens()){
            outputText= outputText.concat(para.nextToken()+"\r\n");
        }

    //Confirm Write Successful
        confirmation = confirmation.concat("\n"+Client+" Letter Successful");
        System.out.println("*** "+Client+" Write Successful***");
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + 
                fullPath + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" 
                + fullPath + "'");                  
        }
        return outputText;
}//End of readFile

}
