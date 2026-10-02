package java8features.bi;

import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        // All Interfaces like BiPredicate, BiFunction, BiConsumer, BiSupplier

        Predicate<Integer> predicate = x -> x % 2 == 0;
        System.out.println(predicate.test(23));

        BiPredicate<Integer, Integer> biPredicate = (x, y) -> x % 2 == 0 || y % 2 == 0;
        System.out.println(biPredicate.test(43,22));

        Function<String,Integer> function = s -> s.length()/2;
        System.out.println(function.apply("vikass"));

        BiFunction<String, String, Integer> biFunction = (x,y) -> x.length() + y.length();
        System.out.println(biFunction.apply("vikas","kumarr"));

        Consumer<Integer> consumer = x -> System.out.println(x);
        consumer.accept(34);

        BiConsumer<Integer, Integer> biConsumer = (x,y) -> {
            System.out.println(x+" "+y);
        };
        biConsumer.accept(38,32);


        Supplier<Integer> supplier = () -> 12;
        System.out.println(supplier.get());

    }
}
