package lab.lab9;

public class EmployeeTest {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        manager.loadEmployeesFromFile("q3.txt");
        manager.addEmployee("Ali Veli", "IT", "ali@sirket.com");
        manager.addEmployee("Ayse Can", "HR", "ayse@sirket.com");
        manager.displayEmployees();
        manager.searchEmployee("Ali Veli");
    }
}

