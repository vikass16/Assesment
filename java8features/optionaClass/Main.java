package java8features.optionaClass;

public class Main {
    public static void main(String[] args) {
        String name = getName(1);
        System.out.println(name.toUpperCase());
        String name2 = getName2(9);
        System.out.println(name2);
    }

    public static String getName(int id){
        return "vikas";
    }
    public static String getName2(int id){
        return null;
    }
}
