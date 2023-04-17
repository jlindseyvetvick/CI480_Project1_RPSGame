import java.util.Random;
import java.util.Scanner;

import rps.RockPaperScissorsGUI;
import sprites.SprapiException;

public class Project1_SPRAPI_Vetvick {

	public static void main(String[] args) throws SprapiException {

		// create new game window with a width of 500 and a height of 600
		RockPaperScissorsGUI rps = new RockPaperScissorsGUI(500, 600, "Extreme Rock, Paper, Scissors");

		//allow for game window to be resized
		rps.setResizable(true);
		rps.setSize(500,250);

		// initialize two images for the game window display
		rps.leftSpriteInit("JARVIS", "images/JARVIS.PNG");
		rps.rightSpriteInit("coolStickFigure", "images/coolStickFigure.png");

		// add costumes for left panel in the game window (computer)
		rps.addCostume("left", "happyRock", "images/happyRock.png");
		rps.addCostume("left", "happyPaper", "images/happyPaper.png");
		rps.addCostume("left", "happyScissors", "images/happyScissors.png");
		rps.addCostume("left", "sadRock", "images/sadRock.png");
		rps.addCostume("left", "sadPaper", "images/sadPaper.png");
		rps.addCostume("left", "sadScissors", "images/sadScissors.png");
		rps.addCostume("left", "surprisedRock", "images/surprisedRock.png");
		rps.addCostume("left", "surprisedPaper", "images/surprisedPaper.png");
		rps.addCostume("left", "surprisedScissors", "images/surprisedScissors.png");
		rps.addCostume("left", "winningRock", "images/winningRock.png");
		rps.addCostume("left", "winningPaper", "images/winningPaper.png");
		rps.addCostume("left", "winningScissors", "images/winningScissors.png");
		rps.addCostume("left", "bowTie", "images/bowTie.png");
		// add costumes for right panel in the game window (player)
		rps.addCostume("right", "happyRock", "images/happyRock.png");
		rps.addCostume("right", "happyPaper", "images/happyPaper.png");
		rps.addCostume("right", "happyScissors", "images/happyScissors.png");
		rps.addCostume("right", "sadRock", "images/sadRock.png");
		rps.addCostume("right", "sadPaper", "images/sadPaper.png");
		rps.addCostume("right", "sadScissors", "images/sadScissors.png");
		rps.addCostume("right", "surprisedRock", "images/surprisedRock.png");
		rps.addCostume("right", "surprisedPaper", "images/surprisedPaper.png");
		rps.addCostume("right", "surprisedScissors", "images/surprisedScissors.png");
		rps.addCostume("right", "winningRock", "images/winningRock.png");
		rps.addCostume("right", "winningPaper", "images/winningPaper.png");
		rps.addCostume("right", "winningScissors", "images/winningScissors.png");
		rps.addCostume("right", "bowTie", "images/bowTie.png");

		// initiate game play by asking the user for their name
		System.out.println("Welcome to EXTREME Rock, Paper, Scissors!");
		System.out.println("Type your game name below: ");
		Scanner scan = new Scanner(System.in);
		String playerName = scan.nextLine();

		// set the 'display name' for the RPS players
		rps.setPlayerName("left", "JARVIS");
		rps.setPlayerName("right", playerName);

		// display game window
		rps.displayGameWindow();

		// show right and left game window images
		rps.spriteVisibility("right", true);
		rps.spriteVisibility("left", true);

		wait(1);

//-------------------------------Modified Code from Assignment #2: Task 3-------------------------------//

		// create an array of strings to represent player and computer choices
		String choices[] = { "rock", "paper", "scissors" };

		// create an new instance of a random object
		Random ran = new Random();

		// create and initialize variables for player and computer scores
		int playerScore = 0;
		int computerScore = 0;

		// create and initialize variable for while loop to play again
		String keepPlaying = "yes";

		while (keepPlaying.equals("yes")) {

			// use the nextInt method to get a choice of 0, 1, or 2
			int cChoice = ran.nextInt(choices.length);

			// use the generated number to pick the computer's choice
			String computerChoice = choices[cChoice];

			// prompt user for game choice
			System.out.println("");
			System.out.println("Let's Play, " + playerName + "! Make your choice by entering: Rock, Paper, or Scissors. ");

			// store and normalize user input as variable
			String playerChoice = scan.nextLine();
			playerChoice = playerChoice.toLowerCase();

			// make comparisons of player and computer choices
			if (playerChoice.equals(computerChoice)) {
				System.out.println("It's a tie! " + playerName + "'s score is: " + playerScore
						+ " and JARVIS's score is: " + computerScore + ".");
				rps.changeCostume("left", "bowTie");
				rps.flipSprite("left");
				rps.changeCostume("right", "bowTie");

				// animate the bowTie images
				for (int i = 0; i < 4; i++) {
					rps.flipSprite("left");
					rps.flipSprite("right");
					wait(1);
				}
			}

			else if (playerChoice.equals(choices[0]) && computerChoice.equals(choices[1])) {
				computerScore = computerScore + 1;
				System.out.println("You lose! " + playerName + "'s score is: " + playerScore
						+ " and JARVIS's score is: " + computerScore + ".");

				// switch costumes to reflect selections
				rps.changeCostume("left", "happyPaper");
				rps.changeCostume("right", "happyRock");
				wait(2);

				// animate winning & losing images
				rps.changeCostume("left", "surprisedPaper");
				rps.changeCostume("right", "sadRock");
				wait(1);

				rps.changeCostume("left", "winningPaper");
				for (int i = 0; i < 4; i++) {
					rps.flipSprite("left");
					wait(1);
				}
			}

			else if (playerChoice.equals(choices[0]) && computerChoice.equals(choices[2])) {
				playerScore = playerScore + 1;
				System.out.println("You win! " + playerName + "'s score is: " + playerScore + " and JARVIS's score is: "
						+ computerScore + ".");

				// switch costumes to reflect selections
				rps.changeCostume("left", "happyScissors");
				rps.changeCostume("right", "happyRock");
				wait(2);

				// animate winning & losing images
				rps.changeCostume("left", "sadScissors");
				rps.changeCostume("right", "surprisedRock");
				wait(1);

				rps.changeCostume("right", "winningRock");
				for (int i = 0; i < 4; i++) {
					rps.flipSprite("right");
					wait(1);
				}
			}

			else if (playerChoice.equals(choices[1]) && computerChoice.equals(choices[0])) {
				playerScore = playerScore + 1;
				System.out.println("You win! " + playerName + "'s score is: " + playerScore + " and JARVIS's score is: "
						+ computerScore + ".");

				// switch costumes to reflect selections
				rps.changeCostume("left", "happyRock");
				rps.changeCostume("right", "happyPaper");
				wait(2);

				// animate winning & losing images
				rps.changeCostume("left", "sadRock");
				rps.changeCostume("right", "surprisedPaper");
				wait(1);

				rps.changeCostume("right", "winningPaper");
				for (int i = 0; i < 4; i++) {
					rps.flipSprite("right");
					wait(1);
				}
			}

			else if (playerChoice.equals(choices[1]) && computerChoice.equals(choices[2])) {
				computerScore = computerScore + 1;
				System.out.println("You lose! " + playerName + "'s score is: " + playerScore
						+ " and JARVIS's score is: " + computerScore + ".");

				// switch costumes to reflect selections
				rps.changeCostume("left", "happyScissors");
				rps.changeCostume("right", "happyPaper");
				wait(2);

				// animate winning & losing images
				rps.changeCostume("left", "surprisedScissors");
				rps.changeCostume("right", "sadPaper");
				wait(1);

				rps.changeCostume("left", "winningScissors");
				for (int i = 0; i < 4; i++) {
					rps.flipSprite("left");
					wait(1);
				}
			}

			else if (playerChoice.equals(choices[2]) && computerChoice.equals(choices[0])) {
				computerScore = computerScore + 1;
				System.out.println("You lose! " + playerName + "'s score is: " + playerScore
						+ " and JARVIS's score is: " + computerScore + ".");

				// switch costumes to reflect selections
				rps.changeCostume("left", "happyRock");
				rps.changeCostume("right", "happyScissors");
				wait(2);

				// animate winning & losing images
				rps.changeCostume("left", "surprisedRock");
				rps.changeCostume("right", "sadScissors");
				wait(1);

				rps.changeCostume("left", "winningRock");
				for (int i = 0; i < 4; i++) {
					rps.flipSprite("left");
					wait(1);
				}
			}

			else if (playerChoice.equals(choices[2]) && computerChoice.equals(choices[1])) {
				playerScore = playerScore + 1;
				System.out.println("You win! " + playerName + "'s score is: " + playerScore + " and JARVIS's score is: "
						+ computerScore + ".");

				// switch costumes to reflect selections
				rps.changeCostume("left", "happyPaper");
				rps.changeCostume("right", "happyScissors");
				wait(2);

				// animate winning & losing images
				rps.changeCostume("left", "sadPaper");
				rps.changeCostume("right", "surprisedScissors");
				wait(1);

				rps.changeCostume("right", "winningScissors");
				for (int i = 0; i < 4; i++) {
					rps.flipSprite("right");
					wait(1);
				}
			}

			// notify user the entered response was not valid
			else {
				System.out.println("Your entry was invalid. ");
			}

			// prior to looping, ask user if they would like to play again
			System.out.println("");
			System.out.println("Would you like to play again? YES or NO ");
			keepPlaying = scan.nextLine();
			keepPlaying = keepPlaying.toLowerCase();

		}
		
		// end game
		System.out.println("");
		System.out.println("It was nice to play with you! End of game. ");
		scan.close();
	}

	// custom function written by Luc & Max to execute a wait command
	// to be used within the program
	public static void wait(int seconds) {
		int time = seconds * 1000;
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("An error occurred with your " + "thread! This shouldn't usually "
					+ "happen! If it persists, talk " + "to the instructor");
		}
	}
}