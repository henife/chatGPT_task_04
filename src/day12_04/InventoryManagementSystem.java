package day12_04;

import java.util.ArrayList;
import java.util.Scanner;

class Product{
    public String name;
    public String productID;
    public int quantity;
    public double price;

    public Product(String name, String productID, int quantity, double price) {
        this.name = name;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", productID='" + productID + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        while (true) {
            System.out.println("""
                    1. Add a new product.
                    2. Update a product's price.
                    3. View all products.
                    4. Search for a product by name.
                    5. Calculate the total stock value of all products.
                    6. Exit the program.
                    """
            );
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 ->
                    addProduct(products);
                case  2 ->
                    updatePrice(products);
                case 3 ->
                    viewAllProducts(products);
                case 4 ->
                    searchProducts(products);
                case 5 ->
                    calculateTotalStock(products);
                case 6 -> {
                    System.out.println("System exiting");
                    return;
                }

                default -> System.out.println("Invalid choice");
            }
        }
    }
    public static void addProduct(ArrayList<Product> products) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the product: ");
        String name = scanner.nextLine();
        System.out.println("Please enter the product ID: ");
        String productID = scanner.nextLine();
        System.out.println("Please enter the quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the price of the product: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Product product = new Product(name, productID, quantity, price);
        products.add(product);
        System.out.println("Product added successfully!");
    }

    public static void updatePrice(ArrayList<Product> products) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the product or ID: ");
        String identifier = scanner.nextLine();

        boolean found = false;
        for(Product product : products) {
            if(product.name.equalsIgnoreCase(identifier) || product.productID.equalsIgnoreCase(identifier)) {
                System.out.println(product.getName() + "'s current price is " + product.getPrice());
                System.out.println("Please enter the new price of the product: ");
                double newPrice = scanner.nextDouble();
                product.setPrice(newPrice);
                System.out.println("Product updated successfully!");
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Product not found!");
        }
    }
    public static void viewAllProducts(ArrayList<Product> products) {
        if(products.isEmpty()) {
            System.out.println("No products found!");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
    public static void searchProducts(ArrayList<Product> products) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the product: ");
        String searched = scanner.nextLine();

        boolean found = false;
        for(Product product : products) {
            if(product.name.equalsIgnoreCase(searched) || product.productID.equalsIgnoreCase(searched)) {
                System.out.println(product);
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Product not found!");
        }
    }
    public static void calculateTotalStock(ArrayList<Product> products) {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice() * product.getQuantity();
        }
        System.out.println("The total stock is: $" + total);
    }
}
