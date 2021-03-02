package main.java.com.vaneks.javacore.chapter15;

interface Functional_v<T> {
    MyClassNew<T> func(T t);
}
class MyClassNew<T> {
    private T val;
    MyClassNew(T v) { val = v;}
    MyClassNew() {val = null; }
    T getVal(){ return val;}
}
public class ConstructorRefDemo2 {
    public static void main(String[] args) {
        Functional_v<Integer> functional = MyClassNew<Integer>::new;
        MyClassNew<Integer> mc = functional.func(100);
        System.out.println("Знaчeниe val в объекте mc равно " + mc.getVal());
    }
}