package main.java.com.vaneks.javacore.chapter15;
interface Functional {
    MyClass_ func(int i);
}
class MyClass_ {
    private int val;
    MyClass_(int v) { val = v;}
    MyClass_() {val = 0; }
    int getVal(){ return val;}
}
public class ConstructorRefDemo {
    public static void main(String[] args) {
        Functional functional = MyClass_::new;
        MyClass_ mc = functional.func(100);
        System.out.println("Знaчeниe val в объекте mc равно " + mc.getVal());
    }
}
