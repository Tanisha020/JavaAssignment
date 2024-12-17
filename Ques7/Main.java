//Main class for demonstration
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Employee1", 67000.0));
        employees.add(new Employee(2, "Employee2", 55000.78));
        employees.add(new Employee(3, "Employee3", 120000.14));
        employees.add(new Employee(4, "Employee4", 135000.78));
        employees.add(new Employee(5, "Employee5", 115000.0));
        employees.add(new Employee(6, "Employee6", 94000.26));
        employees.add(new Employee(7, "Employee7", 82000.48));

        // Write employee data
        System.out.println("Writing employee data");
        EmployeeOperations.writeData(employees, "employees.txt"); 

        // Reading employee data from both files (employees1.txt and employees2.txt) simultaneously
        System.out.println("Reading employee data from both files\n");
        EmployeeOperations.readData("employees1.txt", "employees2.txt");
    }
}