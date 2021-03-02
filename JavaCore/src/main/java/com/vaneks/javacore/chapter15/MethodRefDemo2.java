package main.java.com.vaneks.javacore.chapter15;
interface StringFunctional {
    String func(String n);
}
class MyStringOps_ {
     String strReverse (String str) {
        String result = "";
        int i;
        for (i=str.length()-1;i>=0; i--)
            result += str.charAt(i);
        return result;
    }
}
public class MethodRefDemo2 {
    static String stringOp(StringFunc sf, String s){
        return sf.func(s);
    }
    public static void main(String[] args) {
        String inStr = "Лямбда-выражения повышают эффективность Java";
        String outStr;
        MyStringOps_ strops = new MyStringOps_() ;
        outStr = stringOp(strops::strReverse,inStr);
        System.out.println("Исходная строка " + inStr);
        System.out.println("Обращенная строка " + outStr);
    }
}
