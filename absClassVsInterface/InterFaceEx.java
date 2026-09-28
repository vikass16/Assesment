package absClassVsInterface;

interface I
{
    int a = 10;

    void display(); // Abstract method in interface

    default void show(){
        System.out.println("Show method from Interface");
    }
}

public class InterFaceEx implements I{

    @Override
    public void display(){
        System.out.println("Display method from Interface I");
    }

}

