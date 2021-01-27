package ioconvert.shopping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListManager {

    public void saveShoppingList(OutputStream os, List<String> groceries) {
        try (PrintStream ps = new PrintStream(os)) {
            for (String item : groceries) {
                ps.println(item);
            }
        }
    }

    public List<String> loadShoppingList(InputStream is) {
        try (BufferedReader isr = new BufferedReader(new InputStreamReader(is))) {
            List<String> items = new ArrayList<>();
            String actualItem;
            while ((actualItem = isr.readLine()) != null) {
                items.add(actualItem);
            }
            return items;
        } catch (IOException e) {
        throw new IllegalStateException("Canot create file", e);
        }
    }
}
