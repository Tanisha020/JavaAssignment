//this is a java class which defines a task for reading employee data
import java.io.*;

public class EmployeeReaderTask implements Runnable {
    private String fileName;

    public EmployeeReaderTask(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(Thread.currentThread().getName() + ": " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
