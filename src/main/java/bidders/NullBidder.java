package bidders;

public class NullBidder extends AbstractBidder{
    /**
     * Retrieves the next bid for the product, which may be zero.
     *
     * @return the next bid
     */
    @Override
    public int placeBid() {
        return 0;
    }
}
