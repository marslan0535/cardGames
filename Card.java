package domain;
/**
 * 230201009-230201014 Murat ARSLAN- NUMAN FÝDAN
 */
public class Card {
	private Type cardType;
	private int cardValue;
	
	public Card(Type cardType, int cardValue){
		setCardType(cardType);
		setCardValue(cardValue);		
	}

	public Type getCardType() {
		return cardType;
	}

	public void setCardType(Type cardType) {
		this.cardType = cardType;
	}

	public int getCardValue() {
		return cardValue;
	}

	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}

	@Override
	public String toString() {
		if (cardValue<11)
			return cardType + " - "+ cardValue;
		else if(cardValue == 11)
			return cardType + " - J";
		else if(cardValue == 12)
			return cardType + " - Q";
		else if(cardValue == 13)
			return cardType + " - K";
		return "";
	}
}
