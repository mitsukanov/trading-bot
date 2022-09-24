package bidders;

import java.util.Scanner;

/**
 * Manual bidder controlled from console
 */
public class ManualBidder extends AbstractBidder{
    /**
     * Retrieves the next bid for the product, which may be zero.
     *
     * @return the next bid
     */
    @Override
    public int placeBid() {

        int bid = enterBid();

        while (bid > cash)
        {
            System.out.println("Please enter correct bid");
            bid = enterBid();
        }

        return bid;
    }

    private int enterBid() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your bid that less than " + cash);
        return scanner.nextInt();
    }
}
