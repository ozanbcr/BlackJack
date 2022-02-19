package blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> deck;
	
	//Constructor
	public Deck() {
		this.deck = new ArrayList<Card>();
	}
	
	public void createDeck() {
		for (cardSuits suit : cardSuits.values()) {
			for(cardNumbers number : cardNumbers.values()) {
				deck.add(new Card(suit, number)) ;
			}
		}
	}
	
	@Override
	public String toString() {
		String deckOutput = "";
		int i =1;
		for (Card card : this.deck) {
			deckOutput +=  "\n" + i + " "+ card.toString();
			i++;
		}
		return deckOutput;
	}
	
	public int deckSize() {
		return deck.size();
	}
	
	public void shuffle() {
		ArrayList<Card> tempDeck = new ArrayList<Card>(); // create an empty deck.
		Random random = new Random();
		int randomIndex ;
		int deckSize = deck.size();
		for (int i=1 ; i<= deckSize ; i++) {
			
			// Generating random index = random.nextInt((max - min) + 1) + min ;
			randomIndex = random.nextInt((deck.size()-1 - 0)+ 1) + 0;
			tempDeck.add(deck.get(randomIndex));
			deck.remove(randomIndex);
		}
		deck = tempDeck ; 
	}
	
	public void removeCard(int i) {
		deck.remove(i);
	}
	
	public Card getCard(int i ) {
		return deck.get(i);
	}
	
	public void addCard(Card addCard) {
		deck.add(addCard);
	}
	
}