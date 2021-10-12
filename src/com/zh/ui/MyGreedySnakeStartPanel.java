package com.zh.ui;

import java.awt.event.*;

import javax.swing.*;

import com.zh.util.FrameUtil;



public class MyGreedySnakeStartPanel extends JFrame implements ActionListener{
	
	//首先对菜单栏进行部署
	JMenuBar jmb=null;
	
	//开始游戏
	JMenu jm1=null;
	JMenuItem jmi1=null;  //先设置开始新的游戏
	
	//初始化闪烁面板
	MyStartFlashingPanel msfp;
	
	//创建正式的游戏面板
	MyGameStartPanel mgsp;
	
	public MyGreedySnakeStartPanel()
	{
		jmb=new JMenuBar();
		jm1=new JMenu("游戏(G)");
		jm1.setMnemonic('G');
		jmi1=new JMenuItem("开始新的游戏(N)");
		jmi1.setMnemonic('N');
		jmi1.addActionListener(this);
		jmi1.setActionCommand("newGame");
		jm1.add(jmi1);
		jmb.add(jm1);
		this.setJMenuBar(jmb);
		
		//开始调用闪烁面板，启动线程
		msfp=new MyStartFlashingPanel();
		Thread t=new Thread(msfp);
		t.start();
		
		this.add(msfp);
		this.setSize(800,800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FrameUtil.setFrameCenter(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("newGame"))
		{
			System.out.println("开始新的游戏");
			
			//删除旧的面板
			this.remove(msfp);
			
			//创建新的面板
			mgsp=new MyGameStartPanel();
			
			//启动游戏面板线程
			Thread t=new Thread(mgsp);
			t.start();
			this.add(mgsp);
			//注册监听
			this.addKeyListener(mgsp);
			
			this.setVisible(true);
			this.addWindowListener(new WindowAdapter(){
				@Override
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			});
			
//			if(MyGameStartPanel.snake.isLive()==false)
//			{
//				this.remove(mgsp);
//				this.add(msfp);
//				Thread t1=new Thread(msfp);
//				t1.start();
//			}
		}
	}
	
	public static void main(String args[])
	{
		MyGreedySnakeStartPanel mgssp=new MyGreedySnakeStartPanel();
	}

}
