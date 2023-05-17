CSC220 Programming Project#3
    Name : Ting Feng
    ID:922992561
    Note: I built a GUI, the main class is PlayPokerGameGUI.




============================
 
- Due Date: 11:55pm, 05/07/2023 Sunday

- Upload a zip file, including PlayingCard.java and VideoPoker.java, to ilearn

- Implement poker game program in package PJ3:
 
      Part I  (40%) Implement OneDeck class
      Part II (60%) Implement VideoPoker class //done !
 
      Bonus   (15%) Add GUI, only after you have completed I & II
                    Must complete by same due date

  		    Talk to me before you start this part. 
 
  Use Java API List<> interface and ArrayList. Reference :

	https://docs.oracle.com/javase/8/docs/api/java/util/List.html
	https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
	
    	some useful methods:

	addAll(); size(); subList(); clear(); set() 
	get(); add(); remove(); isEmpty() 

  See PJ3/PlayingCard.java and PJ3/VideoPoker.java for more info. 
 

- Use TestOndDeck.java, PlayPokerGame.java and TestCheckHands.java to 
  test correctness of your program

*************************************************************************************
  
- Sample output :  java TestOneDeck

*******    Create one deck of cards      *********


************************************************

Loop # 0

Before shuffle:52 cards

	[A Clubs, 2 Clubs, 3 Clubs, 4 Clubs, 5 Clubs, 6 Clubs, 7 Clubs, 8 Clubs, 9 Clubs, 10 Clubs, J Clubs, Q Clubs, K Clubs, A Diamonds, 2 Diamonds, 3 Diamonds, 4 Diamonds, 5 Diamonds, 6 Diamonds, 7 Diamonds, 8 Diamonds, 9 Diamonds, 10 Diamonds, J Diamonds, Q Diamonds, K Diamonds, A Hearts, 2 Hearts, 3 Hearts, 4 Hearts, 5 Hearts, 6 Hearts, 7 Hearts, 8 Hearts, 9 Hearts, 10 Hearts, J Hearts, Q Hearts, K Hearts, A Spades, 2 Spades, 3 Spades, 4 Spades, 5 Spades, 6 Spades, 7 Spades, 8 Spades, 9 Spades, 10 Spades, J Spades, Q Spades, K Spades]

==============================================

After shuffle:52 cards

	[9 Clubs, 3 Clubs, 2 Diamonds, K Hearts, K Clubs, 9 Diamonds, A Diamonds, K Spades, 7 Clubs, 2 Hearts, 7 Diamonds, 10 Clubs, 4 Clubs, 9 Hearts, 6 Spades, J Diamonds, Q Clubs, 4 Spades, Q Hearts, 8 Diamonds, Q Spades, 5 Clubs, 8 Clubs, 5 Spades, J Spades, 8 Hearts, 5 Diamonds, 6 Diamonds, 2 Clubs, 10 Diamonds, Q Diamonds, 3 Diamonds, 5 Hearts, 10 Spades, J Clubs, 3 Spades, 2 Spades, 6 Clubs, 4 Hearts, 3 Hearts, 9 Spades, J Hearts, 7 Spades, 7 Hearts, 8 Spades, K Diamonds, A Spades, 10 Hearts, A Clubs, 4 Diamonds, 6 Hearts, A Hearts]


Hand 0:15 cards

	[6 Clubs, 4 Hearts, 3 Hearts, 9 Spades, J Hearts, 7 Spades, 7 Hearts, 8 Spades, K Diamonds, A Spades, 10 Hearts, A Clubs, 4 Diamonds, 6 Hearts, A Hearts]


Remain:37 cards

	[9 Clubs, 3 Clubs, 2 Diamonds, K Hearts, K Clubs, 9 Diamonds, A Diamonds, K Spades, 7 Clubs, 2 Hearts, 7 Diamonds, 10 Clubs, 4 Clubs, 9 Hearts, 6 Spades, J Diamonds, Q Clubs, 4 Spades, Q Hearts, 8 Diamonds, Q Spades, 5 Clubs, 8 Clubs, 5 Spades, J Spades, 8 Hearts, 5 Diamonds, 6 Diamonds, 2 Clubs, 10 Diamonds, Q Diamonds, 3 Diamonds, 5 Hearts, 10 Spades, J Clubs, 3 Spades, 2 Spades]

