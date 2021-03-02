package main.java.com.vaneks.javacore.chapter20;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[] args) {
        String source = "Now is the time for all good men\n"
                + " to соте to the aid of their country\n"
                + "and рау their due taxes.";
        char buffer[] = new char[source.length()];
        source.getChars(0, source.length(), buffer, 0);
        try (FileWriter fO = new FileWriter("file1.txt");
             FileWriter f1 = new FileWriter("file2.txt");
             FileWriter f2 = new FileWriter("fileЗ.txt")) {
            for (int i = 0; i < buffer.length; i += 2) {
                fO.write(buffer[i]);
            }
            f1.write(buffer);
            f2.write(buffer, buffer.length - buffer.length / 4,
                    buffer.length / 4);
        } catch (IOException е) {
            System.out.println("Пpoизoшлa ошибка ввода-вывода");
        }
    }
}
