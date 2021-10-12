package com.zh.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Egg {
	
    int row;
    int col;
    int size = 20;   //һ������Ŀ��
    
    boolean colorFlag = true;
    
    static Random random = new Random();  //�������һ�������

    public Egg(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    public void generateNewEgg()
    {
    	row=random.nextInt(30-3)+3;
    	col=random.nextInt(30-3)+3;
    }
    
    public void draw(Graphics g)
    {
    	Color tmp=g.getColor();
    	
    	if(colorFlag)
    	{
    		g.setColor(Color.red);
    		colorFlag=false;
    	}else
    	{
    		g.setColor(Color.gray);
    		colorFlag=true;
    	}
    	
    	g.fillOval(col*size, row*size, size, size);
    	g.setColor(tmp);
    }
    
    //����һ������
    public Rectangle getRect()
    {
    	return new Rectangle(col*size,row*size,size,size);
    }
    
}
