/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This object stores the employee data from the CSV file
 * @author Howtoon
 */
public class EmployeeInfo {
    private ArrayList<Employee> allEmployees;
    private HashMap<String, ArrayList<Employee>> groups; //Key value pair to organize lists of employees by role
    private double totalSalary;

    public EmployeeInfo(ArrayList<Employee> allEmployees, HashMap<String, ArrayList<Employee>> groups, double totalSalary) 
    {
        this.allEmployees = allEmployees;
        this.groups = groups;
        this.totalSalary = totalSalary;
    }

    public ArrayList<Employee> getAllEmployees() {
        return allEmployees;
    }

    public void setAllEmployees(ArrayList<Employee> allEmployees) {
        this.allEmployees = allEmployees;
    }

    public HashMap<String, ArrayList<Employee>> getGroups() {
        return groups;
    }

    public void setGroups(HashMap<String, ArrayList<Employee>> groups) {
        this.groups = groups;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }
    
    
}
