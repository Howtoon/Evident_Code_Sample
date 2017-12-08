/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input.implementation;

import domain.InputParameters;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 * This class is strictly for taking in the user input of filename and salary cap
 * it contains only static methods
 * @author Howtoon
 */
public class UserInput 
{
    private static String fileName;    // Name of CSV File to be parsed
    private static double salaryLimit = 0;    // Salary limit to be calculated
    private static boolean isDone = false;     //boolean for controlling whether input is complete or not
    private static Scanner file = null;         //Scanner to read the data from the file
    private static final Scanner KB = new Scanner(System.in);    //Scanner for keyboard input
        
    /**
     * Takes in the user input fileName and salaryCap and verifies that they are valid.
     * @return 
     */
    public static InputParameters getUserInput()
    {
        do{
            System.out.print("Enter the absolute path of the CSV file\nOr press <Enter> to browse and select a file:");
            fileName = KB.nextLine();       // Get the absolute path of the CSV File
            if (fileName.compareToIgnoreCase("")==0) //if the user presses enter with no input, the file chooser dialog will open
            {
                JFileChooser chooser = new JFileChooser();
                int returnVal = chooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    fileName = chooser.getSelectedFile().getAbsolutePath();
                    System.out.println("You selected: " +
                    chooser.getSelectedFile().getName());
                    isDone = true;
                }
                else{
                    System.out.println("You chose to cancel. Goodbye.");
                    System.exit(0);
                }
            }
            try{
                file = new Scanner(new File(fileName));
                isDone = true;  //the file path was valid
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File "+ fileName + " Not Found.");
            }
        }
        while(!isDone);
        isDone = false;
        do{
            System.out.print("\nEnter the salary limit: ");   //promt the user for input
            try{
                salaryLimit = Double.parseDouble(KB.nextLine());
                isDone = true;  //the salary limit was valid
            }
            catch(Exception e)      //if an error is made when entering the salary limit
            {
                //error message
                System.out.println("You did not enter a valid numerical value, Please try again.");
            }
        }
        while(!isDone);
        
        return new InputParameters(file, salaryLimit);
    }
}
