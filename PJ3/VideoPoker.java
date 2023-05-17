package PJ3;
import java.util.*;

/*CSC220 Programming Project#3
		Name : Ting Feng
		ID:922992561
		Note: I built a GUI, the main class is PlayPokerGameGUI.


/*
 * Ref: http://en.wikipedia.org/wiki/Video_poker
 *      http://www.freeslots.com/poker.htm
 *
 *
 * Short Description and Poker rules:
 *
 * Video poker is also known as draw poker. 
 * The dealer uses a 52-card deck, which is played fresh after each playerHand. 
 * The player is dealt one five-card poker playerHand. 
 * After the first draw, which is automatic, you may hold any of the cards and draw 
 * again to replace the cards that you haven't chosen to hold. 
 * Your cards are compared to a table of winning combinations. 
 * The object is to get the best possible combination so that you earn the highest 
 * payout on the bet you placed. 
 *
 * Winning Combinations
 *  
 * 1. Jacks or Better: a pair pays out only if the cards in the pair are Jacks, 
 * 	Queens, Kings, or Aces. Lower pairs do not pay out. 
 * 2. Two Pair: two sets of pairs of the same card denomination. 
 * 3. Three of a Kind: three cards of the same denomination. 
 * 4. Straight: five consecutive denomination cards of different suit. 
 * 5. Flush: five non-consecutive denomination cards of the same suit. 
 * 6. Full House: a set of three cards of the same denomination plus 
 * 	a set of two cards of the same denomination. 
 * 7. Four of a kind: four cards of the same denomination. 
 * 8. Straight Flush: five consecutive denomination cards of the same suit. 
 * 9. Royal Flush: five consecutive denomination cards of the same suit, 
 * 	starting from 10 and ending with an ace
 *
 */


/* This is the video poker game class.
 * It uses OneDeck and Card objects to implement video poker game.
 * Please do not modify any data fields or defined methods
 * You may add new data fields and methods
 * Note: You must implement defined methods
 */



public class VideoPoker {

	// default constant values
	private static final int defaultBalance = 100;
	private static final int numberCards = 5;

	// default constant payout value and playerHand types
	private static final int[] winningMultipliers = {1, 2, 3, 5, 6, 9, 25, 50, 250};
	private static final String[] winningHands = {
			"Royal Pair", "Two Pairs", "Three of a Kind", "Straight", "Flush	",
			"Full House", "Four of a Kind", "Straight Flush", "Royal Flush"};

	// use one deck of cards
	private final OneDeck thisDeck;

	// holding current player 5-card hand, balance, bet
	private List<Card> playerHand;
	private int playerBalance;
	private int playerBet;

	/**
	 * default constructor, set balance = defaultBalance
	 */
	public VideoPoker() {
		this(defaultBalance);
	}

	/**
	 * constructor, set given balance
	 */
	public VideoPoker(int balance) {
		this.playerBalance = balance;
		thisDeck = new OneDeck();
	}

	/**
	 * This display the payout table based on winningMultipliers and
	 * winningHands arrays
	 */
	private void showPayoutTable() {
		System.out.println("\n\n");
		System.out.println("Payout Table   	      Multiplier   ");
		System.out.println("=======================================");
		int size = winningMultipliers.length;
		for (int i = size - 1; i >= 0; i--) {
			System.out.println(winningHands[i] + "\t|\t" + winningMultipliers[i]);
		}
		System.out.println("\n\n");
	}

