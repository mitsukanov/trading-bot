package auction;

import bidders.AbstractBidder;

import java.util.List;

/**
 * Auction actions
 */
public interface Auction {

    /**
     * Play bets with all products
     *
     * @return bidder <-> bidder auction result
     */
    List<AbstractBidder> start();
}
