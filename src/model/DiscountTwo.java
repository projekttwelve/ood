package model;
/**
 *  Class that contains a certain discount, is used
 *  by programs that want to use this discount
 */

public class DiscountTwo implements DiscountStrategy {

    /**
     * returns a certain discount
     */
    @Override
    public double getDiscount() {
        return 0.8;
    }
}