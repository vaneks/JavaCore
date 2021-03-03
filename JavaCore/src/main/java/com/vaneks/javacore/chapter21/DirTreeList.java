package main.java.com.vaneks.javacore.chapter21;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class MyFileVisitor extends SimpleFileVisitor<Path> {
    public FileVisitResult visitFile(Path path, BasicFileAttributes attribs) throws IOException
    {
        System.out.println(path);
        return FileVisitResult.CONTINUE;
    }
}
class DirTreeList {
    public static void main(String args[]) {
        String dirname = "C:/Intel";
        System.out.println("Дepeвo каталогов, "
                + "начиная с каталога " + dirname + ":\n");
        try {
            Files.walkFileTree(Paths.get(dirname), new MyFileVisitor());
        } catch (IOException exc) {
            System.out.println("Oшибкa ввода-вывода" + exc);
        }
    }
}