// This java class contains methods to write employee data to a file and read employee data from 2 files simultaneously
import java.io.*;
import java.util.*;

public class EmployeeOperations {

    // Method to write employee data to a file
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
        Object lock = new Object(); // lock for synchronization
        boolean[] turn = {true};   // Flag: true for thread1, false for thread2

        Runnable task1 = new FileReaderRunnable(file1, lock, turn, true); //reader 1 starts first
        Runnable task2 = new FileReaderRunnable(file2, lock, turn, false); // reader 2 starts second

        Thread t1 = new Thread(task1, "Employees1");
        Thread t2 = new Thread(task2, "Employees2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Class for file reading tasks
    private static class FileReaderRunnable implements Runnable {
        private final String fileName;
        private final Object lock;
        private final boolean[] turn;
        private final boolean isFirst;

        public FileReaderRunnable(String fileName, Object lock, boolean[] turn, boolean isFirst) {
            this.fileName = fileName;
            this.lock = lock;
            this.turn = turn;
            this.isFirst = isFirst;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while (true) {
                    synchronized (lock) {
                        while (turn[0] != isFirst) {
                            lock.wait(); // Wait for its turn
                        }

                        if ((line = reader.readLine()) == null) {
                            turn[0] = !isFirst; // Allow the other thread to finish
                            lock.notifyAll();
                            break;
                        }

                        System.out.println(Thread.currentThread().getName() + ": " + line);
                        turn[0] = !turn[0]; // Switch the turn
                        lock.notifyAll();
                    }
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
