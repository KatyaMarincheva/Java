package softuni.methods.homework;

public class P3_FullHouse {
	public static void main(String[] args) {
		String[] suits = {"\u2660", "\u2665", "\u2666", "\u2663"};
		String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		
		int fullHousesCount = 0;
				
		for (int suit1 = 0; suit1 < suits.length - 2; suit1++) {
			for (int suit2 = suit1 + 1; suit2 < suits.length; suit2++) {
				for (int suit3 = suit2 + 1; suit3 < suits.length; suit3++) {
					for (int suit1Low = 0; suit1Low < suits.length; suit1Low++) {
						for (int suit2Low = suit1Low + 1; suit2Low < suits.length; suit2Low++) {
							for (int faceUp = 0; faceUp < faces.length; faceUp++) {
								for (int faceLow = 0; faceLow < faces.length; faceLow++) {
									
									if (faceLow != faceUp) {
										
										String format = "(%s%s %s%s %s%s %s%s %s%s)";
										String hand = String.format(format, 
												faces[faceUp], suits[suit1],
												faces[faceUp], suits[suit2],
												faces[faceUp], suits[suit3],
												faces[faceLow], suits[suit1Low],
												faces[faceLow], suits[suit2Low]);
										
										System.out.println(hand);
										fullHousesCount++;	
									}																	
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(fullHousesCount);
	}
}