# Auction system

## Introduction

Specification of functional requirements as part of computerisation of the product sale process based on the auction mechanism.


## Business processes

---
<a id="bc1"></a>
### BC1: Auction sale

**Actors:** [Seller](#ac1), [Buyer](#ac2)

**Description:** Business process describing a sale by the auction mechanism.

**Main scenario:**
1. [Seller](#ac1) offers the product at an auction. ([UC1](#uc1))
2. [Buyer](#ac2) offers a bid for the product that is higher than the currently highest bid. ([BR1](#br1)) ([UC5](#uc5))
3. [Buyer](#ac2) wins the auction ([BR2](#br2)) ([UC6](#uc6))
4. [Buyer](#ac2) transfers the amount due to the Seller. ([UC7](#uc7))
5. [Seller](#ac1) transfers the product to the Buyer. ([UC2](#uc2))

**Alternative scenarios:** 

2.A. Buyer's bid has been outbid and [Buyer](#ac2) wants to outbid the current highest bid.
* 2.A.1. Continue at step 2. ([UC5](#uc5))

3.A. Auction time has elapsed and [Buyer](#ac2) has lost the auction. ([BR2](#br2)) ([UC6](#uc6))
* 3.A.1. End of use case.

---

## Actors

<a id="ac1"></a>
### AC1: Seller

A person offering goods at an auction.

<a id="ac2"></a>
### AC2: Buyer

A person intending to purchase a product at an auction..


## User level use cases

### Actors and their goals 

[Seller](#ac1):
* [UC1](#uc1): Offering a product at an auction
* [UC2](#uc2): Transferring prodcut to the buyer
* [UC3](#uc3): Receiving payment from the buyer
* [UC4](#uc4): Handling outbid scenarios
* [UC8](#uc8): Managing auctions.
* [UC9](#uc9): Handling prodcut returns.

[Buyer](#ac2):
* [UC5](#uc5): Bidding on a product
* [UC6](#uc6): Winning an auction
* [UC7](#uc7): Making payment for the won auction
* [UC10](#uc10): Managing bids.
* [UC11](#uc11): View auction history.

---
<a id="uc1"></a>
### UC1: Offering a product at an auction

**Actors:** [Seller](#ac1)

**Main scenario:**
1. [Seller](#ac1) reports to the system the willingness to offer the product up at an auction.
2. System asks for the product data and initial price.
3. [Seller](#ac1) provides product data and the initial price.
4. System verifies data correctness.
5. System informs that the product has been successfully put up for auction.

**Alternative scenarios:** 

4.A. Incorrect or incomplete product data has been entered.
* 4.A.1. informs about incorrectly entered data.
* 4.A.2. Continue at step 2.

---

<a id="uc2"></a>
### UC2: Transferring product to the buyer

**Actors:** [Seller](#ac1), [Buyer](#ac2)

**Main scenario:**
1. After a successful completion of an auction where [Buyer](#ac2) has won ([UC6](#uc6)), [Seller](#ac1) recevies notification from the system.
2. [Seller](#ac1) accesses the system and verifies the auction details.
3. [Seller](#ac1) prepares the product for transfer.
4. [Seller](#ac1) communicates with [Buyer](#ac2) to arrange the transfer logistics.
5. [Seller](#ac1) updates the status of the auction in the system.
6. [Seller](#ac1) completes the transfer of the product to [Buyer](#ac2) as agreed upon.
7. [Seller](#ac1) confirms the completion of the product transfer in the system.

**Alternative scenarios:** 

1.A. Dissimilarities in product's condition or issues with transfer process.
* 4.A.1. [Seller](#ac1) communicates with [Buyer](#ac2) to resolve the issue.
* 4.A.2  [Seller](#ac1) updates the auction status in the system to indicates a delay in the transfer process.
* 4.A.3  The transfer process continues once the issues are resolved.

---

## Business objects (also known as domain or IT objects)

### BO1: Auction

The auction is a form of concluding a sale and purchase transaction in which the Seller specifies the starting bid of the product, while the Buyers may offer their own purchase offer, each time proposing a bid higher than the currently offered bid. The auction ends after a specified period of time. If at least one purchase offer has been submitted, the product is purchased by the Buyer who offered the highest bid. 

### BO2: Product

A physical or digital item to be auctioned.

### B03: Transaction

The Payment represents the financial transaction conducted between the buyer and the seller upon the successful completion of an auction.
## Business rules

<a id="br1"></a>
### BR1: Bidding at auction

Bidding at auction requires submitting an amount higher than current by a minimum of EUR 1.00

<a id="br2"></a>
### BR2: Winning an auction

Auction is won by [Buyer](#ac2) who submitted the highest bid before the end of the auction (time expires).


## CRUDL Matrix


| Use case                                  | Auction | Product | Payment     |
| ----------------------------------------- | ------- | ------- | ----------- |
| UC1: Offering a product at an auction     |    C    |    C    |      -      |
| UC2: Transferring product to the buyer    |   R,U   |    R    |      -      |
| UC3: Receiving payment from the buyer     |   R,U   |    R    |     C,R     | 
| UC4: Handling outbid scenarios            |   R,U   |    R    |      -      |
| UC5: Bidding on a product                 |   R,U   |    R    |      -      |
| UC6: Winning an auction                   |   R,U   |    R    |      -      |
| UC7: Making payment for the won auction   |   R,U   |    R    |     C,R     |
| UC8: Managing auctions                    |   R,U   |    -    |      -      |
| UC9: Handling prodcut returns             |    -    |   R,U   |      -      |
| UC10: Managing bids                       |   R,U   |    -    |      -      |
| UC11: View auction history                |    R    |    -    |      -      |



