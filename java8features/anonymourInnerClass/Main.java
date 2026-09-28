package java8features.anonymourInnerClass;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee() {
            @Override
            public String getSalary() {
                return "Rs. 20";
            }

            @Override
            public String getDesignation() {
                return "Software Engineer";
            }
        };

        System.out.println(employee.getDesignation()+" : "+employee.getSalary());
    }
}
