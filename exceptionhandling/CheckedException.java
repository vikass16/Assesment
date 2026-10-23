package exceptionhandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckedException {
    public static void main(String[] args) throws IOException {
        fun2();
    }

    public static void fun2() throws FileNotFoundException{
        fun1();
    }
    public static void fun1() throws FileNotFoundException {
        FileReader fileReader = new FileReader("a.txt");
    }
}

// This is Checked Which will checked While compilation,
// If we want throw an Exception without try-catch then we can throw like this Example , Explicitly using throws KeyWord with method Signature
