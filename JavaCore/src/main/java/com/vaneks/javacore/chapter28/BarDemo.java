package main.java.com.vaneks.javacore.chapter28;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction() );
        System.out.println("Зaпycк потоков");
        new MyThread1(cb, "А");
        new MyThread1(cb, "В");
        new MyThread1(cb, "С");
        new MyThread1(cb, "E");
        new MyThread1(cb, "F");
        new MyThread1(cb, "G");
        new MyThread1(cb, "Х");
        new MyThread1(cb, "У");
        new MyThread1(cb, "Z");
    }
}
class MyThread1 implements Runnable {
    CyclicBarrier cbar;
    String name;

    MyThread1(CyclicBarrier c, String n) {
        cbar = c;
        name = n;
        new Thread(this).start();
    }

    public void run() {
        System.out.println(name);

        try {
            cbar.await();
        } catch (BrokenBarrierException exc) {
            System.out.println(exc);
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }
}
class BarAction implements Runnable {
    public void run() {
        System.out.println("Бapьep достигнут!");
    }
}