==============================================

After shuffle:37 cards

	[9 Hearts, K Hearts, 7 Diamonds, 6 Spades, K Clubs, 10 Clubs, 10 Diamonds, 9 Diamonds, 3 Spades, Q Clubs, 3 Diamonds, 8 Hearts, Q Hearts, 10 Spades, 6 Diamonds, 5 Diamonds, A Diamonds, 7 Clubs, 2 Hearts, J Clubs, 4 Spades, 2 Spades, 3 Clubs, 8 Clubs, J Diamonds, J Spades, Q Diamonds, 2 Diamonds, 5 Spades, 2 Clubs, 5 Clubs, 9 Clubs, Q Spades, K Spades, 8 Diamonds, 5 Hearts, 4 Clubs]


Hand 1:15 cards

	[3 Clubs, 8 Clubs, J Diamonds, J Spades, Q Diamonds, 2 Diamonds, 5 Spades, 2 Clubs, 5 Clubs, 9 Clubs, Q Spades, K Spades, 8 Diamonds, 5 Hearts, 4 Clubs]


Remain:22 cards

	[9 Hearts, K Hearts, 7 Diamonds, 6 Spades, K Clubs, 10 Clubs, 10 Diamonds, 9 Diamonds, 3 Spades, Q Clubs, 3 Diamonds, 8 Hearts, Q Hearts, 10 Spades, 6 Diamonds, 5 Diamonds, A Diamonds, 7 Clubs, 2 Hearts, J Clubs, 4 Spades, 2 Spades]

==============================================

After shuffle:22 cards

	[A Diamonds, 7 Clubs, 5 Diamonds, 10 Spades, K Clubs, 10 Diamonds, 10 Clubs, K Hearts, 2 Hearts, Q Hearts, 6 Diamonds, Q Clubs, 9 Hearts, 7 Diamonds, 4 Spades, J Clubs, 6 Spades, 2 Spades, 3 Diamonds, 8 Hearts, 3 Spades, 9 Diamonds]


Hand 2:15 cards

	[K Hearts, 2 Hearts, Q Hearts, 6 Diamonds, Q Clubs, 9 Hearts, 7 Diamonds, 4 Spades, J Clubs, 6 Spades, 2 Spades, 3 Diamonds, 8 Hearts, 3 Spades, 9 Diamonds]


Remain:7 cards

	[A Diamonds, 7 Clubs, 5 Diamonds, 10 Spades, K Clubs, 10 Diamonds, 10 Clubs]

==============================================

After shuffle:7 cards

	[A Diamonds, K Clubs, 7 Clubs, 10 Spades, 5 Diamonds, 10 Clubs, 10 Diamonds]


Hand 3:15 cards
*** In catch block:PlayingCardException:Error Msg: Not enough cards to deal

************************************************

Loop # 1

Before shuffle:52 cards

	[A Clubs, 2 Clubs, 3 Clubs, 4 Clubs, 5 Clubs, 6 Clubs, 7 Clubs, 8 Clubs, 9 Clubs, 10 Clubs, J Clubs, Q Clubs, K Clubs, A Diamonds, 2 Diamonds, 3 Diamonds, 4 Diamonds, 5 Diamonds, 6 Diamonds, 7 Diamonds, 8 Diamonds, 9 Diamonds, 10 Diamonds, J Diamonds, Q Diamonds, K Diamonds, A Hearts, 2 Hearts, 3 Hearts, 4 Hearts, 5 Hearts, 6 Hearts, 7 Hearts, 8 Hearts, 9 Hearts, 10 Hearts, J Hearts, Q Hearts, K Hearts, A Spades, 2 Spades, 3 Spades, 4 Spades, 5 Spades, 6 Spades, 7 Spades, 8 Spades, 9 Spades, 10 Spades, J Spades, Q Spades, K Spades]

==============================================

