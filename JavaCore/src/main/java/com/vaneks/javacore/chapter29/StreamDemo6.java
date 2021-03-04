package main.java.com.vaneks.javacore.chapter29;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class StreamDemo6 {
    public static void main(String[] args) {
        ArrayList<Double> myList = new ArrayList<>( ) ;
        myList.add(1.1);
        myList.add(3.6);
        myList.add(9.2);
        myList.add(4.7);
        myList.add(12.1);
        myList.add(5.0);
        System.out.print("Иcxoдныe значения из списка myList: ");
        myList.stream().forEach( (a)-> {
            System.out.print(a + " ");
        } ) ;
        System.out.println();
        IntStream cStrm = myList.stream()
                .mapToInt((a) -> (int) Math.ceil(a) );
        System.out.print("Maкcимaльнo допустимые пределы "
                + " значений из списка myList: ");
        cStrm. forEach ( (a) -> {
            System.out.print(a + " ");
        } ) ;
    }
}
