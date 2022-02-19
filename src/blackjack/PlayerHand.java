package blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerHand extends Hand {
	@SuppressWarnings("unused")
	private ArrayList<Card> playerHand;
	
	//Constructor
	public PlayerHand() {
		super();
		this.playerHand = new ArrayList<Card>();
	}
	
	Scanner input = new Scanner(System.in);
	
	// Player gameplan depends on players decisions. Can hit another card if handvalue is already over 17 unlike the dealer gameplan.
	public void play(Deck deck) {
		System.out.println("\n Hit (1) or Stay (2)?");
		int answer = input.nextInt();
		
		while (answer == 1) {
			this.draw(deck);
			System.out.println("New card : " + this.getCard(this.handSize()-1).toString());
			System.out.println("Your hand : " + this.toString());
			System.out.println("Total value : "+ this.handValue());
			
			if (this.handValue() > 21 ) {
				break;
			} else {
				System.out.println("\n Hit (1) or Stay (2)?");
				answer = input.nextInt();
			}
			
		if (answer == 2 ) {
			System.out.println("You have decided to stay.");
			break;
				}
			}
					
		
	}

}
