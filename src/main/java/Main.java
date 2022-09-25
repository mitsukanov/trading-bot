import auction.Auction;
import auction.DefaultAuction;
import bidders.AbstractBidder;
import bidders.AverageBidder;
import bidders.RandomBidder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter products quantity (positive, even):");
        int quantity = scanner.nextInt();

        //Getting info and initializing of the first bidder
        System.out.println("Enter cash for first bidder:");
        int firstCash = scanner.nextInt();
        AbstractBidder firstBidder = new AverageBidder();
        firstBidder.init(quantity, firstCash);

        //Getting info and initializing of the second bidder
        System.out.println("Enter cash for second bidder:");
        int secondCash = scanner.nextInt();
        AbstractBidder secondBidder = new RandomBidder();
        secondBidder.init(quantity, secondCash);

        Auction auction = new DefaultAuction(firstBidder, secondBidder, quantity);
        auction.start();
    }
}