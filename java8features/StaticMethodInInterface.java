package java8features;


interface AA{

    // This is a static method (public is by default so not need to write). Must have a body.
    static void sayHello(){
        System.out.println("Hello AA");
    }

    // This is a default method (it must have a body)
    default void sayBye(){
        System.out.println("Bye AA");
    }

    // This is an abstract method (It must be implemented by main class and must not have a body)
    void sayNothing();
}
public class StaticMethodInInterface implements AA{
    public static void main(String[] args) {

        StaticMethodInInterface st = new StaticMethodInInterface();

//        st.sayHello();
//        StaticMethodInInterface.sayHello();
        // We can not Access static method of an interface using main Class, or using its object (mentioned above)
        // to call static method we have to use interface name here

        AA.sayHello(); // like this (even without implementing AA)

        // But we can access default method with object of Main Class
        st.sayBye();
        st.sayNothing(); // Without this overriding will not work

    }

    @Override
    public void sayNothing() {
        System.out.println("To override the same method is mandatory when you defined an abstract method inside an Interface");
    }
}
