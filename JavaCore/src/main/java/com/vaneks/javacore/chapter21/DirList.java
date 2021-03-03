package main.java.com.vaneks.javacore.chapter21;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirList {
    public static void main(String[] args) {
        String dirname = "c:/";
        try ( DirectoryStream<Path> dirstrm =
                      Files.newDirectoryStream(Paths.get(dirname))) {
            System.out.println("Kaтaлoг " + dirname);
            for (Path entry : dirstrm) {
                BasicFileAttributes attribs = Files.readAttributes(entry, BasicFileAttributes.class);
                if (attribs.isDirectory())
                    System.out.print("<DIR> ");
                else
                    System.out.print(" ");
                System.out.println(entry.getName(0));
            }
        }catch(InvalidPathException е) {
            System.out.println("Oшибкa указания пути" + е);
        }catch(NotDirectoryException е) {
            System.out.println(dirname + "не является каталогом.");
        } catch (IOException e){
            System.out.println("Oшибкa ввода-вывода: " + e);
        }
    }
}
