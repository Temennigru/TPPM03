package GameCore.Util;

import javax.swing.ImageIcon;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.io.File;
import java.util.regex.*;
import GameCore.GameExceptions;

import java.awt.*;
import javax.swing.*;
import java.io.File;



public class ImgDatabase {

	private Map<String, ImageIcon> untapped;
	private Map<String, ImageIcon> tapped;
	private Map<String, ImageIcon> large;

	private ImgDatabase(){};

	public ImgDatabase(String folder) throws GameExceptions.GameException {

		untapped = new HashMap<String, ImageIcon>();
		tapped = new HashMap<String, ImageIcon>();
		large = new HashMap<String, ImageIcon>();

		Pattern p = Pattern.compile("^(.*).jpg$");

		File tappedRoot = new File(folder + "/tapped");
 
		if(tappedRoot.isDirectory()){
			String[] subNode = tappedRoot.list();

			for(String filename : subNode){
				File sub = new File(tappedRoot, filename);
				if (!sub.isDirectory()) {
 					Matcher m = p.matcher(filename);
 					if (m.matches()) {
 						tapped.put(m.toMatchResult().group(1), new ImageIcon(sub.getAbsolutePath()));
 					}
				}
			}
		} else {
			throw new GameExceptions.InvalidImageDBFolderHierarchy(tappedRoot.getAbsolutePath());
		}
 
		tappedRoot = new File(folder + "/untapped");
 
		if(tappedRoot.isDirectory()){
			String[] subNode = tappedRoot.list();

			for(String filename : subNode){
				File sub = new File(tappedRoot, filename);
				if (!sub.isDirectory()) {
 					Matcher m = p.matcher(filename);
 					if (m.matches()) {
 						untapped.put(m.toMatchResult().group(1), new ImageIcon(sub.getAbsolutePath()));
 					}
				}
			}
		} else {
			throw new GameExceptions.InvalidImageDBFolderHierarchy(tappedRoot.getAbsolutePath());
		}
 
		tappedRoot = new File(folder + "/large");
 
		if(tappedRoot.isDirectory()){
			String[] subNode = tappedRoot.list();

			for(String filename : subNode){
				File sub = new File(tappedRoot, filename);
				if (!sub.isDirectory()) {
 					Matcher m = p.matcher(filename);
 					if (m.matches()) {
 						large.put(m.toMatchResult().group(1), new ImageIcon(sub.getAbsolutePath()));
 					}
				}
			}
		} else {
			throw new GameExceptions.InvalidImageDBFolderHierarchy(tappedRoot.getAbsolutePath());
		}
	}

	// 0 is tapped, 1 is untapped, 2 is large
	public ImageIcon[] getImages(String name) throws GameExceptions.GameException {
		if (!untapped.containsKey(name)){
			throw new GameExceptions.MissingImageDBFile(name, "untapped");
		} else if (!tapped.containsKey(name)) {
			throw new GameExceptions.MissingImageDBFile(name, "tapped");
		} else if (!large.containsKey(name)) {
			throw new GameExceptions.MissingImageDBFile(name, "large");
		}

		ImageIcon[] ret = new ImageIcon[3];
		ret[0] = tapped.get(name); ret[1] = untapped.get(name); ret[2] = large.get(name);

		return ret;
	}


	private static class TestClass extends JFrame {
		JPanel panel;
		JLabel label;

		public TestClass(ImageIcon img) {
			setSize(350,500); //exact size of card image files
			this.panel = new JPanel();
			panel.setBackground(Color.WHITE);
			this.label = new JLabel();
			label.setIcon(img);
			panel.add(label);
			this.getContentPane().add(panel);
			setVisible(true);
		}

		public void visual(ImageIcon img) {
			this.label.setIcon(img);
			this.panel.revalidate();
			this.panel.repaint();
		}



	}


	public static void main(String[] args) {

		try {
			ImgDatabase db = new ImgDatabase("GameCore/img/cards");

			TestClass t = new TestClass(db.getImages("CardBack")[2]);

			while (true) {
				java.util.Scanner scanner = new java.util.Scanner(System.in);
				scanner.useDelimiter(String.format("%n"));
				System.out.println("querry:");
				String querry = scanner.next();
				System.out.println("orientation:");
				int orientation = Integer.parseInt(scanner.next());

				t.visual(db.getImages(querry)[orientation]);
			}

		} catch (GameExceptions.GameException e) {
			System.out.println(e.getMessage());
		}

	}

}
