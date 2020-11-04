package week02;

public class Product {
    private String name;
    private String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
    public boolean areTheyEqual (Product p){
        return name.equals(p.getName()); // elfelejtetted a getterét a pnek
    }
    public boolean areTheyEqualPlus (Product p){
        return name.equals(p) && (code.length() + 1) >= p.getCode().length();

    }


        public static void main(String[] args) {
        Product product1 = new  Product("Alma","001");

        Product product2 = new  Product("Alma","0001");

        Product product3 = new  Product("Körte","002");

        System.out.println(product2.areTheyEqual(product1));
        System.out.println(product3.areTheyEqual(product1));
        System.out.println(product1.areTheyEqual(product2));
        System.out.println(product2.areTheyEqualPlus(product1));
        System.out.println(product3.areTheyEqualPlus(product2));
        System.out.println(product1.areTheyEqualPlus(product3));




    }
}
