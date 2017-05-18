package domain;

public class Simulation {

	private HumanPlayer humanPlayer;
	private ComputerPlayer computerPlayer;
	private Desk desk;
	
	public Simulation(HumanPlayer humanPlayer) {		
		this.humanPlayer = humanPlayer;
		computerPlayer = new ComputerPlayer("computer");
		desk = Desk.getInstance();
		
		giveCardsToPlayers();
		startTheGame();
	}
	
	private void startTheGame() {
		//simulation part
		//randomly select first player
		//if there is no winner card will be stay on desk and game continue
		Player beginnigPlayer = pickFirstOne();
		while(desk.getCount() < 52){
			if(beginnigPlayer == humanPlayer)
				humanPlayer.makeNextMove();
			else
				computerPlayer.makeNextMove();

			if(beginnigPlayer != humanPlayer)
				humanPlayer.makeNextMove();
			else
				computerPlayer.makeNextMove();
			
			Player winner = compareCards(humanPlayer.getLastPlayedCard(), computerPlayer.getLastPlayedCard());
			if (winner != null){
				//this means there is a winner, so give him socore
				winner.increaseScore(desk.calculateScore(winner.getLastPlayedCard()));
				desk.getCardOnDesk().clear();
				
				if (winner == humanPlayer){
					System.out.println("Winner is "+humanPlayer.getName());
					System.out.println("You gain "+desk.calculateScore(winner.getLastPlayedCard())+" point");
					System.out.println("Your New Score: "+humanPlayer.getScore());
					System.out.println(computerPlayer.getName()+" Score is still: "+computerPlayer.getScore());
					beginnigPlayer = computerPlayer;				
				}else{
					System.out.println("Winner is "+computerPlayer.getName());
					System.out.println(computerPlayer.getName()+" gain "+desk.calculateScore(winner.getLastPlayedCard())+" point");
					System.out.println(computerPlayer.getName()+ "New Score: "+computerPlayer.getScore());
					System.out.println("Your Score is still: "+humanPlayer.getScore());
					beginnigPlayer = humanPlayer;
				}	
			}else{
				//there is no winner so keep playing
				System.out.println("No winner on hand, continue to play");
			}
		}
		if (computerPlayer.getScore()>humanPlayer.getScore()) 
			System.out.println("!!!!!WÝNNER IS COMPUTER!!!!!");
		else
			System.out.println("!!!!!YOU ARE THE WÝNNER!!!!!");

		System.out.println("COMPUTER SCORE : "+computerPlayer.getScore());
		System.out.println("YOUR SCORE : "+humanPlayer.getScore());
		
		DataAccessLayer dataAccessLayer = DataAccessLayer.getInstance();
		prepareFileText();
		try {
			dataAccessLayer.writeFile("humanPlayerName_computerPlayerName", prepareFileText());	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}		


	private String prepareFileText() {
		//prepare file text
		return humanPlayer.getName()+":"+humanPlayer.getScore()+"\n   "
				+computerPlayer.getName()+":"+computerPlayer.getScore();	
	}



	private Player compareCards(Card humanCard, Card computerCard) {
		//compare cards, try to select winner if there is no winner then return null
		if (humanCard.getCardValue()> computerCard.getCardValue()) {
			return humanPlayer;
		}else if (humanCard.getCardValue() < computerCard.getCardValue()) {
			return computerPlayer;
		}else{
			return null;
		}
		
	}

	private Player pickFirstOne() {
		//ramdomize first player
		int rand = (int)(Math.random()*(2));
		if (rand == 0)
			return computerPlayer;
		else
			return humanPlayer;
	}

	private void giveCardsToPlayers(){
		//give players to their cards equally
		Card[] first = new Card[26];
		Card[]second = new Card[26];
		int i = 0;
		for (Card card : GameAplication.getCards()) {
			if (i<26){
				first[i] = card;
			}else{
				second[i-26] = card;
			}
			i++;
		}
		humanPlayer.setHand(first);
		computerPlayer.setHand(second);
	}
	
	
}