After shuffle:52 cards

	[A Hearts, 5 Hearts, 3 Diamonds, K Hearts, 8 Spades, 5 Spades, 10 Spades, 10 Diamonds, 2 Diamonds, 6 Clubs, 7 Hearts, K Clubs, 7 Spades, Q Clubs, 5 Clubs, K Diamonds, 2 Clubs, Q Spades, Q Diamonds, 6 Hearts, A Clubs, A Spades, 3 Spades, 6 Diamonds, 4 Clubs, 8 Hearts, 10 Clubs, 8 Clubs, 3 Clubs, 4 Hearts, Q Hearts, K Spades, 3 Hearts, 10 Hearts, 9 Hearts, 7 Clubs, 9 Spades, 8 Diamonds, 5 Diamonds, J Diamonds, 7 Diamonds, 6 Spades, 9 Clubs, 9 Diamonds, 2 Spades, 4 Diamonds, A Diamonds, 2 Hearts, 4 Spades, J Clubs, J Hearts, J Spades]


Hand 0:15 cards

	[8 Diamonds, 5 Diamonds, J Diamonds, 7 Diamonds, 6 Spades, 9 Clubs, 9 Diamonds, 2 Spades, 4 Diamonds, A Diamonds, 2 Hearts, 4 Spades, J Clubs, J Hearts, J Spades]


Remain:37 cards

	[A Hearts, 5 Hearts, 3 Diamonds, K Hearts, 8 Spades, 5 Spades, 10 Spades, 10 Diamonds, 2 Diamonds, 6 Clubs, 7 Hearts, K Clubs, 7 Spades, Q Clubs, 5 Clubs, K Diamonds, 2 Clubs, Q Spades, Q Diamonds, 6 Hearts, A Clubs, A Spades, 3 Spades, 6 Diamonds, 4 Clubs, 8 Hearts, 10 Clubs, 8 Clubs, 3 Clubs, 4 Hearts, Q Hearts, K Spades, 3 Hearts, 10 Hearts, 9 Hearts, 7 Clubs, 9 Spades]

==============================================

After shuffle:37 cards

	[Q Spades, 5 Clubs, A Hearts, 3 Spades, 4 Hearts, 10 Clubs, 9 Hearts, 6 Clubs, K Hearts, 8 Hearts, Q Clubs, 6 Diamonds, 10 Spades, 3 Diamonds, 5 Hearts, 9 Spades, 8 Clubs, K Clubs, 8 Spades, 10 Hearts, 7 Spades, 4 Clubs, 10 Diamonds, A Clubs, 6 Hearts, 2 Clubs, 7 Hearts, K Diamonds, Q Hearts, 2 Diamonds, Q Diamonds, 7 Clubs, K Spades, 3 Hearts, 3 Clubs, 5 Spades, A Spades]


Hand 1:15 cards

	[10 Diamonds, A Clubs, 6 Hearts, 2 Clubs, 7 Hearts, K Diamonds, Q Hearts, 2 Diamonds, Q Diamonds, 7 Clubs, K Spades, 3 Hearts, 3 Clubs, 5 Spades, A Spades]


Remain:22 cards

	[Q Spades, 5 Clubs, A Hearts, 3 Spades, 4 Hearts, 10 Clubs, 9 Hearts, 6 Clubs, K Hearts, 8 Hearts, Q Clubs, 6 Diamonds, 10 Spades, 3 Diamonds, 5 Hearts, 9 Spades, 8 Clubs, K Clubs, 8 Spades, 10 Hearts, 7 Spades, 4 Clubs]

==============================================

After shuffle:22 cards

	[8 Hearts, Q Spades, 10 Clubs, 3 Spades, 9 Hearts, 5 Clubs, 10 Spades, 6 Clubs, A Hearts, 4 Clubs, 7 Spades, K Clubs, K Hearts, 10 Hearts, 9 Spades, 8 Clubs, 5 Hearts, 4 Hearts, 6 Diamonds, Q Clubs, 8 Spades, 3 Diamonds]


Hand 2:15 cards

	[6 Clubs, A Hearts, 4 Clubs, 7 Spades, K Clubs, K Hearts, 10 Hearts, 9 Spades, 8 Clubs, 5 Hearts, 4 Hearts, 6 Diamonds, Q Clubs, 8 Spades, 3 Diamonds]


Remain:7 cards

	[8 Hearts, Q Spades, 10 Clubs, 3 Spades, 9 Hearts, 5 Clubs, 10 Spades]

==============================================

After shuffle:7 cards

	[3 Spades, 10 Clubs, 8 Hearts, 9 Hearts, Q Spades, 5 Clubs, 10 Spades]


Hand 3:15 cards
*** In catch block:PlayingCardException:Error Msg: Not enough cards to deal

