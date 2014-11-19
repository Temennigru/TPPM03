//package GameCore.Ui.Gui;
//import GameCore.GameObjectCore.*;
//import java.io.File;
import java.awt.*;
import javax.swing.*;

public class MainLayout extends javax.swing.JFrame {

    private static class PassListener extends java.awt.event.ActionListener {
        public PassListener() {
            super();
        }

        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            game = GameCore.getGame();
            if (! game.valid() ){
                throw new GameExceptions.InvalidGameException();
            }
            game.passPriority();
            get_gui().refresh();
        }

    }

    private static class CardListener extends java.awt.event.ActionListener {
        Card card;
        private CardListener(){};
        public CardListener(Card card) {
            super();
        }

        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            // TODO: Open prompt window for what to do with card
            game = GameCore.getGame();
            if (! game.valid() ){
                throw new GameExceptions.InvalidGameException();
            }
            game.passPriority();
            get_gui().refresh();
        }
    }
    
    public MainLayout() {
    	
    	//initializes
        initComponents();
        
        //handPanel
    	ImageIcon iconx = new ImageIcon("GameCore/Cards/img/cards/untapped/Swamp.jpg");
       	jLabel1.setIcon(iconx); 
       	jLabel2.setIcon(iconx);
       	jLabel3.setIcon(iconx);
       	
      	//testing mouse events for jlabel1
    	jLabel1.addMouseListener(new java.awt.event.MouseAdapter(){
    		public void mouseClicked(java.awt.event.MouseEvent evt) {
    			labelMouseClicked(evt);
  	      	}
  	        public void mouseEntered(java.awt.event.MouseEvent evt){
  	    	  	labelMouseEntered(evt);
  	        }
    	});
        
    }
    
    public void place (JLabel j, String s){
    	if ( s.equals("Hand") ) {
    		handPanel.setLayout(handPanelLayout);
            handPanelLayout.setHorizontalGroup(
                handPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(handPanelLayout.createSequentialGroup()
                    .addComponent(j)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGap(0, 860, Short.MAX_VALUE))
            );
            handPanelLayout.setVerticalGroup(
                handPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, handPanelLayout.createSequentialGroup()
                    .addGroup(handPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(j)
            )));  		
    	}
    	if ( s.equals("Graveyard") ){
    		graveyardPanel.setLayout(graveyardPanelLayout);
            graveyardPanelLayout.setHorizontalGroup(
                graveyardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(graveyardPanelLayout.createSequentialGroup()
                    .addComponent(j)
                    .addGap(0, 940, Short.MAX_VALUE))
            );
            graveyardPanelLayout.setVerticalGroup(
                graveyardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(graveyardPanelLayout.createSequentialGroup()
                    .addComponent(j)
                    .addGap(0, 434, Short.MAX_VALUE))
            );	
    	}
        if ( s.equals("p1Battlefield") ){
        	p1BattlefieldPanel.setLayout(p1BattlefieldPanelLayout);
            p1BattlefieldPanelLayout.setHorizontalGroup(
                p1BattlefieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(p1BattlefieldPanelLayout.createSequentialGroup()
                    .addComponent(j)
                    .addGap(0, 675, Short.MAX_VALUE))
            );
            p1BattlefieldPanelLayout.setVerticalGroup(
                p1BattlefieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(p1BattlefieldPanelLayout.createSequentialGroup()
                    .addComponent(j)
                    .addGap(0, 356, Short.MAX_VALUE))
            );
            
        }
        if ( s.equals("p2Battlefield") ){
        	p2BattlefieldPanel.setLayout(p2BattlefieldPanelLayout);
            p2BattlefieldPanelLayout.setHorizontalGroup(
                p2BattlefieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(p2BattlefieldPanelLayout.createSequentialGroup()
                    .addComponent(j)
                    .addGap(0, 675, Short.MAX_VALUE))
            );
            p2BattlefieldPanelLayout.setVerticalGroup(
                p2BattlefieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(p2BattlefieldPanelLayout.createSequentialGroup()
                    .addComponent(j)
                    .addGap(0, 216, Short.MAX_VALUE))
            );
        }
    }
    

    private void labelMouseClicked(java.awt.event.MouseEvent evt) {                                        
    	ImageIcon tapped = new ImageIcon("GameCore/Cards/img/cards/tapped/Swamp.jpg");
        jLabel1.setIcon(tapped);     
    }   
    private void labelMouseEntered(java.awt.event.MouseEvent evt) {                                        
    	ImageIcon large = new ImageIcon("GameCore/Cards/img/cards/large/Swamp.jpg");
        cardInfo.setIcon(large);     
    }   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        verticalSplitPane = new javax.swing.JSplitPane();
        infoSplitPane = new javax.swing.JSplitPane();
        cardViewSplitPane = new javax.swing.JSplitPane();
        batllefieldSplitPane = new javax.swing.JSplitPane();
        p2Battlefield = new javax.swing.JScrollPane();
        p2BattlefieldPanel = new javax.swing.JPanel();
        p1Battlefield = new javax.swing.JScrollPane();
        p1BattlefieldPanel = new javax.swing.JPanel();
        cardViewScrollPane = new javax.swing.JScrollPane();
        cardInfoPanel = new javax.swing.JPanel();
        cardInfo = new javax.swing.JLabel();
        cardDescription = new javax.swing.JLabel();
        infoScrollPane = new javax.swing.JScrollPane();
        infoPanel = new javax.swing.JPanel();
        p2Lifepoints = new javax.swing.JLabel();
        p2Cards = new javax.swing.JLabel();
        p1Lifepoints = new javax.swing.JLabel();
        p1Cards = new javax.swing.JLabel();
        blackMana = new javax.swing.JLabel();
        greenMana = new javax.swing.JLabel();
        redMana = new javax.swing.JLabel();
        blueMana = new javax.swing.JLabel();
        whiteMana = new javax.swing.JLabel();
        uncoloredMana = new javax.swing.JLabel();
        turnPlayer = new javax.swing.JLabel();
        turnPhase = new javax.swing.JLabel();
        priority = new javax.swing.JLabel();
        stack = new javax.swing.JLabel();
        passButton = new javax.swing.JButton();
        handTabbedPane = new javax.swing.JTabbedPane();
        handPane = new javax.swing.JScrollPane();
        handPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        graveyardPane = new javax.swing.JScrollPane();
        graveyardPanel = new javax.swing.JPanel();
        handPanelLayout = new javax.swing.GroupLayout(handPanel);
        p2BattlefieldPanelLayout = new javax.swing.GroupLayout(p2BattlefieldPanel);
        p1BattlefieldPanelLayout = new javax.swing.GroupLayout(p1BattlefieldPanel);
        cardInfoPanelLayout = new javax.swing.GroupLayout(cardInfoPanel);
        infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        graveyardPanelLayout = new javax.swing.GroupLayout(graveyardPanel);
       	iconBlack = new ImageIcon("GameCore/Cards/img/other/iconblack.png");
       	iconWhite = new ImageIcon("GameCore/Cards/img/other/iconwhite.png");
       	iconRed = new ImageIcon("GameCore/Cards/img/other/iconred.png");
       	iconBlue = new ImageIcon("GameCore/Cards/img/other/iconblue.png");
       	iconGreen = new ImageIcon("GameCore/Cards/img/other/icongreen.png");
       	iconUncolored = new ImageIcon("GameCore/Cards/img/other/iconuncolored.png");
       	iconCardBack = new ImageIcon ("GameCore/Cards/img/cards/large/CardBack.jpg");       
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Magic The Gathering");
        setPreferredSize(new java.awt.Dimension(900, 800));

        verticalSplitPane.setDividerLocation(500);
        verticalSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        infoSplitPane.setDividerLocation(150);
        cardViewSplitPane.setDividerLocation(330);
        batllefieldSplitPane.setDividerLocation(250);
        batllefieldSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        p2Battlefield.setViewportView(p2BattlefieldPanel);
        batllefieldSplitPane.setTopComponent(p2Battlefield);
        p1Battlefield.setViewportView(p1BattlefieldPanel);
        batllefieldSplitPane.setRightComponent(p1Battlefield);
        cardViewSplitPane.setRightComponent(batllefieldSplitPane);
      
       	cardInfo.setIcon(iconCardBack);
       	blackMana.setIcon(iconBlack);
       	whiteMana.setIcon(iconWhite);
       	redMana.setIcon(iconRed);
       	blueMana.setIcon(iconBlue);
       	greenMana.setIcon(iconGreen);
       	uncoloredMana.setIcon(iconUncolored);
        cardDescription.setText("Card Description");

        cardInfoPanel.setLayout(cardInfoPanelLayout);
        cardInfoPanelLayout.setHorizontalGroup(
            cardInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardInfoPanelLayout.createSequentialGroup()
                .addGroup(cardInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardInfo)
                    .addComponent(cardDescription))
                .addGap(0, 264, Short.MAX_VALUE))
        );
        cardInfoPanelLayout.setVerticalGroup(
            cardInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardInfoPanelLayout.createSequentialGroup()
                .addComponent(cardInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardDescription)
                .addGap(0, 559, Short.MAX_VALUE))
        );

        cardViewScrollPane.setViewportView(cardInfoPanel);
        cardViewSplitPane.setLeftComponent(cardViewScrollPane);
        infoSplitPane.setRightComponent(cardViewSplitPane);

        p2Lifepoints.setText("Player2 Lifepoints");
        p2Cards.setText("Player2 Cards");
        p1Lifepoints.setText("Player1 Lifepoints");
        p1Cards.setText("Player1 Cards");
        turnPlayer.setText("Turn: Player1");
        turnPhase.setText("Phase: Main");
        priority.setText("Priority: Player1");
        stack.setText("Stack: Empty");
       
        turnPlayer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                turnPlayerMouseClicked(evt);
            }
        });

        passButton.setText("PASS");
        passButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passButtonActionPerformed(evt);
            }
        });

        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passButton)
                    .addComponent(stack)
                    .addComponent(priority)
                    .addComponent(turnPhase)
                    .addComponent(turnPlayer)
                    .addComponent(uncoloredMana)
                    .addComponent(whiteMana)
                    .addComponent(blueMana)
                    .addComponent(redMana)
                    .addComponent(greenMana)
                    .addComponent(blackMana)
                    .addComponent(p1Cards)
                    .addComponent(p1Lifepoints)
                    .addComponent(p2Cards)
                    .addComponent(p2Lifepoints))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        
        
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(p2Lifepoints)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p2Cards)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(p1Lifepoints)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p1Cards)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(blackMana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(greenMana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(redMana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(blueMana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(whiteMana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uncoloredMana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(turnPlayer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(turnPhase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priority)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passButton)
                .addContainerGap(232, Short.MAX_VALUE))
        );

        infoScrollPane.setViewportView(infoPanel);
        infoSplitPane.setLeftComponent(infoScrollPane);
        verticalSplitPane.setTopComponent(infoSplitPane);
        
        handPane.setViewportView(handPanel);
        handTabbedPane.addTab("Hand", handPane);
        graveyardPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        graveyardPane.setViewportView(graveyardPanel);

        handTabbedPane.addTab("Graveyard", graveyardPane);

        verticalSplitPane.setRightComponent(handTabbedPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(verticalSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(verticalSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void turnPlayerMouseClicked(java.awt.event.MouseEvent evt) {
    	//teste
        this.turnPlayer.setText("Turn: teste");
    }                                       

    private void passButtonActionPerformed(java.awt.event.ActionEvent evt) {

    }
    
    private String getManaSpend(){
    	JTextField inputBlackMana = new JTextField();
    	JTextField inputBlueMana = new JTextField();
    	JTextField inputRedMana = new JTextField();
    	JTextField inputWhiteMana = new JTextField();
    	JTextField inputGreenMana = new JTextField();
    	JTextField inputUncoloredMana = new JTextField();
    	JLabel inputIconBlack = new JLabel();
    	JLabel inputIconBlue = new JLabel();
    	JLabel inputIconRed = new JLabel();
    	JLabel inputIconWhite = new JLabel();
    	JLabel inputIconGreen = new JLabel();
    	JLabel inputIconUncolored = new JLabel();
    	   	
    	final JComponent[] inputs = new JComponent[] {
    			inputIconBlack, 
    			new JLabel ("Black Mana"),
    			inputBlackMana,
    			inputIconBlue,
    			new JLabel ("Blue Mana"),
    			inputBlueMana,
    			inputIconRed,
    			new JLabel ("Red Mana"),
    			inputRedMana,
    			inputIconWhite,
    			new JLabel ("White Mana"),
    			inputWhiteMana,
    			inputIconGreen,
    			new JLabel ("Green Mana"),
    			inputGreenMana,
    			inputIconUncolored,
    			new JLabel ("Uncolored Mana"),
    			inputUncoloredMana
    			    	};
    	
    	ImageIcon iconBlack = new ImageIcon("C:\\Users\\40\\Desktop\\20black.png");
    	inputIconBlack.setIcon(iconBlack);
    	ImageIcon iconBlue = new ImageIcon("C:\\Users\\40\\Desktop\\20blue.png");
    	inputIconBlue.setIcon(iconBlue);
    	ImageIcon iconRed = new ImageIcon("C:\\Users\\40\\Desktop\\20red.png");
    	inputIconRed.setIcon(iconRed);
    	ImageIcon iconWhite = new ImageIcon("C:\\Users\\40\\Desktop\\20white.png");
    	inputIconWhite.setIcon(iconWhite);
    	ImageIcon iconGreen = new ImageIcon("C:\\Users\\40\\Desktop\\20green.png");
    	inputIconGreen.setIcon(iconGreen);
    	ImageIcon iconUncolored = new ImageIcon("C:\\Users\\40\\Desktop\\20x.png");
    	inputIconUncolored.setIcon(iconUncolored);
    	
    	JOptionPane.showMessageDialog(null, inputs, "Pay the correct mana cost", JOptionPane.PLAIN_MESSAGE);
    	System.out.println("You entered " +
    			inputBlackMana.getText() + ", " +
    			inputBlueMana.getText() + ", " +
    			inputRedMana.getText() + ", " +
    			inputWhiteMana.getText() + ", " +
    			inputGreenMana.getText() + ", " +
    			inputUncoloredMana.getText());
        return "";
    }                                          
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainLayout().setVisible(true);
            }
        });
    }

    private javax.swing.JSplitPane batllefieldSplitPane;
    private javax.swing.JLabel blackMana;
    private javax.swing.JLabel blueMana;
    private javax.swing.JLabel cardDescription;
    private javax.swing.JLabel cardInfo;
    private javax.swing.JPanel cardInfoPanel;
    private javax.swing.JScrollPane cardViewScrollPane;
    private javax.swing.JSplitPane cardViewSplitPane;
    private javax.swing.JScrollPane graveyardPane;
    private javax.swing.JPanel graveyardPanel;
    private javax.swing.JLabel greenMana;
    private javax.swing.JScrollPane handPane;
    private javax.swing.JPanel handPanel;
    private javax.swing.JTabbedPane handTabbedPane;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JScrollPane infoScrollPane;
    private javax.swing.JSplitPane infoSplitPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane p1Battlefield;
    private javax.swing.JPanel p1BattlefieldPanel;
    private javax.swing.JLabel p1Cards;
    private javax.swing.JLabel p1Lifepoints;
    private javax.swing.JScrollPane p2Battlefield;
    private javax.swing.JPanel p2BattlefieldPanel;
    private javax.swing.JLabel p2Cards;
    private javax.swing.JLabel p2Lifepoints;
    private javax.swing.JButton passButton;
    private javax.swing.JLabel priority;
    private javax.swing.JLabel redMana;
    private javax.swing.JLabel stack;
    private javax.swing.JLabel turnPhase;
    private javax.swing.JLabel turnPlayer;
    private javax.swing.JLabel uncoloredMana;
    private javax.swing.JSplitPane verticalSplitPane;
    private javax.swing.JLabel whiteMana;
   	private ImageIcon iconBlack;
   	private ImageIcon iconWhite;
   	private ImageIcon iconRed;
   	private ImageIcon iconBlue;
   	private ImageIcon iconGreen;
   	private ImageIcon iconUncolored;
   	private ImageIcon iconCardBack;
   	private javax.swing.GroupLayout handPanelLayout;
   	private javax.swing.GroupLayout p2BattlefieldPanelLayout; 
    private javax.swing.GroupLayout p1BattlefieldPanelLayout;
    private javax.swing.GroupLayout cardInfoPanelLayout;
    private javax.swing.GroupLayout infoPanelLayout;
    private javax.swing.GroupLayout graveyardPanelLayout;

    // End of variables declaration                   
}
