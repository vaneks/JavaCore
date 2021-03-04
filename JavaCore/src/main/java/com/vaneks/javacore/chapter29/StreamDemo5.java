package main.java.com.vaneks.javacore.chapter29;

import java.util.ArrayList;
import java.util.stream.Stream;

class NamePhoneEmail {
    String name;
    String phonenum;
    String email;
    NamePhoneEmail(String name, String phonenum, String email) {
        this.name = name;
        this.phonenum = phonenum;
        this.email = email;
    }
}
class NamePhone {
    String name;
    String phonenum;
    NamePhone(String name, String phonenum) {
        this.name = name;
        this.phonenum = phonenum;
    }
}
public class StreamDemo5 {
    public static void main(String[] args) {
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();
        myList .add (new NamePhoneEmail ("Ларри", "555-5555",
                "Larry@HerbSchildt.com"));
        myList.add(new NamePhoneEmail("Джeймc", "555-4444",
                "James@HerbSchildt.com"));
        myList. add (new NamePhoneEmail ("Мэри", "555-3333",
                "Mary@HerbSchildt.com") );
        System.out.println("Иcxoдныe элементы из списка myList: ");
        myList.stream() .forEach( (a) -> {
                    System.out.println(a.name + " " + a.phonenum + " " + a.email); });
        System.out.println();
        Stream<NamePhone> nameAndPhone = myList.stream() .map(
                (a) -> new NamePhone(a.name,a.phonenum)) ;
        System.out.println(
                "Список имен и номеров телефонов: ");
        nameAndPhone.forEach( (a) -> {
            System.out.println(a.name + " " + a.phonenum);
        } ) ;

//        Stream<NamePhone> nameAndP = myList.stream()
//                .filter((a) -> a.name.equals("Джeймc"))
//                .map( (a) -> new NamePhone(a.name,a.phonenum));
//        nameAndP.forEach( (a) -> {
//            System.out.println(a.name + " " + a.phonenum);
//        } ) ;
    }
}
