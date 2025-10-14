package lab07;

class SharedBuffer {
    private int data;
    private boolean available = false;

    public synchronized void produce(int value) {
        while (available) { 
            try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        data = value;
        available = true;
        System.out.println("Produced: " + value);
        notify(); 
    }

    
    public synchronized void consume() {
        while (!available) { 
            try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        System.out.println("Consumed: " + data);
        available = false;
        notify(); 
    }
}

class Producer extends Thread {
    SharedBuffer buffer;
    Producer(SharedBuffer b) { buffer = b; }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.produce(i);
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}

class Consumer extends Thread {
    SharedBuffer buffer;
    Consumer(SharedBuffer b) { buffer = b; }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.consume();
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();
        new Producer(buffer).start();
        new Consumer(buffer).start();
    }
}