import java.applet.*; //Window
import java.awt.*; //Drawing stuff
import java.util.*; //Fun stuff

public class SierpenskiCarpet extends Applet{
  private Image display;//Frame
  private Graphics drawingArea;//Canvas

  public void init() {
    int height = getSize().height;
    int width = getSize().width;

    display = createImage(width, height);
    drawingArea = display.getGraphics();
    drawGasket(0,0,height,drawingArea);
  }//init`

  public void paint(Graphics g) {
    g.drawImage(display, 0, 0, null);
  }//paint

  public static void drawGasket(int x, int y, int side, Graphics g) {
    int sub = side / 3;

    //Draw the middle
    g.fillRect(x + sub, y + sub, sub, sub);

    if(sub >= 1) {//Magic number
      //Top 3 squares
      drawGasket(x,y,sub,g);//Left
      drawGasket(x+sub,y,sub,g);//Middle
      drawGasket(x+sub*2,y,sub,g);//Right
      //Middle two
      drawGasket(x,y+sub,sub,g);//Left
      ///////////////////////////////////Middle skip
      drawGasket(x+sub*2,y+sub,sub,g);//Right
      //Bottom three
      drawGasket(x,y+sub*2,sub,g);//left
      drawGasket(x+sub,y+sub*2,sub,g);//middle
      drawGasket(x+sub*2,y+sub*2,sub,g);//right
    }
  }

}
