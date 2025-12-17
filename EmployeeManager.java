package lab.lab9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeeManager {
    private Employee[] employees;
    private int employeeCount;
    public EmployeeManager(){
        this.employees = new Employee[100];
        this.employeeCount = 0;
    }
    public void loadEmployeesFromFile(String filePath){
        BufferedReader fileReader = null;
        try{
            fileReader = new BufferedReader(new FileReader(filePath));
            String line;
            while((line = fileReader.readLine()) != null){
                line=line.trim();
                if(line.length()==0){
                    continue;
                }
                String[] parts = line.split(",");
                if(parts.length == 3 ){
                    String name = parts[0].trim();
                    String department = parts[1].trim();
                    String email = parts[2].trim();
                    Employee newEmp = new Employee(name , department , email);
                    if(employeeCount<employees.length){
                        employees[employeeCount]=newEmp;
                        employeeCount++;
                    }else{
                        System.out.println("Array is full! ");
                    }
                }
            }
            System.out.println("Employees loaded successfully! Total: " + employeeCount);
        }catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
        }finally {
            try{
                if(fileReader != null){
                    fileReader.close();
                }
            }catch (IOException e){
                System.out.println("Error closing file.");
            }
        }
    }

    public void displayEmployees(){
        System.out.println("--- Employee List ---");
        for(int i = 0 ; i < employeeCount ; i++){
            System.out.println(employees[i].toString());
        }
    }

    public void addEmployee(String name, String department, String email){
        if(employeeCount<employees.length){
            Employee newEmp = new Employee(name, department, email);
            employees[employeeCount]=newEmp;
            employeeCount++;
        }else{
            System.out.println("List is full!");
            return;
        }
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter("q3.txt", true);
            String lineToWrite = name + "," + department + "," + email + "\n";
            fileWriter.write(lineToWrite);
        }catch (IOException e){
            System.err.println("Error appending to file.");
        }finally {
            try{
                if(fileWriter != null){
                    fileWriter.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing file.");
            }
        }
    }

    public void searchEmployee(String searchName) {
        boolean isFound = false;
        System.out.println("Searching for: " + searchName);
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getName().equalsIgnoreCase(searchName)) {
                System.out.println(employees[i].toString());
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("No employee found with name: " + searchName);
        }
    }
}
