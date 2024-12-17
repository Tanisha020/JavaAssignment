// modified class with thread saftey

class PrinterManagerModified {
    private static PrinterManagerModified printer;

    private PrinterManagerModified() {
        System.out.println("Printer created.");
    }

    public static PrinterManagerModified getPrinter() {
        if (printer == null) {
            //using block synchronization to prevent access at same time
            synchronized (PrinterManagerModified.class) {
                if (printer == null) {
                    printer = new PrinterManagerModified();
                }
            }
        }
        return printer;
    }

    public void printDocument(String document) {
        System.out.println("Printing document: " + document);
    }
}

public class MainSynchronized {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                PrinterManagerModified manager = PrinterManagerModified.getPrinter();
                manager.printDocument("Shared Document");
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
    }
}