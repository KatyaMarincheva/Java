package softuni.methods.homework;

import java.util.HashSet;
import java.util.Random;

public class P6_RandomHandsOf5Cards {
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		
		String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		String[] suits = {"\u2660", "\u2665", "\u2666", "\u2663"};
		
		int numberOfHands = 5;
		int cardsInHand = 5;
		
		for (int i = 0; i < numberOfHands; i++) {
			HashSet<String> hand = new HashSet<String>();			
			
			while (hand.size() < cardsInHand) {
				String face = faces[rand.nextInt(13)];
				String suit = suits[rand.nextInt(4)];
				
				String cardFormat = "%s%s";
				String card = String.format(cardFormat, face, suit);
				hand.add(card);			
			}
			
			String handAsString = String.join(" ", hand);
			System.out.println(handAsString);
		}		
	}
}