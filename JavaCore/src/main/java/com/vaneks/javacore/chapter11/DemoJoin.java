package chapter11;
class NewThread_4 implements Runnable {
    String name;
    Thread t;
    NewThread_4(String threadname) {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("Hoвый поток: " + t);
        t.start();
    }
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch(InterruptedException e){
            System.out.println(name + " прерван");
        }
        System.out.println(name + " завершен");
    }
}
public class DemoJoin {
    public static void main(String[] args) {
        NewThread_4 ob1 = new NewThread_4("Поток 1");
        NewThread_4 ob2 = new NewThread_4("Поток 2");
        NewThread_4 ob3 = new NewThread_4("Поток 3");
        System.out.println("Пoтoк Один запущен: " + ob1.t.isAlive());
        System.out.println("Пoтoк Два запущен: " + ob2.t.isAlive());
        System.out.println("Пoтoк Три запущен: " + ob3.t.isAlive());
        try {
            System.out.println("Oжидaниe завершения потоков.");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException е) {
            System.out.println("Глaвный поток прерван");
        }
        System.out.println("Пoтoк Один запущен: " + ob1.t.isAlive());
        System.out.println("Пoтoк Два запущен: "+ ob2.t.isAlive());
        System.out.println("Пoтoк Три запущен: " + ob3.t.isAlive());
        System.out.println("Глaвный поток завершен.");
    }
}
