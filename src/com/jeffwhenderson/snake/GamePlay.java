package com.jeffwhenderson.snake;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GamePlay extends JPanel {
	private int[] snakeXLength = new int[750];
	private int[] snakeYLength = new int[750];
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false; 
	
	private ImageIcon upMouth;
	private ImageIcon downMouth;
	private ImageIcon rightMouth;
	private ImageIcon leftMouth;
	
	private ImageIcon snakeImage;
	
	private Timer timer;
	private int delay = 100;
	
	
	private ImageIcon titleImage;
	
	public GamePlay() 
	{
		
	}
	
	public void paint(Graphics g) 
	{
		g.setColor(Color.white);
		g.drawRect(24, 10, 851, 55);
		
		titleImage = new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		
		g.setColor(Color.white);
		g.drawRect(24, 74, 851, 577);
		
		g.setColor(Color.black);
		g.fillRect(25, 75, 850, 575);
	}
}
