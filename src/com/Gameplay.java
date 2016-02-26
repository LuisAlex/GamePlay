package com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.KeyboardFocusManager;
import java.awt.LayoutManager;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import javax.swing.JOptionPane;

import javax.swing.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.actor.service.AlienService;
import com.actor.service.impl.AlienServiceImpl;
import com.actor.service.impl.HumanServiceImpl;
import com.actor.service.impl.RobotServiceImpl;
import com.actor.Robot;
import com.actor.Human;
import com.actor.Alien;


public class Gameplay implements ActionListener{
	
	@Autowired
	private AlienServiceImpl alienService; 
	@Autowired
	private HumanServiceImpl humanService;
	@Autowired
	private RobotServiceImpl robotService;
	private int c;
	private int b;
	private int a=b=c=200;
	int d = 8;
	boolean UniTime = true;
	int robotHealth = 0;
	int humanHealth = 0;
	int alienHealth = 0;
	String path = "img/build/build";
	 
	Gameplay(){  
		
		
		Robot robot = new RobotServiceImpl().getRobot("robot");
		Human human = new HumanServiceImpl().getHuman("human");
		Alien alien = new AlienServiceImpl().getAlien("alien");
		robotHealth = robot.getHealth();
		humanHealth = human.getHealth();
		alienHealth = alien.getHealth();
   

			JFrame f=new JFrame("Gameplay"); 
		    ImageIcon carga = new ImageIcon("img/carga.jpg");
		    ImageIcon picR = new ImageIcon("img/buildSave.jpg");
		    ImageIcon picL = new ImageIcon("img/build.jpg");

		    
		    ImageIcon alienPic = new ImageIcon("img/alien.png");
		    ImageIcon humanPic = new ImageIcon("img/human.jpg");
		    ImageIcon robotPic = new ImageIcon("img/robot.jpg");
		    ImageIcon escaleraPic = new ImageIcon("img/escalera.jpg");
		    ImageIcon alienFlag = new ImageIcon("img/bandera.png");
		    ImageIcon humanFlag = new ImageIcon("img/bandera.png");
		    ImageIcon robotFlag = new ImageIcon("img/bandera.png");
   
		    
		    JLabel labelescaleraPic;
		    labelescaleraPic=new JLabel();
		    labelescaleraPic.setBounds(200,0,500,560);
		    labelescaleraPic.setIcon(escaleraPic);
		    f.add(labelescaleraPic);
		  
		    JLabel labelImagen;
		    labelImagen=new JLabel();
		    labelImagen.setBounds(700,0,400,330);
		    labelImagen.setIcon(picR);
		    f.add(labelImagen);
		    
		    JLabel labelImagen1;
		    labelImagen1=new JLabel();
		    labelImagen1.setBounds(10,0,400,330);
		    labelImagen1.setIcon(picL);
		    f.add(labelImagen1);
		    
		    
		    JLabel labelalienFlag;
		    labelalienFlag=new JLabel();
		    labelalienFlag.setBounds(700,10,200,100);
		    labelalienFlag.setIcon(alienFlag);
		    f.add(labelalienFlag);
		    
		    JLabel labelhumanFlag;
		    labelhumanFlag=new JLabel();
		    labelhumanFlag.setBounds(700,50,400,170);
		    labelhumanFlag.setIcon(humanFlag);
		    f.add(labelhumanFlag);
		    
		    JLabel labelrobotFlag;
		    labelrobotFlag=new JLabel();
		    labelrobotFlag.setBounds(700,100,400,230);
		    labelrobotFlag.setIcon(robotFlag);
		    f.add(labelrobotFlag);
		    
		    JLabel labelCarga;
		    labelCarga=new JLabel();
		    labelCarga.setBounds(10,10,160,50);
		    labelCarga.setIcon(carga);
		    f.add(labelCarga);
		   
		    JLabel labelalienPic;
		    JLabel labelalienText;
		    labelalienText = new JLabel("Health: "+String.valueOf(robotHealth));
		    labelalienText.setBounds(240,380,100, 40);

		    labelalienPic=new JLabel();
		    labelalienPic.setBounds(a,10,200,100);
		    labelalienPic.setIcon(alienPic);
		    f.add(labelalienPic);
		    f.add(labelalienText);
		    
		    JLabel labelhumanPic;
		    JLabel labelhumanText;
		    labelhumanText = new JLabel("Health: "+String.valueOf(humanHealth));
		    labelhumanText.setBounds(135,380,100, 40);
		    labelhumanPic=new JLabel();
		    labelhumanPic.setBounds(b,50,400,170);
		    labelhumanPic.setIcon(humanPic);
		    f.add(labelhumanPic);
		    f.add(labelhumanText);
		    
		    JLabel labelrobotPic;
		    JLabel labelrobotText;
		    labelrobotText = new JLabel("Health: "+String.valueOf(robotHealth));
		    labelrobotText.setBounds(35,380,100, 40);
		    labelrobotPic=new JLabel();
		    labelrobotPic.setBounds(c,100,400,230);
		    labelrobotPic.setIcon(robotPic);
		    f.add(labelrobotPic);
		    f.add(labelrobotText);
		    
		    JButton b1=new JButton(robot.getNombre());  
			b1.setBounds(10,350,100, 40);  
			f.add(b1);  
			b1.addActionListener (new ActionListener(){
				public void actionPerformed(ActionEvent e){
				labelCarga.setBounds(10,10,160-d,50);
				if(d>150)
				{
					JOptionPane.showMessageDialog(null, "Ow no, there is no more building ...sorry, GAME OVER!!");
				}
				labelrobotPic.setBounds(c=c+42,100,400,230); 
				if(youGetTheBuid(c))
				{
					labelrobotFlag.setBounds(650,100,400,230);
					b1.setEnabled(false);
				}else
				{
					healthAffected();
					labelrobotText.setText("Health: "+String.valueOf(robotHealth));
					labelhumanText.setText("Health: "+String.valueOf(humanHealth));
					labelalienText.setText("Health: "+String.valueOf(alienHealth));
					if(robotHealth == 0 || humanHealth == 0|| alienHealth == 0)
					{
						JOptionPane.showMessageDialog(null, "Running out of healt? ... sorry, GAME OVER!!");
						b1.setEnabled(false);
					}
				}
				} }
				);

			
			JButton b2=new JButton(human.getNombre());  
			b2.setBounds(110,350,100, 40);  
			f.add(b2); 
			b2.addActionListener (new ActionListener(){
				public void actionPerformed(ActionEvent e){
					labelCarga.setBounds(10,10,160-d,50);
					if(d>150)
					{
						JOptionPane.showMessageDialog(null, "Ow no, there is no more building ...sorry, GAME OVER!!");
					}
					labelhumanPic.setBounds(b=b+42,50,400,170);				
					if(youGetTheBuid(b))
					{
						labelhumanFlag.setBounds(650,50,400,170);
						
						b2.setEnabled(false);
					}else
					{
						healthAffected();
						labelrobotText.setText("Health: "+String.valueOf(robotHealth));
						labelhumanText.setText("Health: "+String.valueOf(humanHealth));
						labelalienText.setText("Health: "+String.valueOf(alienHealth));
						if(robotHealth == 0 || humanHealth == 0|| alienHealth == 0)
						{
							JOptionPane.showMessageDialog(null, "Running out of healt? ... sorry, GAME OVER!!");
							b1.setEnabled(false);
							b2.setEnabled(false);
						}
					}
					} }
				);

			JButton b3=new JButton(alien.getNombre());  
			b3.setBounds(210,350,100, 40);  
			f.add(b3); 
			b3.addActionListener (new ActionListener(){
			public void actionPerformed(ActionEvent e){
			labelCarga.setBounds(10,10,160-d,50);
			if(d>150)
			{
				JOptionPane.showMessageDialog(null, "Ow no, there is no more building ...sorry, GAME OVER!!");
			}
			labelalienPic.setBounds(a=a+42,10,200,100);
			healthAffected();					
			if(youGetTheBuid(a))
			{
				labelalienFlag.setBounds(650,10,200,100);
				b3.setEnabled(false);
			}else
			{
				healthAffected();
				labelrobotText.setText("Health: "+String.valueOf(robotHealth));
				labelhumanText.setText("Health: "+String.valueOf(humanHealth));
				labelalienText.setText("Health: "+String.valueOf(alienHealth));
				if(robotHealth == 0 || humanHealth == 0|| alienHealth == 0)
				{
					JOptionPane.showMessageDialog(null, "Running out of healt? ... sorry, GAME OVER!!");
					b1.setEnabled(false);
					b2.setEnabled(false);
					b3.setEnabled(false);
				}
			}
			} }
			);
			
			ImageIcon image = new ImageIcon("img/build.jpg");
			JLabel label = new JLabel("", image, JLabel.CENTER);
			JPanel panel = new JPanel(new BorderLayout());
			
			   			
			panel.add( label, BorderLayout.CENTER );
			f.setSize(900,450);  
			f.setLayout(null);  
			f.setVisible(true);  
			f.setTitle("Gameplay");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }  
	
	
		
public static void main(String[] args) {  
    new Gameplay();  
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

public void healthAffected()
{
	if (UniTime)
	{
		UniTime = false;
	}else
	{
		UniTime = true;
		robotHealth--;
		alienHealth--;
		humanHealth--;
		d = d+10;
	}
}

public boolean youGetTheBuid(int condition)
{
	if(condition>600)
	{
		return true;
	}else
	{
		return false;
	}
}

}
