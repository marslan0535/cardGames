package domain;

public class HumanPlayer extends Player{

	public HumanPlayer(String name) {
		super(name);
	}

	@Override
	public void makeNextMove(){
		Desk desk = Desk.getInstance();
		Menu menu = Menu.getInstance();
		
		Card card = menu.writeHandAndGetChoice(this,desk.getCardOnDesk());
		getHand().remove(card);
		desk.getUsedCards().add(card);
		desk.addCardOnDesk(card);
		
		desk.increaseCount();
		setLastPlayedCard(card); 
		
	}
}
