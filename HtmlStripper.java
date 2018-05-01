import java.io.*;
/**
 * HtmlStripper houses the functions that HtmlStripperApp calls.
 * 
 * CS 215 final project
 * @Hanifa Hotelwala
 * Version 1.0
 * 02/03/2018
 */
public class HtmlStripper
{
    //variables
    String type="tag-free.txt"; 
    String line; 

    /**
     * This function reads the original .html or .htm file that the user inputs with the tags. 
     */
    public  void readFile(String fileName)
    {

        try{

            FileReader fr = new FileReader(fileName);

            //user reader
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader keyboard = new BufferedReader(isr);

            //buffered reader
            BufferedReader br = new BufferedReader(fr);

            while((line = br.readLine()) != null)
            {
                System.out.println("\n"); 
                System.out.println(line); 

            }

            //Close buffered reader
            br.close();

        }
        catch(Exception e){
            System.out.println("Error while writing file:" +e.getMessage()); 
        }

    }

    /**
     * This function is in charge of finding all of the html/htm tags and removing it. 
     * These changes are later stored in a file ending in '_tag-free.txt' in the directory. 
     */
    public void findAndRemoveTags(String fileName)
    {
        try{
            //variables
            String option1 = ".html"; 
            String option2 = ".htm"; 
            String choice; 
            String newFileName; 

            //file reader
            FileReader fr = new FileReader(fileName);

            //user reader
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader keyboard = new BufferedReader(isr);

            if(fileName.contains(option1))
                newFileName = fileName.replace(option1, "_"); 
            else if (fileName.contains(option2))
                newFileName = fileName.replace(option2,"_"); 
            else
            {
                newFileName = null; 
                System.out.println("New file was not created"); 
            }

            //file writer
            FileWriter fw = new FileWriter(newFileName+type);

            //buffered reader/ writer
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw);

            System.out.println("\n"); 

            System.out.println("All tags have been removed. '"+newFileName+"tag-free.txt' has been\ncreated with the following content:  \n");
            while((line = br.readLine()) != null)
            {

                line= line.replaceAll("\\<[^>]*>","");

                bw.write(line); 
                System.out.println(line); 

            }

            //Close the buffer reader/ writer
            br.close();
            bw.close(); 

        }
        catch(Exception e){
            System.out.println("Error while writing file:" +e.getMessage()); 
        }

    }

    /**
     * This function searches and eliminates a word based on what the user inputs as well as outputs the count
     * A new file ending in '_updated.txt' stores these changes. 
     * I decided to store the new changes in a new file rather than making the changes in the same '_tag-free.txt' file 
     * because I wanted the user to have the option of viewing the original '_tag-free.txt' file at all times. 
     * 
     */
    public void searchAndEliminate(String fileName)
    {
        try{
            //variables
            int count =0;
            String updatedFile;
            String tempLine="";
            String option1 = "_tag-free.txt";
            String type1 ="updated.txt"; 

            //filereader
            FileReader fr = new FileReader(fileName);
            //user reader
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader keyboard = new BufferedReader(isr);

            if(fileName.contains(option1))
                updatedFile = fileName.replace(option1,"_");
            else
            {
                updatedFile = null; 
                System.out.println("Updated file not created"); 
            }

            //file writer
            FileWriter fw = new FileWriter(updatedFile+type1); //new file is created with edits

            //buffered reader/ writer
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw);

            System.out.println("Please enter a word you would like to remove from this file: ");
            String toDelete = keyboard.readLine(); 

            String[]splitwords = fileName.split(" "); 

            while((line = br.readLine()) != null)
            {
                tempLine= line; // tempLine holds original content of line before deletion of particular string of characters take place

                line= line.replace(toDelete,""); 
                if(line != tempLine) 
                    count++;    
                bw.write(line); 

            }
            System.out.println("\n"+ count+" instance(s) of '"+toDelete+"' has been detected"); 
            System.out.println("These detections have been eliminated and stored in a new file named: "+updatedFile+type1); 

            br.close();
            bw.close(); 

        }
        catch(Exception e){
            System.out.println("Error while writing file:" +e.getMessage()); 
        }

    }
}
