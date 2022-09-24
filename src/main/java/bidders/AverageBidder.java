package bidders;

/**
 * Bidder calculates the bid by dividing the amount of money
 * by the number of goods and place it time by time throughout the auction
 */
public class AverageBidder extends AbstractBidder{

    private int bid = -1;

    @Override
    public int placeBid() {

        if (bid == -1)
        {
            bid = Math.round((float) (cash / generalQuantity * 2));
        }

        return bid;
    }
}
