/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package output.implementation;

import domain.Employee;
import domain.EmployeeInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * This class is a Binomial Linear Optimization Problem Solver for a set of employees with a given salary cap
 * it contains only static methods
 * @author Howtoon
 */
public class BLOPS {
    
    /**
     * This method starts the Binomial Linear Optimization process 
     * @param employeeInfo
     * @param salaryLimit
     */
    public static void startBLOPS(EmployeeInfo employeeInfo, double salaryLimit)
    {
        System.out.print("\n\nThe total salary for all employees is:\n");

        printTotals(employeeInfo.getTotalSalary());       //prints the totals based on time breakdown (year, month, day, etc.)

        printTotalsByRole(employeeInfo.getGroups());

        System.out.println("These are all groupings of employees whose sum of annual salary\n are as close to the salary limit (without going over)");
        printAllPossibleSets(employeeInfo.getAllEmployees(), salaryLimit);  //prints all the sets that are possible without going over and without being able to add more employees
    }
    
    /**
     * prints the total salary for each role
     * @param groups
     */
    private static void printTotalsByRole(HashMap<String, ArrayList<Employee>> groups)
    {
        System.out.println("The total salary per role:\n");

        for (Map.Entry<String, ArrayList<Employee>> entry : groups.entrySet()) 
        {
            double total = 0;       //tally variable
            for (Employee i : entry.getValue()) //iterate over the array
            {
                total += i.getSalary();     //tally up the total
            }

            System.out.print(entry.getKey() + ":\n");   //print the name of the role
            printTotals(total);     //prints the totals based on time breakdown (year, month, day, etc.)
        }
    }
    
    /**
     * Prints the largest possible sets of employees without going over budget
     * @param allEmployees
     * @param salaryLimit 
     */
    private static void printAllPossibleSets(ArrayList<Employee> allEmployees, double salaryLimit)
    {
        HashSet<HashSet<Employee>> setsOfEmployees = new HashSet<>();   //create a master set of sets
        for (int i = 0; i<allEmployees.size(); i++) //start from the first position
        {   
            ArrayList<Employee> set = new ArrayList<>();    //set to build on
            ArrayList<Employee> compSet = new ArrayList<>();    //set to compare to
            int total = 0;                                      //tally variable
            if (allEmployees.get(i).getSalary() <= salaryLimit)  //check if the element being tested can be added
            {
                set.add(allEmployees.get(i));           //add it to the set
                total += allEmployees.get(i).getSalary();   //add to the tally
            }
            else            //if it cannot be added, goto the next element
            {
                continue;
            }
            compSet.addAll(allEmployees);           //create the comparison set
            compSet.remove(allEmployees.get(i));    //remove the element that is being tested from the comparison set
            int k = i+1;                            //start at the next element (this is the index variable)
            for (int j = 0; j < compSet.size(); j++) {  //compare the test element to all other elements
                if (k > compSet.size() - 1)         //if the end of the array is reached, start at the beginning
                {
                    k = 0;          
                }
                if (total + compSet.get(k).getSalary() <= salaryLimit)  //check if the comparison element can be added
                {
                    set.add(compSet.get(k));        //add the comarison element
                    if (setsOfEmployees.contains(new HashSet<>(set)))     //check if the master set of sets already contains this set
                    {
                        set.remove(compSet.get(k));     //if the master set of sets already contains this set, then remove the last entry and move on
                    }
                    else
                    {
                        total += compSet.get(k).getSalary();        //add to the tally the total
                        compSet.remove(compSet.get(k));         //remove the variable that has been added so it does not get compared again
                        j--;        //decrement the counter variable to account for the removed element
                    }
                }
                k++;        //increment the index variable
            }
            if (!setsOfEmployees.contains(new HashSet<>(set)))
            {
                boolean isSubset = false;       //set a boolean to test for subsets
                for (HashSet<Employee> masterSet : setsOfEmployees) //interate through the master set of sets
                {
                    if (masterSet.containsAll(set)) //check if the new set is a sub set of another set
                    {
                        isSubset = true;
                    }
                }
                if (!isSubset)      //if it is not a subset of another set, then add it to the master set of sets
                {
                    setsOfEmployees.add(new HashSet<>(set));
                    System.out.println(set);    //print the set because it is unique
                }
            }
        }
    }
    
    /**
     * Prints the break down from annual salary to monthly, weekly, daily, etc.
     * @param total 
     */
    private static void printTotals(double total)
    {
        System.out.print("per year\t");
        System.out.printf("%.2f\n",total);

        System.out.print("per month\t");
        System.out.printf("%.2f\n",(total/12));

        System.out.print("per week\t");
        System.out.printf("%.2f\n",(total/52));

        System.out.print("per day\t\t");
        System.out.printf("%.2f\n",(total/(52*5)));

        System.out.print("per hour\t");
        System.out.printf("%.2f\n",(total/(52*5*8)));

        System.out.print("per minute\t");
        System.out.printf("%.2f\n\n",(total/(52*5*8*60)));
    }
}
