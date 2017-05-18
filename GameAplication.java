package domain;

import java.util.ArrayList;

public class GameAplication {
	private static Card[] cards;
	public static void main(String[] args) {
		cards = new Card[52];
		start();
	}
	
	private static void start(){
		init();
		Menu menu = Menu.getInstance();		
		menu.menuWorks();
		
	}
	private static void init(){
		//create Cards
		int cardCount = 0;
		for (Type types : Type.values()) {
			for (int i = 1; i <= 13; i++) {
				Card card = new Card(types, i);
				cards[cardCount] = card;
				cardCount++;
			}
		}
		shuffleCards();
		
	}
	
	public static void shuffleCards(){
		//shuffle Cards
		for ( int i = cards.length-1; i > 0; i-- ) {
            int random = (int)(Math.random()*(i+1));
            Card temp = cards[i];
            cards[i] = cards[random];
            cards[random] = temp;
        }
	}

	public static Card[] getCards() {
		return cards;
	}	
}
