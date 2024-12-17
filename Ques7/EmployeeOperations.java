// this java class contains methods to write employee data to a file and read employee data from 2 files simultaneously
import java.io.*;
import java.util.*;

public class EmployeeOperations {

    //method to write employee data to a file
    public static void writeData(List<Employee> employees, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Employee employee : employees) {
                writer.write(employee.getId() + ", " + employee.getName() + ", " + employee.getSalary());
                writer.newLine();
            }
            System.out.println("Employee data written to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing employee data to file: " + fileName);
            e.printStackTrace();
        }
    }

    // Method to read employee data from two files using threads
    public static void readData(String file1, String file2) {
        //creating runnable tasks
        Runnable r1 = new EmployeeReaderTask(file1);
        Runnable r2 = new EmployeeReaderTask(file2);

        // creating threads
        Thread t1 = new Thread(r1, "Employees1 ");
        Thread t2 = new Thread(r2, "Employees2 ");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}