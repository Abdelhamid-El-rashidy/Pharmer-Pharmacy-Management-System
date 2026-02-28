import java.util.HashMap;

public class Stock {
    private HashMap<Integer, Product> products;

    public Stock() {
        products = new HashMap<>();
    }

    public void register(Product item) {
        products.put(item.getId(), item);
    }

    public void remove(int id) {
        if (products.containsKey(id)) {
            products.remove(id);
        } else {
            System.out.println("Product not found.");
        }
    }

    public Product searchByID(int id) {
        return products.get(id);
    }

    public void showAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Stock is empty.");
        } else {
            for (Product p : products.values()) {
                System.out.println(p);
            }
        }
    }
}