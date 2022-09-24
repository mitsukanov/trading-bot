package bidders;

import auction.Bidder;

/**
 * Bidder with default validations and initializations
 */
public abstract class AbstractBidder implements Bidder{

    /**
     * Current value of bidder money. 0 by default.
     */
    protected int cash = 0;

    /**
     * Current bidder's product quantity. 0 by default.
     */
    protected int ownQuantity = 0;

    /**
     * General product quantity.
     */
    protected int generalQuantity;


    /**
     * @throws IllegalArgumentException if quantity or ownCash are negative numbers or if quantity is not even
     */
    @Override
    public void init(int quantity, int cash) {
        this.generalQuantity = quantity;
        this.cash = cash;
    }


    /**
     * @throws IllegalArgumentException if own or other are negative numbers
     */
    @Override
    public void bids(int own, int other) {
        System.out.println("First bidder's bid: " + own);
        System.out.println("Second bidder's bid: " + other);
    }


    /**
     * Get quantity of won products for future comparing.
     *
     * @return quantity of won products
     */
    @Override
    public int getQuantityOfWonProducts(){
        return ownQuantity;
    }


    /**
     * Increase quantity of won products.
     *
     * @param wonQuantity
     * quantity of won products
     */
    @Override
    public void addQuantityOfWonProducts(int wonQuantity)
    {
        ownQuantity += wonQuantity;
    }


    /**
     * Get bidder's cash for future comparing.
     *
     * @return bidder's remaining cash
     */
    @Override
    public int getCash(){
        return cash;
    }



    /**
     * Reduce cash on a bid size
     *
     * @param bid
     * size of bid
     */@Override
    public void reduceCash(int bid){
        cash -= bid;
    }


    /**
     * Comparing results of two bidders
     *
     * @param opponent
     * opponent bidder
     *
     * @return comparison result
     */
    public <T extends AbstractBidder> int compareTo(T opponent)
    {
        if (getQuantityOfWonProducts() > opponent.getQuantityOfWonProducts()) {
            return 1;
        }
        if (getQuantityOfWonProducts() < opponent.getQuantityOfWonProducts()) {
            return -1;
        }

        return Integer.compare(getCash(), opponent.getCash());
    }
}