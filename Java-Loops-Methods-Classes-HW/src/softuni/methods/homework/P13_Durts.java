package softuni.methods.homework;

import java.util.Scanner;

public class P13_Durts {
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
		Rectangle vertical = new Rectangle(rectVerticalX, rectVerticalY, rectVerticalWidth, rectVerticalHeight);
		
		double rectHorizontalX = x - r;
		double rectHorizontalY = y + r/2;
		double rectHorizontalWidth = 2 * r;
		double rectHorizontalHeight = r;
		Rectangle horizontal = new Rectangle(rectHorizontalX, rectHorizontalY, rectHorizontalWidth, rectHorizontalHeight);
		
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
	
	public static class Rectangle {
	    
		private double x;
		private double y;
		private double width;
		private double height;
		
	    public Rectangle(double x, double y, double width, double height) {
	        this.x = x;
	        this.y = y;
	        this.width = width;
	        this.height = height;
	    }
	    
		public double getX() {
			return x;
		}
		
		public void setX(double x) {
			this.x = x;
		}
		
		public double getY() {
			return y;
		}
		
		public void setY(double y) {
			this.y = y;
		}
		
		public double getWidth() {
			return width;
		}
		
		public void setWidth(double width) {
			this.width = width;
		}
		
		public double getHeight() {
			return height;
		}
		
		public void setHeight(double height) {
			this.height = height;
		}
		
	    public boolean contains(double x, double y) {
	    	
	    	boolean isInside = y <= this.y && y >= this.y - this.height && x >= this.x && x <= this.x + this.width;
	    	return isInside;
	    }
	}
}