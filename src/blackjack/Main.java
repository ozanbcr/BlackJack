package blackjack;

import java.util.Scanner;

// OZAN BİÇER 

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to game of Blackjack.");
	
		Deck deck = new Deck();
		deck.createDeck();
		deck.shuffle();
		//System.out.println(deck); // To control if deck is created properly.
		
		
		PlayerHand playerHand = new PlayerHand();
		DealerHand dealerHand = new DealerHand();
		
		System.out.println("Enter your budget.");
		try (Scanner input = new Scanner(System.in)) {
			double playerMoney = input.nextDouble() ; // Budget value can be decimal if needed.
			
			
			while (playerMoney > 0 ) {
				
				System.out.println("\nEnter your bet :");
				double playerBet = input.nextDouble(); // Bet can be decimal.
				if (playerBet < 0) {
					System.out.println("Your bet can't be a negative value!!.");
					break;
				}
				if (playerBet > playerMoney) {
					System.out.println("Sorry. You can't bet more than your budget. !");
					break ;
				}
				boolean endRound = false ;
				
				playerHand.draw(deck);
				dealerHand.draw(deck);
				playerHand.draw(deck);
				dealerHand.draw(deck);
				
				
				while(true) {
					System.out.println("\nYour hand : " + playerHand.toString());
					System.out.println("Your total value : " + playerHand.handValue());
					System.out.println("\nDealer's hand : " + dealerHand.getCard(0).toString()+ "  -?unknown?-"); // Dealer's one card is hidden while its player's turn.
					
					if (playerHand.handValue() == 21) {
						System.out.println("Blackjack !! You won " + (1.5*playerBet) + ".");
						playerMoney += (playerBet *1.5);
						endRound = true ;
						break;
					}
					
					playerHand.play(deck);
					
					if (playerHand.handValue() > 21 ) {
						System.out.println("You lost " + playerBet + ".");
						playerMoney -= playerBet;
						endRound = true ;
						break;
					}
					
					break;
				}
				
			
				System.out.println("\nDealer's hand : " + dealerHand.toString());	// Dealer hand is fully shown now.		
				
				// Dealer keeps hitting while handvalue is under 17.
				while(dealerHand.handValue() < 17 && endRound == false ) {
					dealerHand.play(deck);
					
				}
				
				System.out.println("Dealer's value : " + dealerHand.handValue());
				
				
				if ((dealerHand.handValue() > 21) && endRound == false) {
					System.out.println("You won " + playerBet + ".") ;
					playerMoney += playerBet ;
					endRound = true ;
				}
				
				if (dealerHand.handValue() > playerHand.handValue() && endRound == false ) {
					System.out.println("\nDealer won. You lost " + playerBet + ".");
					playerMoney -= playerBet ;
					endRound = true ;
				}
				
				if(playerHand.handValue() == dealerHand.handValue() && endRound == false) {
					System.out.println("\nYou have same value with the dealer. Your bet is paid back.");
					endRound = true ;
				}
				
				if ((playerHand.handValue() > dealerHand.handValue()) && endRound == false ) {
					System.out.println("\nYou won " + playerBet + "." );
					playerMoney += playerBet ;
					endRound = true ;
				}
				
				playerHand.resetDeck(deck);
				dealerHand.resetDeck(deck);
				deck.shuffle();
				System.out.println("\nEnd of round.");
				System.out.println("Current budget : " + playerMoney);
			}
		}
		
		System.out.println("You are out of money. Game over ! ") ;

	}

}

