import java.time.LocalDate;

public class Product {
    private final int id;
    private String name;
    private int quantity;
    private LocalDate expireDate;
    private double price;
    private double discount;

    // Constructor
    public Product(int id, String name, int quantity,
                   LocalDate expireDate, double price, double discount) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.expireDate = expireDate;
        this.price = price;
        this.discount = discount;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public LocalDate getExpireDate() { return expireDate; }
    public double getPrice() { return price; }
    public double getDiscount() { return discount; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setExpireDate(LocalDate expireDate) { this.expireDate = expireDate; }
    public void setPrice(double price) { this.price = price; }
    public void setDiscount(double discount) { this.discount = discount; }

    // Logic
    public boolean isExpired() {
        return expireDate.isBefore(LocalDate.now());
    }

    public void reduceQuantity(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
        } else {
            throw new IllegalArgumentException("Not enough stock available.");
        }
    }

    public void addQuantity(int amount) {
        quantity += amount;
    }

    public double getFinalPrice() {
        return price - (price * discount / 100);
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Quantity: " + quantity +
                ", Expire: " + expireDate +
                ", Price: " + price +
                ", Discount: " + discount + "%" +
                ", Final Price: " + getFinalPrice();
    }
}