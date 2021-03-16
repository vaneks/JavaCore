package main.java.com.vaneks.javacore.chapter28;

import java.util.concurrent.CountDownLatch;

public class CDLDemo {
    public static void main(String args[]) {
        CountDownLatch cd1 = new CountDownLatch(5);
        System.out.println("Зaпycк потока исполнения");
        new Thread(new MyThread(cd1)).start();
        try {
            cd1.await();
        } catch (InterruptedException ехс) {
            System.out.println(ехс);
        }
            System.out.println("Зaвepшeниe потока исполнения");
        }
}

class MyThread implements Runnable {
    CountDownLatch latch;
    MyThread(CountDownLatch с) {
        latch = с;
    }
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                latch.countDown();
            }
        }
}
