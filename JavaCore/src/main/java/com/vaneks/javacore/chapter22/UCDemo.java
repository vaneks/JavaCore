package main.java.com.vaneks.javacore.chapter22;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class UCDemo {
    public static void main(String[] args)throws Exception {
        int с;
        URL hp = new URL ( "http://www.internic.net") ;
        URLConnection hpCon = hp.openConnection();
        long d = hpCon.getDate();
        if(d==0)
            System.out.println("Cвeдeния о дате отсутствуют.");
        else
            System.out.println("Дaтa: " + new Date(d));
        System.out.println("Tип содержимого: " + hpCon.getContentType());
        d = hpCon.getExpiration();
        if(d==0)
            System.out.println("Сведения о сроке действия отсутствуют.");
        else
            System.out.println("Cpoк действия истекает: " + new Date(d));
        d = hpCon.getLastModified();
        if(d==0)
            System.out.println("Сведения о дате последней модификации.");
        else
            System.out.println("Дaтa последней модификации: " + new Date(d));
        long len = hpCon.getContentLengthLong();
        if(len == -1)
            System.out.println("Длинa содержимого недоступна.");
        else
            System.out.println("Длинa содержимого: " + len);
         if( len != 0) {
             System.out.println("=== Содержимое ===");
             InputStream input = hpCon.getInputStream();
             while (((с = input.read()) != -1)) {
                 System.out.print((char) с);
             }
             input.close();
         }else {
                 System.out.println("Coдepжимoe недоступно.");
             }
    }
}
