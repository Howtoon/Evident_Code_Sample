/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
* The Employee object holds information about an employee
*/
public class Employee
{
   private String name;    //Employee's name
   private String dob;     //date of birth
   private double salary;  //annual salary
   private String role;    //role in the company

   /**
    * Creates an employee object
    * @param name
    * @param dob
    * @param salary
    * @param role 
    */
   public Employee(String name, String dob, double salary, String role)
   {
       this.name = name;
       this.dob = dob;
       this.salary = salary;
       this.role = role;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   public String getDob() {
       return dob;
   }

   public void setDob(String dob) {
       this.dob = dob;
   }

   public double getSalary() {
       return salary;
   }

   public void setSalary(double salary) {
       this.salary = salary;
   }

   public String getRole() {
       return role;
   }

   public void setRole(String role) {
       this.role = role;
   }

   @Override
   public String toString()
   {
       return role + " " + name + " " + salary; 
   }
}
