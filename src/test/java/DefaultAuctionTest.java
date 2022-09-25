import auction.Auction;
import auction.DefaultAuction;
import bidders.AbstractBidder;
import bidders.AverageBidder;
import bidders.ZeroBidder;
import bidders.RandomBidder;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DefaultAuctionTest {

    @Test
    public void biddersWithTheSameMinBalanceTest(){
        AbstractBidder firstBidder = new RandomBidder();
        firstBidder.init(0, 1);
        AbstractBidder secondBidder = new RandomBidder();
        secondBidder.init(0, 1);

        Auction auction = new DefaultAuction(firstBidder, secondBidder, 10);

        List<AbstractBidder> result = auction.start();

        firstBidder = result.get(0);
        secondBidder = result.get(1);

        Assert.assertEquals(firstBidder.getQuantityOfWonProducts(), secondBidder.getQuantityOfWonProducts());
    }


    @Test (expected = IllegalArgumentException.class)
    public void bidderWithNegativeCashTest(){
        AbstractBidder firstBidder = new RandomBidder();
        firstBidder.init(0, -1);
        AbstractBidder secondBidder = new RandomBidder();
        secondBidder.init(0, 1);

        Auction auction = new DefaultAuction(firstBidder, secondBidder, 10);
        auction.start();
    }


    @Test (expected = IllegalArgumentException.class)
    public void bidderWithNullCashTest(){
        AbstractBidder firstBidder = new RandomBidder();
        firstBidder.init(0, 0);
        AbstractBidder secondBidder = new RandomBidder();
        secondBidder.init(0, 1);

        Auction auction = new DefaultAuction(firstBidder, secondBidder, 10);
        auction.start();
    }


    @Test
    public void zeroBiddersDrawTest(){
        AbstractBidder firstBidder = new ZeroBidder();
        firstBidder.init(0, 100);
        AbstractBidder secondBidder = new ZeroBidder();
        secondBidder.init(0, 100);

        Auction auction = new DefaultAuction(firstBidder, secondBidder, 10);

        List<AbstractBidder> result = auction.start();

        firstBidder = result.get(0);
        secondBidder = result.get(1);

        Assert.assertEquals(firstBidder.getQuantityOfWonProducts(), secondBidder.getQuantityOfWonProducts());
    }


    @Test
    public void nullQuantityTest(){
        AbstractBidder firstBidder = new AverageBidder();
        firstBidder.init(0, 100);
        AbstractBidder secondBidder = new AverageBidder();
        secondBidder.init(0, 100);

        Auction auction = new DefaultAuction(firstBidder, secondBidder, 0);

        List<AbstractBidder> result = auction.start();

        firstBidder = result.get(0);
        secondBidder = result.get(1);

        Assert.assertEquals(0, firstBidder.getQuantityOfWonProducts());
        Assert.assertEquals(firstBidder.getQuantityOfWonProducts(), secondBidder.getQuantityOfWonProducts());
    }
}
