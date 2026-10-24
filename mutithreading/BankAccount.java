package mutithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;


     // This one is for Implicit lock
//    public synchronized void withdraw(int amount) throws InterruptedException {
//        System.out.println(Thread.currentThread().getName()+" attempting to amount Rs."+ amount);
//        if(balance >= amount){
//            System.out.println(Thread.currentThread().getName()+" proceeding with withdraw");
//            Thread.sleep(3000);
//            balance -= amount;
//            System.out.println(Thread.currentThread().getName()+" completed withdrawal. Remaining balance Rs. "+balance);
//        }else {
//            System.out.println(Thread.currentThread().getName()+" insufficient balance");
//        }
//    }

    // This one is for Explicit lock
    private final Lock lock = new ReentrantLock();
    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" attempting to withdraw "+amount);

        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                if(balance >= amount){
                    try {
                        System.out.println(Thread.currentThread().getName()+" proceeding with withdrawal");
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() +" completed withdrawal. Remaining amount "+balance);
                    }catch (Exception e){
                        Thread.currentThread().interrupt();
                    }finally {
                        lock.unlock();
                    }
                }else {
                    System.out.println(Thread.currentThread().getName()+" insufficient balance");
                }
            }else {
                System.out.println(Thread.currentThread().getName()+" could not acquire the lock, will try again later");
            }
        }catch (Exception e){
            Thread.currentThread().interrupt();
        }
    }



}

class Main3{
    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount();
//        bankAccount.withdraw(50);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                bankAccount.withdraw(60);
            }
        };

        Thread t1 = new Thread(task,"thread1");
        Thread t2 = new Thread(task, "thread2");
        t1.start();
        t2.start();
    }
}
