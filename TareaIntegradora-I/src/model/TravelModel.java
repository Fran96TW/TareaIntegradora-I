package model;

public class TravelModel {
    private double totalTravelPrice;
    private double highestPrice;

    public void addTotalPrice(double[] individualPrices) {
        //Logic to store total prices
        for (double price : individualPrices) {
            totalTravelPrice += price;

            // Update highestPrice if the new total is higher
            if (price > highestPrice) {
                highestPrice = price;
            }
        }
    }

    public double calculateTotalTravelPrice(double[] individualPrices) {
		
        //Logic to calculate the total travel price
		
        double total = 0;
        for (double individualPrice : individualPrices) {
            total += individualPrice;
        }
        return total;
    }

    public double getHighestPrice() {
        // Logic to get the highest recorded price
        return highestPrice;
    }
}
