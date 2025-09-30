package lab006;

class TablePrinter {
    // Synchronized method to ensure one thread completes the full table
    synchronized void printTable(int number, String threadName) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(threadName + " prints: " + number + " * " + i + " = " + (number * i));
            try {
                Thread.sleep(300); // Slow down for visibility
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TableThread extends Thread {
    TablePrinter printer;
    int number;
    String threadName;

    TableThread(TablePrinter printer, int number, String threadName) {
        this.printer = printer;
        this.number = number;
        this.threadName = threadName;
    }

    public void run() {
        printer.printTable(number, threadName);
    }
}

public class TableDemo {
    public static void main(String[] args) {
        TablePrinter printer = new TablePrinter();

        TableThread t1 = new TableThread(printer, 5, "Thread-1");
        TableThread t2 = new TableThread(printer, 5, "Thread-2");

        t1.start();
        t2.start();
    }
}