	/**
	 * Check current playerHand using winningMultipliers and winningHands arrays
	 * Must print yourHandType (default is "Sorry, you lost") at the end of function.
	 * This can be checked by testCheckHands() and main() method.
	 */
	private String checkHands() {
		String msg = "Sorry, you lost";
		int comb = 0;
		if (isFLush() && straightEnd() == 14) {
			// 9. Royal Flush: five consecutive denomination cards of the same suit starting from 10 and ending with an ace
			comb = 9;
		} else if (isFLush() && straightEnd() > 0) {
			// 8. Straight Flush: five consecutive denomination cards of the same suit.
			comb = 8;
		} else if (denominationTypes().equals(Arrays.asList(1, 4))) {
			// 7. Four of a kind: four cards of the same denomination.
			comb = 7;
		} else if (denominationTypes().equals(Arrays.asList(2, 3))) {
			// 6. Full House: a set of three cards of the same denomination plus a set of two cards of the same denomination.
			comb = 6;
		} else if (isFLush()) {
			// 5. Flush: five non-consecutive denomination cards of the same suit.
			comb = 5;
		} else if (straightEnd()>0) {
			// 4. Straight: five consecutive denomination cards of different suit.
			comb = 4;
		} else if (denominationTypes().equals(Arrays.asList(1, 1, 3))) {
			// 3. Three of a Kind: three cards of the same denomination.
			comb = 3;
		} else if (denominationTypes().equals(Arrays.asList(1, 2, 2))) {
			// 2. Two Pair: two sets of pairs of the same card denomination.
			comb = 2;
		} else if (hasJackorBetter()) {
     		// 1. Jacks or Better: a pair pays out only if the cards in the pair are Jacks, Queens, Kings, or Aces. Lower pairs do not pay out.
			comb = 1;
		}
		if (comb > 0) {
			playerBalance += playerBet * winningMultipliers[comb - 1];
			msg = winningHands[comb - 1];
		}
		System.out.println(msg);
		return msg;
	}

