package lab006;

class MessageSender {
    // Synchronized method to prevent message mixing
    synchronized void sendMessage(String msg, String threadName) {
        System.out.println(threadName + " sending message: " + msg);
        try {
            Thread.sleep(500); // Small delay to simulate message sending
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SenderThread extends Thread {
    MessageSender sender;
    String msg;
    String threadName;

    SenderThread(MessageSender sender, String msg, String threadName) {
        this.sender = sender;
        this.msg = msg;
        this.threadName = threadName;
    }

    public void run() {
        sender.sendMessage(msg, threadName);
    }
}

public class MessageDemo {
    public static void main(String[] args) {
        MessageSender sender = new MessageSender();

        SenderThread t1 = new SenderThread(sender, "Hello from Thread-1", "Thread-1");
        SenderThread t2 = new SenderThread(sender, "Hello from Thread-2", "Thread-2");

        t1.start();
        t2.start();
    }
}

