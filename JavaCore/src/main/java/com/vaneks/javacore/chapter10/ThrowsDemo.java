package main.java.com.vaneks.javacore.chapter10;

public class ThrowsDemo {
    static void throwOne() throws IllegalAccessError {
        System.out.println("В теле метода throwOne().");
        throw new IllegalAccessError("Демонстрация");
    }

    public static void main(String[] args) {
        try {
            throwOne();
        } catch (IllegalAccessError e) {
            System.out.println("Перехваченное исключение:  " + e);
        }
    }
}
