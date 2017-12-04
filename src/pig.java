import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class pig {

	public static void main(String[] args) {
		boolean condition = true;
		while (condition) {
			HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
			hm.put(2, 0);
			hm.put(3, 0);
			hm.put(4, 0);
			hm.put(5, 0);
			hm.put(6, 0);
			int i = 0;
//			keeps track of our stats surrounding rolls for the round
			int currentTotal = 0;
			int highestTotal = 0;
			int cumulativeTotal = 0;
//			----------------------
//			keeps track of our roll-related statistics on a per-game basis
			int currentRolls = 0;
			int highestRolls = 0;
			int totalRolls = 0;
//			-----------------------
			int gamesToPlay = Console.getInt("How many times would you like to play?: ");
			System.out.println("Here we go");
			while (i<gamesToPlay) {
				boolean gameInProgress = true;
				while (gameInProgress) {
					int currentRoll = rollTheDice();
					if (currentRoll==1) {
						gameInProgress = false;
					} else {
						hm.put(currentRoll, hm.get(currentRoll) + 1);
						currentTotal += currentRoll;
						currentRolls++;
					}
				if (currentTotal>highestTotal) {
					highestTotal = currentTotal;
				}
				if (currentRolls>highestRolls) {
					highestRolls = currentRolls;
				}
				}
				totalRolls += currentRolls;
				cumulativeTotal += currentTotal;
				i++;
			}
			int highestKey = 0;
			int highestValue = 0;
			for (int j = 0; j < 5; j++) {
				if (hm.get(j+2)>highestValue) {
					highestValue = hm.get(j+2);
					highestKey = j+2;
				}
			}
			
			System.out.println("Played "+gamesToPlay+" games");
			System.out.println("Highest Score is "+highestTotal);
			System.out.println("Total rolls: "+totalRolls);
			System.out.println("Highest # of rolls in a single game: "+highestRolls);
			System.out.println("Average rolls per game: "+totalRolls/gamesToPlay);
			System.out.println("Average score per game: "+cumulativeTotal/gamesToPlay);
			System.out.println("Most commonly rolled number: "+highestKey+" it was rolled "+highestValue+" times.");
			if (Console.getString("Continue? (y/n): ").toLowerCase().equals("y")) {
				continue;
			}
			break;
		}
		System.out.println("bye");
	}
	
	public static int rollTheDice() {
		return (int) (Math.random() * 6) + 1;
	}

}
