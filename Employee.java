package lab.lab9;

public class Employee {
    private String name;
    private String department;
    private String email;
    public Employee(String name , String department , String email){
        this.department = department;
        this.name = name;
        this.email = email;
    }

    public void setDepartment(String department) {this.department = department;}
    public void setEmail(String email) {this.email = email;}
    public void setName(String name) {this.name = name;}
    public String getName(){return this.name;}
    public String getDepartment(){return this.department;}
    public String getEmail(){return this.email;}

    public String toString(){
        return "Name: " + name + " | Department: " + department + " | Email: " + email;
    }


}

