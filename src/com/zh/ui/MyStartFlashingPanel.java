package com.zh.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;

public class MyStartFlashingPanel extends JPanel implements Runnable{

	int times=1;
	
	public void paint(Graphics g)
	{

		
		super.paint(g);

		g.fillRect(0, 0, 600, 600);
		
		if(times%2==0)
		{
			//������ʾ��Ϣ
			g.setColor(Color.yellow);
			Font mtFont=new Font("������κ",Font.BOLD,30);
			g.setFont(mtFont);
			g.drawString("̰������Ϸ", 200, 280);
		}
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try{
				Thread.sleep(800);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			times++;
			//�ػ�
			this.repaint();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
