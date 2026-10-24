package mutithreading;

public class MyNewThread extends Thread{
    @Override
    public void run() {
        for(int i=1; i<=5; i++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        MyNewThread t1 = new MyNewThread();

        t1.start();
    }
}
