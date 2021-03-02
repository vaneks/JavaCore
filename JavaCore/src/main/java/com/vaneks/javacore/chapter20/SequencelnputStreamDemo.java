package main.java.com.vaneks.javacore.chapter20;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

class InputStreamEnumerator implements Enumeration<FileInputStream> {
        private Enumeration<String> files;
        public InputStreamEnumerator(Vector<String> files) {
            this.files = files.elements();
        }
            public boolean hasMoreElements() {
                return files.hasMoreElements();
            }
            public FileInputStream nextElement() {
            try {
                return new FileInputStream(
                        files.nextElement().toString());
            }catch(IOException е){
                    return null;
                }
            }
        }
public class SequencelnputStreamDemo {
    public static void main(String args[]) {
        int с;
        Vector<String> files = new Vector<String>();
        files.addElement("file3.txt");
        files.addElement("file2.txt");
        files.addElement("file1.txt");
        InputStreamEnumerator ise = new InputStreamEnumerator(files);
        InputStream input = new SequenceInputStream(ise);
        try {
            while ((с = input.read()) != -1)
                System.out.print((char) с);
        } catch (NullPointerException е) {
            System.out.println("Oшибкa открытия файла.");
        } catch (IOException е) {
            System.out.println("Oшибкa ввода-вывода: " + е);
        } finally {
            try {
                input.close();
            } catch (IOException е) {
                System.out.println("Oшибкa закрытия потока ввода SequenceInputStream");
            }
        }
    }
}
