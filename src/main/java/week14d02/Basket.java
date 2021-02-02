package week14d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Basket {

    private Map<String, List<String>> products;

    public Basket(String filename) {
        products = readFileToMap(filename);
    }

    public Map<String, List<String>> readFileToMap(String fileName) {
        Path file = Path.of(fileName);
        Map<String, List<String>> result = new HashMap<>();
        try (BufferedReader br = Files.newBufferedReader(file)) {
            String line;
            while ((line = br.readLine()) != null) {
                String s = line.substring(0, line.indexOf(" "));
                String b = line.substring(line.indexOf(" ") + 1);
                String[] basket = b.split(",");
                result.put(s, Arrays.asList(basket.clone()));
            }
            return result;
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public List<String> listBasket(String id) {
        List<String> result = new ArrayList<>();
        for (String key : products.keySet()) {
            if (id.equals(key)) {
                result = products.get(key);
            }
        }
        Collections.sort(result);
        return result;
    }

    public int countProduct(String name) {
        int counter = 0;
        for (String currentKey : products.keySet()) {
            if (products.get(currentKey).contains(name)) {
                counter++;
            }
        }
        return counter;
    }

    public int countList(String name) {
        return products.get(name).size();
    }

    public String statistics() {
        List<String> productsWithoutDuplication = new ArrayList<>();
        for (String currentKey : products.keySet()) {
            for (int i = 0; i < products.get(currentKey).size(); i++) {
                if (!productsWithoutDuplication.contains(products.get(currentKey).get(i))) {
                    productsWithoutDuplication.add(products.get(currentKey).get(i));
                }
            }
        }
        String[] productsWithoutDuplicationArray = productsWithoutDuplication.toArray(new String[0]);
        int[] productAmount = new int[productsWithoutDuplicationArray.length];

        for (int i = 0; i < productsWithoutDuplicationArray.length; i++) {
            productAmount[i] = countProduct(productsWithoutDuplication.get(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < productAmount.length; i++) {
            sb.append(productsWithoutDuplicationArray[i]);
            sb.append("=");
            sb.append(productAmount[i]);
            sb.append(",");
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Basket b = new Basket("src/main/java/week14d02/shopping_list.txt");
        System.out.println(b.statistics());

    }
    }