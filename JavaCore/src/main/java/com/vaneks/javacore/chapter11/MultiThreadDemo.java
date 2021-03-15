package chapter11;
class NewThread_3 implements Runnable {
    String name;
    Thread t;
    NewThread_3(String threadname) {
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
public class MultiThreadDemo {
    public static void main(String[] args) {
        new NewThread_3("Поток 1");
        new NewThread_3("Поток 2");
        new NewThread_3("Поток 3");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Глaвный поток прерван");
        }
        System.out.println("Глaвный поток завершен");
    }
}
