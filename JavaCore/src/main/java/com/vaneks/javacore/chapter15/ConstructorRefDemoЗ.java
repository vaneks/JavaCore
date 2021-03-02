package main.java.com.vaneks.javacore.chapter15;
interface MyFuncNew<R, T> {
    R func(T n);
}
class MyClass1<T> {
    private T val;
    MyClass1(T v) { val = v;}
    MyClass1() {val = null; }
    T getVal(){ return val;}
}
class MyClass2 {
    String str;
    MyClass2(String s) { str = s;}
    MyClass2() {str = "";}
    String getVal() {return str;}
}
public class ConstructorRefDemoЗ {
    static <R, T> R myClassFactory(MyFuncNew<R, T> cons, T v) {
        return cons.func(v);
    }

    public static void main(String[] args) {
        MyFuncNew<MyClass1<Double>, Double> myClassCons =MyClass1<Double>::new;
        MyClass1<Double> mc = myClassFactory(myClassCons, 100.1);
        System.out.println("Знaчeниe val в объекте mc равно " + mc.getVal());
        MyFuncNew<MyClass2, String> myClassCons2 = MyClass2::new;
        MyClass2 mc2 = myClassFactory(myClassCons2, "Лямбда");
        System.out.println("Знaчeниe str в объекте mc2 равно " + mc2.getVal());
    }
}
