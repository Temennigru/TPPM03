package GameCore.Ui.Gui;

import java.awt.*;
import javax.swing.*;

public class ImageDisplay extends JFrame{
	
	public static String BuildAddress(String cardname){
		String prefix = new String ("C:\\Users\\40\\Desktop\\");
		String sufix = new String (".jpg");
		String address = prefix + cardname + sufix;
		return address;
	}
	
	public ImageDisplay (String card)
	{
	setSize(350,500);
	JPanel panel = new JPanel();
	panel.setBackground(Color.WHITE);
	ImageIcon icon = new ImageIcon(card);
	JLabel label = new JLabel();
	label.setIcon(icon);
	panel.add(label);
	this.getContentPane().add(panel);
	setVisible(true);
	}
	
	/*
	public static void main (String[] args)
	{
		String card1 = new String ("BlackCat");
		String card2 = new String ("Barishi");
		String add1 = ImageDisplay.BuildAddress(card1);
		String add2 = ImageDisplay.BuildAddress(card2);
		System.out.println (add1);
		System.out.println (add2);
		new ImageDisplay(add1);
		new ImageDisplay(add2);
	}
	*/
}
