package main.java.com.vaneks.javacore.chapter20;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo_v2 {
    public static void main(String[] args) {
        String source = "Now is the time for all good men\n"
                + " to соmе to the aid of their country\n"
                + " and рау their due taxes.";
        byte buf[] = source.getBytes();

        try(FileOutputStream f0 = new FileOutputStream("D:/file1.txt");
            FileOutputStream f1 = new FileOutputStream("D:/file2.txt");
            FileOutputStream f2= new FileOutputStream("D:/file3.txt"))
        {
            for( int i = 0; i < buf.length; i +=2) {
                f0.write(buf[i]);
            }
            f1.write(buf);
            f2.write(buf,buf.length-buf.length/4, buf.length/4);
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода");
        }
    }
}
