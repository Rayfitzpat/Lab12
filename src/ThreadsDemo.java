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


    // asks the user for a starting number and then counts down to zero
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
//
// starts the thread
        t1.start();
//
    }
}
