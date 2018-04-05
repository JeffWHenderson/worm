package com.jeffwhenderson.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GamePlay extends JPanel implements KeyListener, ActionListener {
	private int[] snakeXLength = new int[750];
	private int[] snakeYLength = new int[750];
	
	private int length = 3;
	private int moves = 0;
	
	private boolean left = false, right = false, up = false, down = false;
	
	private ImageIcon upMouth, downMouth, rightMouth, leftMouth, snakeImage;
	private ImageIcon titleImage;
	
	private Timer timer;
	private int delay = 100;

	
	public GamePlay() 
	{
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	
	public void paint(Graphics g) 
	{
		if(moves == 0) {
			snakeXLength[2] = 50;
			snakeXLength[1] = 75;
			snakeXLength[0] = 100;
			
			snakeYLength[2] = 100;
			snakeYLength[1] = 100;
			snakeYLength[0] = 100;
		}
		
		g.setColor(Color.white);
		g.drawRect(24, 10, 851, 55);
		
		titleImage = new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		
		g.setColor(Color.white);
		g.drawRect(24, 74, 851, 577);
		
		g.setColor(Color.black);
		g.fillRect(25, 75, 850, 575);
		
		rightMouth = new ImageIcon("rightmouth.png");
		rightMouth.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);
		
		for(int i = 0; i < length; i++ ) {
			if(i == 0 && right)
			{
				rightMouth = new ImageIcon("rightmouth.png");
				rightMouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
			}
			if(i == 0 && left)
			{
				leftMouth = new ImageIcon("leftmouth.png");
				leftMouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
			}
			if(i == 0 && down)
			{
				downMouth = new ImageIcon("downmouth.png");
				downMouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
			}
			if(i == 0 && up)
			{
				upMouth = new ImageIcon("upmouth.png");
				upMouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
			}
			if(i != 0)
			{
				snakeImage = new ImageIcon("snakeimage.png");
				snakeImage.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
			}
		}
		
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
