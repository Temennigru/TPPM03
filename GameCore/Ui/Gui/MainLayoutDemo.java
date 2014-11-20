package GameCore.Ui.Gui;
//import GameCore.GameObjectCore.*;
import java.awt.*;
import javax.swing.*;
import java.io.File;

public class MainLayoutDemo extends javax.swing.JFrame {

    public MainLayoutDemo() {
        initComponents();
        
    	ImageIcon iconx = new ImageIcon("GameCore/img/cards/untapped/Swamp.jpg");
    	ImageIcon icony = new ImageIcon("GameCore/img/cards/untapped/StranglerootGeist.jpg");
    	ImageIcon iconz = new ImageIcon("GameCore/img/cards/untapped/ArmyOfTheDamned.jpg");
       	jLabel1.setIcon(iconx);
       	jLabel2.setIcon(icony);
       	jLabel3.setIcon(iconz);
       	
       	ImageIcon iconBlack = new ImageIcon("GameCore/img/other/iconblack.png");
       	ImageIcon iconWhite = new ImageIcon("GameCore/img/other/iconwhite.png");
       	ImageIcon iconRed = new ImageIcon("GameCore/img/other/iconred.png");
       	ImageIcon iconBlue = new ImageIcon("GameCore/img/other/iconblue.png");
       	ImageIcon iconGreen = new ImageIcon("GameCore/img/other/icongreen.png");
       	ImageIcon iconUncolored = new ImageIcon("GameCore/img/other/iconuncolored.png");
       	ImageIcon iconCardBack = new ImageIcon ("GameCore/img/cards/large/CardBack.jpg");
       	
       	cardInfo.setIcon(iconCardBack);      	
       	blackMana.setIcon(iconBlack);
       	whiteMana.setIcon(iconWhite);
       	redMana.setIcon(iconRed);
       	blueMana.setIcon(iconBlue);
       	greenMana.setIcon(iconGreen);
       	uncoloredMana.setIcon(iconUncolored);
       	
    	
    	jLabel1.addMouseListener(new java.awt.event.MouseAdapter(){
    		public void mouseClicked(java.awt.event.MouseEvent evt) {                                        
                // TODO add your handling code here:
                ImageIcon tapped = new ImageIcon("GameCore/img/cards/tapped/Swamp.jpg");
                jLabel1.setIcon(tapped);     
  	      	}
  	      
  	      	public void mouseEntered(java.awt.event.MouseEvent evt){                             
                // TODO add your handling code here:
                ImageIcon hover = new ImageIcon("GameCore/img/cards/large/Swamp.jpg");
                cardInfo.setIcon(hover);     
  	      	}
    	});
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMouseClicked(evt);
            }
          
