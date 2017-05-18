package domain;

public class ComputerPlayer extends Player{

	private Desk desk;
	public ComputerPlayer(String name) {
		super(name);
		desk = Desk.getInstance();
	}

	@Override
	public void setHand(Card[] cardArray) {
		//sort computer's card for eaasy selection
		for (int i = 0; i < cardArray.length; i++) {
		}
		
		for (int c = 0; c < ( 26 - 1 ); c++) {
		    for (int d = 0; d < 26 - c - 1; d++) {
		        if (desk.calculateScore(cardArray[d]) > desk.calculateScore(cardArray[d+1])) /* For descending order use < */
		        {
			          Card swap      = cardArray[d];
			          cardArray[d]   = cardArray[d+1];
			          cardArray[d+1] = swap;
		        }
		    }
	    }
		
		for (Card card : cardArray) {
			getHand().add(card);
		}
	}
	


	@Override
	public void makeNextMove(){
		//computer next move
		//if user make a move, try to win the hand if cant't win so consider minimum loose

		Card selected = null;
		Desk desk = Desk.getInstance();
		if (!desk.getCardOnDesk().isEmpty() ) {
			for (int i=0; i<getHand().size();i++){
				if (getHand().get(i).getCardValue() > desk.getCardOnDesk().get(desk.getCardOnDesk().size()-1).getCardValue()) {
					selected = getHand().get(i);
					break;
				}
			}
			if (selected == null) {
				selected = getHand().get(0);
			}
		}else if(desk.getCardOnDesk().isEmpty()){
			selected = getHand().get(getHand().size()-1);
		}

		getHand().remove(selected);
		desk.getUsedCards().add(selected);
		desk.addCardOnDesk(selected);
		
		desk.increaseCount();
		setLastPlayedCard(selected);
		System.out.println(selected);
	}
	
	

}
