package main.java.com.vaneks.javacore.chapter10;

public class SuperSubCatch {
    public static void main(String[] args) {
        try {
            int a = 0;
            int b = 42 / a;
        } catch (Exception e) {
            System.out.println("Перехват исключенй общего класса Exception");
        }
        // Этот оператор catch достигнут не будет
/*        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Этот код недостижим");
        }*/
    }
}
