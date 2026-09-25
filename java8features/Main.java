package java8features;




interface A{
    default void sayHello(){
        System.out.println("Hello Java 8");
    }

   // void sayBye(); // This is an Abstract method and An Abstract method can't have a body
}

class B implements A{
    @Override
    public void sayHello() {
        System.out.println("B will be called here because B override the implementation of it's parent A");
    }
}
public class Main {
    public static void main(String[] args) {
        B b = new B();
        b.sayHello();
    }
}
