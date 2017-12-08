/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input.implementation;

import domain.Employee;
import domain.EmployeeInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * This class is strictly for reading a CSV file of employee information
 * it contains only static methods
 * @author Howtoon
 */
public class ReadEmployeeFile {
    private static ArrayList<Employee> allEmployees = new ArrayList<>();
    private static HashMap<String, ArrayList<Employee>> groups = new HashMap<>(); //Key value pair to organize lists of employees by role
    private static double totalSalary = 0;
    private static Scanner file; 
    
    /**
     * Reads a CSV file of employee information and returns an EmplyeeInfo object
     * @param file
     * @return 
     */
    public static EmployeeInfo readCSVFile(Scanner file)
    {
        while(file.hasNextLine())
            {
                String data = file.nextLine();  //get the next line from the CSV file
                StringTokenizer tokens = new StringTokenizer(data, ",");    //create a tokenizer to read the CSV line
                String name = tokens.nextToken();   //first entry should be the name
                String dob = tokens.nextToken();    //then date of birth
                double salary = Double.parseDouble(tokens.nextToken()); //then the annual salary
                totalSalary += salary;      //add the new salary to the total of all salaries
                String role = tokens.nextToken();   //then the role of the new employee
                Employee newGuy = new Employee(name, dob, salary, role);    //create the new employee object
                allEmployees.add(newGuy);   //add the new employee to the master list of employees
                if (groups.containsKey(newGuy.getRole()))   // if the role of this employee already exists
                {
                    groups.get(newGuy.getRole()).add(newGuy);   //add the new guy to the existing list
                }
                else    //if the role does not exist
                {
                    ArrayList<Employee> newList = new ArrayList<>();    //create a new list
                    newList.add(newGuy);
                    groups.put(newGuy.getRole(), newList);          //put the new list into the map of roles using the new role as the key
                }
            }
        return new EmployeeInfo(allEmployees, groups, totalSalary);
    }
}
