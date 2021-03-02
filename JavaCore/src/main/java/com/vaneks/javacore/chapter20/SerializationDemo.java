package main.java.com.vaneks.javacore.chapter20;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        try (ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("serial"))) {
            MyClass object1 = new MyClass("Hello", -7, 2.7e10);
            System.out.println("objectl: " + object1);
            objOStrm.writeObject(object1);
        } catch (IOException е) {
            System.out.println("Иcключeниe при сериализации: " + е);
        }
        try (ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("serial"))) {
            MyClass object2 = (MyClass) objIStrm.readObject();
            System.out.println("object2: " + object2);
        } catch (Exception е) {
            System.out.println("Иcключeниe при десериализации: " + е);
            System.exit(0);
        }
    }
}
class MyClass implements Serializable {
    String s;
    int i;
    double d;

    public MyClass(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }
        public String toString() {
            return "s= " + s + " ; i= " + i + "; d= " + d;
        }
    }

