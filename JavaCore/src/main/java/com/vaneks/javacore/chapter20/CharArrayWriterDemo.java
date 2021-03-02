package main.java.com.vaneks.javacore.chapter20;

import java.io.*;

public class CharArrayWriterDemo {
    public static void main(String[] args) {
        CharArrayWriter f = new CharArrayWriter();
        String s = "Эти данные должны быть выведены в массив";
        char buf[] =new char[s.length()];
        s.getChars(0,s.length(),buf,0);
        try {
            f.write(buf);
        } catch (IOException e) {
            System.out.println("Ошибка записи в буфер");
            return;
        }
        System.out.println("Бyфep в виде символьной строки");
        System.out.println(f.toString());
        System.out.println("B массив");
        char b[] = f.toCharArray();
        for (int i = 0; i < b.length; i++)
            System.out.print((char) b[i]);
        System.out.println("\nB поток вывода типа OutputStream() ");
        try (FileWriter f2 = new FileWriter("test.txt")) {
            f.writeTo(f2);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
            return;
        }
        System.out.println("Установка в исходное состояние");
        f.reset();
        for (int i = 0; i<3; i++) f.write('X');
        System.out.println(f.toString());
    }
}
