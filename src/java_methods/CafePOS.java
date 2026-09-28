package java_methods;
public class CafePOS {

    public static double calculateTax(double amount, double taxRate) {
        double tax = amount * taxRate;
        return amount + tax;
    }

    public static void generateReceipt(String name, double finalAmount) {
        System.out.println("\n===== CAFE RECEIPT =====");
        System.out.println("Customer: " + name);
        System.out.printf("Final Total: $%.2f%n", finalAmount);
        System.out.println("========================");
    }

    public static void main(String[] args) {

        String customerName = "Alex";
        double coffeePrice = 4.50;
        int quantity = 4;
        boolean hasLoyaltyCard = true;

        double baseTotal = coffeePrice * quantity;

        double discountedTotal = baseTotal;

        if (hasLoyaltyCard) {
            discountedTotal = baseTotal - 2.50;
        } else if (baseTotal > 15.00) {
            discountedTotal = baseTotal - (baseTotal * 0.10);
        }

        double finalAmount = calculateTax(discountedTotal, 0.08);

        System.out.println("Brewing in 3...");
        System.out.println("Brewing in 2...");
        System.out.println("Brewing in 1...");
        System.out.println("Coffee is ready!");

        generateReceipt(customerName, finalAmount);
    }
}