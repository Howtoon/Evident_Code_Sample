/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import domain.Employee;
import domain.EmployeeInfo;
import domain.InputParameters;
import input.implementation.ReadEmployeeFile;
import input.implementation.UserInput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import output.implementation.BLOPS;

/**
 *
 * @author Howtoon
 */
public class Client{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        InputParameters params = UserInput.getUserInput();
        EmployeeInfo employeeInfo = ReadEmployeeFile.readCSVFile(params.getFileReader());
        BLOPS.startBLOPS(employeeInfo, params.getSalaryLimit());
    }
}
