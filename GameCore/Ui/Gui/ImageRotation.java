package GameCore.Ui.Gui;
import GameCore.GameObjectCore.*;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageRotation {
    
    //test
    public static void main(String args[]) throws Exception {
        JFrame frame = new JFrame("Rotation Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final BufferedImage bi = ImageIO.read(new File("C:\\Users\\40\\Desktop\\107.jpg"));
        frame.add(new JPanel() {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(bi.getWidth(), bi.getHeight());
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.rotate(Math.PI / 2, 0, bi.getHeight() / 1 );
                g2.drawImage(bi, 0, 0, null);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }
}
