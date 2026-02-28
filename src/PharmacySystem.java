import java.time.LocalDate;
import java.util.Scanner;

public class PharmacySystem {

    private Pharmacy pharmacy;
    private Scanner scanner;

    public PharmacySystem() {
        pharmacy = new Pharmacy();
        scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addProduct();
                case 2 -> searchProduct();
                case 3 -> sellProduct();
                case 4 -> restockProduct();
                case 5 -> showAllProducts();
                case 6 -> showRevenue();
                case 0 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    private void showMenu() {
        System.out.println("\n===== Pharmer SYSTEM =====");
        System.out.println("1. Add Product");
        System.out.println("2. Search Product");
        System.out.println("3. Sell Product");
        System.out.println("4. Restock Product");
        System.out.println("5. Show All Products");
        System.out.println("6. Show Total Revenue");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    private void addProduct() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter Expire Date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.next());

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter Discount (%): ");
        double discount = scanner.nextDouble();

        Product product = new Product(id, name, quantity, date, price, discount);
        pharmacy.getStock().register(product);

        System.out.println("Product added successfully.");
    }

    private void searchProduct() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();

        Product p = pharmacy.getStock().searchByID(id);

        if (p != null) {
            System.out.println(p);
        } else {
            System.out.println("Product not found.");
        }
    }

    private void sellProduct() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter Quantity to sell: ");
        int quantity = scanner.nextInt();

        pharmacy.sellProduct(id, quantity);
    }

    private void restockProduct() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter Quantity to add: ");
        int quantity = scanner.nextInt();

        pharmacy.restockProduct(id, quantity);
    }

    private void showAllProducts() {
        pharmacy.getStock().showAllProducts();
    }

    private void showRevenue() {
        System.out.println("Total Revenue: " + pharmacy.getTotalRevenue());
    }
}