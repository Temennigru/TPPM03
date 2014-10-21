package GameCore.Ui.Gui;

import GameCore.GameObjectCore.*;

import java.awt.*;
import javax.swing.*;
import java.io.File;

public class ImageDisplay extends JFrame{
	
	JPanel panel;
	static ImageIcon icon;
	JLabel label;
	private static final String defaultImg = "GameCore/Cards/Img/CardBack.jpg";
	
	public static String BuildAddress(String cardname){
		String prefix = new String ("GameCore/Cards/Img/");
		String sufix = new String (".jpg");
		String address = prefix + cardname + sufix;
		return address;
	}
	
	public static String BuildAddress(Card card){
		// Remove special characters
		/*String cardname = card.name.replaceAll("\\s+", "");
		cardname = card.name.replaceAll("\'", "");
		cardname = card.name.replaceAll("-", "");
		*/

		return card.m_imgLocation;
		/*String prefix = new String ("GameCore/Cards/Img/");
		String sufix = new String (".jpg");
		String address = prefix + cardname + sufix;
		return address;*/
	}

	public ImageDisplay()
	{
		setSize(312,445); //exact size of card image files
		this.panel = new JPanel();
		panel.setBackground(Color.WHITE);
		this.icon = new ImageIcon(defaultImg);
		this.label = new JLabel();
		label.setIcon(icon);
		panel.add(label);
		this.getContentPane().add(panel);
		setVisible(true);
	}
	
	public void displayNew(String card) {
		File f = new File(card);
		if(f.exists() && !f.isDirectory()) {
			this.icon = new ImageIcon(card);
    	} else {
    		System.out.println("Image not found: " + card);
    		this.icon = new ImageIcon(defaultImg);
    	}

		this.label.setIcon(icon);
		this.panel.revalidate();
		this.panel.repaint();
	}
	
	public static void main (String[] args)
	{
		String card1 = new String ("StranglerootGeist");
		String card2 = new String ("Forest");
		String add1 = ImageDisplay.BuildAddress(card1);
		String add2 = ImageDisplay.BuildAddress(card2);
		System.out.println (add1);
		System.out.println (add2);
		ImageDisplay sera = new ImageDisplay();
		sera.displayNew(add1);
		
		/*
		try {
		    Thread.sleep(2000); //2000 milliseconds
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		sera.icon = new ImageIcon(add2);
		sera.label.setIcon(icon);
		sera.panel.revalidate();
		sera.panel.repaint();
		*/
	}
}
