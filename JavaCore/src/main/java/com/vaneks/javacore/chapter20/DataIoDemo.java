package main.java.com.vaneks.javacore.chapter20;

import java.io.*;

public class DataIoDemo {
    public static void main(String args[]) throws IOException {
        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream("Test.dat"))) {
            dout.writeDouble(98.6);
            dout.writeInt(1000);
            dout.writeBoolean(true);
        } catch (FileNotFoundException е) {
            System.out.println("Heльзя открыть файл вывода");
            return;
        } catch (IOException е) {
            System.out.println("Oшибкa ввода-вывода: " + е);
        }
        try (DataInputStream din = new DataInputStream(new FileInputStream("Test.dat"))) {
            double d = din.readDouble();
            int i = din.readInt();
            boolean b = din.readBoolean();
            System.out.println("Пoлyчaeмыe значения: " + d + " " + i + " " + b);
        } catch (FileNotFoundException е) {
            System.out.println("Heльзя открыть файл ввода ");
            return;
        } catch (IOException е) {
            System.out.println("Omибкa ввода-вывода: " + е);
        }
    }
}