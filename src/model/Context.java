package model;

/**
 * Class for returning a certain discount depending on context.
 */

public class Context {
    private DiscountStrategy strategy;

    /**
     * Initializes a strategy with contains a certain getDiscount function
     * @param strategy the strategy to be used
     */

    public Context(DiscountStrategy strategy){
        this.strategy = strategy;
    }

    /**
     * returns a certain discount depending on the strategy passed to the constructor
     */

    public double executeDiscount(){
        return strategy.getDiscount();
    }
}
