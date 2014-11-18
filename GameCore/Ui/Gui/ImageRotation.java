package GameCore.Ui.Gui;
import GameCore.GameObjectCore.*;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageRotation {
	
    public static void main(String args[]) throws Exception {
        JFrame frame = new JFrame("Rotation Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final BufferedImage bi = ImageIO.read(new File("C:\\Users\\40\\Desktop\\107.jpg"));
        
        
        frame.add(new JPanel() {

            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public Dimension getPreferredSize() {
                return new Dimension(bi.getWidth(), bi.getHeight());
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                
                double sin = Math.abs(Math.sin(Math.toRadians(90))),
                        cos = Math.abs(Math.cos(Math.toRadians(90)));

                int w = bi.getWidth(null), h = bi.getHeight(null);

                int neww = (int) Math.floor(w*cos + h*sin),
                     newh = (int) Math.floor(h*cos + w*sin);
                
                g2.translate((neww-w)/2, (newh-h)/2);
                g2.rotate(Math.toRadians(90), bi.getWidth()/2, bi.getHeight()/2);
//              g2.rotate(Math.PI / 4, bi.getWidth() / 2, bi.getHeight() / 2 );
                g2.drawImage(bi, 0, 0, null);
                
                
            }
        });
        frame.pack();
        frame.setVisible(true);
    }
}
