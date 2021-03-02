package main.java.com.vaneks.javacore.chapter15;
interface StringFunc {
    String func(String n);
}
class MyStringOps {
    static String strReverse (String str) {
        String result = "";
        int i;
        for (i=str.length()-1;i>=0; i--)
            result += str.charAt(i);
        return result;
    }
}
public class MethodRefDemo {
    static String stringOp(StringFunc sf, String s){
        return sf.func(s);
    }
    public static void main(String[] args) {
        String inStr = "Лямбда-выражения повышают эффективность Java";
        String outStr;
        outStr = stringOp(MyStringOps::strReverse,inStr);
        System.out.println("Исходная строка " + inStr);
        System.out.println("Обращенная строка " + outStr);
    }
}
