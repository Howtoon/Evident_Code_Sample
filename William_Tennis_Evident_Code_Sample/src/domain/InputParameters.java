/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Scanner;

/**
 * This object holds the users input parameters 
 * @author Howtoon
 */
public class InputParameters {
    Scanner fileReader;    // Name of CSV File to be parsed
    double salaryLimit = 0;    // Salary limit to be calculated

    public InputParameters(Scanner fileReader, double salaryLimit)
    {
        this.fileReader = fileReader;
        this.salaryLimit = salaryLimit;
    }
    
    public Scanner getFileReader() {
        return fileReader;
    }

    public void setFileReader(Scanner fileReader) {
        this.fileReader = fileReader;
    }

    public double getSalaryLimit() {
        return salaryLimit;
    }

    public void setSalaryLimit(double salaryLimit) {
        this.salaryLimit = salaryLimit;
    }
}
