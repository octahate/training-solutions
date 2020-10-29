package classstructuremethods;

public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();
        client.setName("John Doe");
        client.setYear(1993);
        client.setAddress("Hold u.1");

        System.out.println("Your data:");
        System.out.println(client.getAddress());
        System.out.println(client.getName());
        System.out.println(client.getYear());

        client.migrate("nap u. 1");
        System.out.println("New address: " + client.getAddress());

    }
}
