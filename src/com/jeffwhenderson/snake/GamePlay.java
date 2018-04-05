package com.jeffwhenderson.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

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
	
	private ImageIcon upMouth, downMouth, rightMouth, leftMouth, snakeImage, apple;
	private ImageIcon titleImage;
	private Random random = new Random();
	
	private int[] appleXPosition = {25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850};
	private int[] appleYPosition = {75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625};
	
	private int xpos = random.nextInt(34); 
	private int ypos = random.nextInt(23); 
	

	
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
		
		apple = new ImageIcon("enemy.png");
		if(appleXPosition[xpos] == snakeXLength[0] && appleYPosition[ypos] == snakeYLength[0]) {
			length++;
			xpos = random.nextInt(34);
			ypos = random.nextInt(23);
		}
		
		apple.paintIcon(this, g, appleXPosition[xpos], appleYPosition[ypos]);
		
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();
		if(right) {
			for(int i = length - 1; i >= 0; i-- ) {
				snakeYLength[i + 1] = snakeYLength[i];
			}
			for(int i = length; i >= 0; i-- ) {
				if(i == 0) {
					snakeXLength[i] = snakeXLength[i] + 25;
				}else {
					snakeXLength[i] = snakeXLength[i - 1];
				}
				if(snakeXLength[i] > 850)
					snakeXLength[i] = 25;
			}
			repaint();
		}
		if(left) {
			for(int i = length - 1; i >= 0; i-- ) {
				snakeYLength[i + 1] = snakeYLength[i];
			}
			for(int i = length; i >= 0; i-- ) {
				if(i == 0) {
					snakeXLength[i] = snakeXLength[i] - 25;
				}else {
					snakeXLength[i] = snakeXLength[i - 1];
				}
				if(snakeXLength[i]  < 25)
					snakeXLength[i] = 850;
			}
			repaint();
		}		
		if(up) {
			for(int i = length - 1; i >= 0; i-- ) {
				snakeXLength[i + 1] = snakeXLength[i];
			}
			for(int i = length; i >= 0; i-- ) {
				if(i == 0) {
					snakeYLength[i] = snakeYLength[i] - 25;
				}else {
					snakeYLength[i] = snakeYLength[i - 1];
				}
				if(snakeYLength[i]  < 75)
					snakeYLength[i] = 625;
			}
			repaint();
		}
		if(down) {
			for(int i = length - 1; i >= 0; i-- ) {
				snakeXLength[i + 1] = snakeXLength[i];
			}
			for(int i = length; i >= 0; i-- ) {
				if(i == 0) {
					snakeYLength[i] = snakeYLength[i] + 25;
				}else {
					snakeYLength[i] = snakeYLength[i - 1];
				}
				if(snakeYLength[i]  > 625)
					snakeYLength[i] = 75;
			}
			repaint();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moves++;
			right = true;
			if(!left)
				right = true;
			else {
				right = false;
				left = true;
			}
			up = false;
			down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			moves++;
			left = true;
			if(!right)
				left = true;
			else {
				left = false;
				right = true;
			}
			up = false;
			down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			moves++;
			up = true;
			if(!down)
				up = true;
			else {
				up = false;
				down = true;
			}
			left = false;
			right = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			moves++;
			down = true;
			if(!up)
				down = true;
			else {
				down = false;
				up = true;
			}
			left = false;
			right = false;
		}
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
