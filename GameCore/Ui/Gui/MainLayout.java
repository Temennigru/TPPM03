package GameCore.Ui.Gui;
import GameCore.GameObjectCore.*;
import java.awt.*;
import javax.swing.*;
import java.io.File;

public class MainLayout extends javax.swing.JFrame {

    public MainLayout() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        verticalSplitPane = new javax.swing.JSplitPane();
        infoSplitPane = new javax.swing.JSplitPane();
        cardViewSplitPane = new javax.swing.JSplitPane();
        batllefieldSplitPane = new javax.swing.JSplitPane();
        opponentBattlefieldSplitPane = new javax.swing.JSplitPane();
        opponentTopBattlefieldSplitPane = new javax.swing.JPanel();
        opponentBottomBattlefieldSplitPane = new javax.swing.JPanel();
        playerBattlefieldSplitPane = new javax.swing.JSplitPane();
        playerBatllefieldTopSplitPane = new javax.swing.JPanel();
        playerBattlefieldBottomSplitPane = new javax.swing.JPanel();
        cardViewScrollPane = new javax.swing.JScrollPane();
        cardInfoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
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
        handTabbedPane = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        verticalSplitPane.setDividerLocation(400);
        verticalSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        infoSplitPane.setDividerLocation(150);

        cardViewSplitPane.setDividerLocation(150);

        batllefieldSplitPane.setDividerLocation(200);
        batllefieldSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        opponentBattlefieldSplitPane.setDividerLocation(90);
        opponentBattlefieldSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        javax.swing.GroupLayout opponentTopBattlefieldSplitPaneLayout = new javax.swing.GroupLayout(opponentTopBattlefieldSplitPane);
        opponentTopBattlefieldSplitPane.setLayout(opponentTopBattlefieldSplitPaneLayout);
        opponentTopBattlefieldSplitPaneLayout.setHorizontalGroup(
            opponentTopBattlefieldSplitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
        );
        opponentTopBattlefieldSplitPaneLayout.setVerticalGroup(
            opponentTopBattlefieldSplitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        opponentBattlefieldSplitPane.setTopComponent(opponentTopBattlefieldSplitPane);

        javax.swing.GroupLayout opponentBottomBattlefieldSplitPaneLayout = new javax.swing.GroupLayout(opponentBottomBattlefieldSplitPane);
        opponentBottomBattlefieldSplitPane.setLayout(opponentBottomBattlefieldSplitPaneLayout);
        opponentBottomBattlefieldSplitPaneLayout.setHorizontalGroup(
            opponentBottomBattlefieldSplitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
        );
        opponentBottomBattlefieldSplitPaneLayout.setVerticalGroup(
            opponentBottomBattlefieldSplitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 103, Short.MAX_VALUE)
        );

        opponentBattlefieldSplitPane.setRightComponent(opponentBottomBattlefieldSplitPane);

        batllefieldSplitPane.setTopComponent(opponentBattlefieldSplitPane);

