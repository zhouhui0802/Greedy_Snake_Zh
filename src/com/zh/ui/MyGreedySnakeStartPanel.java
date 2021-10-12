package com.zh.ui;

import java.awt.event.*;

import javax.swing.*;

import com.zh.util.FrameUtil;



public class MyGreedySnakeStartPanel extends JFrame implements ActionListener{
	
	//���ȶԲ˵������в���
	JMenuBar jmb=null;
	
	//��ʼ��Ϸ
	JMenu jm1=null;
	JMenuItem jmi1=null;  //�����ÿ�ʼ�µ���Ϸ
	
	//��ʼ����˸���
	MyStartFlashingPanel msfp;
	
	//������ʽ����Ϸ���
	MyGameStartPanel mgsp;
	
	public MyGreedySnakeStartPanel()
	{
		jmb=new JMenuBar();
		jm1=new JMenu("��Ϸ(G)");
		jm1.setMnemonic('G');
		jmi1=new JMenuItem("��ʼ�µ���Ϸ(N)");
		jmi1.setMnemonic('N');
		jmi1.addActionListener(this);
		jmi1.setActionCommand("newGame");
		jm1.add(jmi1);
		jmb.add(jm1);
		this.setJMenuBar(jmb);
		
		//��ʼ������˸��壬�����߳�
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
			System.out.println("��ʼ�µ���Ϸ");
			
			//ɾ���ɵ����
			this.remove(msfp);
			
			//�����µ����
			mgsp=new MyGameStartPanel();
			
			//������Ϸ����߳�
			Thread t=new Thread(mgsp);
			t.start();
			this.add(mgsp);
			//ע�����
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
