package main.java.com.vaneks.javacore.chapter29;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
class NamePhoneE {
    String name;
    String phonenum;
    String email;
    NamePhoneE(String name, String phonenum, String email) {
        this.name = name;
        this.phonenum = phonenum;
        this.email = email;
    }
}
class NameP {
    String name;
    String phonenum;
    NameP(String name, String phonenum) {
        this.name = name;
        this.phonenum = phonenum;
    }
}
public class StreamDemo7 {
    public static void main(String[] args) {
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();
        myList .add (new NamePhoneEmail ("Ларри", "555-5555",
                "Larry@HerbSchildt.com"));
        myList.add(new NamePhoneEmail("Джeймc", "555-4444",
                "James@HerbSchildt.com"));
        myList. add (new NamePhoneEmail ("Мэри", "555-3333",
                "Mary@HerbSchildt.com") );
        Stream<NameP> nameAndPhone = myList.stream().map((a) -> new NameP(a.name, a.phonenum));
        List<NameP> npList = nameAndPhone.collect(Collectors.toList());
        System.out.println("Имена и номера телефонов в списке типа List:");
        for(NameP nameP : npList)
            System.out.println( nameP.name + " : " + nameP.phonenum);
        nameAndPhone = myList.stream() .map(
                (a) -> new NameP(a.name, a.phonenum)
        ) ;

        Set<NameP> npSet = nameAndPhone.collect(Collectors.toSet());
        System.out.println("\nИмeнa и номера телефонов в множестве типа Set:");
        for(NameP e : npSet)
            System.out.println(e.name + ": " + e.phonenum);

    }
}
