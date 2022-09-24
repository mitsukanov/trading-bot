package bidders;

import java.util.Random;

/**
 * Bidder with random bids.
 */
public class RandomBidder extends AbstractBidder {

    /**
     * @return next random bid
     */
    @Override
    public int placeBid() {
        return new Random().nextInt(cash);
    }
}
