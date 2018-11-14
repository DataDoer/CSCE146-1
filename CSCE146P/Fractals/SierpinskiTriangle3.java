//Justin Baum
//00426510

import java.applet.*;
import java.awt.*;
import java.util.*;


public class SierpinskiTriangle3 extends Applet{
  private Image display;//Frame
  private Graphics drawingArea;//Canvas
  private static int iter = 9;
  private static Color[] colors = {Color.blue, Color.green, Color.red, Color.yellow, Color.white, Color.magenta};
  private static int numcolors = colors.length;
  private static boolean fill = false;
  private static boolean draw = true;
  private static boolean draworfill = fill; //Change to draw or fill if you want to draw or fill the polygons
  private static int arbitrarypixels = 4;

  public void init() {
    int height = getSize().height;
    int width = getSize().width;

    display = createImage(width, height);
    drawingArea = display.getGraphics();

    //FIRST TRIANGLE
    int startX1 = mid(width,0);
    int startY1 = 0;
    int startX2 = 0;
    int startY2 = height-1;
    int startX3 = width-1;
    int startY3 = height-1;
    firstTriangle(startX1, startY1, startX2, startY2, startX3, startY3, drawingArea,iter);
    //This right here looks really ugly if you fill in the first triangle, so I drew it
    //I just copy pasted the code and redid the function slightly different, because I didn't want to have to redo the function w a first triangle exception
    insideTriangles(startX1, startY1, startX2, startY2, startX3, startY3, drawingArea,iter);
  }
  public void paint(Graphics g) {
    g.drawImage(display, 0, 0, null);
  }//paint

  public static void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Graphics drawingArea, int a) {
    int[] xPoints = {x1,x2,x3};
    int[] yPoints = {y1,y2,y3};
    drawingArea.setColor(colors[0]);
    //Ask if draw or fill?
    if (draworfill) drawingArea.drawPolygon(xPoints,yPoints,3); else {
      drawingArea.setColor(colors[a%numcolors]);
      drawingArea.fillPolygon(xPoints,yPoints,3);
    }
  }//triangle

  public static void insideTriangles(int x1, int y1, int x2, int y2, int x3, int y3, Graphics drawingArea,int limit) {
    drawTriangle(mid(x1,x2),mid(y1,y2),mid(x1,x3),mid(y1,y3),mid(x2,x3),mid(y2,y3),drawingArea, limit);
    if(limit <= 0) return;//Halting cluase
    if(Math.min(Math.abs(x1-x2),Math.abs(y1-y2))<=arbitrarypixels) return;//halting clause for the 4 pixel limit
    //Every triangle gets made with the diagram I made in the comments
    //The triangle being passed in can be any triangle in the fractal
    //Every point gets made as the triangle ABC
    //Then the triangles are made recursively for ADE, DBF, EFC
    //And finally the mid point triangle is made for DEF above
    insideTriangles(x1,y1,mid(x1,x2),mid(y1,y2),mid(x1,x3),mid(y1,y3),drawingArea,limit-1);//Top Triangle
    insideTriangles(mid(x1,x2),mid(y1,y2),x2,y2,mid(x2,x3),mid(y2,y3),drawingArea,limit-1);//Left Triangle
    insideTriangles(mid(x1,x3),mid(y1,y3),mid(x2,x3),mid(y2,y3),x3,y3,drawingArea,limit-1);//Right Triangle
  }

  public static int mid(int x1, int x2) {//Just to neaten up the code
    return (x1+x2)/2;
  }
  public static void firstTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Graphics drawingArea, int a) {
    int[] xPoints = {x1,x2,x3};
    int[] yPoints = {y1,y2,y3};
    drawingArea.setColor(colors[0]);
    drawingArea.drawPolygon(xPoints,yPoints,3);
  }//triangle
}//Triangles

/*
How I solved it
A = (x1,y1)
B = (x2,y2)
C = (x3,y3)
D = mid point of A&B
E = mid point of A&C
F = mid point of B&C

Triangle ADE -> ABC
D1 = midpoint of A&D
E1 = midpoint of A&E
F1 = midpoint of D&E
etc.....

----------A----------
|         /\        |
|        /  \       |
|       /    \      |
|      D      E     |
|     /        \    |
|    /          \   |
|   /            \  |
|  /              \ |
B---------F---------C
*/
