/**
 * File:    Intro.java
 * Desc:    This class is the first UI that is introduced to the user.  It allows
 *          the player to choose what size of board they want.
 */

// package
package wumpusworld;

// imports
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Intro class
 */
public class Intro extends javax.swing.JFrame {

    // boolean variable for the "16" keyboard press
    boolean one_pressed = false;
    
    /**
     * Creates new form Intro
     */
    public Intro() {
        initComponents();
        
        this.requestFocus();
        // keyboard listener that detects key presses
        // looks for all gameplay keys, such as UP, DOWN, LEFT, RIGHT, C, G, A,
        // ESCAPE, and so on
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher((KeyEvent e) -> {
                    
                    // if the main frame is in focus
                    if (this.isFocusOwner()) {
                        // detect ONLY if it's a key released, so it only does it once
                        if (e.getID() == KeyEvent.KEY_RELEASED) {
                            // determine what to do from what key is pressed
                            switch (e.getKeyCode()) {
                                case KeyEvent.VK_S:
                                    l();    // super secret method
                                    break;
                                case KeyEvent.VK_4:
                                    button16.doClick();
                                    break;
                                case KeyEvent.VK_8:
                                    button64.doClick();
                                    break;
                                case KeyEvent.VK_1:
                                    one_pressed = true;
                                    break;
                                case KeyEvent.VK_6:
                                    if(one_pressed) {
                                        button256.doClick();
                                    }
                                    break;
                                case KeyEvent.VK_ESCAPE:
                                    System.exit(0);
                                default:
                                    break;
                            }
                        }
                    }
                    return false;
                });
    }
    
    // <editor-fold defaultstate="collapsed" desc="sooper secret settings">
    
    /**
     * STAGE 2 COMPLETE
     * 3 STAGES REMAINING
     */
    void l() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher((KeyEvent e) -> {
                    if (this.isFocusOwner()) {
                        if (e.getKeyCode() == KeyEvent.VK_L) {
                            o();
                        } else {
                        }
                    }
                    return false;
                });
    }

    /**
     * STAGE 3 COMPLETE
     * 2 STAGES REMAINING
     */
    void o() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher((KeyEvent e) -> {
                    if (this.isFocusOwner()) {
                        if (e.getKeyCode() == KeyEvent.VK_O) {
                            t();
                        } else {
                        }
                    }
                    return false;
                });
    }

    /**
     * STAGE 4 COMPLETE
     * 1 STAGE REMAINING
     */
    void t() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher((KeyEvent e) -> {
                    if (this.isFocusOwner()) {
                        if (e.getKeyCode() == KeyEvent.VK_T) {
                            h();
                        } else {
                        }
                    }
                    return false;
                });
    }

    /**
     * STAGE 5 COMPLETE
     * BRING IN THE SLOTH
     */
    void h() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher((KeyEvent e) -> {
                    if (this.isFocusOwner()) {
                        if (e.getKeyCode() == KeyEvent.VK_H) {
                            
    //  ____   ___    _____ _   _ _____   ____  _     ___ _____ _   _ 
    // |  _ \ / _ \  |_   _| | | | ____| / ___|| |   / _ \_   _| | | |
    // | | | | | | |   | | | |_| |  _|   \___ \| |  | | | || | | |_| |
    // | |_| | |_| |   | | |  _  | |___   ___) | |__| |_| || | |  _  |
    // |____/ \___/    |_| |_| |_|_____| |____/|_____\___/ |_| |_| |_|

                            image.setIcon(new ImageIcon("src//img//sloth//bigsloth.png"));
                        } else {
                        }
                    }
                    return false;
                });
    }
    // </editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        scrollpane = new javax.swing.JScrollPane();
        textarea = new javax.swing.JTextArea();
        title = new javax.swing.JLabel();
        button16 = new javax.swing.JButton();
        button64 = new javax.swing.JButton();
        button256 = new javax.swing.JButton();
        image = new javax.swing.JLabel();
        warningLabel = new javax.swing.JLabel();
        standalone = new javax.swing.JRadioButton();
        agent = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome to Wumpus World!");

        scrollpane.setBorder(null);
        scrollpane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        textarea.setEditable(false);
        textarea.setBackground(new java.awt.Color(240, 240, 240));
        textarea.setColumns(20);
        textarea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textarea.setRows(5);
        textarea.setText("4 X 4 Board:\t  1 Wumpus, 2 Pits, 1 Gold\n(Easy)\t  \n\n8 X 8 Board:\t  4 Wumpi, 6 Pits, 4 Gold\n(Medium)\t  \n\n16 x 16 Board:  8 Wumpi, 12 Pits, 8 Gold\n(Hard)\t  ");
        textarea.setFocusable(false);
        scrollpane.setViewportView(textarea);

        title.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        title.setText("Choose a board size to begin!");
        title.setFocusable(false);

        button16.setText("4 X 4");
        button16.setFocusable(false);
        button16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button16ActionPerformed(evt);
            }
        });

        button64.setText("8 X 8");
        button64.setFocusable(false);
        button64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button64ActionPerformed(evt);
            }
        });

        button256.setText("16 X 16");
        button256.setFocusable(false);
        button256.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button256ActionPerformed(evt);
            }
        });

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bigwumpus.png"))); // NOI18N
        image.setFocusable(false);

        warningLabel.setText("* AI Agent required for AI Agent Version");

        buttonGroup.add(standalone);
        standalone.setSelected(true);
        standalone.setText("Standalone Version");

        buttonGroup.add(agent);
        agent.setText("AI Agent Version");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                    .addComponent(scrollpane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(standalone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(agent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button256, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(warningLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button64)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button256)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(warningLabel)
                        .addComponent(agent))
                    .addComponent(standalone))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button16ActionPerformed
        
        if(standalone.isSelected()) {
            Main.openBoard16();
            Main.closeIntro();
        } else if (agent.isSelected()) {
            Main.openBoard16AI();
            Main.closeIntro();
        }
    }//GEN-LAST:event_button16ActionPerformed

    private void button64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button64ActionPerformed
        if(standalone.isSelected()) {
            Main.openBoard64();
            Main.closeIntro();
        } else if (agent.isSelected()) {
            //Main.openBoard64AI();
            //Main.closeIntro();
            JOptionPane.showMessageDialog(null, "Not implemented yet!", "Whoops!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_button64ActionPerformed

    private void button256ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button256ActionPerformed
        if(standalone.isSelected()) {
            Main.openBoard256();
            Main.closeIntro();
        } else if (agent.isSelected()) {
            //Main.openBoard256AI();
            //Main.closeIntro();
            JOptionPane.showMessageDialog(null, "Not implemented yet!", "Whoops!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_button256ActionPerformed

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
            java.util.logging.Logger.getLogger(Intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            //new Intro().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton agent;
    private javax.swing.JButton button16;
    private javax.swing.JButton button256;
    private javax.swing.JButton button64;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel image;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JRadioButton standalone;
    private javax.swing.JTextArea textarea;
    private javax.swing.JLabel title;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}
