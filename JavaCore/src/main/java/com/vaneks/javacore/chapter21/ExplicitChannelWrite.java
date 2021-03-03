package main.java.com.vaneks.javacore.chapter21;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;

public class ExplicitChannelWrite {
    public static void main(String[] args) {
        try (FileChannel fChan = (FileChannel)
                Files. newByteChannel ( Paths.get ( "test.txt") ,
                        StandardOpenOption.WRITE,
                        StandardOpenOption.CREATE)) {
            ByteBuffer mBuf = ByteBuffer.allocate(26);
            for(int i=0; i<26; i++)
                mBuf.put( (byte) ('А' + i));
                mBuf.rewind();
                fChan.write(mBuf);
            }catch(InvalidPathException e) {
                System. out .println ("Ошибка указания пути " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода" + e);
            System.exit(1);
        }
    }
}