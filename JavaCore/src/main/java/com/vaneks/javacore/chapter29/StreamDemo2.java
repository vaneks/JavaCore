package main.java.com.vaneks.javacore.chapter29;

import java.util.ArrayList;
import java.util.Optional;

public class StreamDemo2 {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>( );
        myList.add(7);
        myList. add ( 18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);
        Optional<Integer> productObj =
                myList.stream() .reduce( (а,b) -> а*b);
        if(productObj.isPresent())
            System.out.println("Пpoизвeдeниe в виде объекта "
                    + "типа Optional: " + productObj.get());
        int product = myList.stream() .reduce(1, (а,b) -> а*b);
        System.out.println("Пpoизвeдeниe в виде значения типа int: " + product);
    }
}
