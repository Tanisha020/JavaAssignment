/*Example: Printer Manager (Managing a Shared Printer in an Office)
In an office, there is often a single shared printer. A PrinterManager class can ensure that only one printer is used to manage all print requests, preventing multiple printers from conflicting with each other.
*/

class PrinterManager {
    private static PrinterManager printer;

    // Private constructor to restrict instance to one
    private PrinterManager() {
        System.out.println("Printer created.");
    }

    public static PrinterManager getPrinter() {
        if (printer == null) {
            printer = new PrinterManager();
        }
        return printer;
    }

    public void printDocument(String document) {
        System.out.println("Printing document: " + document);
    }
}

public class Main {
    public static void main(String[] args) {

        PrinterManager printer1 = PrinterManager.getPrinter();
        PrinterManager printer2 = PrinterManager.getPrinter();

        System.out.println(printer1 == printer2); // Output: true (same instance)

        printer1.printDocument("Employee List 1.txt");
        printer2.printDocument("Employee List 2.txt");
    }
}