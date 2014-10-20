package GameCore.Ui.Gui;

import java.awt.*;
import javax.swing.*;

public class ImageDisplay extends JFrame{
	
	JPanel panel;
	static ImageIcon icon;
	JLabel label;
	
	public static String BuildAddress(String cardname){
		String prefix = new String ("C:\\Users\\40\\Desktop\\");
		String sufix = new String (".jpg");
		String address = prefix + cardname + sufix;
		return address;
	}
	
	public ImageDisplay(String card)
	{
	setSize(350,500);
	this.panel = new JPanel();
	panel.setBackground(Color.WHITE);
	this.icon = new ImageIcon(card);
	this.label = new JLabel();
	label.setIcon(icon);
	panel.add(label);
	this.getContentPane().add(panel);
	setVisible(true);
	}
	
	
	public static void main (String[] args)
	{
		String card1 = new String ("BlackCat"); String card2 = new String ("Barishi");
		String add1 = ImageDisplay.BuildAddress(card1);
		String add2 = ImageDisplay.BuildAddress(card2);
		System.out.println (add1);	System.out.println (add2);
		ImageDisplay sera = new ImageDisplay(add1);
		
		try {
		    Thread.sleep(2000); //2000 milliseconds
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		sera.icon = new ImageIcon(add2);
		sera.label.setIcon(icon);
		sera.panel.revalidate();
		sera.panel.repaint();
	}
}
