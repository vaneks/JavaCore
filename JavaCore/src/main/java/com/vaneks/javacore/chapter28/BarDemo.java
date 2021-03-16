package main.java.com.vaneks.javacore.chapter28;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction() );
        System.out.println("Зaпycк потоков");
        new Thread(new MyThread1(cb, "А")).start();
        new Thread(new MyThread1(cb, "В")).start();
        new Thread(new MyThread1(cb, "С")).start();
        new Thread(new MyThread1(cb, "Х")).start();
        new Thread(new MyThread1(cb, "У")).start();
        new Thread(new MyThread1(cb, "Z")).start();
    }
}
class MyThread1 implements Runnable
{
    CyclicBarrier cbar;
    String name;

    MyThread1(CyclicBarrier c, String n) {
        cbar = c;
        name = n;
    }

    public void run() {
        System.out.println(name);
        try {
            cbar.await();
        } catch (BrokenBarrierException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class BarAction implements Runnable {
    public void run() {
        System.out.println("Бapьep достигнут!");
    }
}

