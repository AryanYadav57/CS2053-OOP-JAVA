package lab006;

class Printer1 {  
    // synchronized method
    synchronized void printNumbers(String threadName) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " prints: " + i);
            try {
                Thread.sleep(500); // slow down for visibility
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread1 extends Thread {  
    Printer1 printer;
    String threadName;

    MyThread1(Printer1 p, String name) {  
        printer = p;
        threadName = name;
    }

    public void run() {
        printer.printNumbers(threadName);
    }
}

public class SyncVer {
    public static void main(String[] args) {
        Printer1 p = new Printer1();  
        MyThread1 t1 = new MyThread1(p, "Thread-1");  
        MyThread1 t2 = new MyThread1(p, "Thread-2");  
        t1.start();
        t2.start();
    }
}
