import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadsDemo extends Thread {

    public String name;
    public static int counter;

    public static Lock lock = new ReentrantLock();

    public ThreadsDemo(String name)
    {
        this.name = name;
    }

    public void run()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("please enter a starting number for the countdown:");
        counter = in.nextInt();
        while (true) {
            lock.lock();
            if (counter == 0)
                break;
            System.out.println("Thread " + name + " value " + counter);
            counter--;
            lock.unlock();
            try {
                Thread.sleep( 1000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

        ThreadsDemo t1 = new ThreadsDemo("T1");
//        ThreadsDemo t2 = new ThreadsDemo("T2");
//        ThreadsDemo t3 = new ThreadsDemo("T3");
//        ThreadsDemo t4 = new ThreadsDemo("T4");

        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        ThreadsDemo t5 = new ThreadsDemo("T5");
//        ThreadsDemo t6 = new ThreadsDemo("T6");
//        ThreadsDemo t7 = new ThreadsDemo("T7");
//        ThreadsDemo t8 = new ThreadsDemo("T8");
//
//        t5.start();
//        t6.start();
//        t7.start();
//        t8.start();
    }
}
