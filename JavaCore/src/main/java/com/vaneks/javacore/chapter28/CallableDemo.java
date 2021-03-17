package main.java.com.vaneks.javacore.chapter28;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String args[]) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer> f;
        Future<Double> f2;
        Future<Integer> fЗ;
        System.out.println("Запуск");
        f = es.submit(new Sum(10));
        f2 = es.submit(new Hypot(3, 4));
        fЗ = es.submit(new Factorial(5));
        try {
            System.out.println(f.get());
            System.out.println(f2.get());
            System.out.println(fЗ.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        es.shutdown();
        System.out.println("Зaвepшeниe");
    }
}
class Sum implements Callable<Integer> {
    int stop;
    Sum(int v) {
        stop = v;
    }
    public Integer call() {
    int sum = 0;
    for(int i = 1; i <= stop; i++) {
        sum += i;
    }
        return sum;
    }
}
class Hypot implements Callable<Double> {
    double side1, side2;

    Hypot(double sl, double s2) {
        side1 = sl;
        side2 = s2;
    }

    public Double call() {
        return Math.sqrt((side1 * side1) + (side2 * side2));
    }
}
class Factorial implements Callable<Integer> {
    int stop;
    Factorial ( int v) { stop =  v; }
    public Integer call() {
        int fact = 1;
        for(int i = 2; i <= stop; i++) {
            fact *= i;
        }
            return fact;
    }
}
