package com.zh.entity;

import java.awt.Graphics;

public class Snake {
	
	public Node head;
	public int size;
	public int score=0;
	public boolean live=true;
	
	public Snake()
	{
		head=new Node(15,20,Direction.LEFT);
		head.next=null;
		size=1;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public boolean isLive()
	{
		return live;
	}
	
	
	
	public boolean dead(Node node)  //�ж��Ƿ����
	{
		if(node.row<1||node.col<0||node.row>29||node.col>29)
		{
			return true;
		}
		
		return false;
	}
	
	
	public void isDead()  //�ж�̰�����Ƿ�����
	{
		
		if(head.row<0||head.col<0||head.row>29||head.col>29)
		{
			live=false;
			System.out.println("������Χ");
			return;
		}
		
		Node work_next=head.next;
		while(work_next!=null)
		{
			if(head.row==work_next.row&&head.col==work_next.col)  //̰����ҧ��������
			{
				live=false;
				return;
			}
			if(dead(work_next))
			{
				live=false;
				return;
			}
			
			work_next=work_next.next;
		}
	}
	
	public void draw(Graphics g)
	{
		if(!live)
		{
			return;
		}
		
		Node work_next=head;
		while(work_next!=null)
		{
			work_next.draw(g);
			work_next=work_next.next;
		}
		
		move();
		isDead();
	}
	
	//̰���ߵ��ƶ�
	public void move()
	{
		addToHead();
		deleteFromTail();
	}
	
	public void addToHead()
	{
		Node node=null;
		switch(head.direction)
		{
		case LEFT:
			node=new Node(head.col-1,head.row,head.direction);
			break;
		case UP:
			node=new Node(head.col,head.row-1,head.direction);
			break;
		case DOWN:
			node=new Node(head.col,head.row+1,head.direction);
			break;
		case RIGHT:
			node=new Node(head.col+1,head.row,head.direction);
			break;
		}
		
		node.next=head;
		head=node;
		size++;
	}
	
	   public void eatEgg(Egg egg) {
	    	
	        if (head.getRect().intersects(egg.getRect())) {
	        	//�ж����������Ƿ��ཻ
	            addToHead();  //�ߵĳ�������
	            egg.generateNewEgg();  //����ٴβ���һ������
	            score += 5;
	        }
	    }
	
	public void deleteFromTail()
	{
		Node work_next=head;
		Node tmp=null;
		
		while(work_next.next!=null)
		{
			tmp=work_next;
			work_next=work_next.next;
		}
		tmp.next=null;
		size--;
	}
}
