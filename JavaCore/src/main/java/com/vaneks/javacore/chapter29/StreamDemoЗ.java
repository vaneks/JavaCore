package main.java.com.vaneks.javacore.chapter29;

import java.util.ArrayList;

public class StreamDemoЗ {
    public static void main(String[] args) {
        ArrayList<Double> myList = new ArrayList<>( );
        myList.add(7.0);
        myList.add(18.0);
        myList.add(10.0);
        myList.add(24.0);
        myList.add(17.0);
        myList.add(5.0);
        double productOfSqrRoots = myList.parallelStream().reduce(1.0,
                (а,b) ->а* Math.sqrt(b),
                (а,b) -> а * b) ;

        System.out.println("Пpoизвeдeниe квадратных корней:" + productOfSqrRoots);
    }
}
