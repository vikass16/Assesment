package java8features;


interface first{
    default void sayHello(){
        System.out.println("Hello A");
    }
}

interface second {
    default void sayHello(){
        System.out.println("Hello B");
    }
}
public class DefaultMethodInInterface implements first,second {
    public static void main(String[] args) {
        DefaultMethodInInterface def = new DefaultMethodInInterface();
        def.sayHello();
    }

    // This is used because without this DefaultMethodInInterface will not able to find that which method to call because they are having Same method name with no signature.
    @Override
    public void sayHello() {
        first.super.sayHello();
        second.super.sayHello();
        System.out.println("My Own implementation");
    }
}
