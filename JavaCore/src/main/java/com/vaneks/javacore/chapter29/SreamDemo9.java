package main.java.com.vaneks.javacore.chapter29;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class SreamDemo9 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>( ) ;
        myList.add ("Альфа");
        myList .add ( "Бета" ) ;
        myList.add ("Гамма");
        myList.add ("Дельта");
        myList.add("Kcи");
        myList.add ("Омега");
        Stream<String> myStream = myList.stream();
        Spliterator<String> splitltr = myStream.spliterator();
        while(splitltr.tryAdvance((n) -> System.out.println(n)));
    }
}
