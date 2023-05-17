package PJ3;

import java.util.*;
/*CSC220 Programming Project#3
		Name : Ting Feng
		ID:922992561
		Note: I built a GUI, the main class is PlayPokerGameGUI.


//=================================================================================
/** class PlayingCardException: It is used for errors related to Card and 
 *  OneDeck objects.
 *  Do not modify this class!
 */
class PlayingCardException extends Exception {

    /* Constructor to create a PlayingCardException object */
    PlayingCardException (){
		super ();
    }

    PlayingCardException ( String reason ){
		super ( reason );
    }

    
}



//=================================================================================
/** class Card : for creating playing card objects
 *  it is an immutable class.
 *  Rank - valid values are 1 to 13
 *  Suit - valid values are 1 to 4
 *  Do not modify this class!
 */
public class Card {
	
    /* constant suits and ranks */
    static final String[] Suit = {"","Clubs", "Diamonds", "Hearts", "Spades" };
    static final String[] Rank = {"","A","2","3","4","5","6","7","8","9","10","J","Q","K"};

    /* Data field of a card: rank and suit */
    private int cardRank;  /* values: 1-13 (see Rank[] above) */
    private int cardSuit;  /* values: 1-4  (see Suit[] above) */

    /* Constructor to create a card */
    /* throw PlayingCardException if rank or suit is invalid */
    public Card(int rank, int suit) throws PlayingCardException { 
	if ((rank < 1) || (rank > 13))
		throw new PlayingCardException("Invalid rank:"+rank);
	else
        	cardRank = rank;
	if ((suit < 1) || (suit > 4))
		throw new PlayingCardException("Invalid suit:"+suit);
	else
        	cardSuit = suit;
    }

    /* Accessor and toString */
    /* You may impelemnt equals(), but it will not be used */
    public int getRank() { return cardRank; }
    public int getSuit() { return cardSuit; }
    public String toString() { return Rank[cardRank] + " " + Suit[cardSuit]; }


    /* Few quick tests here */
    public static void main(String args[])
    {
	try {
	    Card c1 = new Card(1,4);    // A Spades
	    System.out.println(c1);
	    c1 = new Card(10,1);	// 10 Clubs
	    System.out.println(c1);
	    c1 = new Card(10,5);        // generate exception here
	}
	catch (PlayingCardException e)
	{
	    System.out.println("PlayingCardException: "+e.getMessage());
	}
    }
}



//=================================================================================
/** class OneDeck represents : one deck of 52 playing cards
 *
 *  Do not add new data fields!
 *  Do not modify any methods
 *  You may add private methods 
 */

class OneDeck {

    /* this is used to keep track of original 52 cards */
    private List<Card> saveDeck;


    /* this starts with copying cards from saveDeck */
    /* it is used to play the card game                  */
    /* see reset(): resets playDeck to saveDeck    */
    private List<Card> playDeck;


    /**
     * Constructor: Creates default one deck of 52 playing cards in saveDeck and
     * 		    copy them to playDeck.
     * Note: You need to catch PlayingCardException from Card constructor
     *	     Use ArrayList for both saveDeck & playDeck
     */
    public OneDeck(){
        saveDeck = new ArrayList<>();
        for (int i = 1; i <=13 ; i++) {
            for (int j = 1; j <=4 ; j++) {
                try {
                    saveDeck.add(new Card(i,j));
                } catch (PlayingCardException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        playDeck= new ArrayList<>(saveDeck);


        // implement this method!
    }


    /**
     * Task: Shuffles cards in playDeck.
     * Hint: Look at java.util.Collections
     */
    public void shuffle()
    {
        Collections.shuffle(playDeck);


        // implement this method!
    }

    /**
     * Task: Deals cards from the playDeck.
     *
     * @param numberCards number of cards to deal
     * @return a list containing cards that were dealt
     * @throw PlayingCardException if numberCard > number of remaining cards
     *
     * Note: You need to create ArrayList to stored dealt cards
     *       and should removed dealt cards from playDeck
     *
     */
    public List<Card> deal(int numberCards) throws PlayingCardException
    {
        if(numberCards > playDeck.size()){
            throw new PlayingCardException();
        }
        List<Card> subList = playDeck.subList(playDeck.size()-numberCards,playDeck.size());
        List<Card> dealCards = new ArrayList<>(subList);
        subList.clear();
        return dealCards;
    }

    /**
     * Task: Resets playDeck by getting all cards from the saveDeck.
     */
    public void reset()
    {


        playDeck = new ArrayList<>(saveDeck);
        // implement this method!
    }

    /**
     * Task: Return number of remaining cards in playDeck.
     */
    public int remainSize()
    {
	return playDeck.size();
    }

    /**
     * Task: Returns a string representing cards in the playDeck 
     */
    public String toString()
    {
	return ""+playDeck;
    }


    /* Quick test                   */
    /*                              */
    /* Do not modify these tests    */
    /* Generate OneDecks of cards    */
    /* Loop 2 times:                */
    /*   Deal 15 cards for 4 times  */
    /*   Expect exception last time */
    /*   reset()                    */

    public static void main(String args[]) {

        System.out.println("*******    Create one deck of cards      *********\n\n");
        OneDeck decks = new OneDeck();

        for (int j = 0; j < 2; j++) {
            System.out.println("\n************************************************\n");
            System.out.println("Loop # " + j + "\n");
            System.out.println("Before shuffle:" + decks.remainSize() + " cards");
            System.out.println("\n\t" + decks);
            System.out.println("\n==============================================\n");

            int numHands = 4;
            int cardsPerHand = 15;

            for (int i = 0; i < numHands; i++) {
                decks.shuffle();
                System.out.println("After shuffle:" + decks.remainSize() + " cards");
                System.out.println("\n\t" + decks);
                try {
                    System.out.println("\n\nHand " + i + ":" + cardsPerHand + " cards");
                    System.out.println("\n\t" + decks.deal(cardsPerHand));
                    System.out.println("\n\nRemain:" + decks.remainSize() + " cards");
                    System.out.println("\n\t" + decks);
                    System.out.println("\n==============================================\n");
                } catch (PlayingCardException e) {
                    System.out.println("*** In catch block:PlayingCardException:Error Msg: " + e.getMessage());
                }
            }


            decks.reset();
        }
    }
}