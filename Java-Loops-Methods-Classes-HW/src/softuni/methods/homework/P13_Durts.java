package softuni.methods.homework;

import java.util.Scanner;

public class P13_Durts {
	private static Rectangle vertical = new P13_Durts().new Rectangle();
    private static Rectangle horizontal = new P13_Durts().new Rectangle();
    
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
		vertical = new P13_Durts().new Rectangle(rectVerticalX, rectVerticalY, rectVerticalWidth, rectVerticalHeight);
		
		double rectHorizontalX = x - r;
		double rectHorizontalY = y + r/2;
		double rectHorizontalWidth = 2 * r;
		double rectHorizontalHeight = r;
		horizontal = new P13_Durts().new Rectangle(rectHorizontalX, rectHorizontalY, rectHorizontalWidth, rectHorizontalHeight);
		
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			double pX = scanner.nextDouble();
			double pY = scanner.nextDouble();
			
			boolean isWithinTarget = vertical.contains(pX, pY) || horizontal.contains(pX, pY);
			if (isWithinTarget) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
		
	}
	
	private class Rectangle {
	    
		private double x; 
		private double y;
		private double width;
		private double height;
		
	    private Rectangle(double x, double y, double width, double height) {
	        this.x = x;
	        this.y = y;
	        this.width = width;
	        this.height = height;
	    }
	    
		private Rectangle() {
			this (0, 0, 0, 0);
		}

		private double getX() {
			return x;
		}
		
		private void setX(double x) {
			this.x = x;
		}
		
		private double getY() {
			return y;
		}
		
		private void setY(double y) {
			this.y = y;
		}
		
		private double getWidth() {
			return width;
		}
		
		private void setWidth(double width) {
			this.width = width;
		}
		
		private double getHeight() {
			return height;
		}
		
		private void setHeight(double height) {
			this.height = height;
		}
		
		private boolean contains(double x, double y) {
	    	
	    	boolean isInside = y <= this.y && y >= this.y - this.height && x >= this.x && x <= this.x + this.width;
	    	return isInside;
	    }
	}
}