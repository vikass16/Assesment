package java8features.consumerANDsupplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        // Consumer is an Interface which has an Abstract method [accept()] Which is used to accept the condition.

        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("vikas");

        Consumer<List<Integer>> list = li -> {
            for (Integer i : li){
                System.out.println(i+14);
            }
        };
        list.accept(Arrays.asList(1,2,3,4,5));

        // Supplier is also an Interface which has an Abstract method of get() name.

        Supplier<Integer> supplier = () -> 1;
        System.out.println(supplier.get());

        // use of Predicate, Function, Consumer and Supplier together.
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer,Integer> function = x -> x * x;
        Consumer<Integer> consumer1 = x -> System.out.println(x);
        Supplier<Integer> supplier1 = () -> 100;

        if(predicate.test(supplier1.get())){
            consumer1.accept(function.apply(supplier1.get()));
        }

    }
}
