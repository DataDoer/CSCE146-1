import java.applet.*;
import java.awt.*;
import java.util.*;

public class RandomFractal extends Applet {
  private Image display;//Frame
  private Graphics drawingArea;//Canvas

  public void init() { //Called by the graphics library sort of like a constructor
    int height = getSize().height;
    int width = getSize().width;

    display = createImage(width, height);
    drawingArea = display.getGraphics();

    randomFractal(0,height/2,width, height/2, drawingArea);
  }//init

  public void paint(Graphics g) {
    g.drawImage(display, 0, 0, null);
  }//paint

  public static void randomFractal(int leftX, int leftY, int rightX, int rightY, Graphics drawingArea) {
    int stop = 1;//pixel limit
    int max = 25;//This is y max movement
    int midX;
    int midY;
    int delta;
    Random r = new Random();

    if((rightX-leftX) <= stop) {//Stopping condition;
      drawingArea.drawLine(leftX, leftY, rightX, rightY);
    } else {
      midX = (leftX+rightX)/2;
      midY = (leftY+rightY)/2;
      delta = r.nextInt(max);
      midY += delta;
      /*
      System.out.println("randomFractal("+leftX+", "+leftY+", "+midX+", "+midY+", drawingArea);");
      System.out.println("randomFractal("+midX+", "+midY+", "+rightX+", "+rightY+", drawingArea);");
      */
      randomFractal(leftX, leftY, midX, midY, drawingArea);//Left Recursion
      randomFractal(midX, midY, rightX, rightY, drawingArea);//Right Recursion
    }//if-else
  }//randomFractal

}//RandomFractal
