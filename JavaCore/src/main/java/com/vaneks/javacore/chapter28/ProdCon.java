package main.java.com.vaneks.javacore.chapter28;

import java.util.concurrent.Semaphore;

class Q {
    int n;
    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);
    void get() {
        try {
            semCon.acquire();
        } catch(InterruptedException е) {
            System.out.println("Пepexвaчeнo исключение"
                    + "типа InterruptedException");
        }
        System.out.println("Пoлyчeнo: " + n);
        semProd.release();
    }
    void put (int n) {
        try {
            semProd.acquire();
        } catch (InterruptedException е) {
            System.out.println("Пepexвaчeнo исключение "
                    + "типа InterruptedException");
        }
        this.n = n;
        System.out.println("Oтnpaвлeнo: " + n);
        semCon.release();
    }
}

class Producer implements Runnable {
    Q q;
    Producer(Q q){
        this.q = q;
        new Thread(this, "Producer").start();
    }
    public void run(){
        for(int i=0; i < 20; i++) q.put(i);
    }
}

class Consumer implements Runnable {
    Q q;
    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer") .start();
    }
    public void run() {
        for (int i = 0; i < 20; i++) q.get();
    }
}
class ProdCon {
    public static void main(String args[]) {
        Q q = new Q();
        new Thread(new Producer(q), "Producer").start();
        new Thread(new Consumer(q), "Consumer").start();
    }
}
