# Trading Bot
Test task for Optimax Energy

# General info
QU = quantity units MU = monetary units

# Explanation
A product x QU will be auctioned under 2 parties.
The parties have each y MU for auction. They then offer an arbitrary number simultaneously of its MU on
the first 2 QU of the product. After that, the bids will be visible to both.
The 2 QU of the product is awarded to who has offered the most MU; if both bid the same, then both get 1
QU. Both bidders must pay their amount - including the defeated. A bid of 0 MU is allowed. Bidding on each
2 QU is repeated until the supply of x QU is fully auctioned.

# Thesis
Each bidder aims to get a larger amount than its competitor.
In an auction, the program that is able to get more QU than the other wins. In case of a tie, the program that
retains more MU wins.

# Task
Your task is to write a program that can participate in this auction and competes with one of our pro-
grams. Please explain its strategy.