/*************************************************************************************
 *
 *  This program is used to test PJ3.VideoPoker class
 *  More info are given in Readme file
 * 
 *  PlayPokerGame class allows user to run program as follows:
 *
 *    	java PlayPokerGame	// default credit is $100
 *  or 	java PlayPokerGame NNN	// set initial credit to NNN
 *
 *  Do not modify this file!
 *
 **************************************************************************************/

import PJ3.VideoPoker;

class PlayPokerGame {

    public static void main(String args[]) {
	VideoPoker pokergame;
	if (args.length > 0)
		pokergame = new VideoPoker(Integer.parseInt(args[0]));
	else
		pokergame = new VideoPoker();
	pokergame.play();
    }
}
