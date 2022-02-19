package blackjack;

import java.util.ArrayList;

public class DealerHand extends Hand {
	@SuppressWarnings("unused")
	private ArrayList<Card> dealerHand;
	
	public DealerHand() {
		super();
		this.dealerHand = new ArrayList<Card>();
	}
	
	// Dealer has to stay if handvalue is over or equal to 17. Unless, dealer keeps hitting a new card.
	public void play(Deck deck) {
		System.out.println("Dealer value : " + this.handValue() );
		System.out.println("\nDealer has to hit if total value is under 17 !");
		super.draw(deck);
		System.out.println("Dealer got : " + this.getCard(this.handSize()-1).toString());
	}

}

