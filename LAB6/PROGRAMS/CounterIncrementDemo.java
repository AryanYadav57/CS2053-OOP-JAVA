package lab006;

class Counter {
    private int count = 0;

    // Synchronized method to ensure correct increment
    synchronized void increment() {
        count++;
    }

    int getCount() {
        return count;
    }
}

class IncrementThread extends Thread {
    Counter counter;

    IncrementThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class CounterIncrementDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // Starting two threads to increment the counter
        IncrementThread t1 = new IncrementThread(counter);
        IncrementThread t2 = new IncrementThread(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final counter value: " + counter.getCount());
    }
}