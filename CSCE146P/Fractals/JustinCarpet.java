//Justin Baum
//00426510

import java.applet.*;
import java.awt.*;
import java.util.*;


public class JustinCarpet extends Applet{
  private Image display;//Frame
  private Graphics drawingArea;//Canvas
  private static int iter = 7;
  private static Color[] colors = {Color.blue, Color.green};
  private static int numcolors = colors.length;
  private static boolean fill = false;
  private static boolean draw = true;
  private static boolean draworfill = fill; //Change to draw or fill if you want to draw or fill the polygons
  private static int arbitrarypixels = 4;
  private static int margin = 3;

  public void init() {
    int height = getSize().height;
    int width = getSize().width;

    display = createImage(width, height);
    drawingArea = display.getGraphics();

    //FIRST Square
    int startX1 = margin;//A
    int startY1 = margin;
    int startX2 = width-margin;
    int startY2 = margin;
    int startX3 = width-margin;
    int startY3 = height-margin;
    int startX4 = margin;
    int startY4 = height-margin;
    //This right here looks really ugly if you fill in the first triangle, so I drew it
    //I just copy pasted the code and redid the function slightly different, because I didn't want to have to redo the function w a first triangle exception
    insideSquares(startX1, startY1, startX2, startY2, startX3, startY3,startX4,startY4, drawingArea,iter);
    //drawFirstSquare(startX1, startY1, startX2, startY2, startX3, startY3, startX4, startY4, drawingArea,iter);
    //Put after to draw on top
  }
  public void paint(Graphics g) {
    g.drawImage(display, 0, 0, null);
  }//paint

  public static void drawSquare(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, Graphics drawingArea, int a) {
    int[] xPoints = {x1,x2,x3,x4};
    int[] yPoints = {y1,y2,y3,y4};
    if(draworfill) {
      drawingArea.setColor(colors[0]);
      drawingArea.drawPolygon(xPoints,yPoints,4);
    } else {
      drawingArea.setColor(colors[a%numcolors]);
      drawingArea.fillPolygon(xPoints,yPoints,4);
    }

  }//drawSquare

  public static void drawFirstSquare(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, Graphics drawingArea, int a) {
    int[] xPoints = {x1,x2,x3,x4};
    int[] yPoints = {y1,y2,y3,y4};
    drawingArea.setColor(colors[0]);
    drawingArea.drawPolygon(xPoints,yPoints,4);
  }//drawSquare

  public static void insideSquares(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, Graphics drawingArea, int a) {
    int x5 = mid(x1,x2);//e
    int y5 = mid(y1,y2);
    int x6 = mid(x2,x3);
    int y6 = mid(y2,y3);
    int x7 = mid(x3,x4);
    int y7 = mid(y3,y4);
    int x8 = mid(x4,x1);
    int y8 = mid(y4,y1);
    int midx = mid(x1,x3);
    int midy = mid(y1,y3);
    if(a <= 0) return;
    if(Math.abs(x1-x3) < arbitrarypixels) return;
    drawSquare(x1,y1,x2,y2,x3,y3,x4,y4,drawingArea,a-1);//ABCD
    insideDiamonds(x1,y1,x5,y5,midx,midy,x8,y8,drawingArea,a-1);//AEIH
    insideSquares(x5,y5,x2,y2,x6,y6,midx,midy,drawingArea,a-1);//EBFI
    insideDiamonds(midx,midy,x6,y6,x3,y3,x7,y7,drawingArea,a-1);//IFCG
    insideSquares(x8,y8,midx,midy,x7,y7,x4,y4,drawingArea,a-1);//HIGD
  }


  public static void insideDiamonds(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, Graphics drawingArea, int a) {
    int x5 = mid(x1,x2);//e
    int y5 = mid(y1,y2);
    int x6 = mid(x2,x3);
    int y6 = mid(y2,y3);
    int x7 = mid(x3,x4);
    int y7 = mid(y3,y4);
    int x8 = mid(x4,x1);
    int y8 = mid(y4,y1);
    if(a <= 0) return;
    drawSquare(x5,y5,x6,y6,x7,y7,x8,y8, drawingArea, a-1);
    insideDiamonds(x5,y5,x6,y6,x7,y7,x8,y8, drawingArea, a-1);

  }

  public static int mid(int x1, int x2) {//Just to neaten up the code
    return (x1+x2)/2;
  }
}//Triangles

/*
How I solved it
A = (x1,y1)
B = (x2,y2)
C = (x3,y3)
D = (x4,y4)
E = mid point of A&B
F = mid point of B&C
G = mid point of C&D
H = mid point of D&A



A----J----E----N----B
|   /  \  |    |    |
| /     \ |    |    |
M         K---------O
| \     / |    |    |
|   \ /   |    |    |
H----L----I----P----F
|         |         |
|         |         |
|         |         |
|         |         |
|         |         |
C---------G---------C
*/
