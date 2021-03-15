package main.java.com.vaneks.javacore.chapter11;

class Callme {
    synchronized void call (String msg){
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Прервано");
        }
        System.out.println("]");
    }
}
class Caller implements Runnable {
    String msg;
    Callme target;
    Thread t;
    public Caller(Callme target, String s) {
        this.target = target;
        msg  = s;
        t = new Thread(this);
        t.start();
    }
    public  void run() {
        target.call(msg);
    }
}
public class Synch {
    public static void main(String[] args) {
        Callme target = new Callme();
        Caller ob1 = new Caller(target, "Добро пожаловать");
        Caller ob2 = new Caller(target,"в синхронизированный");
        Caller ob3 = new Caller(target, "мир!");
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Прервано");
        }
    }
}
