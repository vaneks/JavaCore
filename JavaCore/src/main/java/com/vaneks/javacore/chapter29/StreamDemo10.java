package main.java.com.vaneks.javacore.chapter29;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamDemo10 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        myList.add ("Альфа") ;
        myList.add ("Бета");
        myList.add ("Гамма");
        myList.add( "Дельта");
        myList.add("Kcи");
        myList.add ("Омега");
        Stream<String> myStream = myList.stream();
        Spliterator<String> splititr = myStream.spliterator();
        Spliterator<String> splititr2 = splititr.trySplit();
        if(splititr2 != null) {
            System.out.println("Результат, выводимый итератором splititr2: ");
            splititr2.forEachRemaining((n) ->
                    System.out.println(n));
        }
        System.out.println( "\nРезультат, выводимый итератором splititr: ");
        splititr.forEachRemaining((n) -> System.out.println(n));
    }
}
