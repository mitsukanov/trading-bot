package auction;

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
    List<Bidder> start();
}
