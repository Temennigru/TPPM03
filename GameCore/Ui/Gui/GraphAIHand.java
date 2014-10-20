package GameCore.Ui.Gui;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GraphAIHand extends JPanel {
	
	ImageIcon icon1 = new ImageIcon("C:\\Users\\40\\Desktop\\backs.jpg");
	ImageIcon icon2 = new ImageIcon("C:\\Users\\40\\Desktop\\backs.jpg");
	ImageIcon icon3 = new ImageIcon("C:\\Users\\40\\Desktop\\backs.jpg");
	ImageIcon icon4 = new ImageIcon("C:\\Users\\40\\Desktop\\backs.jpg");
	ImageIcon icon5 = new ImageIcon("C:\\Users\\40\\Desktop\\backs.jpg");
	ImageIcon icon6 = new ImageIcon("C:\\Users\\40\\Desktop\\backs.jpg");
	ImageIcon icon7 = new ImageIcon("C:\\Users\\40\\Desktop\\backs.jpg");
	JLabel label = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	JLabel label5 = new JLabel();
	JLabel label6 = new JLabel();
	JLabel label7 = new JLabel();
	
	public GraphAIHand(){

		setBackground (Color.DARK_GRAY);
		setLayout (new FlowLayout(FlowLayout.CENTER));
		add(label);
		label.setIcon(icon1);
		add(label2);
		label2.setIcon(icon2);
		add(label3);
		label3.setIcon(icon3);
		add(label4);
		label4.setIcon(icon4);
		add(label5);
		label5.setIcon(icon5);
		add(label6);
		label6.setIcon(icon6);
		add(label7);
		label7.setIcon(icon7);

	}
}
