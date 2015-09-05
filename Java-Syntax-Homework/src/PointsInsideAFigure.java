import java.util.Scanner;

public class PointsInsideAFigure {
	
	public static void main(String[] args) {
		
		System.out.print("Please, enter the coordinates of a point: ");
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		double X = scanner.nextDouble();
		double Y = scanner.nextDouble();
		
		boolean isInsideTopFigure = Y >= 6.0 && Y <= 8.5 && X >= 12.5 && X <= 22.5; 
		boolean isInsideLeftFigure = Y >= 8.5 && Y <= 13.5 && X >= 12.5 && X <= 17.5;
		boolean isInsideRightFigure = Y >= 8.5 && Y <= 13.5 && X >= 20 && X <= 22.5;

		boolean isIndideAFigure = isInsideLeftFigure || isInsideTopFigure || isInsideRightFigure;
		
		String result = isIndideAFigure ? "Inside" : "Outside";
		System.out.println(result);
	}
}