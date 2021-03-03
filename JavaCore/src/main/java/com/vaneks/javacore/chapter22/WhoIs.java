package main.java.com.vaneks.javacore.chapter22;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class WhoIs {
    public static void main(String[] args) throws Exception {
        int с;
        try (Socket s = new Socket("whois.internic.net", 43)) {
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            String str = (args.length == 0 ? "OraclePressBooks.com" : args[0]) + "\n";
            byte buf[] = str.getBytes();
            out.write(buf);
            while ((с = in.read()) != -1) {
                System.out.print((char) с);
            }
        }
    }
}

