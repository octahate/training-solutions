package references.parameters;

public class ReferencesMain {
    public static void main(String[] args) {
        Person person1 = new Person("Péter",31);
        Person person2 = person1;
        person1.setName("Pál");
        System.out.println(person1.getName());
        System.out.println(person2.getName());
        int a = 24;
        int b = a;
        b +=1;
        System.out.println(a);
        System.out.println(b);
    }
}
