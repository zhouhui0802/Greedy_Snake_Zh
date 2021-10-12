package com.zh.ui;





import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;

import com.zh.entity.Direction;
import com.zh.entity.Egg;
import com.zh.entity.Node;
import com.zh.entity.Snake;

public class MyGameStartPanel extends JPanel implements ActionListener, KeyListener,Runnable{

	boolean isPause=false;
    public static int COLS = 30;
    public static int ROWS = 30;
    
    public static int CELLSIZE = 20;
    
    public Egg egg = new Egg(10,8);
    
    public static  Snake snake=new Snake();
    
	public MyGameStartPanel()
	{
		
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 600, 600);
		
        if (snake.isLive() == false) {
        	//当游戏结束之后
            g.setColor(Color.MAGENTA);
            Font tmp = g.getFont();
            g.setFont(new Font("宋体",Font.BOLD,30));
            g.drawString("Game Over",200, 280);
            g.drawString("F2重新开始",200,340);
            g.setFont(tmp);
            return;
        }
        
		//画出提示信息
		showInfo(g);
        //画出游戏的网格
        g.setColor(Color.green);
        for (int i = 0; i < COLS; i++) {
            g.drawLine(i*CELLSIZE,0,i*CELLSIZE,ROWS*CELLSIZE);
        }
        for (int i = 0; i < ROWS; i++) {
            g.drawLine(0,i*CELLSIZE,COLS*CELLSIZE,i*CELLSIZE);
        }
        
        //画出鸡蛋
        egg.draw(g);
        //蛇吃鸡蛋
        snake.eatEgg(egg);
        //画出贪吃蛇
        snake.draw(g);
        
        if(snake.isLive()==false)
        {
        	
        }
	}
	
	public void showInfo(Graphics g)
	{
		Font f=new Font("宋体",Font.BOLD,20);
		g.setFont(f);
        g.drawString("总得分:  "+snake.getScore(),630,40);
        g.drawString("蛇节数:  "+snake.getSize(),630,100);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try{
				Thread.sleep(500);
				if(isPause==true)
				{
					continue;
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			//重新绘制
			this.repaint();
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getKeyCode())
		{
		case KeyEvent.VK_LEFT:
			if(snake.head.direction!=Direction.RIGHT)
			{
				snake.head.direction=Direction.LEFT;
			}
			break;
		case KeyEvent.VK_UP:
			if(snake.head.direction!=Direction.DOWN)
			{
				snake.head.direction=Direction.UP;
			}
			break;
		case KeyEvent.VK_RIGHT:
			if(snake.head.direction!=Direction.LEFT)
			{
				snake.head.direction=Direction.RIGHT;
			}
			break;
		case KeyEvent.VK_DOWN:
			if(snake.head.direction!=Direction.UP)
			{
				snake.head.direction=Direction.DOWN;
			}
			break;
		case KeyEvent.VK_B:
			isPause=!isPause;
			break;
        case KeyEvent.VK_F2:   //游戏结束
            if (snake.isLive() == false) {
            	snake.head = new Node(15,20,Direction.LEFT);
            	snake.live = true;
                snake.score = 0;
                snake.size = 1;
            }
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
