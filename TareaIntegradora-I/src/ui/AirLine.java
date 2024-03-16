package ui;

import model.FeeModel;
import model.TravelModel;

import java.util.Scanner;

public class AirLine {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("<-------AIRLINES ASSOCIATION------->");
        System.out.println("Welcome to our airline services!");

        // Request customer information
        System.out.print("Enter the number of travelers: ");
        int numberOfTravelers = scanner.nextInt();

        TravelModel travelModel = new TravelModel();
        FeeModel feeModel = new FeeModel();

        for (int i = 1; i <= numberOfTravelers; i++) {
            System.out.println("\n--- Traveler " + i + " ---");
            System.out.print("Enter the approximate luggage weight for traveler " + i + " in kg: ");
            double luggageWeight = scanner.nextDouble();

            // Calculate the fee type based on luggage weight
            String feeType = calculateFeeType(luggageWeight);
            double feePrice = feeModel.calculatePriceFee(feeType, 0); // assuming initial price of 0

            // Offer additional services
            System.out.print("Do you want to add additional services? (yes/no): ");
            String additionalServicesChoice = scanner.next().toLowerCase();

            // Logic for additional services (choose seat, additional luggage, etc.)
            if (additionalServicesChoice.equals("yes")) {
                // Service: Choose Seat
                if (feeType.equals("XS") || feeType.equals("S")) {
                    System.out.print("Choose seat preference (aisle/window/other): ");
                    String seatPreference = scanner.next().toLowerCase();

                    if (seatPreference.equals("aisle") || seatPreference.equals("window")) {
                        feePrice += 15000; // Additional cost for aisle/window seat
                    }
                    // No additional cost for other seat preferences (middle seat)
                }

                // Service: Additional Luggage - 10 kg
                System.out.print("Do you want to add an additional 10 kg luggage? (yes/no): ");
                String additional10KgLuggageChoice = scanner.next().toLowerCase();

                if (additional10KgLuggageChoice.equals("yes")) {
                    feePrice += 50000; // Additional cost for each 10 kg luggage
                }

                // Service: Additional Luggage - 23 kg
                System.out.print("Do you want to add an additional 23 kg luggage? (yes/no): ");
                String additional23KgLuggageChoice = scanner.next().toLowerCase();

                if (additional23KgLuggageChoice.equals("yes")) {
                    feePrice += 100000; // Additional cost for each 23 kg luggage
                }
            }

            // Store total price and highest recorded price
            double[] individualPrices = {feePrice};
            travelModel.addTotalPrice(individualPrices);
        }

        // Display results
        displayResults(travelModel);
    }

    private static String calculateFeeType(double luggageWeight) {

        // Logic to determine fee type based on luggage weight

        if (luggageWeight <= 3) {
            return "XS"; // Up to 3 kg, fee type XS
        } else if (luggageWeight <= 10) {
            return "S";  // Up to 10 kg, fee type S
        } else {
            return "M";  // More than 10 kg, fee type M
        }
    }

    private static void displayResults(TravelModel travelModel) {
        System.out.println("\n<-------RESULTS------->");
        System.out.println("Total prices for each traveler: $");

        // Get the array of individual prices from the TravelModel
        double[] individualPrices = {travelModel.calculateTotalTravelPrice()};

        // Display individual prices for each traveler
        for (int i = 0; i < individualPrices.length; i++) {
            double price = individualPrices[i];
            System.out.println("Traveler " + (i + 1) + "'s price: $" + price);
        }

        double totalTravelPrice = travelModel.calculateTotalTravelPrice();
        double highestPrice = travelModel.getHighestPrice();

        System.out.println("\nTotal travel price for all travelers: $" + totalTravelPrice);
        System.out.println("Highest recorded price: $" + highestPrice);
    }
}

