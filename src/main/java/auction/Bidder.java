package auction;

import bidders.AbstractBidder;

/**
 * Represents a bidder for the action.
 */
public interface Bidder {

    /**
     * Initializes the bidder with the production quantity and the allowed cash limit.
     *
     * @param quantity
     * the quantity
     * @param cash
     * the cash limit
     */
    void init(int quantity, int cash);

    /**
     * Retrieves the next bid for the product, which may be zero.
     *
     * @return the next bid
     */
    int placeBid();

    /**
     * Shows the bids of the two bidders.
     *
     * @param own
     * the bid of this bidder
     * @param other
     * the bid of the other bidder
     */
    void bids(int own, int other);

    /**
     * Get quantity of won products for future comparing.
     *
     * @return quantity of won products
     */
    int getQuantityOfWonProducts();

    /**
     * Increase quantity of won products.
     *
     * @param quantity
     * quantity of won products
     */
    void addQuantityOfWonProducts(int quantity);

    /**
     * Get bidder's cash for future comparing.
     *
     * @return bidder's remaining cash
     */
    int getCash();

    /**
     * Reduce cash on a bid size
     *
     * @param bid
     * size of bid
     */
    void reduceCash(int bid);

    /**
     * Comparing results of two bidders
     *
     * @param opponent
     * opponent bidder
     *
     * @return comparison result
     */
    <T extends AbstractBidder> int compareTo(T opponent);
}