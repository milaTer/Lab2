
 /* -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		
		this.setSize(APPLICATION_WIDTH,APPLICATION_HEIGHT);
		
		GRect board = new GRect(WIDTH, HEIGHT);
		board.setFillColor(Color.BLACK);
		add(board);		
		 setup();
		 paddle();
	}
	// creating bricks
	 private void setup() {
		 int n=10;
		 int y=BRICK_Y_OFFSET+BRICK_HEIGHT*n + BRICK_SEP*n;	 
		 for (int j=0;j<10; j++){
		    int x=BRICK_SEP-2;	 
		   for ( int i=0; i<NBRICKS_PER_ROW; i++){		 
		      bricks = new GRect(x,y,BRICK_WIDTH,BRICK_HEIGHT);	      
		      add(bricks);
		      x= x+BRICK_WIDTH+BRICK_SEP; 
		      if (j==0 || j==1){
		    	  bricks.setFillColor(Color.CYAN);
		    	  bricks.setFilled(true);
		      }
		      else if (j==2 || j==3){
		    	  bricks.setFillColor(Color.green);
		    	  bricks.setFilled(true);
		      }
		      else if (j==4 || j==5){
		    	  bricks.setFillColor(Color.yellow);
		    	  bricks.setFilled(true);
		      }
		      else if( j==6 || j==7){
		    	  bricks.setFillColor(Color.orange);
		    	  bricks.setFilled(true);
		      }
		      else {
		    	  bricks.setFillColor(Color.red);
		    	  bricks.setFilled(true);
		      }
		 }
		      n--;
		     y=BRICK_Y_OFFSET+BRICK_HEIGHT*n + BRICK_SEP*n;
		    
		 }	 
	  }
		// paddle	
		  private void paddle() {
			  paddle = new GRect(WIDTH/2-PADDLE_WIDTH/2, HEIGHT-PADDLE_Y_OFFSET,PADDLE_WIDTH,PADDLE_HEIGHT);
				paddle.setFilled(true);
				add (paddle);
			    addMouseListeners();
		}
		// move paddle
		  public void mouseMoved(MouseEvent e) {
			if ((e.getX()<getWidth()-PADDLE_WIDTH/2)&&(e.getX()>PADDLE_WIDTH/2)){
			  paddle.setLocation(e.getX()-PADDLE_WIDTH/2, getHeight()-PADDLE_Y_OFFSET);
			
			}	
			
		}
	
 private GRect bricks;
 private GRect paddle;
}
