package main.java.com.vaneks.javacore.chapter21;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class MappedChaпnelRead {
    public static void main(String[] args) {
        try ( FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("test.txt"))) {
            long fSize = fChan.size();
            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, fSize);
            for (int i = 0; i < fSize; i++)
                System.out.print((char) mBuf.get());
            System.out.println();
        } catch(InvalidPathException е) {
            System.out.println("Oшибкa указания пути " + е);
        } catch (IOException е) {
                    System.out.println("Oшибкa ввода-вывода " + е);
        }
    }
}
