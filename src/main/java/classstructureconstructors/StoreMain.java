package classstructureconstructors;

public class StoreMain {
    public static void main(String[] args) {
        Store store = new Store ("Apples");

        System.out.println(store.getStock());
        System.out.println(store.getProduct());
        store.store(3);

        System.out.println(store.getStock());
        System.out.println(store.getProduct());
        store.dispatch(2);

        System.out.println(store.getStock());
        System.out.println(store.getProduct());

        Store newStore = new Store("Pears");
        System.out.println(newStore.getStock());
        System.out.println(newStore.getProduct());
        newStore.store(8);

        System.out.println(newStore.getStock());
        System.out.println(newStore.getProduct());
        newStore.dispatch(4);

        System.out.println(newStore.getStock());
        System.out.println(newStore.getProduct());
    }
}
