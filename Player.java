package domain;

import java.util.ArrayList;
import java.util.Iterator;

public class Player {
	private final String name;
	private ArrayList<Card> hand;
	private int score;
	private Card lastPlayedCard;
	
	public Player(String name) {
		hand = new ArrayList<Card>();
		lastPlayedCard = null;
		this.name = name;
		score = 0;
	}

	public int getScore() {
		return score;
	}

	public void increaseScore(int addScore) {
		this.score += addScore;
	}
	
	public String getName() {
		return name;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}
	
	public Card getLastPlayedCard() {
		return lastPlayedCard;
	}

	public void setLastPlayedCard(Card lastPlayedCard) {
		this.lastPlayedCard = lastPlayedCard;
	}

	public void setHand(Card[] cardArray){
		for (Card card : cardArray) {
			getHand().add(card);
		}
	}

	public void makeNextMove() {		
		return;
	}
	
	public void handtoString() {
		System.out.println("Your Hand:");
		int i = 0;
		for (Card card : getHand()) {
			i++;
			System.out.println(i+" - "+card);
		}

	}

}
