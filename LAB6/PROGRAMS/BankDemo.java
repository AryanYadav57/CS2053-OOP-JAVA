package lab006;
class BankAccount {
    private int balance = 1000;

    // synchronized method to prevent race conditions
    synchronized void withdraw(String name, int amount) {
        if (balance >= amount) {
            System.out.println(name + " is withdrawing " + amount);
            try { Thread.sleep(500); } catch (Exception e) {}
            balance -= amount;
            System.out.println(name + " completed withdrawal. Remaining balance: " + balance);
        } else {
            System.out.println(name + " tried to withdraw " + amount + " but insufficient funds!");
        }
    }
}

class WithdrawalThread extends Thread {
    BankAccount account;
    String personName;
    int amount;

    WithdrawalThread(BankAccount acc, String name, int amt) {
        account = acc;
        personName = name;
        amount = amt;
    }

    public void run() {
        account.withdraw(personName, amount);
    }
}

public class BankDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        WithdrawalThread t1 = new WithdrawalThread(account, "Person-1", 700);
        WithdrawalThread t2 = new WithdrawalThread(account, "Person-2", 500);

        t1.start();
        t2.start();
    }
}

