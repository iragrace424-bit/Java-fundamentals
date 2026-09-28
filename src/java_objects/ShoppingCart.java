package java_objects;
import java.util.Scanner;

public class ShoppingCart {

    private int totalItems;
    private double totalPrice;

    public void addItem(double price) {

        totalItems++;
        totalPrice = totalPrice + price;

        System.out.println(getCartSummary());
    }

    public void removeItem(double price) {

        if (totalItems > 0) {
            totalItems--;
            totalPrice = totalPrice - price;

            if (totalPrice < 0) {
                totalPrice = 0;
            }

            System.out.println(getCartSummary());
        } else {
            System.out.println("Cart is empty.");
        }
    }

    public void emptyCart() {

        totalItems = 0;
        totalPrice = 0;

        System.out.println("Cart has been emptied.");
    }
    public int gettotalItems() {
        return totalItems;
    }
    public double gettotalPrice() {
        return totalPrice;
    }

    private String getCartSummary() {

        return "Cart has " + totalItems
                + " items. Total: $"
                + String.format("%.2f", totalPrice);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ShoppingCart cart = new ShoppingCart();

        System.out.print("Enter item name: ");
        String itemName = input.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();

        System.out.print("Enter price of one item: ");
        double price = input.nextDouble();

        System.out.println("\nAdding " + itemName + "...");

        for (int i = 0; i < quantity; i++) {
            cart.addItem(price);
        }

        System.out.println("\nWould you like to remove an item?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int choice = input.nextInt();

        if (choice == 1) {

            System.out.print("How many items do you want to remove? ");
            int removeQuantity = input.nextInt();

            for (int i = 0; i < removeQuantity; i++) {
                cart.removeItem(price);
            }
        }

        System.out.println("\nFinal cart information:");
        System.out.println("Total items: " + cart.gettotalItems());
        System.out.printf("Total price: $%.2f%n", cart.gettotalPrice());

        input.close();
    }
}