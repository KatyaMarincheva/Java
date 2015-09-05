package softuni.methods.homework;

import java.util.HashSet;
import java.util.Set;

public class P4_FullHouseWithJokers {
	
	public static void main(String[] args) {
        String[] faces = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "b", "A", };
        char[] suits = { '♣', '♦', '♥', '♠' };
        
        int count = 0;
        int suitsLength = suits.length;
        int facesLength = faces.length;
        int combinationsCount = (int)Math.pow(2, 5) - 1;
        
        Set<String> setOfHands = new HashSet<String>();
        String[] results = new String[5];
        
        for (int i = 0; i < facesLength; i++) {
            for (int j = 0; j < facesLength; j++) {
                if (i == j) {
                    continue;
                }
                
                for (int a = 0; a < suitsLength; a++) {
                    for (int b = a + 1; b < suitsLength; b++) {
                        for (int c = b + 1; c < suitsLength; c++) {
                            for (int d = 0; d < suitsLength; d++) {
                                for (int e = d + 1; e < suitsLength; e++) {
                                    for (int combs = 0; combs <= combinationsCount; combs++) {
                                            int num = combs;
                                            
                                        for (int joker = 0; joker < 5; joker++) {
                                            if (num % 2 == 1) {
	                                            results[joker] = "*";
	                                            num /= 2;
	                                    	}
                                        }
                                        
                                        String format = "(%s %s %s %s %s)";
                                        String hand = String.format(
                                        		format, 
                                        		results[4],
                                        		results[3],
                                                results[2],
                                                results[1],
                                                results[0]);
                                                
                                        setOfHands.add(hand);
                                        
                                        String cardFormat = "%s%s";
                                        results[4] = String.format(cardFormat, faces[i], suits[a]);
                                        results[3] = String.format(cardFormat, faces[i], suits[b]);
                                        results[2] = String.format(cardFormat, faces[i], suits[c]);
                                        results[1] = String.format(cardFormat, faces[j], suits[d]);
                                        results[0] = String.format(cardFormat, faces[j], suits[e]);
                                        count++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        
            for (String hand : setOfHands) {
                    System.out.println(hand);
            }
            
            System.out.println();
            System.out.println(count);
        }
	}
}