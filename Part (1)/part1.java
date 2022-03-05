import java.util.*;
import java.io.*;

public class part1 {

    public static void main(String[] args) {
        // asks the user for a number and calls in the function createThreads and passes
        // that number
        // as an argument
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        int answer = enterRoom(createThreads(num));
        System.out.println("The minotaur expresses that you took " + answer + " steps to get to the exit. \n");

    }

    // function to take in a number and create a thread for each number and return
    // them
    // as an array
    public static Thread[] createThreads(int num) {
        Thread[] threads = new Thread[num];
        for (int i = 0; i < num; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    System.out.println("Thread " + Thread.currentThread().getName() + " is running");
                }
            });
            threads[i].start();
        }
        return threads;
    }

    // function that takes an array of threads and does the following:
    // 1. there is a room with a switch that can be on or off where all the threads
    // can go in, but only one thread can go in at a time.
    // 2. the first thread in the array which will be called Main Thread is going to
    // maintain a count of how many threads have entered the room, let the count be
    // 1 initially.
    // 3. when the Main thread enters the room, if the switch is on, it will turn
    // off the switch and increase the count by 1. if that count becomes equal to
    // the (thread length -1), then returns the counter. if the switch is off, do
    // nothing and come out of the room.
    // 4. if any other thread enters the room and the switch is off, then do nothing
    // and come out of the room.
    // 5. if the Main thread enters the room and the switch is on, then turn off the
    // switch and increase the count by 1. if that count becomes equal to (2
    // *(thread length -2)), then returns the counter, else do nothing and come out
    // of the room.
    // 6. if a other thread except the Main thread enters the room and knows the
    // switch is off for the second time then turn on the switch. else do nothing.
    // return the counter.
    public static int enterRoom(Thread[] threads) {
        int count = 1;
        boolean switchOn = true;
        for (int i = 0; i < threads.length; i++) {
            if (i == 0) {
                synchronized (threads[i]) {
                    while (switchOn) {
                        try {
                            threads[i].wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    if (count == threads.length - 1) {
                        return count;
                    }
                }
            } else {
                synchronized (threads[i]) {
                    if (switchOn) {
                        switchOn = false;
                        count++;
                        if (count == (threads.length - 1) * 2) {
                            return count;
                        }
                    } else {
                        try {
                            threads[i].wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return count;
    }

}