package com.zh.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Node {

	public int row;
	public int col;
	public Direction direction;
	
	public Node next=null;

	
	public int size=20;
	
	public Color nodeColor=Color.yellow;
	
	public Node(int col,int row,Direction direction)
	{
		this.row=row;
		this.col=col;
		this.direction=direction;
	}
	
	public void draw(Graphics g)
	{
		Color tmp=g.getColor();
		g.setColor(nodeColor);
		g.fillRect(col*size, row*size, size, size);
		g.setColor(tmp);
	}
	
	public Rectangle getRect()
	{
		return new Rectangle(col*size,row*size,size,size);
	}
}
