package domain;

import java.util.ArrayList;

public class Desk {
	
	private static Desk instance = new Desk();
	private ArrayList<Card> usedCards;
	private int count;
	private ArrayList<Card> cardOnDesk;
	private boolean noWinner;
	
	public Desk() {
		usedCards = new ArrayList<Card>();
		cardOnDesk= new ArrayList<Card>();
		usedCards.clear();
		count = 0;
	}
	
	public static Desk getInstance() {
		return instance;
	}
	
	public int getCount() {
		return count;
	}
	
	public void increaseCount() {
		this.count++;
	}
	
	public ArrayList<Card> getUsedCards() {
		return usedCards;
	}

	public ArrayList<Card> getCardOnDesk() {
		return cardOnDesk;
	}
	
	public void addCardOnDesk(Card cardOnDesk) {
		this.cardOnDesk.add(cardOnDesk);
	}
	
	public int calculateScore(Card card) {
		switch (card.getCardType()) {
		case SPADES:
			return card.getCardValue()*5;
		case HEARTS:
			return card.getCardValue()*7;
		case DIAMONDS:
			return card.getCardValue()*9;
		case CLUBS:
			return card.getCardValue()*11;
		}
		return 0;

	}
}
