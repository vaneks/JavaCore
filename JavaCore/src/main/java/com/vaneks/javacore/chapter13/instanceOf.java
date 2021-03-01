package main.java.com.vaneks.javacore.chapter13;

import org.w3c.dom.ls.LSOutput;

class A {
    int i, j;
}
class B {
    int i, j;
}
class C extends A {
    int k;
}
class D extends A {
    int k;
}

public class instanceOf {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        if(a instanceof A)
            System.out.println("a является экземпляром A");
        if(b instanceof B)
            System.out.println("b является экземпляром B");
        if(c instanceof C)
            System.out.println("c является экземпляром C");
        if(c instanceof A)
            System.out.println("c можно привести к типу A");
        if(a instanceof C)
            System.out.println("a можно привести к типу C");
        System.out.println();
        A ob;
        ob = d;
        System.out.println("ob теперь ссылается на d");
        if(ob instanceof D)
            System.out.println("ob является экземпляром D");
        System.out.println();

        ob = c;
        System.out.println("ob теперь ссылается на с");
        if(ob instanceof D)
            System. out .println ( "оb можно привести к типу D");
        else
            System.out.println("ob нельзя привести к типу D");
        if(ob instanceof A)
            System.out.println("ob можно привести к типу А");
        System.out.println();
        if(a instanceof Object)
            System.out.println("a можно привести к типу Object");
        if(b instanceof Object)
            System.out.println("b можно привести к типу Object");
        if(c instanceof Object)
            System.out.println("с можно привести к типу к Object");
        if(d instanceof Object)
            System.out.println("d можно привести к типу к Object");
    }
}