*************************************************************************************

- Sample output : java TestCheckHands

[A Spades, 10 Spades, Q Spades, J Spades, K Spades]
Royal Flush!
-----------------------------------
[9 Spades, 10 Spades, Q Spades, J Spades, K Spades]
Straight Flush!
-----------------------------------
[9 Spades, 10 Spades, Q Spades, J Spades, 8 Diamonds]
Straight!
-----------------------------------
[9 Spades, 10 Spades, Q Spades, J Spades, 5 Spades]
Flush!
-----------------------------------
[8 Spades, 8 Clubs, Q Spades, 8 Diamonds, 8 Hearts]
Four of a Kind!
-----------------------------------
[8 Spades, 8 Clubs, Q Spades, 8 Diamonds, J Spades]
Three of a Kind!
-----------------------------------
[8 Spades, 8 Clubs, J Diamonds, 8 Diamonds, J Spades]
Full House!
-----------------------------------
[8 Spades, 9 Diamonds, J Diamonds, 8 Diamonds, J Spades]
Two Pairs!
-----------------------------------
[3 Diamonds, 9 Diamonds, J Diamonds, 8 Diamonds, J Spades]
Royal Pair!
-----------------------------------
[3 Diamonds, 9 Diamonds, 3 Spades, 8 Diamonds, J Spades]
Sorry, you lost!
-----------------------------------


**************************************************************************************

$ java PlayPokerGame 1000



Payout Table          Multiplier
=======================================
Royal Flush     |       250
Straight Flush  |       50
Four of a Kind  |       25
Full House      |       9
Flush           |       6
Straight        |       5
Three of a Kind |       3
Two Pairs       |       2
Royal Pair      |       1



-----------------------------------
Balance:$1000
Enter bet:200
Hand:[7 Hearts, 9 Diamonds, K Diamonds, A Spades, J Hearts]
Enter positions of cards to keep (e.g. 1 4 5 ):		        <-- replace all cards
Hand:[10 Hearts, 7 Spades, 8 Diamonds, 6 Clubs, 8 Clubs]
Sorry, you lost!

Your balance:$800, one more game (y or n)?y

Want to see payout table (y or n)y



Payout Table          Multiplier
=======================================
Royal Flush     |       250
Straight Flush  |       50
Four of a Kind  |       25
Full House      |       9
Flush           |       6
Straight        |       5
Three of a Kind |       3
Two Pairs       |       2
Royal Pair      |       1



-----------------------------------
Balance:$800
Enter bet:200
Hand:[10 Hearts, Q Clubs, 5 Diamonds, 4 Hearts, 2 Clubs]
Enter positions of cards to keep (e.g. 1 4 5 ):1 2 3 4 5	<-- keep all cards
Hand:[10 Hearts, Q Clubs, 5 Diamonds, 4 Hearts, 2 Clubs]
Sorry, you lost!

Your balance:$600, one more game (y or n)?y

Want to see payout table (y or n)n
-----------------------------------
Balance:$600
Enter bet:200
Hand:[6 Diamonds, 8 Hearts, J Clubs, 5 Spades, 9 Hearts]
Enter positions of cards to keep (e.g. 1 4 5 ):1 5		<-- keep 2 cards
Hand:[6 Diamonds, 5 Diamonds, 3 Diamonds, 9 Diamonds, 9 Hearts]
Sorry, you lost!

Your balance:$400, one more game (y or n)?y

Want to see payout table (y or n)200
-----------------------------------
Balance:$400
Enter bet:200
Hand:[K Spades, 4 Hearts, J Spades, J Clubs, 5 Spades]
Enter positions of cards to keep (e.g. 1 4 5 ):3 4
Hand:[9 Clubs, Q Clubs, J Spades, J Clubs, 2 Clubs]
Royal Pair!

Your balance:$400, one more game (y or n)?y

Want to see payout table (y or n)n
-----------------------------------
Balance:$400
Enter bet:400
Hand:[2 Spades, 2 Diamonds, 3 Clubs, A Diamonds, 5 Hearts]
Enter positions of cards to keep (e.g. 1 4 5 ):1 2
Hand:[2 Spades, 2 Diamonds, K Hearts, 4 Clubs, 9 Spades]
Sorry, you lost!

Your balance is 0
Bye!

