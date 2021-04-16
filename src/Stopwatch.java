import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Stopwatch extends Thread {
// initialise variables
    public String name;
    public String time;
    public static int counter = 0;
    public static int seconds = 0;
    public static int minutes= 0;
    public static int hours = 0;
    public static Boolean isTrue = true;


    public static Lock lock = new ReentrantLock();

    public Stopwatch() {

    }

    public Stopwatch(String name)
    {
        this.name = name;
    }
  // this method will increment the counter (miliseconds by 10) then convert them to seconds, which will be converted to minutes and finally hours
    public void run()
    {

        while (isTrue) {
            lock.lock();

//            time = hours + ":" + minutes +":" +seconds + ":" + counter;
            System.out.println(hours + ":" + minutes +":" +seconds + ":" + counter);
            counter = counter +10;
            if (counter == 100){
                counter = 0;
                seconds ++;
                if (seconds == 60){
                    seconds = 0;
                    minutes ++;
                    if (minutes == 60 ){
                        minutes = 0;
                        hours++;
                    }
                    }
            }
            lock.unlock();
            try {
                Thread.sleep( 100);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        Stopwatch s1 = new Stopwatch("S1");
// starts the stopwatch
        s1.start();
    }
// Getters and Setters
    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Stopwatch.counter = counter;
    }

    public static int getSeconds() {
        return seconds;
    }

    public static void setSeconds(int seconds) {
        Stopwatch.seconds = seconds;
    }

    public static int getMinutes() {
        return minutes;
    }

    public static void setMinutes(int minutes) {
        Stopwatch.minutes = minutes;
    }

    public static int getHours() {
        return hours;
    }

    public static void setHours(int hours) {
        Stopwatch.hours = hours;
    }
}