	private boolean isFLush() {
		int suit = playerHand.get(0).getSuit();
		for (Card c: playerHand) {
			if (c.getSuit() != suit) {
				return false;
			}
		}
		return true;
	}
	private List<Integer> denominationTypes(){
		int[] counts = new int[14];
		for (Card c: playerHand) {
			counts[c.getRank()]++;
		}
		List<Integer> freqs = new ArrayList<>();
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] > 0) {
				freqs.add(counts[i]);
			}
		}
		Collections.sort(freqs);
		return freqs;

	}


	private static List<Integer> tenToAce = Arrays.asList(1, 10, 11, 12, 13);
	/**
	 * Return the highest rank of the straight.
	 * Otherwise, 0 to signal it's not a straight.
	 */
	private int straightEnd() {
		List<Integer> ls = new ArrayList<>();
		for (Card c: playerHand) {
			ls.add(c.getRank());
		}
		Collections.sort(ls);
		if (ls.equals(tenToAce)) {
			return 14;
		}
		for (int i = 1; i < numberCards; i++) {
			if (ls.get(i) - ls.get(0) != i) {
				return 0;
			}
		}
		return ls.get(4);
	}

	private boolean hasJackorBetter(){
		int[] counts = new int[14];
		for (Card c: playerHand) {
			counts[c.getRank()]++;
			if(counts[c.getRank()] == 2){
				if(c.getRank() >= 11 || c.getRank()==1){
					return true;
				}
			}
		}
		return false;

	}

	/*************************************************
	 *   add additional private methods here ....
	 *
	 *************************************************/


	public void play() {

		/** The main algorithm for single player poker game
		 *
		 * Steps:
		 * 		showPayoutTable()
		 *
		 * 		++
		 * 		show balance, get bet
		 *		verify bet value, update balance
		 *		reset deck, shuffle deck,
		 *		deal cards and display cards
		 *		ask for positions of cards to keep
		 *          get positions in one input line
		 *		update cards
		 *		check hands, display proper messages
		 *		update balance if there is a payout
		 *		if balance = O:
		 *			end of program
		 *		else
		 *			ask if the player wants to play a new game
		 *			if the answer is "no" : end of program
		 *			else : showPayoutTable() if user wants to see it
		 *			goto ++
		 */
		try {
			Scanner in = new Scanner(System.in);
			showPayoutTable();
			while (true) {
				// show balance
				System.out.println("Balance: " + playerBalance);
				// take bet
				System.out.println("What's your bet?");
				playerBet = in.nextInt();
				if(playerBet > playerBalance){
					System.out.println("Sorry, your balance is not enough");
					break;
				}
				playerBalance -= playerBet;
				// reset deck
				thisDeck.reset();
				thisDeck.shuffle();
				// draw 5 cards
				playerHand = thisDeck.deal(numberCards);
				System.out.println("Cards " + playerHand);
				// ask for what to keep
				System.out.println("What cards do you want to keep? (comma separated 1~5)");
				String idx = in.next();
				List<Card> keptCards = new ArrayList<>();
				for (String i : idx.split(",")) {
					keptCards.add(playerHand.get(Integer.parseInt(i) - 1));
				}
				keptCards.addAll(thisDeck.deal(numberCards - keptCards.size()));
				playerHand = keptCards;
				System.out.println("Cards " + playerHand);
				checkHands();
				if (playerBalance <= 0) {
					System.out.println("Do you want a new game? (yes/no)");
					if (!in.next().equals("yes")) {
						break;
					}
					playerBalance = defaultBalance;
					showPayoutTable();
				}
			}
		} catch (PlayingCardException e) {
			throw new RuntimeException(e);
		}
		// implement this method
	}

	/*************************************************
	 *   Methods for GUI
	 *
	 *************************************************/

	public int getBalance() {
		return playerBalance;
	}

	public List<Card> getCards() {
		return playerHand;
	}

	public void start(int bet) {
		playerBet = bet;
		playerBalance -= playerBet;
		thisDeck.reset();
		thisDeck.shuffle();
		try {
			playerHand = thisDeck.deal(numberCards);
		} catch (PlayingCardException e) {
			throw new RuntimeException(e);
		}
	}

	public String replace(List<Integer> selected) {
		try {
			List<Card> newCards = thisDeck.deal(numberCards - selected.size());
			for (int i = 0; i < 5; i++) {
				if (!selected.contains(i)) {
					playerHand.set(i, newCards.remove(newCards.size()-1));
				}
			}
			return checkHands();
		} catch (PlayingCardException e) {
			throw new RuntimeException(e);
		}
	}


	/*************************************************
	 *   do not modify methods below
	 *   methods are used for testing your program.
	 *
	 *************************************************/

	/**
	 * testCheckHands is used to test checkHands() method
	 * checkHands() should print your current hand type
	 */
	public void testCheckHands() {
		try {
			playerHand = new ArrayList<Card>();

			// set Royal Flush
			playerHand.add(new Card(1, 4));
			playerHand.add(new Card(10, 4));
			playerHand.add(new Card(12, 4));
			playerHand.add(new Card(11, 4));
			playerHand.add(new Card(13, 4));
			System.out.println(playerHand);
			checkHands();
			System.out.println("-----------------------------------");

			// set Straight Flush
			playerHand.set(0, new Card(9, 4));
			System.out.println(playerHand);
			checkHands();
			System.out.println("-----------------------------------");

			// set Straight
			playerHand.set(4, new Card(8, 2));
			System.out.println(playerHand);
			checkHands();
			System.out.println("-----------------------------------");

			// set Flush
			playerHand.set(4, new Card(5, 4));
			System.out.println(playerHand);
			checkHands();
			System.out.println("-----------------------------------");

			// "Royal Pair" , "Two Pairs" , "Three of a Kind", "Straight", "Flush	",
			// "Full House", "Four of a Kind", "Straight Flush", "Royal Flush" };

			// set Four of a Kind
			playerHand.clear();
			playerHand.add(new Card(8, 4));
			playerHand.add(new Card(8, 1));
			playerHand.add(new Card(12, 4));
			playerHand.add(new Card(8, 2));
			playerHand.add(new Card(8, 3));
			System.out.println(playerHand);
			checkHands();
			System.out.println("-----------------------------------");

			// set Three of a Kind
			playerHand.set(4, new Card(11, 4));
			System.out.println(playerHand);
			checkHands();
			System.out.println("-----------------------------------");

			// set Full House
			playerHand.set(2, new Card(11, 2));
			System.out.println(playerHand);
			checkHands();
			System.out.println("-----------------------------------");

			// set Two Pairs
			playerHand.set(1, new Card(9, 2));
			System.out.println(playerHand);
			checkHands();
			System.out.println("-----------------------------------");

			// set Royal Pair
			playerHand.set(0, new Card(3, 2));
			System.out.println(playerHand);
			checkHands();
			System.out.println("-----------------------------------");

			// non Royal Pair
			playerHand.set(2, new Card(3, 4));
			System.out.println(playerHand);
			checkHands();
			System.out.println("-----------------------------------");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * testOneDeck() is used to test OneDeck class
	 * testOneDeck() should execute OneDeck's main()
	 */
	public void testOneDeck() {
		OneDeck tmp = new OneDeck();
		tmp.main(null);
	}

	/* Quick testCheckHands() */
	public static void main(String args[]) {
		VideoPoker pokergame = new VideoPoker();
		pokergame.testCheckHands();
	}
}