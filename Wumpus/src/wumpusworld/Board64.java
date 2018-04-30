/**
 * File:    Board64.java
 * Desc:    This class is the main play board, and it includes the Swing
 *          Components and the methods and functions that accompany them.
 */
// package
package wumpusworld;

// imports
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;

/**
 * Board64
 */
public class Board64 extends javax.swing.JFrame {

    // length and width of board
    public final int SIZE = 8;

    // make game object based on length/width of baord
    Game game = new Game(SIZE);

    // hashmap to contain the labels
    Map<String, JLabel> tiles = new HashMap<>();

    // debugger class to print out stuff
    Debugger debug = new Debugger();

    // text storage class
    Message msg = new Message();

    // B-Random
    Random rand = new Random();

    /**
     * Creates new form Board64
     */
    public Board64() {

        // init the components
        initComponents();

        // set the scrollbar stuff
        JScrollBar sb = tileScrollPane.getVerticalScrollBar();
        sb.setValue(sb.getMaximum());
        sb.setUnitIncrement(20);
        tileScrollPane.validate();

        // request the focus
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
                                    if (start.isEnabled()) {
                                        start();
                                        break;
                                    } else {
                                        // do nothing
                                        break;
                                    }
                                case KeyEvent.VK_UP:
                                    if (up.isEnabled()) {
                                        up();
                                    } else {
                                        // do nothing
                                    }
                                    break;
                                case KeyEvent.VK_DOWN:
                                    if (down.isEnabled()) {
                                        down();
                                    } else {
                                        // do nothing
                                    }
                                    break;
                                case KeyEvent.VK_LEFT:
                                    if (left.isEnabled()) {
                                        left();
                                    } else {
                                        // do nothing
                                    }
                                    break;
                                case KeyEvent.VK_RIGHT:
                                    if (right.isEnabled()) {
                                        right();
                                    } else {
                                        // do nothing
                                    }
                                    break;
                                case KeyEvent.VK_A:
                                    if (arrow.isEnabled()) {
                                        arrow();
                                        break;
                                    } else {
                                        // do nothing
                                        break;
                                    }
                                case KeyEvent.VK_G:
                                    if (grab.isEnabled()) {
                                        grab();
                                        break;
                                    } else {
                                        // do nothing
                                        break;
                                    }
                                case KeyEvent.VK_C:
                                    if (climb.isEnabled()) {
                                        climb();
                                        break;
                                    } else {
                                        // do nothing
                                        break;
                                    }
                                case KeyEvent.VK_R:
                                    if (reset.isEnabled()) {
                                        reset();
                                        break;
                                    } else {
                                        // do nothing
                                        break;
                                    }
                                case KeyEvent.VK_ESCAPE:
                                    System.exit(0);
                                default:
                                    break;
                            }
                        }
                    }
                    return false;
                });

        // populate the board
        game.populate();

        // set the images based on the populate function
        setImages();

        // create a map
        initializeMap();

        // set the current pos
        game.setCurrent(0, SIZE - 1);
    }

    /**
     * Function to create the map so the labels can be referenced by a string
     * Thank the almighty lord for hashmaps
     */
    public void initializeMap() {
        tiles.put("tile0_0", tile0_0);
        tiles.put("tile0_1", tile0_1);
        tiles.put("tile0_2", tile0_2);
        tiles.put("tile0_3", tile0_3);
        tiles.put("tile0_4", tile0_4);
        tiles.put("tile0_5", tile0_5);
        tiles.put("tile0_6", tile0_6);
        tiles.put("tile0_7", tile0_7);
        tiles.put("tile1_0", tile1_0);
        tiles.put("tile1_1", tile1_1);
        tiles.put("tile1_2", tile1_2);
        tiles.put("tile1_3", tile1_3);
        tiles.put("tile1_4", tile1_4);
        tiles.put("tile1_5", tile1_5);
        tiles.put("tile1_6", tile1_6);
        tiles.put("tile1_7", tile1_7);
        tiles.put("tile2_0", tile2_0);
        tiles.put("tile2_1", tile2_1);
        tiles.put("tile2_2", tile2_2);
        tiles.put("tile2_3", tile2_3);
        tiles.put("tile2_4", tile2_4);
        tiles.put("tile2_5", tile2_5);
        tiles.put("tile2_6", tile2_6);
        tiles.put("tile2_7", tile2_7);
        tiles.put("tile3_0", tile3_0);
        tiles.put("tile3_1", tile3_1);
        tiles.put("tile3_2", tile3_2);
        tiles.put("tile3_3", tile3_3);
        tiles.put("tile3_4", tile3_4);
        tiles.put("tile3_5", tile3_5);
        tiles.put("tile3_6", tile3_6);
        tiles.put("tile3_7", tile3_7);
        tiles.put("tile4_0", tile4_0);
        tiles.put("tile4_1", tile4_1);
        tiles.put("tile4_2", tile4_2);
        tiles.put("tile4_3", tile4_3);
        tiles.put("tile4_4", tile4_4);
        tiles.put("tile4_5", tile4_5);
        tiles.put("tile4_6", tile4_6);
        tiles.put("tile4_7", tile4_7);
        tiles.put("tile5_0", tile5_0);
        tiles.put("tile5_1", tile5_1);
        tiles.put("tile5_2", tile5_2);
        tiles.put("tile5_3", tile5_3);
        tiles.put("tile5_4", tile5_4);
        tiles.put("tile5_5", tile5_5);
        tiles.put("tile5_6", tile5_6);
        tiles.put("tile5_7", tile5_7);
        tiles.put("tile6_0", tile6_0);
        tiles.put("tile6_1", tile6_1);
        tiles.put("tile6_2", tile6_2);
        tiles.put("tile6_3", tile6_3);
        tiles.put("tile6_4", tile6_4);
        tiles.put("tile6_5", tile6_5);
        tiles.put("tile6_6", tile6_6);
        tiles.put("tile6_7", tile6_7);
        tiles.put("tile7_0", tile7_0);
        tiles.put("tile7_1", tile7_1);
        tiles.put("tile7_2", tile7_2);
        tiles.put("tile7_3", tile7_3);
        tiles.put("tile7_4", tile7_4);
        tiles.put("tile7_5", tile7_5);
        tiles.put("tile7_6", tile7_6);
        tiles.put("tile7_7", tile7_7);
    }

    // <editor-fold defaultstate="collapsed" desc="Swing Components">
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reset = new javax.swing.JButton();
        start = new javax.swing.JButton();
        scrollpane2 = new javax.swing.JScrollPane();
        prompt = new javax.swing.JTextArea();
        arrow = new javax.swing.JButton();
        up = new javax.swing.JButton();
        goldIndicator = new javax.swing.JLabel();
        right = new javax.swing.JButton();
        grab = new javax.swing.JButton();
        left = new javax.swing.JButton();
        arrowIndicator = new javax.swing.JLabel();
        down = new javax.swing.JButton();
        climb = new javax.swing.JButton();
        scrollpane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        tileScrollPane = new javax.swing.JScrollPane();
        tilePanel = new javax.swing.JPanel();
        tile6_6 = new javax.swing.JLabel();
        tile7_5 = new javax.swing.JLabel();
        tile4_0 = new javax.swing.JLabel();
        tile4_7 = new javax.swing.JLabel();
        tile7_6 = new javax.swing.JLabel();
        tile0_5 = new javax.swing.JLabel();
        tile3_0 = new javax.swing.JLabel();
        tile6_5 = new javax.swing.JLabel();
        tile1_2 = new javax.swing.JLabel();
        tile0_1 = new javax.swing.JLabel();
        tile7_2 = new javax.swing.JLabel();
        tile1_5 = new javax.swing.JLabel();
        tile3_2 = new javax.swing.JLabel();
        tile0_3 = new javax.swing.JLabel();
        tile3_1 = new javax.swing.JLabel();
        tile0_0 = new javax.swing.JLabel();
        tile4_1 = new javax.swing.JLabel();
        tile2_5 = new javax.swing.JLabel();
        tile5_5 = new javax.swing.JLabel();
        tile4_6 = new javax.swing.JLabel();
        tile0_2 = new javax.swing.JLabel();
        tile0_4 = new javax.swing.JLabel();
        tile3_3 = new javax.swing.JLabel();
        tile2_2 = new javax.swing.JLabel();
        tile5_2 = new javax.swing.JLabel();
        tile2_6 = new javax.swing.JLabel();
        tile5_4 = new javax.swing.JLabel();
        tile6_1 = new javax.swing.JLabel();
        tile5_7 = new javax.swing.JLabel();
        tile6_4 = new javax.swing.JLabel();
        tile7_3 = new javax.swing.JLabel();
        tile5_6 = new javax.swing.JLabel();
        tile7_0 = new javax.swing.JLabel();
        tile4_2 = new javax.swing.JLabel();
        tile7_4 = new javax.swing.JLabel();
        tile1_3 = new javax.swing.JLabel();
        tile7_7 = new javax.swing.JLabel();
        tile0_7 = new javax.swing.JLabel();
        tile1_4 = new javax.swing.JLabel();
        tile2_4 = new javax.swing.JLabel();
        tile6_0 = new javax.swing.JLabel();
        tile2_1 = new javax.swing.JLabel();
        tile2_3 = new javax.swing.JLabel();
        tile3_4 = new javax.swing.JLabel();
        tile4_3 = new javax.swing.JLabel();
        tile6_7 = new javax.swing.JLabel();
        tile4_5 = new javax.swing.JLabel();
        tile6_2 = new javax.swing.JLabel();
        tile3_7 = new javax.swing.JLabel();
        tile1_6 = new javax.swing.JLabel();
        tile5_3 = new javax.swing.JLabel();
        tile1_0 = new javax.swing.JLabel();
        tile1_7 = new javax.swing.JLabel();
        tile5_1 = new javax.swing.JLabel();
        tile6_3 = new javax.swing.JLabel();
        tile5_0 = new javax.swing.JLabel();
        tile1_1 = new javax.swing.JLabel();
        tile2_0 = new javax.swing.JLabel();
        tile2_7 = new javax.swing.JLabel();
        tile4_4 = new javax.swing.JLabel();
        tile3_5 = new javax.swing.JLabel();
        tile3_6 = new javax.swing.JLabel();
        tile7_1 = new javax.swing.JLabel();
        tile0_6 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exit = new javax.swing.JMenuItem();
        gameMenu = new javax.swing.JMenu();
        howtoplay = new javax.swing.JMenuItem();
        cheatmode = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenu();
        version = new javax.swing.JMenuItem();
        about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        reset.setText("Reset [R]");
        reset.setEnabled(false);
        reset.setFocusable(false);
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        start.setText("Start [S]");
        start.setFocusable(false);
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        scrollpane2.setBorder(null);
        scrollpane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        prompt.setEditable(false);
        prompt.setBackground(new java.awt.Color(240, 240, 240));
        prompt.setColumns(20);
        prompt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        prompt.setLineWrap(true);
        prompt.setRows(5);
        prompt.setText("Press start to begin your adventure!");
        prompt.setWrapStyleWord(true);
        prompt.setBorder(null);
        prompt.setFocusable(false);
        scrollpane2.setViewportView(prompt);

        arrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bow_arrow.png"))); // NOI18N
        arrow.setEnabled(false);
        arrow.setFocusable(false);
        arrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrowActionPerformed(evt);
            }
        });

        up.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/up.png"))); // NOI18N
        up.setEnabled(false);
        up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upActionPerformed(evt);
            }
        });

        goldIndicator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        goldIndicator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gold0.png"))); // NOI18N

        right.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/right.png"))); // NOI18N
        right.setEnabled(false);
        right.setFocusable(false);
        right.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightActionPerformed(evt);
            }
        });

        grab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hand.png"))); // NOI18N
        grab.setEnabled(false);
        grab.setFocusable(false);
        grab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabActionPerformed(evt);
            }
        });

        left.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/left.png"))); // NOI18N
        left.setEnabled(false);
        left.setFocusable(false);
        left.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftActionPerformed(evt);
            }
        });

        arrowIndicator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arrowIndicator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bow_arrow4.png"))); // NOI18N

        down.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/down.png"))); // NOI18N
        down.setToolTipText("");
        down.setEnabled(false);
        down.setFocusable(false);
        down.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downActionPerformed(evt);
            }
        });

        climb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/stairs.png"))); // NOI18N
        climb.setEnabled(false);
        climb.setFocusable(false);
        climb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                climbActionPerformed(evt);
            }
        });

        scrollpane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        text.setEditable(false);
        text.setColumns(20);
        text.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        text.setLineWrap(true);
        text.setRows(5);
        text.setWrapStyleWord(true);
        text.setFocusable(false);
        scrollpane1.setViewportView(text);

        tileScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tile6_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile6_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile6_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile6_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e_p.png"))); // NOI18N
        tile7_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile6_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile6_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile6_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile6_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout tilePanelLayout = new javax.swing.GroupLayout(tilePanel);
        tilePanel.setLayout(tilePanelLayout);
        tilePanelLayout.setHorizontalGroup(
            tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile6_0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile6_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile6_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile6_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile6_4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile6_5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile6_6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile6_7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile7_0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile7_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile7_4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile7_5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile7_6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile7_7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile0_0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile0_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile0_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile0_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile0_4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile0_5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile0_6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile0_7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile1_0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile1_5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile1_6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile1_7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile2_0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile2_5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile2_6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile2_7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile3_0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile3_5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile3_6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile3_7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile4_0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile4_5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile4_6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile4_7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile5_0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile5_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile5_4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile5_5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile5_6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile5_7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tilePanelLayout.setVerticalGroup(
            tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile0_7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile0_6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile0_5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile0_4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile0_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile0_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile0_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile0_0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile1_7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile1_6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile1_5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile1_0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile2_7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile2_6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile2_5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile2_0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile3_7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile3_6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile3_5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile3_0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile4_7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile4_6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile4_5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile4_0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile5_7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile5_6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile5_5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile5_4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile5_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile5_0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile6_7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile6_6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile6_5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile6_4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile6_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile6_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile6_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile6_0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile7_7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile7_6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile7_5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile7_4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile7_2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile7_0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tileScrollPane.setViewportView(tilePanel);

        fileMenu.setText("File");

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        fileMenu.add(exit);

        menuBar.add(fileMenu);

        gameMenu.setText("Game");

        howtoplay.setText("How to Play");
        howtoplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                howtoplayActionPerformed(evt);
            }
        });
        gameMenu.add(howtoplay);

        cheatmode.setText("Cheat Mode");
        cheatmode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cheatmodeActionPerformed(evt);
            }
        });
        gameMenu.add(cheatmode);

        menuBar.add(gameMenu);

        aboutMenu.setText("About");

        version.setText("Version");
        version.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                versionActionPerformed(evt);
            }
        });
        aboutMenu.add(version);

        about.setText("About Project");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        aboutMenu.add(about);

        menuBar.add(aboutMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollpane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(arrow, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(left, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(arrowIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(down, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grab, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(up, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(right, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(climb, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(goldIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(scrollpane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tileScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reset)
                            .addComponent(start))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollpane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(arrow, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(up, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(left, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(arrowIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(goldIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(grab, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(right, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(down, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(climb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addComponent(scrollpane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(tileScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void howtoplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_howtoplayActionPerformed
        JOptionPane.showMessageDialog(
                null,
                "Your mission is to get the gold and escape successfully.\n"
                + "However, there are pits and a Wumpus monster to stop you!\n"
                + "You can kill the Wumpus by shooting your arrow at him, but\n"
                + "remember, you only get one shot! Literally! You get one arrow!"
                + "Navigate through the cave to find the gold, then get back to\n"
                + "where you started to escape the cave!\n\n"
                + "Either use the buttons on the left to play, or use your keyboard:\n"
                + "   [Arrow Keys]: Move around the cave\n"
                + "   [S]: Start the game\n"
                + "   [R]: Reset the game\n"
                + "   [A]: Draw you arrow\n"
                + "   [G]: Grab for the gold\n"
                + "   [C]: Climb out of the cave\n\n"
                + "Good luck!",
                "How to Play",
                -1,
                new ImageIcon("src//img//wumpus.png")
        );
    }//GEN-LAST:event_howtoplayActionPerformed

    private void cheatmodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cheatmodeActionPerformed
        enableCheatMode();
    }//GEN-LAST:event_cheatmodeActionPerformed

    private void versionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_versionActionPerformed
        JOptionPane.showMessageDialog(null, "Version 1.1\n"
                + "15 April 2017");
    }//GEN-LAST:event_versionActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        JOptionPane.showMessageDialog(null, "I didn't want to do the NQueens assignment...\n"
                + "So I did this instead.\n\n"
                + "And now it's being implemented as an Agent-based game!");
    }//GEN-LAST:event_aboutActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        reset();
    }//GEN-LAST:event_resetActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        start();
    }//GEN-LAST:event_startActionPerformed

    private void arrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrowActionPerformed
        arrow();
    }//GEN-LAST:event_arrowActionPerformed

    private void upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upActionPerformed
        up();
    }//GEN-LAST:event_upActionPerformed

    private void rightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightActionPerformed
        right();
    }//GEN-LAST:event_rightActionPerformed

    private void grabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabActionPerformed
        grab();
    }//GEN-LAST:event_grabActionPerformed

    private void leftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftActionPerformed
        left();
    }//GEN-LAST:event_leftActionPerformed

    private void downActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downActionPerformed
        down();
    }//GEN-LAST:event_downActionPerformed

    private void climbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_climbActionPerformed
        climb();
    }//GEN-LAST:event_climbActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        disableCheatMode();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // </editor-fold>
    /**
     * Sets the images of the tiles
     */
    public final void setImages() {

        // traverse the whole board
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                Tile tile = game.getTileAt(i, j);

                // if nothing's there
                if (!tile.hasBreeze()
                        && !tile.hasGold()
                        && !tile.hasStench()
                        && !tile.hasPit()
                        && !tile.hasWumpus()) {
                    tile.setImages("e", SIZE);
                }

                // if it's easy, breezy, beautiful Covergirl
                if (tile.hasBreeze()) {
                    tile.setImages("b", SIZE);
                }

                // if it's shiny
                if (tile.hasGold()) {
                    tile.setImages("g", SIZE);
                }

                // if it's stinky
                if (tile.hasStench()) {
                    tile.setImages("s", SIZE);
                }

                // if it's breezy and shiny
                if (tile.hasBreeze()
                        && tile.hasGold()) {
                    tile.setImages("bg", SIZE);
                }

                // if it's breezy and stinky
                if (tile.hasBreeze()
                        && tile.hasStench()) {
                    tile.setImages("sb", SIZE);
                }

                // if it's stinky and shiny
                if (tile.hasStench()
                        && tile.hasGold()) {
                    tile.setImages("sg", SIZE);
                }

                // if it's a plethora of things
                if (tile.hasBreeze()
                        && tile.hasGold()
                        && tile.hasStench()) {
                    tile.setImages("sbg", SIZE);
                }

                // if a fall to your death is inevitable
                if (tile.hasPit()) {
                    tile.setImages("p", SIZE);
                }

                // if the big bastard is there
                if (tile.hasWumpus()) {
                    tile.setImages("w", SIZE);
                }
            }
        }
    }

    public void showImage(int x, int y) {
        String name = "tile" + x + "_" + y;
        tiles.get(name).setIcon(new ImageIcon(game.board[x][y].getUncoveredImage()));
    }
    
    public void waitASecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }
    }
    
    /**
     * When a player steps on a bat, bat moves player to random spot on board
     */
    public void movePlayerBecauseBat() {

        
        waitASecond();
        

        boolean moved = false;

        while (!moved) {

            // randomize position
            int col = rand.nextInt(SIZE);
            int row = rand.nextInt(SIZE);

            if (game.board[row][col].hasWumpus() || game.board[row][col].hasPit()) {
                // start over
            } else {

                // store the old variables
                int oldX = game.getCurrX();
                int oldY = game.getCurrY();

                // update the current position and show player on new tile
                game.setCurrent(col, row);
                updateLabel(game.getCurrX(), game.getCurrY(), true);
            }
        }
    }

    /**
     * Basically "flips" all of the images to their uncovered sides Uses the
     * hashmap and a loop to change each label
     */
    public void enableCheatMode() {

        String name;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                name = "tile" + i + "_" + j;
                tiles.get(name).setIcon(new ImageIcon(game.board[i][j].getUncoveredImage()));
            }
        }

        // set the current positions's coordinates to the version with a player
        updateLabel(game.getCurrX(), game.getCurrY(), true);
    }
    
    /**
     * Basically "flips" all of the images to their uncovered sides Uses the
     * hashmap and a loop to change each label
     */
    public void disableCheatMode() {

        String name;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                name = "tile" + i + "_" + j;
                tiles.get(name).setIcon(new ImageIcon("src//img//e.png"));
            }
        }

        // set the current positions's coordinates to the version with a player
        updateLabel(game.getCurrX(), game.getCurrY(), true);
    }

    /**
     * Starts the game, graphically and programmatically
     */
    public void start() {

        // update graphics
        up.setEnabled(true);
        down.setEnabled(false);
        left.setEnabled(false);
        right.setEnabled(true);
        arrow.setEnabled(true);
        grab.setEnabled(true);
        climb.setEnabled(true);

        start.setEnabled(false);
        reset.setEnabled(true);

        prompt.setText("Use the arrow keys to move around, and the bow, grab, and climb controls for actions.");

        // update label
        updateLabel(game.getCurrX(), game.getCurrY(), true);

        // check the tile for danger
        checkTile(game.getTileAt(game.getCurrX(), game.getCurrY()));
    }

    /**
     * Updates the label based on the input of the column and row, as well as a
     * boolean that tells it if it needs the player on the piece Uses the
     * hashmap to find which label to change
     *
     * @param x, the column of the label table
     * @param y, the row of the label table
     * @param p, boolean to see if player is needed on the piece
     */
    public void updateLabel(int x, int y, boolean p) {

        String name = "tile" + y + "_" + x;
        if (p) {
            tiles.get(name).setIcon(new ImageIcon(game.board[y][x].getUncoveredImage_p()));
        } else {
            tiles.get(name).setIcon(new ImageIcon(game.board[y][x].getUncoveredImage()));
        }
    }

    /**
     * Function to update the arrow buttons, basically hindering the user from
     * making any bad moves. Basically just disables the button if the user
     * won't be able to go there.
     */
    public void updateDirections() {
        if (game.getCurrY() == 0) {
            up.setEnabled(false);
        } else {
            up.setEnabled(true);
        }
        if (game.getCurrY() == SIZE - 1) {
            down.setEnabled(false);
        } else {
            down.setEnabled(true);
        }
        if (game.getCurrX() == 0) {
            left.setEnabled(false);
        } else {
            left.setEnabled(true);
        }
        if (game.getCurrX() == SIZE - 1) {
            right.setEnabled(false);
        } else {
            right.setEnabled(true);
        }
    }

    /**
     * Checks the tile for anything in it and sets the Text object to a random
     * text in the Message class
     *
     * @param tile
     */
    public void checkTile(Tile tile) {

        // checks to see if the tile is at the start
        // if so, set climb button enabled
        if (game.isAtStart()) {
            climb.setEnabled(true);
        } else {
            climb.setEnabled(false);
        }

        // if tile is empty
        if (!tile.hasBreeze()
                && !tile.hasGold()
                && !tile.hasStench()
                && !tile.hasPit()
                && !tile.hasWumpus()) {
            text.setText(msg.getEmpty());
        }

        // if tile is breezy
        if (tile.hasBreeze()) {
            text.setText(msg.getBreeze());
        }

        // if tile is shiny
        if (tile.hasGold()) {
            text.setText(msg.getGold());
        }

        // if tile is stinky
        if (tile.hasStench()) {
            text.setText(msg.getStench());
        }

        // if tile is breezy and shiny
        if (tile.hasBreeze()
                && tile.hasGold()) {
            text.setText(msg.getBreezeGold());
        }

        // if tile is breezy and stinky
        if (tile.hasBreeze()
                && tile.hasStench()) {
            text.setText(msg.getBreezeStench());
        }

        // if tile is stinky is shiny
        if (tile.hasStench()
                && tile.hasGold()) {
            text.setText(msg.getStenchGold());
        }

        // if tile is errything
        if (tile.hasBreeze()
                && tile.hasGold()
                && tile.hasStench()) {
            text.setText(msg.getBreezeStenchGold());
        }

        // if tile has a pit
        // end the game
        if (tile.hasPit()) {
            text.setText(msg.getPit());
            game.setGameEnded(true);
            game.setDeath("pit");
            endGame(false);
        }

        // if tile has a wumpus
        if (tile.hasWumpus()) {
            text.setText(msg.getWumpus());
            game.setDeath("wumpus");
            game.setGameEnded(true);
            endGame(false);
        }

        // if tile had a wumpus, but RIP wumpus
        if (tile.hasDeadWumpus()) {
            text.setText(msg.getDeadWumpus());
        }
    }

    /**
     * Kills the Wumpus in the game, then updates the graphics
     *
     * @param c the column the wumpus is in
     * @param r the row the wumpus is in
     */
    public void killWumpus(int c, int r) {

        // kill the wumpus in the game
        game.board[r][c].setDeadWumpus(true);

        // update graphics
        text.setText(msg.getArrowHit());
        game.board[r][c].setUncoveredImage_p("wd_p");
        game.board[r][c].setUncoveredImage("wd");
        game.board[r][c].setWumpus(false);
        updateLabel(game.getCurrX(), game.getCurrY(), true);
    }

    /**
     * Ends the game Updates the graphics, then calls the endgame method in game
     *
     * @param result, either death or great success
     */
    public void endGame(boolean result) {

        // update graphics
        up.setEnabled(false);
        down.setEnabled(false);
        left.setEnabled(false);
        right.setEnabled(false);
        grab.setEnabled(false);
        arrow.setEnabled(false);
        climb.setEnabled(false);

        // end the game
        game.endGame(result);
    }

    /**
     * Resets the board by closing then reopening
     */
    public void reset() {
        Main.closeBoard64();
        Main.openBoard64();
    }

    /**
     * Checks if arrow is currently about to be fired, then if an arrow can even
     * be fired in that direction. If the arrow is not being fired, check if
     * player can move, then move in that direction.
     */
    public void up() {
        if (game.getFiringArrow()) {
            if ((game.getCurrX() >= 0 && game.getCurrX() <= SIZE - 1) && (game.getCurrY() > 0 && game.getCurrY() <= SIZE - 1)) {
                fireUp();
            }
        }
        if (game.getCurrY() > 0) {
            moveUp();
        }

        // update text file
        IO.outTile(game.getTileAt(game.getCurrX(), game.getCurrY()), game.getCurrX(), game.getCurrY(), SIZE);
    }

    /**
     * Moves the player up
     */
    public void moveUp() {

        // update graphics
        updateLabel(game.getCurrX(), game.getCurrY(), false);

        // update globals
        game.decY();
        game.incMoves();

        // check tile for stuff
        checkTile(game.getTileAt(game.getCurrX(), game.getCurrY()));
        
        // update graphics again
        updateLabel(game.getCurrX(), game.getCurrY(), true);
        
        // update the arrow buttons
        if (!game.getGameEnded()) {
            updateDirections();
        }
    }

    /**
     * Fires an arrow up
     */
    public void fireUp() {

        // if tile above has wumpus
        if (game.checkTileForWumpus(game.getCurrX(), game.getCurrY() - 1)) {

            // decrease number of wumpi and arrows
            game.decNumWumps();

            // deck that bastard
            killWumpus(game.getCurrX(), game.getCurrY() - 1);
            fire();
            
            // update graphics
            grab.setEnabled(true);
            prompt.setText("");
            game.setFiringArrow(false);

            // else tile above doesn't has wumpus  
        } else {

            // update graphics
            text.setText(msg.getArrowMiss());
            fire();
            prompt.setText("");
            grab.setEnabled(true);
            game.setFiringArrow(false);
        }
    }

    /**
     * Checks if arrow is currently about to be fired, then if an arrow can even
     * be fired in that direction. If the arrow is not being fired, check if
     * player can move, then move in that direction.
     */
    public void down() {
        if (game.getFiringArrow()) {
            if ((game.getCurrX() >= 0 && game.getCurrX() <= SIZE - 1) && (game.getCurrY() >= 0 && game.getCurrY() < SIZE - 1)) {
                fireDown();
            }
        }
        if (game.getCurrY() < SIZE - 1) {
            moveDown();
        }

        // update text file
        IO.outTile(game.getTileAt(game.getCurrX(), game.getCurrY()), game.getCurrX(), game.getCurrY(), SIZE);
    }

    /**
     * Moves the player down
     */
    public void moveDown() {

        // update graphics
        updateLabel(game.getCurrX(), game.getCurrY(), false);

        // update globals
        game.incY();
        game.incMoves();

        // check tile for stuff
        checkTile(game.getTileAt(game.getCurrX(), game.getCurrY()));
        
        // update graphics again
        updateLabel(game.getCurrX(), game.getCurrY(), true);

        // update the arrow buttons
        if (!game.getGameEnded()) {
            updateDirections();
        }
    }

    /**
     * Fires an arrow down
     */
    public void fireDown() {

        // if tile below has wumpus
        if (game.checkTileForWumpus(game.getCurrX(), game.getCurrY() + 1)) {

            // decrease number of wumpi and arrows
            game.decNumWumps();

            // deck that bastard
            killWumpus(game.getCurrX(), game.getCurrY() + 1);
            fire();
            
            // update graphics
            grab.setEnabled(true);
            prompt.setText("");
            game.setFiringArrow(false);

            // else tile below doesn't has wumpus    
        } else {

            // update graphics
            text.setText(msg.getArrowMiss());
            fire();
            prompt.setText("");
            grab.setEnabled(true);
            game.setFiringArrow(false);
        }
    }

    /**
     * Checks if arrow is currently about to be fired, then if an arrow can even
     * be fired in that direction. If the arrow is not being fired, check if
     * player can move, then move in that direction.
     */
    public void left() {
        if (game.getFiringArrow()) {
            if ((game.getCurrX() > 0 && game.getCurrX() <= SIZE - 1) && (game.getCurrY() >= 0 && game.getCurrY() <= SIZE - 1)) {
                fireLeft();
            }
        }

        if (game.getCurrX() > 0) {
            moveLeft();
        }

        // update text file
        IO.outTile(game.getTileAt(game.getCurrX(), game.getCurrY()), game.getCurrX(), game.getCurrY(), SIZE);
    }

    /**
     * Moves the player left
     */
    public void moveLeft() {

        // update graphics
        updateLabel(game.getCurrX(), game.getCurrY(), false);

        // update globals
        game.decX();
        game.incMoves();

        // check tile for stuff
        checkTile(game.getTileAt(game.getCurrX(), game.getCurrY()));
        
        // update graphics again
        updateLabel(game.getCurrX(), game.getCurrY(), true);

        // update the arrow buttons
        if (!game.getGameEnded()) {
            updateDirections();
        }
    }

    /**
     * Fires an arrow left
     */
    public void fireLeft() {

        // if tile to the left has wumpus
        if (game.checkTileForWumpus(game.getCurrX() - 1, game.getCurrY())) {

            // decrease number of wumpi and arrows
            game.decNumWumps();

            // deck that bastard
            killWumpus(game.getCurrX() - 1, game.getCurrY());
            fire();
            
            // update graphics
            grab.setEnabled(true);
            prompt.setText("");
            game.setFiringArrow(false);

            // else tile to the left doesn't has wumpus    
        } else {

            // update graphics
            text.setText(msg.getArrowMiss());
            fire();
            prompt.setText("");
            grab.setEnabled(true);
            game.setFiringArrow(false);
        }
    }

    /**
     * Checks if arrow is currently about to be fired, then if an arrow can even
     * be fired in that direction. If the arrow is not being fired, check if
     * player can move, then move in that direction.
     */
    public void right() {
        if (game.getFiringArrow()) {
            if ((game.getCurrX() >= 0 && game.getCurrX() < SIZE - 1) && (game.getCurrY() >= 0 && game.getCurrY() <= SIZE - 1)) {
                fireRight();
            }
        }
        if (game.getCurrX() < SIZE - 1) {
            moveRight();
        }

        // update text file
        IO.outTile(game.getTileAt(game.getCurrX(), game.getCurrY()), game.getCurrX(), game.getCurrY(), SIZE);
    }

    /**
     * Moves the player right
     */
    public void moveRight() {

        // update graphics
        updateLabel(game.getCurrX(), game.getCurrY(), false);

        // update globals
        game.incX();
        game.incMoves();

        // check tile for stuff
        checkTile(game.getTileAt(game.getCurrX(), game.getCurrY()));
        
        // update graphics again
        updateLabel(game.getCurrX(), game.getCurrY(), true);

        // update the arrow buttons
        if (!game.getGameEnded()) {
            updateDirections();
        }
    }

    /**
     * Fires an arrow right
     */
    public void fireRight() {

        // if tile to the right has wumpus
        if (game.checkTileForWumpus(game.getCurrX() + 1, game.getCurrY())) {

            // decrease the number of wumpi and arrows
            game.decNumWumps();

            // deck that bastard
            killWumpus(game.getCurrX() + 1, game.getCurrY());
            fire();
            
            // update graphics
            grab.setEnabled(true);
            prompt.setText("");
            game.setFiringArrow(false);

            // else tile to the right doesn't has wumpus    
        } else {

            // update graphics
            text.setText(msg.getArrowMiss());
            fire();
            prompt.setText("");
            grab.setEnabled(true);
            game.setFiringArrow(false);
        }
    }
    
    /**
     * Updates graphics for the arrow firing
     */
    public void fire() {
        game.decNumArrows();
        String name = "src//img//bow_arrow" + game.getNumArrows() + ".png";
        arrowIndicator.setIcon(new ImageIcon(name));
            
        if (game.getNumArrows() == 0) {
            arrow.setEnabled(false);
        }
    }
    
    /**
     * Checks the tile for gold, then updates accordingly
     */
    public void grab() {

        // if tile has gold
        if (game.checkTileForGold()) {

            // update global
            game.incGold();

            // update graphics
            text.setText("You picked up a golden ingot!");
            String name = "src//img//gold" + game.getNumGold() + ".png";
            goldIndicator.setIcon(new ImageIcon(name));
            game.board[game.getCurrY()][game.getCurrX()].setGold(false);

            // set iconimage of tile to the same thing minus gold
            if (game.board[game.getCurrY()][game.getCurrX()].hasBreeze()) {
                game.board[game.getCurrY()][game.getCurrX()].setImages("b", 8);
            }
            if (game.board[game.getCurrY()][game.getCurrX()].hasStench()) {
                game.board[game.getCurrY()][game.getCurrX()].setImages("s", 8);
            }
            if (game.board[game.getCurrY()][game.getCurrX()].hasBreeze()
                    && game.board[game.getCurrY()][game.getCurrX()].hasStench()) {
                game.board[game.getCurrY()][game.getCurrX()].setImages("sb", 8);
            }
            if (!game.board[game.getCurrY()][game.getCurrX()].hasBreeze()
                    && !game.board[game.getCurrY()][game.getCurrX()].hasStench()) {
                game.board[game.getCurrY()][game.getCurrX()].setImages("e", 8);
            }

            // update the label
            updateLabel(game.getCurrX(), game.getCurrY(), true);

            // else no gold
        } else {
            text.setText(msg.getNoGold());
        }
    }

    /**
     * Preps the board for an arrow shot
     */
    public void arrow() {

        // update game variable
        game.setFiringArrow(true);

        // update graphics
        grab.setEnabled(false);
        climb.setEnabled(false);
        prompt.setText("Choose a direction to fire your arrow.  It will go one block forward.");
    }

    /**
     * Function the climb out, resulting in success
     */
    public void climb() {

        // update graphics
        text.setText("You climbed out successfully!");

        // update game variable
        game.setGameEnded(true);

        // end game with success
        endGame(true);
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
            java.util.logging.Logger.getLogger(Board64.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Board64.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Board64.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Board64.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Board64().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JButton arrow;
    private javax.swing.JLabel arrowIndicator;
    private javax.swing.JMenuItem cheatmode;
    private javax.swing.JButton climb;
    private javax.swing.JButton down;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu gameMenu;
    private javax.swing.JLabel goldIndicator;
    private javax.swing.JButton grab;
    private javax.swing.JMenuItem howtoplay;
    private javax.swing.JButton left;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextArea prompt;
    private javax.swing.JButton reset;
    private javax.swing.JButton right;
    private javax.swing.JScrollPane scrollpane1;
    private javax.swing.JScrollPane scrollpane2;
    private javax.swing.JButton start;
    private javax.swing.JTextArea text;
    private javax.swing.JLabel tile0_0;
    private javax.swing.JLabel tile0_1;
    private javax.swing.JLabel tile0_2;
    private javax.swing.JLabel tile0_3;
    private javax.swing.JLabel tile0_4;
    private javax.swing.JLabel tile0_5;
    private javax.swing.JLabel tile0_6;
    private javax.swing.JLabel tile0_7;
    private javax.swing.JLabel tile1_0;
    private javax.swing.JLabel tile1_1;
    private javax.swing.JLabel tile1_2;
    private javax.swing.JLabel tile1_3;
    private javax.swing.JLabel tile1_4;
    private javax.swing.JLabel tile1_5;
    private javax.swing.JLabel tile1_6;
    private javax.swing.JLabel tile1_7;
    private javax.swing.JLabel tile2_0;
    private javax.swing.JLabel tile2_1;
    private javax.swing.JLabel tile2_2;
    private javax.swing.JLabel tile2_3;
    private javax.swing.JLabel tile2_4;
    private javax.swing.JLabel tile2_5;
    private javax.swing.JLabel tile2_6;
    private javax.swing.JLabel tile2_7;
    private javax.swing.JLabel tile3_0;
    private javax.swing.JLabel tile3_1;
    private javax.swing.JLabel tile3_2;
    private javax.swing.JLabel tile3_3;
    private javax.swing.JLabel tile3_4;
    private javax.swing.JLabel tile3_5;
    private javax.swing.JLabel tile3_6;
    private javax.swing.JLabel tile3_7;
    private javax.swing.JLabel tile4_0;
    private javax.swing.JLabel tile4_1;
    private javax.swing.JLabel tile4_2;
    private javax.swing.JLabel tile4_3;
    private javax.swing.JLabel tile4_4;
    private javax.swing.JLabel tile4_5;
    private javax.swing.JLabel tile4_6;
    private javax.swing.JLabel tile4_7;
    private javax.swing.JLabel tile5_0;
    private javax.swing.JLabel tile5_1;
    private javax.swing.JLabel tile5_2;
    private javax.swing.JLabel tile5_3;
    private javax.swing.JLabel tile5_4;
    private javax.swing.JLabel tile5_5;
    private javax.swing.JLabel tile5_6;
    private javax.swing.JLabel tile5_7;
    private javax.swing.JLabel tile6_0;
    private javax.swing.JLabel tile6_1;
    private javax.swing.JLabel tile6_2;
    private javax.swing.JLabel tile6_3;
    private javax.swing.JLabel tile6_4;
    private javax.swing.JLabel tile6_5;
    private javax.swing.JLabel tile6_6;
    private javax.swing.JLabel tile6_7;
    private javax.swing.JLabel tile7_0;
    private javax.swing.JLabel tile7_1;
    private javax.swing.JLabel tile7_2;
    private javax.swing.JLabel tile7_3;
    private javax.swing.JLabel tile7_4;
    private javax.swing.JLabel tile7_5;
    private javax.swing.JLabel tile7_6;
    private javax.swing.JLabel tile7_7;
    private javax.swing.JPanel tilePanel;
    private javax.swing.JScrollPane tileScrollPane;
    private javax.swing.JButton up;
    private javax.swing.JMenuItem version;
    // End of variables declaration//GEN-END:variables
}
