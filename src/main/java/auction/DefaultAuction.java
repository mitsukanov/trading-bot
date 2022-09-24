package auction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DefaultAuction implements Auction {

    private final int PLACED_QU = 2;
    /**
     * First bidder algorithm
     */
    private final Bidder firstBidder;

    /**
     * Second bidder algorithm
     */
    private final Bidder secondBidder;

    /**
     * Products amount at the start
     */
    private int quantity;


    public DefaultAuction(Bidder firstBidder, Bidder secondBidder, int quantity) {
        Objects.requireNonNull(firstBidder);
        Objects.requireNonNull(secondBidder);

        this.firstBidder = firstBidder;
        this.secondBidder = secondBidder;
        this.quantity = quantity;
    }


    /**
     * Run default auction.
     * Product quantity must be positive and even.
     * The biggest bid will win.
     * Bid can be 0.
     * Winner will take 2 quantity units.
     * If bids will be the same - DRAW. Each bidder will take 1 quantity unit.
     *
     * @return list with bidder's results
     */
    @Override
    public List<Bidder> start() {

        while (quantity >= 2 && quantity % 2 == 0)
        {
            System.out.println("The auction starts. Products quantity at auction - 2." +
                    "Remaining number of products " + quantity);

            // Place bids
            int firstBid = firstBidder.placeBid();
            int secondBid = secondBidder.placeBid();

            // Make their bids visible
            firstBidder.bids(firstBid, secondBid);

            // Reduce bidder's cash after bids
            firstBidder.reduceCash(firstBid);
            secondBidder.reduceCash(secondBid);

            AuctionResult bidResult = getBidResult(firstBid, secondBid);
            switch (bidResult) {
                case PLAYER_1_WIN -> {
                    firstBidder.addQuantityOfWonProducts(2);

                    System.out.println("First bidder WON this auction.\n");
                }
                case PLAYER_2_WIN -> {
                    secondBidder.addQuantityOfWonProducts(2);

                    System.out.println("Second bidder WON this auction.\n");
                }
                case DRAW -> {
                    firstBidder.addQuantityOfWonProducts(1);
                    secondBidder.addQuantityOfWonProducts(1);

                    System.out.println("DRAW! Each participant took 1 QU.\n");
                }
            }
            quantity = quantity - 2;
        }

        //Handling the case when not even quantity was entered
        if (quantity % 2 != 0)
        {
            System.out.println("Quantity must be even\n");
            System.exit(1);
        }

        //Handling the case when negative quantity was entered
        if (quantity < 0)
        {
            System.out.println("Quantity must be positive\n");
            System.exit(1);
        }

        List<Bidder> result = new ArrayList<>();
        result.add(firstBidder);
        result.add(secondBidder);

        return result;
    }


    /**
     * Get bid result from bids
     *
     * @param firstBid bid of first player
     * @param secondBid bid of second player
     * @return PLAYER_1_WIN if playerOneBid is greater, PLAYER_2_WIN if playerTwoBid is greater, DRAW if equal
     */
    public AuctionResult getBidResult(int firstBid, int secondBid) {
        int comparison = Double.compare(firstBid, secondBid);
        return comparison > 0 ? AuctionResult.PLAYER_1_WIN
                : comparison < 0 ? AuctionResult.PLAYER_2_WIN
                : AuctionResult.DRAW;
    }
}
