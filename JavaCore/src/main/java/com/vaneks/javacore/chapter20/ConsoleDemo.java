package main.java.com.vaneks.javacore.chapter20;

import java.io.Console;

public class ConsoleDemo {
    public static void main(String[] args) {
        String str;
        Console con;
        con = System.console();
        if(con == null) return;
        str = con.readLine("Bвeдитe строку: ");
        con.printf ("Введенная вами строка: %s\n", str);
    }
}
