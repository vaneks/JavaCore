package main.java.com.vaneks.javacore.chapter15;
interface MyFunct<T> {
    int func(T[] vals, T v);
}
class MyArraysOps {
    static <T> int countMatching(T[] vals, T v) {
        int count = 0;
        for(int i=0; i<vals.length; i++)
            if(vals[i] == v) count++;
            return count;
    }
}
public class GenericMethodRefDemo {
    static <T> int myOp(MyFunct<T> f, T[] vals, T v) {
        return f.func(vals, v);
    }

    public static void main(String[] args) {
        Integer[] vals = {1,2,3,4,2,3,4,4,5};
        String[] strs = {"One","Two","Five","Two"};
        int count;
        count = myOp(MyArraysOps::<Integer>countMatching, vals,4);
        System.out.println("Массив vals одержит " + count + "числа четыре");

        count = myOp(MyArraysOps::<String>countMatching, strs,"Two");
        System.out.println("Maccив strs содержит " + count + " числа два");
    }
}
