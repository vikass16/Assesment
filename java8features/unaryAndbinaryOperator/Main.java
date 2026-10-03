package java8features.unaryAndbinaryOperator;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {

        // Unary and Binary Operators are Interface which extends another Interface which is Function which works on two parameter

        Function<Integer, Integer> function = x -> x * x;
        Function<String, String> function1 = str -> str.toLowerCase();
        // When both Input and Output are of Same type then UnaryOperator applies else Binary Operator

        UnaryOperator<Integer> unaryOperator = x -> x * x;
        System.out.println(unaryOperator.apply(6));

        UnaryOperator<String> unaryOperator1 = str -> str.toLowerCase();
        System.out.println(unaryOperator1.apply("VIkas"));

        BinaryOperator<String> binaryOperator = (x, y) -> x + y;
        System.out.println(binaryOperator.apply("vikas"," kumar"));

    }
}
