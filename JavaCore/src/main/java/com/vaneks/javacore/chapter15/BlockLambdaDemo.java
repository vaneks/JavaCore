package main.java.com.vaneks.javacore.chapter15;
interface NumericFunc {
    int func(int n);
}
public class BlockLambdaDemo {
    public static void main(String[] args) {
        NumericFunc factorial = (n) -> {
            int result = 1;
            for(int i=1; i<=n; i++)
                result = result * i;
            return result;
        };
        System.out.println("Факториал числа 3 равен " + factorial.func(3));
        System.out.println("Факториал числа 5 равен " + factorial.func(5));
    }
}
