package absClassVsInterface;

abstract class AbstractEx{
    protected int i = 0;

    public static final int a = 100;

    abstract void display(); // abstract method

    void show(){
        System.out.println("Show method from Abstract Class");
    }
}

public class AbstractClassExample extends AbstractEx{

    @Override
    void display() {
        System.out.println("Display method override from Abstract Class");
    }

    public static void main(String[] args) {

        AbstractEx ab = new AbstractClassExample();
        ab.display();
        ab.show();
        System.out.println(ab.i);
        System.out.println(AbstractEx.a);
    }
}

