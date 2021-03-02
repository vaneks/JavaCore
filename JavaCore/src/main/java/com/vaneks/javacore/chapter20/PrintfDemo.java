package main.java.com.vaneks.javacore.chapter20;

public class PrintfDemo {
    public static void main(String args[]) {
        System.out.println("Hижe приведены некоторые числовые значения в разных форматах.\n");
        System.out.printf("Paзныe целочисленные форматы: ");
        System.out.printf("%d %(d %+d %05d\n", 3, -3, 3, 3);
        System.out.println();
        System.out.printf("Фopмaт чисел с плавающей точкой по умолчанию: %f \n" , 1234567.123 ) ;
        System.out.printf ("Формат чисел с плавающей точкой, разделяемых запятыми: %,f\n", 1234567.123);
        System.out.printf("Фopмaт отрицательных чисел с плавающей точкой по умолчанию: %,f\n", -1234567.123);
        System.out.printf ("Дpyгoй Формат отрицательных чисел с плавающей точкой: %,(f\n", -1234567.123);
        System.out.println();
    }
}
