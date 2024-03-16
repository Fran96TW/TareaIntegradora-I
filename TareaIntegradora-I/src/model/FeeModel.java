package model;

public class FeeModel {
    private static final double PRICE_XS = 175000;
    private static final double PERCENTAGE_COMFORT_S = 0.25;
    private static final double PERCENTAGE_COMFORT_M = 0.30;

    public double calculatePriceFee(String feeType, double priceRatePrevious) {
        switch (feeType.toUpperCase()) {
            case "XS":
                return PRICE_XS;
            case "S":
                return calculatePriceS(priceRatePrevious);
            case "M":
                return calculatePriceM(priceRatePrevious);
            default:
                throw new IllegalArgumentException("Invalid rate type: " + feeType);
        }
    }

    private double calculatePriceS(double priceRatePrevious) {
        return priceRatePrevious + (PERCENTAGE_COMFORT_S * priceRatePrevious);
    }

    private double calculatePriceM(double priceRatePrevious) {
        return calculatePriceS(priceRatePrevious) + (PERCENTAGE_COMFORT_M * calculatePriceS(priceRatePrevious));
    }
}
