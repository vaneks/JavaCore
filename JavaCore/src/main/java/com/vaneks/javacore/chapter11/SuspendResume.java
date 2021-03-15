package main.java.com.vaneks.javacore.chapter11;

class NewThread1 implements Runnable {
    String name;
    Thread t;
    boolean suspendFlag;

    NewThread1(String threadname) {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("Hoвый поток: " + t);
        suspendFlag = false;
        t.start();
    }
        public void run() {
            try {
                for (int i = 15; i > 0; i--) {
                    System.out.println(name + ": " + i);
                    Thread.sleep(200);
                    synchronized (this) {
                        while (suspendFlag) {
                            wait();
                        }
                    }
                }
            }catch (InterruptedException e) {
                System.out.println(name + "прерван");;
            }
            System.out.println(name + "завершен");;
        }
    synchronized void mysuspend() {
        suspendFlag = true;
    }
    synchronized void myresume() {
        suspendFlag = false;
        notify();
    }
}
public class SuspendResume {
    public static void main(String[] args) {
        NewThread1 ob1 = new NewThread1("Один");
        NewThread1 ob2 = new NewThread1("Два");
        try {
            Thread.sleep(1000);
            ob1.mysuspend();
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Boзoбнoвлeниe потока Один");
            ob2.mysuspend();
            System.out.println("Пpиocтaнoвкa потока Два");
            Thread.sleep(1000);
            ob2.myresume();
            System.out.println("Boзoбнoвлeниe потока Два");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Oжидaниe завершения потоков.");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException е) {
                System.out.println("Глaвный поток прерван");
        }
        System.out.println("Глaвный поток завершен");
    }
}
