package main.java.com.vaneks.javacore.chapter28;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(new LockThread(lock,"A")).start();
        new Thread(new LockThread(lock,"B")).start();
    }
}
class Shared {
    static int count =0;
}
class LockThread implements Runnable {
    String name;
    ReentrantLock lock;
    LockThread(ReentrantLock lk, String n) {
        lock = lk;
        name = n;
    }
    public void run() {
        System.out.println("Зaпycк потока " + name);
        try {
            System.out.println("Пoтoк " + name + " ожидает блокировки счетчика");
            lock.lock();
            System.out.println("Пoтoк " + name + " блокирует счетчик.");
            Shared.count++;
            System.out.println("Пoтoк " + name + " " + Shared.count);
            System.out.println("Пoтoк " + name + " ожидает");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            System.out.println("Пoтoк " + name +  " разблокирует счетчик");
            lock.unlock();
        }
    }
}
