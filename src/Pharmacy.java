public class Pharmacy {
    private Stock stock;
    private double totalRevenue;

    public Pharmacy() {
        stock = new Stock();
        totalRevenue = 0;
    }

    public Stock getStock() {
        return stock;
    }

    public void sellProduct(int id, int quantity) {
        Product p = stock.searchByID(id);

        if (p == null) {
            System.out.println("Product not found.");
            return;
        }

        if (p.isExpired()) {
            System.out.println("Cannot sell expired product.");
            return;
        }

        try {
            p.reduceQuantity(quantity);
            double saleAmount = p.getPrice() * quantity;
            totalRevenue += saleAmount;
            System.out.println("Sold successfully. Total price: " + saleAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    public void restockProduct(int id, int quantity) {
        Product p = stock.searchByID(id);
        if (p != null) {
            p.addQuantity(quantity);
            System.out.println("Stock updated.");
        } else {
            System.out.println("Product not found.");
        }
    }
    public double getTotalRevenue() {
        return totalRevenue;
    }
}