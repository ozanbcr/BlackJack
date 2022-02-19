package blackjack;
import java.util.ArrayList;

public abstract class Hand {
	private ArrayList<Card> hand ;
	
	//Constructor
	public Hand() {
		this.hand = new ArrayList<Card>();
	}
	
	public void draw(Deck deck) {
		hand.add(deck.getCard(0));
		deck.removeCard(0);
	}
	
	@Override
	public String toString() {
		String handOutput = "" ; 
		for (Card card : hand) {
			handOutput += "\n" + card.toString();
		}
		return handOutput;
	}
	
	public int handSize() {
		return hand.size();
	}
	
	public Card getCard(int i) {
		return hand.get(i);
	}
	
	public void removeCard (int i) {
		hand.remove(i);
	}
	
	public abstract void play(Deck deck); 
	// Abstract method. Player and dealer play the game of blackjack in different ways. This method will be defined in subclasses.
	
	
	
	public int handValue() {
		int totalValue = 0;
		
		int aceCount = 0; // Value of ace can be either 1 or 11, depending on the other cards in the hand of a player. 
		
		for (Card card : hand) {
			switch(card.getNumber()) {
			case Two : totalValue += 2 ;
			break;
			case Three : totalValue +=3 ; 
			break ;
			case Four : totalValue += 4 ;
			break ;
			case Five : totalValue += 5 ; 
			break ;
			case Six : totalValue += 6 ;
			break ; 
			case Seven : totalValue += 7 ;
			break;
			case Eight : totalValue += 8 ;
			break ; 
			case Nine : totalValue += 9 ;
			break ;
			case Ten : totalValue += 10 ;
			break ;
			case Jack : totalValue += 10 ;
			break ; 
			case Queen : totalValue += 10 ;
			break ;
			case King : totalValue += 10 ; 
			break ; 
			case Ace : aceCount += 1 ;
			break ;
			}
		}
		
		// Ace Scoring 
		for (int i = 0 ; i < aceCount ; i++ ) {
			if (totalValue > 10) {
				totalValue += 1; // Can't score the ace as 11 here, because total value will be over 21. 
			}
			else {
				totalValue +=11; 
			}
		}
		
		return totalValue ;
	
	}
	
	// Game will be played with just 1 deck of cards, unlike the original game of Blackjack. So we have to reset the deck after every round.
	public void resetDeck(Deck deck) {
		int oldHandSize = hand.size();
		
		for (int i = 0 ; i < oldHandSize ; i++) {
			deck.addCard(this.getCard(i));
		}
		for (int i = 0 ; i < oldHandSize ; i++) {
			this.removeCard(0);
		}
	}
	
	
	

}
