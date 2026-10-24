package collectionFramework;

public class WaekHashMapMain {

    public static void main(String[] args) {
        Phone phone = new Phone("Apple","iPhone 16 pro max");
        System.out.println(phone);
        phone = null;
        System.out.println(phone);
    }
}

class Phone{
    String brand;
    String model;

    public Phone(String model, String brand){
        this.model = model;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}