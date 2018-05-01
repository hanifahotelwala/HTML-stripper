import java.io.*;
import java.util.Scanner;
import java.lang.*;
import java.lang.String; 

/**
 * HTMLStripper - CS 215 Final Project. 
 * 
 * HTMLStripperApp is in charge displaying a menu of options that the user has.
 * Based on what the user enter from the menu, several functions are called
 * such as: readFile(), findAndRemoveTags(), and searchAndEliminate().
 * 
 * @Hanifa Hotelwala
 * @version 1.0
 * 02/03/2018
 *
 */
public class HtmlStripperAPP
{
    public static void main(String[]args) throws IOException
    {
        // Prepare for input
        InputStreamReader isr = new InputStreamReader(System.in); 
        BufferedReader keyboard = new BufferedReader(isr); 
        
        //variables
        String inData; 
        String filename=""; 
        int choice = 0;
        String option= ".html"; 
        String option1= ".htm";
       
        //fileNew reference to the object from the HtmlStripper class
        HtmlStripper fileNew = new HtmlStripper(); 

        //displaying the menu 
        do
        {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Welcome to the HTML Stripper ");
            System.out.println("**** Please only submit .html or .htm files ****"); 
            System.out.println("Enter '1' -> Read the content of your .html or .html file");
            System.out.println("Enter '2' -> To remove all HTML tags in the file");
            System.out.println("Enter '3' -> To search and elimanate certain characters");
            System.out.println("Enter '4' -> To exit");

            System.out.println("----------------------------------------------------------------------");
            System.out.println("Your choice :  ");

            //Attempt to catch errors
            try{
                inData = keyboard.readLine();                
                choice = Integer.parseInt(inData);
                if (choice < 1 || choice > 4) {
                    System.out.println();
                    System.out.println("Invalid entry. Please enter an option from 1 to 3. ");
                    try{
                        inData = keyboard.readLine();              
                        choice = Integer.parseInt(inData);
                    }
                    catch (NumberFormatException ne){ //catches the invalid user input and continues to run the program
                        System.out.println();
                        System.out.println("Not possible. Please choose one of the options.");
                    }
                    catch (Exception e){   //catches the invalid user input and continues to run the program
                        System.out.println();
                        System.out.println("Not possible. Please choose one of the options. ");
                    }

                }
            }

            catch (NumberFormatException ne){  //catches the invalid user input and continues to run the program
                System.out.println();
                System.out.println("Not possible. Please choose one of the options. ");
            }

            if (choice == 1)
            {

                System.out.println("\nName of file: "); 

                try{
                    filename = keyboard.readLine(); 
                    File file = new File(filename); 
                    Scanner inputFile = new Scanner(file); 

                    String[]splitwords = filename.split(" "); 

                    for (int x =0; x< splitwords.length; x++)
                    {
                        if (filename.contains(option) || filename.contains(option1))
                        {
                            System.out.println("\nReading the file...."); 
                            System.out.println("----------------------------------");
                            fileNew.readFile(filename);
                            System.out.println("----------------------------------");
                        }
                        else
                            System.out.println("Please enter the name of the correct file format."); 

                    }
                }
                catch(FileNotFoundException exception){

                    System.out.println("The file was not found in the directory."); 
                }

            }

            else if (choice == 2)
            {
                System.out.println("\nName of file: "); 

                try{
                    filename = keyboard.readLine(); 
                    File file = new File(filename); 
                    Scanner inputFile = new Scanner(file); 

                    String[]splitwords = filename.split(" "); 

                    for (int x =0; x< splitwords.length; x++)
                    {
                        if (filename.contains(option) || filename.contains(option1))
                        {
                            System.out.println("\nReading the file....\n"); 
                            System.out.println("----------------------------------");
                            fileNew.findAndRemoveTags(filename); 
                            System.out.println("----------------------------------");
                        }
                        else
                            System.out.println("Please enter the name of the correct file format, ending in .html or .htm"); 

                    }
                }
                catch(FileNotFoundException exception){

                    System.out.println("The file was not found in the directory."); 
                }

            }
            else if(choice ==3)
            {
                System.out.println("\n");
                System.out.println("Please enter the '_tag-free.txt' file that was created in option 2"); 
                System.out.println("\nName of file: "); 
                String option3 = "tag-free.txt";
                String toDelete =""; 
                int count=0;

                try{
                    filename = keyboard.readLine(); 
                    File file = new File(filename); 
                    Scanner inputFile = new Scanner(file); 

                    String[]splitwords = filename.split(" "); 

                    for (int x =0; x< splitwords.length; x++)
                    {
                        if (filename.contains(option3))
                        {
                            fileNew.searchAndEliminate(filename);
                        }
                        else
                            System.out.println("Please enter the name of the correct file format.\nHint: file should end in _tag-free.txt "); 

                    }
                }
                catch(FileNotFoundException exception){

                    System.out.println("The file was not found in the directory."); 
                }

            }
            
            else if (choice == 4)
            {
                System.out.print("\n");
                System.out.print("Goodbye");
            }
        } 
        while (choice != 4); 

    }
}

