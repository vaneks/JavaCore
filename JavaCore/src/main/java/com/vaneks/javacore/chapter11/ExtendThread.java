package chapter11;

class NewThread_2 extends Thread {
    NewThread_2() {
        super( "Демонcтрационный поток");
        System.out.println("Дочерний поток создан: " + this);
        start();
    }

    @Override
    public void run() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Дочерний поток: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Дочерний поток прерван");
        }
        System.out.println("Дочерний поток завершен");
    }
}
public class ExtendThread {
    public static void main(String[] args) {
        new NewThread_2();
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Главный поток: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }
        System.out.println("Главный поток завершен");
    }

}
