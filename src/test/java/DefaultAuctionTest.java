import auction.Auction;
import auction.Bidder;
import auction.DefaultAuction;
import bidders.AverageBidder;
import bidders.NullBidder;
import bidders.RandomBidder;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DefaultAuctionTest {

    @Test
    public void biddersWithTheSameMinBalanceTest(){
        Bidder firstBidder = new RandomBidder();
        firstBidder.init(0, 1);
        Bidder secondBidder = new RandomBidder();
        secondBidder.init(0, 1);

        Auction auction = new DefaultAuction(firstBidder, secondBidder, 10);

        List<Bidder> result = auction.start();

        firstBidder = result.get(0);
        secondBidder = result.get(1);

        Assert.assertEquals(firstBidder.getQuantityOfWonProducts(), secondBidder.getQuantityOfWonProducts());
    }


    @Test (expected = IllegalArgumentException.class)
    public void bidderWithNegativeCashTest(){
        Bidder firstBidder = new RandomBidder();
        firstBidder.init(0, -1);
        Bidder secondBidder = new RandomBidder();
        secondBidder.init(0, 1);

        Auction auction = new DefaultAuction(firstBidder, secondBidder, 10);
        auction.start();
    }


    @Test (expected = IllegalArgumentException.class)
    public void bidderWithNullCashTest(){
        Bidder firstBidder = new RandomBidder();
        firstBidder.init(0, 0);
        Bidder secondBidder = new RandomBidder();
        secondBidder.init(0, 1);

        Auction auction = new DefaultAuction(firstBidder, secondBidder, 10);
        auction.start();
    }


    @Test
    public void nullBiddersDrawTest(){
        Bidder firstBidder = new NullBidder();
        firstBidder.init(0, 100);
        Bidder secondBidder = new NullBidder();
        secondBidder.init(0, 100);

        Auction auction = new DefaultAuction(firstBidder, secondBidder, 10);

        List<Bidder> result = auction.start();

        firstBidder = result.get(0);
        secondBidder = result.get(1);

        Assert.assertEquals(firstBidder.getQuantityOfWonProducts(), secondBidder.getQuantityOfWonProducts());
    }


    @Test
    public void nullQuantityTest(){
        Bidder firstBidder = new AverageBidder();
        firstBidder.init(0, 100);
        Bidder secondBidder = new AverageBidder();
        secondBidder.init(0, 100);

        Auction auction = new DefaultAuction(firstBidder, secondBidder, 0);

        List<Bidder> result = auction.start();

        firstBidder = result.get(0);
        secondBidder = result.get(1);

        Assert.assertEquals(0, firstBidder.getQuantityOfWonProducts());
        Assert.assertEquals(firstBidder.getQuantityOfWonProducts(), secondBidder.getQuantityOfWonProducts());
    }
}
