import java.util.Scanner;

public class TriangleArea {
	
	public static void main(String[] args) {
		
        System.out.print("Please, enter the coordinates of three points in the coordinate plane:");
        
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        
        int Ax = scanner.nextInt();
        int Ay = scanner.nextInt();
        
        int Bx = scanner.nextInt();
        int By = scanner.nextInt();
        
        int Cx = scanner.nextInt();
        int Cy = scanner.nextInt();
        
        double area = Math.abs((Ax*(By - Cy) + Bx*(Cy - Ay) + Cx*(Ay - By)) / 2);
        
        if (area != 0) {
        	System.out.printf("%sThe area of the triangle is %d.", System.lineSeparator(), (int)area);
		} else {
			System.out.printf("%sResult: 0.%sThese three points do not form a triangle.", System.lineSeparator());
		}      
	}
}