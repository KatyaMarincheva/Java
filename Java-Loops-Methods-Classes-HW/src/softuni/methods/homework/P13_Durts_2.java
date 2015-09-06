package softuni.methods.homework;

import java.util.Scanner;

public class P13_Durts_2 {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		double x = scanner.nextDouble();
		double y = scanner.nextDouble();
		double r = scanner.nextDouble();
		
		double rectVerticalX = x - r/2;
		double rectVerticalY = y + r;
		double rectVerticalWidth = r;
		double rectVerticalHeight = 2 * r;
		
		double rectHorizontalX = x - r;
		double rectHorizontalY = y + r/2;
		double rectHorizontalWidth = 2 * r;
		double rectHorizontalHeight = r;
		
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			double pX = scanner.nextDouble();
			double pY = scanner.nextDouble();
			
			boolean isWithinTarget = 
					contains(pX, pY, rectVerticalX, rectVerticalY, rectVerticalWidth, rectVerticalHeight) 
					|| contains(pX, pY, rectHorizontalX, rectHorizontalY, rectHorizontalWidth, rectHorizontalHeight);
			
			if (isWithinTarget) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
	
	public static boolean contains(
			double pX, 
			double pY, 
			double rectangleX, 
			double rectangleY, 
			double rectangleWidth, 
			double rectangleHeight) {
    	
    	boolean isInside = 
    			pY <= rectangleY 
    			&& pY >= rectangleY - rectangleHeight 
    			&& pX >= rectangleX 
    			&& pX <= rectangleX + rectangleWidth;
    	return isInside;
    }
}