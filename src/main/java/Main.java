import auction.*;
import auction.Bidder;
import bidders.AbstractBidder;
import bidders.AverageBidder;
import bidders.ManualBidder;
import bidders.RandomBidder;

import java.util.List;
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
        List<Bidder> result = auction.start();

        int comparison = firstBidder.compareTo(secondBidder);

        System.out.println(comparison > 0 ? "First bidder WON!\n" : comparison < 0 ? "Second bidder WON!\n" : "DRAW!\n");
        System.out.println("First bidder won quantity: " + result.get(0).getQuantityOfWonProducts() + " QU");
        System.out.println("First bidder has remain cash: " + result.get(0).getCash() + "\n");

        System.out.println("Second bidder won quantity: " + result.get(1).getQuantityOfWonProducts()+ " QU");
        System.out.println("Second bidder has remain cash: " + result.get(1).getCash());
    }
}