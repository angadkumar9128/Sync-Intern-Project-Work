import java.util.Scanner;

public class ElectricityBillingSystem {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
			// Constants for tariff rates
			final double RATE_1 = 8.00;
			final double RATE_2 = 13.00;
			final double RATE_3 = 18.00;

			System.out.print("Enter the customer name: ");
			String customerName = input.nextLine();

			System.out.print("Enter the previous meter reading(In Unit): ");
			int previousReading = input.nextInt();

			System.out.print("Enter the current meter reading(In Unit): ");
			int currentReading = input.nextInt();

			System.out.println("Enter the customer type: ");
			System.out.println("1. Residential");
			System.out.println("2. Commercial");
			System.out.println("3. Industrial");
			System.out.print("Enter your choice: ");
			int customerType = input.nextInt();

			int unitsConsumed = currentReading - previousReading;
			double totalAmount = 0.0;

			if (customerType == 1) {
			    totalAmount = unitsConsumed * RATE_1;
			} else if (customerType == 2) {
			    totalAmount = unitsConsumed * RATE_2;
			} else if (customerType == 3) {
			    totalAmount = unitsConsumed * RATE_3;
			} else {
			    System.out.println("Invalid customer type!");
			    System.exit(0);
			}

			System.out.println("----- Bill Details -----");
			System.out.println("Customer Name: " + customerName);
			System.out.println("Previous Reading: " + previousReading);
			System.out.println("Current Reading: " + currentReading);
			System.out.println("Units Consumed: " + unitsConsumed);
			System.out.println("Total Amount: " + totalAmount +" Rupees Only");
		}
    }
}