        playerBattlefieldSplitPane.setDividerLocation(90);
        playerBattlefieldSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        javax.swing.GroupLayout playerBatllefieldTopSplitPaneLayout = new javax.swing.GroupLayout(playerBatllefieldTopSplitPane);
        playerBatllefieldTopSplitPane.setLayout(playerBatllefieldTopSplitPaneLayout);
        playerBatllefieldTopSplitPaneLayout.setHorizontalGroup(
            playerBatllefieldTopSplitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
        );
        playerBatllefieldTopSplitPaneLayout.setVerticalGroup(
            playerBatllefieldTopSplitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        playerBattlefieldSplitPane.setTopComponent(playerBatllefieldTopSplitPane);

        javax.swing.GroupLayout playerBattlefieldBottomSplitPaneLayout = new javax.swing.GroupLayout(playerBattlefieldBottomSplitPane);
        playerBattlefieldBottomSplitPane.setLayout(playerBattlefieldBottomSplitPaneLayout);
        playerBattlefieldBottomSplitPaneLayout.setHorizontalGroup(
            playerBattlefieldBottomSplitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
        );
        playerBattlefieldBottomSplitPaneLayout.setVerticalGroup(
            playerBattlefieldBottomSplitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
        );

        playerBattlefieldSplitPane.setRightComponent(playerBattlefieldBottomSplitPane);

        batllefieldSplitPane.setRightComponent(playerBattlefieldSplitPane);

        cardViewSplitPane.setRightComponent(batllefieldSplitPane);

        jLabel1.setText("Card Info");

        javax.swing.GroupLayout cardInfoPanelLayout = new javax.swing.GroupLayout(cardInfoPanel);
        cardInfoPanel.setLayout(cardInfoPanelLayout);
        cardInfoPanelLayout.setHorizontalGroup(
            cardInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardInfoPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        cardInfoPanelLayout.setVerticalGroup(
            cardInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardInfoPanelLayout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel1)
                .addContainerGap(224, Short.MAX_VALUE))
        );

        cardViewScrollPane.setViewportView(cardInfoPanel);

        cardViewSplitPane.setLeftComponent(cardViewScrollPane);

        infoSplitPane.setRightComponent(cardViewSplitPane);

        p2Lifepoints.setText("Player2 Lifepoints");

        p2Cards.setText("Player2 Cards");

        p1Lifepoints.setText("Player1 Lifepoints");

        p1Cards.setText("Player1 Cards");

        blackMana.setText("Black Mana");

        greenMana.setText("Green Mana");

        redMana.setText("Red Mana");

        blueMana.setText("Blue Mana");

        whiteMana.setText("White Mana");

        uncoloredMana.setText("Uncolored Mana");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addGap(28, 28, 28)
                .addComponent(p2Lifepoints)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p2Cards)
                .addGap(60, 60, 60)
                .addComponent(p1Lifepoints)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p1Cards)
                .addGap(18, 18, 18)
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
                .addContainerGap(107, Short.MAX_VALUE))
        );

        infoScrollPane.setViewportView(infoPanel);

        infoSplitPane.setLeftComponent(infoScrollPane);

        verticalSplitPane.setTopComponent(infoSplitPane);

        handTabbedPane.addTab("Hand", jScrollPane1);
        handTabbedPane.addTab("Graveyard", jScrollPane2);

        verticalSplitPane.setRightComponent(handTabbedPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(verticalSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(verticalSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

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

    // Variables declaration                  
    private javax.swing.JSplitPane batllefieldSplitPane;
    private javax.swing.JLabel blackMana;
    private javax.swing.JLabel blueMana;
    private javax.swing.JPanel cardInfoPanel;
    private javax.swing.JScrollPane cardViewScrollPane;
    private javax.swing.JSplitPane cardViewSplitPane;
    private javax.swing.JLabel greenMana;
    private javax.swing.JTabbedPane handTabbedPane;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JScrollPane infoScrollPane;
    private javax.swing.JSplitPane infoSplitPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane opponentBattlefieldSplitPane;
    private javax.swing.JPanel opponentBottomBattlefieldSplitPane;
    private javax.swing.JPanel opponentTopBattlefieldSplitPane;
    private javax.swing.JLabel p1Cards;
    private javax.swing.JLabel p1Lifepoints;
    private javax.swing.JLabel p2Cards;
    private javax.swing.JLabel p2Lifepoints;
    private javax.swing.JPanel playerBatllefieldTopSplitPane;
    private javax.swing.JPanel playerBattlefieldBottomSplitPane;
    private javax.swing.JSplitPane playerBattlefieldSplitPane;
    private javax.swing.JLabel redMana;
    private javax.swing.JLabel uncoloredMana;
    private javax.swing.JSplitPane verticalSplitPane;
    private javax.swing.JLabel whiteMana;
}
