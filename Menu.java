package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public static Menu instance = new Menu();
	
	public Menu(){	}
	
	public static Menu getInstance(){
		return instance;
	}
	
	public void menuWorks() {
		//create player and give name
		String name = writeMenu();
		HumanPlayer humanPlayer = new HumanPlayer(name);
		Simulation simulation = new Simulation(humanPlayer);
		
	}
	
	private String writeMenu(){
		//get name
		System.out.println("Welcome to game");
		System.out.println("Please enter a name");

		Scanner keyboardScan = new Scanner(System.in);
		String choice = keyboardScan.nextLine();
		return choice;
	}
	
	public Card writeHandAndGetChoice(Player player, ArrayList<Card> onDesk){
		//every hand prints of Human Player 
		System.out.println("\n\n");
		if (!onDesk.isEmpty()) {
			System.out.print("Card on the desk :");
			for (Card card : onDesk) {
				System.out.print("  "+card);
			}
			System.out.println("");
		}else{
			System.out.println("You are first please select your card");
		}
		
		player.handtoString();
		boolean valid = false;
		int choice = 0; 
		while (!valid){
			try {
				System.out.println("\nPlease write number at the head of card");
				Scanner keyboardScan = new Scanner(System.in);
				choice = keyboardScan.nextInt();
				if (choice>0 && choice <= player.getHand().size())
					valid = true;
				
			} catch (Exception e) {
				
			}
			
		}		
		return player.getHand().get(choice-1);
	}
}