            public void mouseEntered(java.awt.event.MouseEvent evt){                            
                // TODO add your handling code here:
                ImageIcon hover = new ImageIcon("GameCore/img/cards/large/StranglerootGeist.jpg");
                cardInfo.setIcon(hover);     
            }
        });
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMouseClicked(evt);
            }
          
            public void mouseEntered(java.awt.event.MouseEvent evt){                            
                // TODO add your handling code here:
                ImageIcon hover = new ImageIcon("GameCore/img/cards/large/ArmyOfTheDamned.jpg");
                cardInfo.setIcon(hover);     
            }
        });
    	  	   	
        
    }
    
    private void labelMouseClicked(java.awt.event.MouseEvent evt) {                                        
        // TODO add your handling code here:
    	ImageIcon tapped = new ImageIcon("GameCore/img/cards/tapped/Swamp.jpg");
        jLabel1.setIcon(tapped);     
    }   
    private void labelMouseEntered(java.awt.event.MouseEvent evt) {                                        
        // TODO add your handling code here:
    	ImageIcon hover = new ImageIcon("GameCore/img/cards/large/Swamp.jpg");
        cardInfo.setIcon(hover);     
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Magic The Gathering");
        setPreferredSize(new java.awt.Dimension(900, 800));

        verticalSplitPane.setDividerLocation(500);
        verticalSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        infoSplitPane.setDividerLocation(150);

        cardViewSplitPane.setDividerLocation(300);

        batllefieldSplitPane.setDividerLocation(250);
        batllefieldSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        javax.swing.GroupLayout p2BattlefieldPanelLayout = new javax.swing.GroupLayout(p2BattlefieldPanel);
        p2BattlefieldPanel.setLayout(p2BattlefieldPanelLayout);
        p2BattlefieldPanelLayout.setHorizontalGroup(
            p2BattlefieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 709, Short.MAX_VALUE)
        );
        p2BattlefieldPanelLayout.setVerticalGroup(
            p2BattlefieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        p2Battlefield.setViewportView(p2BattlefieldPanel);

        batllefieldSplitPane.setTopComponent(p2Battlefield);

        javax.swing.GroupLayout p1BattlefieldPanelLayout = new javax.swing.GroupLayout(p1BattlefieldPanel);
        p1BattlefieldPanel.setLayout(p1BattlefieldPanelLayout);
        p1BattlefieldPanelLayout.setHorizontalGroup(
            p1BattlefieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 709, Short.MAX_VALUE)
        );
        p1BattlefieldPanelLayout.setVerticalGroup(
            p1BattlefieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        p1Battlefield.setViewportView(p1BattlefieldPanel);

        batllefieldSplitPane.setRightComponent(p1Battlefield);

        cardViewSplitPane.setRightComponent(batllefieldSplitPane);

        //cardInfo.setText("Card Info");

        javax.swing.GroupLayout cardInfoPanelLayout = new javax.swing.GroupLayout(cardInfoPanel);
        cardInfoPanel.setLayout(cardInfoPanelLayout);
        cardInfoPanelLayout.setHorizontalGroup(
            cardInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardInfoPanelLayout.createSequentialGroup()
                .addComponent(cardInfo)
                .addGap(0, 251, Short.MAX_VALUE))
        );
        cardInfoPanelLayout.setVerticalGroup(
            cardInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardInfoPanelLayout.createSequentialGroup()
                .addComponent(cardInfo)
                .addGap(0, 579, Short.MAX_VALUE))
        );

        cardViewScrollPane.setViewportView(cardInfoPanel);

        cardViewSplitPane.setLeftComponent(cardViewScrollPane);

        infoSplitPane.setRightComponent(cardViewSplitPane);

        p2Lifepoints.setText("Player2 Lifepoints");

        p2Cards.setText("Player2 Cards");

        p1Lifepoints.setText("Player1 Lifepoints");

        p1Cards.setText("Player1 Cards");

        turnPlayer.setText("Turn: Player1");
        turnPlayer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                turnPlayerMouseClicked(evt);
            }
        });

        turnPhase.setText("Phase: Main");

        priority.setText("Priority: Player1");

        stack.setText("Stack: Empty");

        passButton.setText("PASS");
        passButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
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
                .addGap(18, 18, 18)
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

        javax.swing.GroupLayout handPanelLayout = new javax.swing.GroupLayout(handPanel);
        handPanel.setLayout(handPanelLayout);
        handPanelLayout.setHorizontalGroup(
            handPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(handPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(0, 860, Short.MAX_VALUE))
        );
        handPanelLayout.setVerticalGroup(
            handPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, handPanelLayout.createSequentialGroup()
                .addGroup(handPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(451, Short.MAX_VALUE))
        );

        handPane.setViewportView(handPanel);

        handTabbedPane.addTab("Hand", handPane);

        graveyardPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout graveyardPanelLayout = new javax.swing.GroupLayout(graveyardPanel);
        graveyardPanel.setLayout(graveyardPanelLayout);
        graveyardPanelLayout.setHorizontalGroup(
            graveyardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 974, Short.MAX_VALUE)
        );
        graveyardPanelLayout.setVerticalGroup(
            graveyardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

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
        // TODO add your handling code here:
        this.turnPlayer.setText("easteregg");
    }                                       

    private void passButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
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
    	ImageIcon iconBlack = new ImageIcon("GameCore/img/other/iconblack.png");
       	ImageIcon iconWhite = new ImageIcon("GameCore/img/other/iconwhite.png");
       	ImageIcon iconRed = new ImageIcon("GameCore/img/other/iconred.png");
       	ImageIcon iconBlue = new ImageIcon("GameCore/img/other/iconblue.png");
       	ImageIcon iconGreen = new ImageIcon("GameCore/img/other/icongreen.png");
       	ImageIcon iconUncolored = new ImageIcon("GameCore/img/other/iconuncolored.png");
    	inputIconBlack.setIcon(iconBlack);
    	inputIconBlue.setIcon(iconBlue);
    	inputIconRed.setIcon(iconRed);
    	inputIconWhite.setIcon(iconWhite);
    	inputIconGreen.setIcon(iconGreen);
    	inputIconUncolored.setIcon(iconUncolored);
    	JOptionPane.showMessageDialog(null, inputs, "Pay the correct mana cost", JOptionPane.PLAIN_MESSAGE);
    	System.out.println("You entered " +
    			inputBlackMana.getText() + ", " +
    			inputBlueMana.getText() + ", " +
    			inputRedMana.getText() + ", " +
    			inputWhiteMana.getText() + ", " +
    			inputGreenMana.getText() + ", " +
    			inputUncoloredMana.getText());
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
            java.util.logging.Logger.getLogger(MainLayoutDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainLayoutDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainLayoutDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainLayoutDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainLayoutDemo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JSplitPane batllefieldSplitPane;
    private javax.swing.JLabel blackMana;
    private javax.swing.JLabel blueMana;
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
    // End of variables declaration                   
}
