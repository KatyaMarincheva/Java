import java.util.Locale;
import java.util.Scanner;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Polygon;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Line2D;
import java.io.FileWriter;
import java.io.IOException;
 
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.dom.GenericDOMImplementation;
import org.w3c.dom.Document;

import com.oracle.webservices.internal.api.databinding.Databinding.Builder;
import com.sun.java_cup.internal.runtime.virtual_parse_stack;
import com.sun.org.apache.bcel.internal.generic.Select;
import com.sun.org.apache.xml.internal.security.encryption.Reference;
import com.sun.xml.internal.fastinfoset.sax.Properties;

import org.w3c.dom.DOMImplementation;

public class PaintAHouseAsSVG {

	private int picZeroX = 250;
    private int picZeroY = 200;
   
    public void paint(Graphics2D g2d) {
            Scanner input = new Scanner(System.in);
            Locale.setDefault(Locale.ROOT);
            // for the project to start, you need to download batik-bin-1.8.zip from this site http://apache.cbox.biz/xmlgraphics/batik/binaries/
            // unzip it, and reference it via project -> Properties -> Java Build Path -> Libraries -> Add Jar; Select it in Order and Export
            // you need to add the batik-1.8.jar only, but the filder holding this jar has to include all the library jars
            // one possible input is 1 2 2
            System.out.print("Please type in the number and the coordinates of the dots u want to visualize in the picture:");
            int inputP = input.nextInt();
            Point[] leftRec = new Point[]{new Point(12.5, 8.5),new Point(12.5, 13.5),
                            new Point(17.5, 13.5), new Point(17.5, 8.5)};
            Point[] rigthRec = new Point[]{new Point(20, 8.5),new Point(20, 13.5),
                            new Point(22.5, 13.5), new Point(22.5, 8.5)};
            Point[] triangle = new Point[]{new Point(12.5, 8.5),new Point(22.5, 8.5),
                            new Point(17.5, 3.5)};
           
            drawBackground(g2d);
        drawFigures(g2d);      
            for (int i = 0; i < inputP; i++) {
                    Point givenPoint= new Point(input.nextDouble(), input.nextDouble());
                    boolean isInside = Point.isInsideFig(leftRec,givenPoint) || Point.isInsideFig(rigthRec,givenPoint) ||
                                     Point.isInsideFig(triangle,givenPoint);
                    drawPoints(g2d, isInside, givenPoint);
            }          
      }
   
    private void drawPoints(Graphics2D g2d, boolean isInside, Point currPoint) {
            Graphics2D g2 = (Graphics2D) g2d;
           
            int x = (int)(picZeroX + (currPoint.getX() - 10)*125/2.5);
            int y = (int)(picZeroY + (currPoint.getY() - 3.5)*125/2.5);
           
            Color purp = new Color(0.5f, 0.5f, 0.5f,0.5f);
            g2.setStroke(new BasicStroke(0.5f));
            g2.setColor(Color.black);
            g2.drawOval(x-7, y-7, 14, 14);         
            if (!isInside) {
                    g2.setColor(purp);
            }
            g2.fillOval(x-7, y-7, 14, 14);         
    }

    private void drawFigures(Graphics2D g2d) {
            Graphics2D g2 = (Graphics2D) g2d;
           
            Color purp = new Color(0.5f, 0.5f, 0.5f,0.5f);
            Color diffBlue = new Color(0,51,120);
           
            int[] x = new int[]{picZeroX + 125,picZeroX + 5*125, picZeroX + 3*125};
            int[] y = new int[]{picZeroY + 2*125,picZeroY + 2*125, picZeroY};
            Polygon p = new Polygon(x,y,3);
           
            g2.setStroke(new BasicStroke(3));
            g2.setColor(purp);
            g2.fillRect(picZeroX+125, picZeroY+2*125, 2*125, 2*125);
            g2.fillRect(picZeroX+4*125, picZeroY+2*125, 125, 2*125);
            g2.fillPolygon(p);
           
            g2.setPaint(diffBlue);
            g2.drawRect(picZeroX+125, picZeroY+2*125, 2*125, 2*125);               
            g2.drawRect(picZeroX+4*125, picZeroY+2*125, 125, 2*125);
            g2.drawPolygon(p);
    }

    private void drawBackground(Graphics2D g2d) {
           
            Graphics2D g2 = (Graphics2D) g2d;                
           
            float dash1[] = {1.5f};
        BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
                            1.5f, dash1, 1.5f);
        g2.setStroke(dashed);
        Font f = new Font("Axis", Font.PLAIN, 30);
        g2.setFont(f);             
           
            float x = picZeroX;
            float y = picZeroY-50;
            float axisX = 10f;
            float axisY = 3.5f;
           
            for (int i = 0; i <6; i++) {
                    g2.drawString(Float.toString(axisX).replaceAll("\\.?0*$", ""), x-28, y-25);
                    g2.draw(new Line2D.Float(x, y, x, y + 5*125+100));
                    x += 125;
                    axisX +=2.5f;
            }
           
            x = picZeroX-30 ;
            y = picZeroY;
           
            for (int i = 0; i <6; i++) {
                    g2.drawString(String.format("%4.1f", axisY).replaceAll("\\.?0*$", ""), x-75, y+9);
                    g2.draw(new Line2D.Float(x, y, x+ 5*125+60, y));
                    y += 125;
                    axisY +=2.5f;
            }                              
    }

    public static void main(String[] args) throws IOException {

        DOMImplementation domImpl =
        		GenericDOMImplementation.getDOMImplementation();
        String svgNS = "http://www.w3.org/2000/svg";
        Document document = domImpl.createDocument(svgNS, "svg", null);        
        SVGGraphics2D svgGenerator = new SVGGraphics2D(document);      
       
        Dimension size=new Dimension(1000,1000);
        PaintAHouseAsSVG prob = new PaintAHouseAsSVG();
        svgGenerator.setSVGCanvasSize(size);
        prob.paint(svgGenerator);      
        boolean useCSS = true;          
        svgGenerator.stream(new FileWriter("house.html"), useCSS);    
    }

}

class Point{
    private double x;
    private double y;
   
    public Point(double x, double y){
            this.x = x;
            this.y = y;
    }
   
    public double getX(){
            return this.x;
    }
   
    public void setX(double x){
            this.x = x;
    }
   
    public double getY(){
            return this.y;
    }
   
    public void setY(double y){
            this.y = y;
    }
   
    public static boolean isInsideFig(Point[] fig, Point pointInQ){
            boolean isIn = true;
           
            for (int i = 0; i < fig.length; i++) {
                    int index = i+1;
                    if (i == fig.length-1) {
                            index =0;
                    }
                    double findSign = (fig[index].x - fig[i].x)*(pointInQ.y - fig[i].y) -  
                                    (fig[index].y - fig[i].y)*(pointInQ.x - fig[i].x);
                    if (findSign > 0) {
                            isIn = false;
                    }
            }
            return isIn;
    }
}