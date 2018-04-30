/**
 * File:    Board256.java
 * Desc:    This class is the main play board, and it includes the Swing
 *          Components and the methods and functions that accompany them.
 */

// package
package wumpusworld;

import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;

/**
 * Class Board 256
 */
public class Board256 extends javax.swing.JFrame {

    // length and width of board
    public final int SIZE = 16;
    
    // make game object based on length/width of baord
    Game game = new Game(SIZE);
    
    // hashmap to contain the labels
    Map<String, JLabel> tiles = new HashMap<>();
    
    // debugger class to print out stuff
    Debugger debug = new Debugger();
    
    // text storage class
    Message msg = new Message();
    
    /**
     * Creates new form Board256
     */
    public Board256() {
        
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
        tiles.put("tile0_8", tile0_8);
        tiles.put("tile0_9", tile0_9);
        tiles.put("tile0_10", tile0_10);
        tiles.put("tile0_11", tile0_11);
        tiles.put("tile0_12", tile0_12);
        tiles.put("tile0_13", tile0_13);
        tiles.put("tile0_14", tile0_14);
        tiles.put("tile0_15", tile0_15);
        tiles.put("tile1_0", tile1_0);
        tiles.put("tile1_1", tile1_1);
        tiles.put("tile1_2", tile1_2);
        tiles.put("tile1_3", tile1_3);
        tiles.put("tile1_4", tile1_4);
        tiles.put("tile1_5", tile1_5);
        tiles.put("tile1_6", tile1_6);
        tiles.put("tile1_7", tile1_7);
        tiles.put("tile1_8", tile1_8);
        tiles.put("tile1_9", tile1_9);
        tiles.put("tile1_10", tile1_10);
        tiles.put("tile1_11", tile1_11);
        tiles.put("tile1_12", tile1_12);
        tiles.put("tile1_13", tile1_13);
        tiles.put("tile1_14", tile1_14);
        tiles.put("tile1_15", tile1_15);
        tiles.put("tile2_0", tile2_0);
        tiles.put("tile2_1", tile2_1);
        tiles.put("tile2_2", tile2_2);
        tiles.put("tile2_3", tile2_3);
        tiles.put("tile2_4", tile2_4);
        tiles.put("tile2_5", tile2_5);
        tiles.put("tile2_6", tile2_6);
        tiles.put("tile2_7", tile2_7);
        tiles.put("tile2_8", tile2_8);
        tiles.put("tile2_9", tile2_9);
        tiles.put("tile2_10", tile2_10);
        tiles.put("tile2_11", tile2_11);
        tiles.put("tile2_12", tile2_12);
        tiles.put("tile2_13", tile2_13);
        tiles.put("tile2_14", tile2_14);
        tiles.put("tile2_15", tile2_15);
        tiles.put("tile3_0", tile3_0);
        tiles.put("tile3_1", tile3_1);
        tiles.put("tile3_2", tile3_2);
        tiles.put("tile3_3", tile3_3);
        tiles.put("tile3_4", tile3_4);
        tiles.put("tile3_5", tile3_5);
        tiles.put("tile3_6", tile3_6);
        tiles.put("tile3_7", tile3_7);
        tiles.put("tile3_8", tile3_8);
        tiles.put("tile3_9", tile3_9);
        tiles.put("tile3_10", tile3_10);
        tiles.put("tile3_11", tile3_11);
        tiles.put("tile3_12", tile3_12);
        tiles.put("tile3_13", tile3_13);
        tiles.put("tile3_14", tile3_14);
        tiles.put("tile3_15", tile3_15);
        tiles.put("tile4_0", tile4_0);
        tiles.put("tile4_1", tile4_1);
        tiles.put("tile4_2", tile4_2);
        tiles.put("tile4_3", tile4_3);
        tiles.put("tile4_4", tile4_4);
        tiles.put("tile4_5", tile4_5);
        tiles.put("tile4_6", tile4_6);
        tiles.put("tile4_7", tile4_7);
        tiles.put("tile4_8", tile4_8);
        tiles.put("tile4_9", tile4_9);
        tiles.put("tile4_10", tile4_10);
        tiles.put("tile4_11", tile4_11);
        tiles.put("tile4_12", tile4_12);
        tiles.put("tile4_13", tile4_13);
        tiles.put("tile4_14", tile4_14);
        tiles.put("tile4_15", tile4_15);
        tiles.put("tile5_0", tile5_0);
        tiles.put("tile5_1", tile5_1);
        tiles.put("tile5_2", tile5_2);
        tiles.put("tile5_3", tile5_3);
        tiles.put("tile5_4", tile5_4);
        tiles.put("tile5_5", tile5_5);
        tiles.put("tile5_6", tile5_6);
        tiles.put("tile5_7", tile5_7);
        tiles.put("tile5_8", tile5_8);
        tiles.put("tile5_9", tile5_9);
        tiles.put("tile5_10", tile5_10);
        tiles.put("tile5_11", tile5_11);
        tiles.put("tile5_12", tile5_12);
        tiles.put("tile5_13", tile5_13);
        tiles.put("tile5_14", tile5_14);
        tiles.put("tile5_15", tile5_15);
        tiles.put("tile6_0", tile6_0);
        tiles.put("tile6_1", tile6_1);
        tiles.put("tile6_2", tile6_2);
        tiles.put("tile6_3", tile6_3);
        tiles.put("tile6_4", tile6_4);
        tiles.put("tile6_5", tile6_5);
        tiles.put("tile6_6", tile6_6);
        tiles.put("tile6_7", tile6_7);
        tiles.put("tile6_8", tile6_8);
        tiles.put("tile6_9", tile6_9);
        tiles.put("tile6_10", tile6_10);
        tiles.put("tile6_11", tile6_11);
        tiles.put("tile6_12", tile6_12);
        tiles.put("tile6_13", tile6_13);
        tiles.put("tile6_14", tile6_14);
        tiles.put("tile6_15", tile6_15);
        tiles.put("tile7_0", tile7_0);
        tiles.put("tile7_1", tile7_1);
        tiles.put("tile7_2", tile7_2);
        tiles.put("tile7_3", tile7_3);
        tiles.put("tile7_4", tile7_4);
        tiles.put("tile7_5", tile7_5);
        tiles.put("tile7_6", tile7_6);
        tiles.put("tile7_7", tile7_7);
        tiles.put("tile7_8", tile7_8);
        tiles.put("tile7_9", tile7_9);
        tiles.put("tile7_10", tile7_10);
        tiles.put("tile7_11", tile7_11);
        tiles.put("tile7_12", tile7_12);
        tiles.put("tile7_13", tile7_13);
        tiles.put("tile7_14", tile7_14);
        tiles.put("tile7_15", tile7_15);
        tiles.put("tile8_0", tile8_0);
        tiles.put("tile8_1", tile8_1);
        tiles.put("tile8_2", tile8_2);
        tiles.put("tile8_3", tile8_3);
        tiles.put("tile8_4", tile8_4);
        tiles.put("tile8_5", tile8_5);
        tiles.put("tile8_6", tile8_6);
        tiles.put("tile8_7", tile8_7);
        tiles.put("tile8_8", tile8_8);
        tiles.put("tile8_9", tile8_9);
        tiles.put("tile8_10", tile8_10);
        tiles.put("tile8_11", tile8_11);
        tiles.put("tile8_12", tile8_12);
        tiles.put("tile8_13", tile8_13);
        tiles.put("tile8_14", tile8_14);
        tiles.put("tile8_15", tile8_15);
        tiles.put("tile9_0", tile9_0);
        tiles.put("tile9_1", tile9_1);
        tiles.put("tile9_2", tile9_2);
        tiles.put("tile9_3", tile9_3);
        tiles.put("tile9_4", tile9_4);
        tiles.put("tile9_5", tile9_5);
        tiles.put("tile9_6", tile9_6);
        tiles.put("tile9_7", tile9_7);
        tiles.put("tile9_8", tile9_8);
        tiles.put("tile9_9", tile9_9);
        tiles.put("tile9_10", tile9_10);
        tiles.put("tile9_11", tile9_11);
        tiles.put("tile9_12", tile9_12);
        tiles.put("tile9_13", tile9_13);
        tiles.put("tile9_14", tile9_14);
        tiles.put("tile9_15", tile9_15);
        tiles.put("tile10_0", tile10_0);
        tiles.put("tile10_1", tile10_1);
        tiles.put("tile10_2", tile10_2);
        tiles.put("tile10_3", tile10_3);
        tiles.put("tile10_4", tile10_4);
        tiles.put("tile10_5", tile10_5);
        tiles.put("tile10_6", tile10_6);
        tiles.put("tile10_7", tile10_7);
        tiles.put("tile10_8", tile10_8);
        tiles.put("tile10_9", tile10_9);
        tiles.put("tile10_10", tile10_10);
        tiles.put("tile10_11", tile10_11);
        tiles.put("tile10_12", tile10_12);
        tiles.put("tile10_13", tile10_13);
        tiles.put("tile10_14", tile10_14);
        tiles.put("tile10_15", tile10_15);
        tiles.put("tile11_0", tile11_0);
        tiles.put("tile11_1", tile11_1);
        tiles.put("tile11_2", tile11_2);
        tiles.put("tile11_3", tile11_3);
        tiles.put("tile11_4", tile11_4);
        tiles.put("tile11_5", tile11_5);
        tiles.put("tile11_6", tile11_6);
        tiles.put("tile11_7", tile11_7);
        tiles.put("tile11_8", tile11_8);
        tiles.put("tile11_9", tile11_9);
        tiles.put("tile11_10", tile11_10);
        tiles.put("tile11_11", tile11_11);
        tiles.put("tile11_12", tile11_12);
        tiles.put("tile11_13", tile11_13);
        tiles.put("tile11_14", tile11_14);
        tiles.put("tile11_15", tile11_15);
        tiles.put("tile12_0", tile12_0);
        tiles.put("tile12_1", tile12_1);
        tiles.put("tile12_2", tile12_2);
        tiles.put("tile12_3", tile12_3);
        tiles.put("tile12_4", tile12_4);
        tiles.put("tile12_5", tile12_5);
        tiles.put("tile12_6", tile12_6);
        tiles.put("tile12_7", tile12_7);
        tiles.put("tile12_8", tile12_8);
        tiles.put("tile12_9", tile12_9);
        tiles.put("tile12_10", tile12_10);
        tiles.put("tile12_11", tile12_11);
        tiles.put("tile12_12", tile12_12);
        tiles.put("tile12_13", tile12_13);
        tiles.put("tile12_14", tile12_14);
        tiles.put("tile12_15", tile12_15);
        tiles.put("tile13_0", tile13_0);
        tiles.put("tile13_1", tile13_1);
        tiles.put("tile13_2", tile13_2);
        tiles.put("tile13_3", tile13_3);
        tiles.put("tile13_4", tile13_4);
        tiles.put("tile13_5", tile13_5);
        tiles.put("tile13_6", tile13_6);
        tiles.put("tile13_7", tile13_7);
        tiles.put("tile13_8", tile13_8);
        tiles.put("tile13_9", tile13_9);
        tiles.put("tile13_10", tile13_10);
        tiles.put("tile13_11", tile13_11);
        tiles.put("tile13_12", tile13_12);
        tiles.put("tile13_13", tile13_13);
        tiles.put("tile13_14", tile13_14);
        tiles.put("tile13_15", tile13_15);
        tiles.put("tile14_0", tile14_0);
        tiles.put("tile14_1", tile14_1);
        tiles.put("tile14_2", tile14_2);
        tiles.put("tile14_3", tile14_3);
        tiles.put("tile14_4", tile14_4);
        tiles.put("tile14_5", tile14_5);
        tiles.put("tile14_6", tile14_6);
        tiles.put("tile14_7", tile14_7);
        tiles.put("tile14_8", tile14_8);
        tiles.put("tile14_9", tile14_9);
        tiles.put("tile14_10", tile14_10);
        tiles.put("tile14_11", tile14_11);
        tiles.put("tile14_12", tile14_12);
        tiles.put("tile14_13", tile14_13);
        tiles.put("tile14_14", tile14_14);
        tiles.put("tile14_15", tile14_15);
        tiles.put("tile15_0", tile15_0);
        tiles.put("tile15_1", tile15_1);
        tiles.put("tile15_2", tile15_2);
        tiles.put("tile15_3", tile15_3);
        tiles.put("tile15_4", tile15_4);
        tiles.put("tile15_5", tile15_5);
        tiles.put("tile15_6", tile15_6);
        tiles.put("tile15_7", tile15_7);
        tiles.put("tile15_8", tile15_8);
        tiles.put("tile15_9", tile15_9);
        tiles.put("tile15_10", tile15_10);
        tiles.put("tile15_11", tile15_11);
        tiles.put("tile15_12", tile15_12);
        tiles.put("tile15_13", tile15_13);
        tiles.put("tile15_14", tile15_14);
        tiles.put("tile15_15", tile15_15);
        
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

        start = new javax.swing.JButton();
        reset = new javax.swing.JButton();
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
        tile6_0 = new javax.swing.JLabel();
        tile3_0 = new javax.swing.JLabel();
        tile1_11 = new javax.swing.JLabel();
        tile2_9 = new javax.swing.JLabel();
        tile10_15 = new javax.swing.JLabel();
        tile9_1 = new javax.swing.JLabel();
        tile2_12 = new javax.swing.JLabel();
        tile1_15 = new javax.swing.JLabel();
        tile14_8 = new javax.swing.JLabel();
        tile5_4 = new javax.swing.JLabel();
        tile14_10 = new javax.swing.JLabel();
        tile3_8 = new javax.swing.JLabel();
        tile10_14 = new javax.swing.JLabel();
        tile9_5 = new javax.swing.JLabel();
        tile2_3 = new javax.swing.JLabel();
        tile15_10 = new javax.swing.JLabel();
        tile1_1 = new javax.swing.JLabel();
        tile11_3 = new javax.swing.JLabel();
        tile4_3 = new javax.swing.JLabel();
        tile7_4 = new javax.swing.JLabel();
        tile9_9 = new javax.swing.JLabel();
        tile14_13 = new javax.swing.JLabel();
        tile3_12 = new javax.swing.JLabel();
        tile13_1 = new javax.swing.JLabel();
        tile10_12 = new javax.swing.JLabel();
        tile11_9 = new javax.swing.JLabel();
        tile4_10 = new javax.swing.JLabel();
        tile9_13 = new javax.swing.JLabel();
        tile8_11 = new javax.swing.JLabel();
        tile13_8 = new javax.swing.JLabel();
        tile10_11 = new javax.swing.JLabel();
        tile11_1 = new javax.swing.JLabel();
        tile3_1 = new javax.swing.JLabel();
        tile1_4 = new javax.swing.JLabel();
        tile5_0 = new javax.swing.JLabel();
        tile4_12 = new javax.swing.JLabel();
        tile5_1 = new javax.swing.JLabel();
        tile4_1 = new javax.swing.JLabel();
        tile9_3 = new javax.swing.JLabel();
        tile5_11 = new javax.swing.JLabel();
        tile15_5 = new javax.swing.JLabel();
        tile2_14 = new javax.swing.JLabel();
        tile10_0 = new javax.swing.JLabel();
        tile3_3 = new javax.swing.JLabel();
        tile4_0 = new javax.swing.JLabel();
        tile14_5 = new javax.swing.JLabel();
        tile14_15 = new javax.swing.JLabel();
        tile8_7 = new javax.swing.JLabel();
        tile12_0 = new javax.swing.JLabel();
        tile10_1 = new javax.swing.JLabel();
        tile0_12 = new javax.swing.JLabel();
        tile0_11 = new javax.swing.JLabel();
        tile12_10 = new javax.swing.JLabel();
        tile4_2 = new javax.swing.JLabel();
        tile9_4 = new javax.swing.JLabel();
        tile11_6 = new javax.swing.JLabel();
        tile12_7 = new javax.swing.JLabel();
        tile10_3 = new javax.swing.JLabel();
        tile5_10 = new javax.swing.JLabel();
        tile11_12 = new javax.swing.JLabel();
        tile11_8 = new javax.swing.JLabel();
        tile14_14 = new javax.swing.JLabel();
        tile0_3 = new javax.swing.JLabel();
        tile15_7 = new javax.swing.JLabel();
        tile8_6 = new javax.swing.JLabel();
        tile2_5 = new javax.swing.JLabel();
        tile12_2 = new javax.swing.JLabel();
        tile14_2 = new javax.swing.JLabel();
        tile8_9 = new javax.swing.JLabel();
        tile13_7 = new javax.swing.JLabel();
        tile15_8 = new javax.swing.JLabel();
        tile11_5 = new javax.swing.JLabel();
        tile11_14 = new javax.swing.JLabel();
        tile5_6 = new javax.swing.JLabel();
        tile15_15 = new javax.swing.JLabel();
        tile11_4 = new javax.swing.JLabel();
        tile6_1 = new javax.swing.JLabel();
        tile15_3 = new javax.swing.JLabel();
        tile6_12 = new javax.swing.JLabel();
        tile8_1 = new javax.swing.JLabel();
        tile11_13 = new javax.swing.JLabel();
        tile4_9 = new javax.swing.JLabel();
        tile1_14 = new javax.swing.JLabel();
        tile4_8 = new javax.swing.JLabel();
        tile0_1 = new javax.swing.JLabel();
        tile7_6 = new javax.swing.JLabel();
        tile10_7 = new javax.swing.JLabel();
        tile13_11 = new javax.swing.JLabel();
        tile0_2 = new javax.swing.JLabel();
        tile12_3 = new javax.swing.JLabel();
        tile0_7 = new javax.swing.JLabel();
        tile2_1 = new javax.swing.JLabel();
        tile4_14 = new javax.swing.JLabel();
        tile9_6 = new javax.swing.JLabel();
        tile12_14 = new javax.swing.JLabel();
        tile6_2 = new javax.swing.JLabel();
        tile14_9 = new javax.swing.JLabel();
        tile0_13 = new javax.swing.JLabel();
        tile1_5 = new javax.swing.JLabel();
        tile9_12 = new javax.swing.JLabel();
        tile2_0 = new javax.swing.JLabel();
        tile9_8 = new javax.swing.JLabel();
        tile3_5 = new javax.swing.JLabel();
        tile15_14 = new javax.swing.JLabel();
        tile7_10 = new javax.swing.JLabel();
        tile13_12 = new javax.swing.JLabel();
        tile4_4 = new javax.swing.JLabel();
        tile10_9 = new javax.swing.JLabel();
        tile8_15 = new javax.swing.JLabel();
        tile2_15 = new javax.swing.JLabel();
        tile11_11 = new javax.swing.JLabel();
        tile2_8 = new javax.swing.JLabel();
        tile6_10 = new javax.swing.JLabel();
        tile8_8 = new javax.swing.JLabel();
        tile15_13 = new javax.swing.JLabel();
        tile11_10 = new javax.swing.JLabel();
        tile3_13 = new javax.swing.JLabel();
        tile4_6 = new javax.swing.JLabel();
        tile6_8 = new javax.swing.JLabel();
        tile0_4 = new javax.swing.JLabel();
        tile1_6 = new javax.swing.JLabel();
        tile3_6 = new javax.swing.JLabel();
        tile6_14 = new javax.swing.JLabel();
        tile8_2 = new javax.swing.JLabel();
        tile0_5 = new javax.swing.JLabel();
        tile7_7 = new javax.swing.JLabel();
        tile1_8 = new javax.swing.JLabel();
        tile6_11 = new javax.swing.JLabel();
        tile13_14 = new javax.swing.JLabel();
        tile12_4 = new javax.swing.JLabel();
        tile10_2 = new javax.swing.JLabel();
        tile11_15 = new javax.swing.JLabel();
        tile0_9 = new javax.swing.JLabel();
        tile7_9 = new javax.swing.JLabel();
        tile3_14 = new javax.swing.JLabel();
        tile12_13 = new javax.swing.JLabel();
        tile12_6 = new javax.swing.JLabel();
        tile2_6 = new javax.swing.JLabel();
        tile5_7 = new javax.swing.JLabel();
        tile6_4 = new javax.swing.JLabel();
        tile7_3 = new javax.swing.JLabel();
        tile9_10 = new javax.swing.JLabel();
        tile7_15 = new javax.swing.JLabel();
        tile13_10 = new javax.swing.JLabel();
        tile15_0 = new javax.swing.JLabel();
        tile13_2 = new javax.swing.JLabel();
        tile13_9 = new javax.swing.JLabel();
        tile3_10 = new javax.swing.JLabel();
        tile12_12 = new javax.swing.JLabel();
        tile5_13 = new javax.swing.JLabel();
        tile8_12 = new javax.swing.JLabel();
        tile2_11 = new javax.swing.JLabel();
        tile8_14 = new javax.swing.JLabel();
        tile4_5 = new javax.swing.JLabel();
        tile1_0 = new javax.swing.JLabel();
        tile2_10 = new javax.swing.JLabel();
        tile2_2 = new javax.swing.JLabel();
        tile5_3 = new javax.swing.JLabel();
        tile1_3 = new javax.swing.JLabel();
        tile13_3 = new javax.swing.JLabel();
        tile12_9 = new javax.swing.JLabel();
        tile6_7 = new javax.swing.JLabel();
        tile15_4 = new javax.swing.JLabel();
        tile12_15 = new javax.swing.JLabel();
        tile8_4 = new javax.swing.JLabel();
        tile3_11 = new javax.swing.JLabel();
        tile9_2 = new javax.swing.JLabel();
        tile2_13 = new javax.swing.JLabel();
        tile4_13 = new javax.swing.JLabel();
        tile5_14 = new javax.swing.JLabel();
        tile15_1 = new javax.swing.JLabel();
        tile10_10 = new javax.swing.JLabel();
        tile9_15 = new javax.swing.JLabel();
        tile1_9 = new javax.swing.JLabel();
        tile9_7 = new javax.swing.JLabel();
        tile15_2 = new javax.swing.JLabel();
        tile8_10 = new javax.swing.JLabel();
        tile15_6 = new javax.swing.JLabel();
        tile13_15 = new javax.swing.JLabel();
        tile14_12 = new javax.swing.JLabel();
        tile5_5 = new javax.swing.JLabel();
        tile6_6 = new javax.swing.JLabel();
        tile13_4 = new javax.swing.JLabel();
        tile7_1 = new javax.swing.JLabel();
        tile14_6 = new javax.swing.JLabel();
        tile1_10 = new javax.swing.JLabel();
        tile0_0 = new javax.swing.JLabel();
        tile1_12 = new javax.swing.JLabel();
        tile6_9 = new javax.swing.JLabel();
        tile0_10 = new javax.swing.JLabel();
        tile4_11 = new javax.swing.JLabel();
        tile4_7 = new javax.swing.JLabel();
        tile13_0 = new javax.swing.JLabel();
        tile4_15 = new javax.swing.JLabel();
        tile6_3 = new javax.swing.JLabel();
        tile5_8 = new javax.swing.JLabel();
        tile1_2 = new javax.swing.JLabel();
        tile3_7 = new javax.swing.JLabel();
        tile8_3 = new javax.swing.JLabel();
        tile5_9 = new javax.swing.JLabel();
        tile14_4 = new javax.swing.JLabel();
        tile8_5 = new javax.swing.JLabel();
        tile7_12 = new javax.swing.JLabel();
        tile15_11 = new javax.swing.JLabel();
        tile12_1 = new javax.swing.JLabel();
        tile2_7 = new javax.swing.JLabel();
        tile3_4 = new javax.swing.JLabel();
        tile10_6 = new javax.swing.JLabel();
        tile14_0 = new javax.swing.JLabel();
        tile15_9 = new javax.swing.JLabel();
        tile7_0 = new javax.swing.JLabel();
        tile10_8 = new javax.swing.JLabel();
        tile5_15 = new javax.swing.JLabel();
        tile10_5 = new javax.swing.JLabel();
        tile7_13 = new javax.swing.JLabel();
        tile12_5 = new javax.swing.JLabel();
        tile13_13 = new javax.swing.JLabel();
        tile7_8 = new javax.swing.JLabel();
        tile7_2 = new javax.swing.JLabel();
        tile7_11 = new javax.swing.JLabel();
        tile15_12 = new javax.swing.JLabel();
        tile7_5 = new javax.swing.JLabel();
        tile9_0 = new javax.swing.JLabel();
        tile0_8 = new javax.swing.JLabel();
        tile9_11 = new javax.swing.JLabel();
        tile10_13 = new javax.swing.JLabel();
        tile6_15 = new javax.swing.JLabel();
        tile11_2 = new javax.swing.JLabel();
        tile0_15 = new javax.swing.JLabel();
        tile0_6 = new javax.swing.JLabel();
        tile2_4 = new javax.swing.JLabel();
        tile8_0 = new javax.swing.JLabel();
        tile1_13 = new javax.swing.JLabel();
        tile13_6 = new javax.swing.JLabel();
        tile3_9 = new javax.swing.JLabel();
        tile5_12 = new javax.swing.JLabel();
        tile7_14 = new javax.swing.JLabel();
        tile14_7 = new javax.swing.JLabel();
        tile11_7 = new javax.swing.JLabel();
        tile6_13 = new javax.swing.JLabel();
        tile12_11 = new javax.swing.JLabel();
        tile3_15 = new javax.swing.JLabel();
        tile5_2 = new javax.swing.JLabel();
        tile6_5 = new javax.swing.JLabel();
        tile14_3 = new javax.swing.JLabel();
        tile1_7 = new javax.swing.JLabel();
        tile14_11 = new javax.swing.JLabel();
        tile11_0 = new javax.swing.JLabel();
        tile3_2 = new javax.swing.JLabel();
        tile8_13 = new javax.swing.JLabel();
        tile13_5 = new javax.swing.JLabel();
        tile14_1 = new javax.swing.JLabel();
        tile10_4 = new javax.swing.JLabel();
        tile12_8 = new javax.swing.JLabel();
        tile0_14 = new javax.swing.JLabel();
        tile9_14 = new javax.swing.JLabel();
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

        start.setText("Start [S]");
        start.setFocusable(false);
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        reset.setText("Reset [R]");
        reset.setEnabled(false);
        reset.setFocusable(false);
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
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
        arrowIndicator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bow_arrow8.png"))); // NOI18N

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

        tile6_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile10_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile10_15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile9_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile9_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile14_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile14_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile14_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile14_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile10_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile10_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile9_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile9_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile15_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile15_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile11_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile11_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile9_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile9_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile14_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile14_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile13_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile13_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile10_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile10_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile11_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile11_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile9_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile9_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile8_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile8_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile13_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile13_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile10_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile10_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile11_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile11_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile9_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile9_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile15_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile15_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile10_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile10_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile14_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile14_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile14_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile14_15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile8_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile8_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile12_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile12_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile10_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile10_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile12_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile12_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile9_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile9_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile11_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile11_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile12_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile12_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile10_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile10_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile11_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile11_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile11_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile11_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile14_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile14_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile15_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile15_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile8_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile8_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile12_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile12_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile14_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile14_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile8_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile8_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile13_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile13_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile15_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile15_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile11_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile11_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile11_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile11_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile15_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile15_15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile11_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile11_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile6_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile15_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile15_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile6_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile8_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile8_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile11_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile11_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile10_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile10_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile13_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile13_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile12_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile12_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile9_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile9_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile12_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile12_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile6_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile14_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile14_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile9_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile9_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile9_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile9_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile15_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile15_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile13_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile13_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile10_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile10_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile8_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile8_15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile11_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile11_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile6_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile8_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile8_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile15_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile15_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile11_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile11_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile6_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile6_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile8_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile8_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile6_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile13_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile13_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile12_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile12_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile10_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile10_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile11_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile11_15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile12_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile12_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile12_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile12_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile6_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile9_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile9_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile13_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile13_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile15_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/scaled/e_p.png"))); // NOI18N
        tile15_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile13_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile13_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile13_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile13_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile12_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile12_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile8_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile8_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile8_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile8_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile13_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile13_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile12_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile12_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile6_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile15_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile15_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile12_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile12_15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile8_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile8_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile9_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile9_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile15_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile15_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile10_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile10_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile9_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile9_15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile9_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile9_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile15_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile15_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile8_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile8_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile15_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile15_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile13_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile13_15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile14_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile14_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile6_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile13_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile13_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile14_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile14_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile6_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile13_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile13_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile4_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile4_15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile6_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile8_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile8_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile14_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile14_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile8_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile8_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile15_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile15_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile12_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile12_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile10_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile10_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile14_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile14_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile15_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile15_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile10_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile10_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile10_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile10_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile12_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile12_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile13_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile13_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile15_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile15_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile9_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile9_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile9_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile9_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile10_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile10_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile6_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile11_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile11_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile2_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile2_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile8_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile8_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile13_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile13_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile7_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile7_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile14_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile14_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile11_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile11_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile6_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile12_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile12_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile5_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile5_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile6_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile6_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile14_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile14_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile1_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile1_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile14_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile14_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile11_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile11_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile3_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile3_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile8_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile8_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile13_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile13_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile14_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile14_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile10_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile10_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile12_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile12_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile0_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile0_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tile9_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/e.png"))); // NOI18N
        tile9_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout tilePanelLayout = new javax.swing.GroupLayout(tilePanel);
        tilePanel.setLayout(tilePanelLayout);
        tilePanelLayout.setHorizontalGroup(
            tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile0_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile0_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile0_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile0_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile0_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile0_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile0_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile0_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile0_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile0_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile0_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile0_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile0_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile0_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile0_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile0_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile1_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile1_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile1_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile1_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile1_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile1_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile1_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile1_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile1_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile1_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile1_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile1_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile2_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile2_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile2_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile2_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile2_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile2_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile2_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile2_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile2_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile2_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile2_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile2_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile3_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile3_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile3_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile3_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile3_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile3_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile3_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile3_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile3_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile3_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile3_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile3_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile4_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile4_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile4_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile4_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile4_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile4_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile4_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile4_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile4_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile4_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile4_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile4_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile5_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile5_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile5_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile5_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile5_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile5_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile5_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile5_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile5_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile5_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile5_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile5_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile5_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile5_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile6_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile6_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile6_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile6_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile6_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile6_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile6_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile6_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile6_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile6_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile6_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile6_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile6_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile6_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile6_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile6_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile7_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile7_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile7_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile7_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile7_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile7_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile7_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile7_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile7_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile7_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile7_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile7_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile7_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile7_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile8_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile8_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile8_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile8_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile8_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile8_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile8_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile8_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile8_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile8_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile8_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile8_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile8_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile8_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile8_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile8_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile9_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile9_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile9_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile9_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile9_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile9_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile9_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile9_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile9_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile9_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile9_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile9_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile9_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile9_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile9_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile9_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile10_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile10_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile10_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile10_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile10_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile10_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile10_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile10_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile10_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile10_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile10_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile10_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile10_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile10_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile10_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile10_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile11_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile11_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile11_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile11_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile11_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile11_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile11_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile11_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile11_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile11_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile11_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile11_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile11_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile11_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile11_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile11_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile12_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile12_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile12_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile12_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile12_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile12_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile12_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile12_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile12_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile12_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile12_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile12_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile12_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile12_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile12_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile12_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile13_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile13_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile13_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile13_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile13_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile13_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile13_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile13_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile13_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile13_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile13_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile13_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile13_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile13_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile13_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile13_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile14_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile14_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile14_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile14_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile14_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile14_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile14_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile14_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile14_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile14_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile14_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile14_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile14_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile14_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile14_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile14_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tilePanelLayout.createSequentialGroup()
                        .addComponent(tile15_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile15_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile15_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile15_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile15_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile15_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile15_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile15_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile15_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile15_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile15_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile15_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile15_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile15_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile15_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tile15_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        tilePanelLayout.setVerticalGroup(
            tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile0_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile0_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile0_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile0_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile0_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile0_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile0_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile0_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile0_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile0_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile0_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile0_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile0_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile0_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile0_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile0_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile1_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile1_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile1_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile1_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile1_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile1_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile1_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile1_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile1_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile1_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile1_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile1_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile2_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile2_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile2_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile2_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile2_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile2_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile2_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile2_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile2_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile2_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile2_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile2_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile3_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile3_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile3_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile3_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile3_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile3_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile3_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile3_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile3_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile3_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile3_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile3_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile4_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile4_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile4_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile4_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile4_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile4_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile4_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile4_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile4_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile4_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile4_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile4_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile5_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile5_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile5_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile5_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile5_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile5_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile5_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile5_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile5_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile5_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile5_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile5_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile5_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile5_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile6_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile6_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile6_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile6_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile6_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile6_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile6_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile6_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile6_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile6_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile6_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile6_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile6_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile6_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile6_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile6_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile7_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile7_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile7_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile7_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile7_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile7_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile7_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile7_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile7_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile7_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile7_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile7_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile7_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile7_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile8_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile8_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile8_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile8_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile8_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile8_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile8_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile8_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile8_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile8_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile8_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile8_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile8_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile8_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile8_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile8_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile9_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile9_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile9_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile9_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile9_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile9_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile9_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile9_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile9_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile9_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile9_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile9_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile9_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile9_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile9_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile9_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile10_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile10_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile10_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile10_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile10_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile10_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile10_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile10_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile10_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile10_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile10_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile10_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile10_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile10_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile10_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile10_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile11_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile11_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile11_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile11_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile11_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile11_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile11_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile11_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile11_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile11_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile11_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile11_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile11_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile11_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile11_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile11_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile12_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile12_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile12_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile12_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile12_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile12_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile12_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile12_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile12_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile12_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile12_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile12_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile12_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile12_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile12_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile12_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile13_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile13_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile13_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile13_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile13_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile13_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile13_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile13_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile13_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile13_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile13_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile13_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile13_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile13_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile13_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile13_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile14_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile14_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile14_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile14_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile14_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile14_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile14_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile14_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile14_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile14_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile14_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile14_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile14_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile14_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile14_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile14_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tile15_15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile15_14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile15_13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile15_12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile15_11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile15_10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile15_9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile15_8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile15_7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile15_6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile15_5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile15_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile15_3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile15_2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile15_1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tile15_0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(scrollpane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
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
                                .addComponent(goldIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollpane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(tileScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
                .addContainerGap())
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
                        .addComponent(scrollpane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
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
                                    .addComponent(climb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollpane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tileScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        //start();
    }//GEN-LAST:event_startActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        //reset();
    }//GEN-LAST:event_resetActionPerformed

    private void arrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrowActionPerformed
        //arrow();
    }//GEN-LAST:event_arrowActionPerformed

    private void upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upActionPerformed
        //up();
    }//GEN-LAST:event_upActionPerformed

    private void rightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightActionPerformed
        //right();
    }//GEN-LAST:event_rightActionPerformed

    private void grabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabActionPerformed
        //grab();
    }//GEN-LAST:event_grabActionPerformed

    private void leftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftActionPerformed
        //left();
    }//GEN-LAST:event_leftActionPerformed

    private void downActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downActionPerformed
        //down();
    }//GEN-LAST:event_downActionPerformed

    private void climbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_climbActionPerformed
        //climb();
    }//GEN-LAST:event_climbActionPerformed

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
    
    /**
     * Basically "flips" all of the images to their uncovered sides
     * Uses the hashmap and a loop to change each label
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
     * boolean that tells it if it needs the player on the piece
     * Uses the hashmap to find which label to change
     *
     * @param x, the column of the label table
     * @param y, the row of the label table
     * @param p, boolean to see if player is needed on the piece
     */
    public void updateLabel(int x, int y, boolean p) {

        String name = "tile" + y + "_" + x;
        if(p) {
            tiles.get(name).setIcon(new ImageIcon(game.board[y][x].getUncoveredImage_p()));
        } else {
            tiles.get(name).setIcon(new ImageIcon(game.board[y][x].getUncoveredImage()));
        }
    }
    
    /**
     * Function to update the arrow buttons, basically hindering the user from making any bad moves.
     * Basically just disables the button if the user won't be able to go there.
     */
    public void updateDirections() {
        if (game.getCurrY() == 0) {
            up.setEnabled(false);
        } else {
            up.setEnabled(true);
        }
        if (game.getCurrY() == SIZE-1) {
            down.setEnabled(false);
        } else {
            down.setEnabled(true);
        }
        if (game.getCurrX() == 0) {
            left.setEnabled(false);
        } else {
            left.setEnabled(true);
        }
        if (game.getCurrX() == SIZE-1) {
            right.setEnabled(false);
        } else {
            right.setEnabled(true);
        }
    }

    /**
     * Checks the tile for anything in it and sets the Text object to a random
     * text in the Message class
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
     * @param c the column the wumpus is in
     * @param r the row the wumpus is in
     */
    public void killWumpus(int c, int r) {

        // kill the wumpus in the game
        game.board[r][c].setDeadWumpus(true);

        // update graphics
        text.setText(msg.getArrowHit());
        game.board[r][c].setUncoveredImage_p("wd");
        game.board[r][c].setUncoveredImage("wd");
        System.out.println(game.board[r][c].getUncoveredImage_p());
        game.board[r][c].setWumpus(false);
        updateLabel(game.getCurrX(), game.getCurrY(), true);
    }

    /**
     * Ends the game
     * Updates the graphics, then calls the endgame method in game
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
        Main.closeBoard256();
        Main.openBoard256();
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
                game.board[game.getCurrY()][game.getCurrX()].setImages("b", SIZE);
            }
            if (game.board[game.getCurrY()][game.getCurrX()].hasStench()) {
                game.board[game.getCurrY()][game.getCurrX()].setImages("s", SIZE);
            }
            if (game.board[game.getCurrY()][game.getCurrX()].hasBreeze()
                    && game.board[game.getCurrY()][game.getCurrX()].hasStench()) {
                game.board[game.getCurrY()][game.getCurrX()].setImages("sb", SIZE);
            }
            if (!game.board[game.getCurrY()][game.getCurrX()].hasBreeze()
                    && !game.board[game.getCurrY()][game.getCurrX()].hasStench()) {
                game.board[game.getCurrY()][game.getCurrX()].setImages("e", SIZE);
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
            java.util.logging.Logger.getLogger(Board256.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Board256.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Board256.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Board256.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Board256().setVisible(true);
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
    private javax.swing.JLabel tile0_10;
    private javax.swing.JLabel tile0_11;
    private javax.swing.JLabel tile0_12;
    private javax.swing.JLabel tile0_13;
    private javax.swing.JLabel tile0_14;
    private javax.swing.JLabel tile0_15;
    private javax.swing.JLabel tile0_2;
    private javax.swing.JLabel tile0_3;
    private javax.swing.JLabel tile0_4;
    private javax.swing.JLabel tile0_5;
    private javax.swing.JLabel tile0_6;
    private javax.swing.JLabel tile0_7;
    private javax.swing.JLabel tile0_8;
    private javax.swing.JLabel tile0_9;
    private javax.swing.JLabel tile10_0;
    private javax.swing.JLabel tile10_1;
    private javax.swing.JLabel tile10_10;
    private javax.swing.JLabel tile10_11;
    private javax.swing.JLabel tile10_12;
    private javax.swing.JLabel tile10_13;
    private javax.swing.JLabel tile10_14;
    private javax.swing.JLabel tile10_15;
    private javax.swing.JLabel tile10_2;
    private javax.swing.JLabel tile10_3;
    private javax.swing.JLabel tile10_4;
    private javax.swing.JLabel tile10_5;
    private javax.swing.JLabel tile10_6;
    private javax.swing.JLabel tile10_7;
    private javax.swing.JLabel tile10_8;
    private javax.swing.JLabel tile10_9;
    private javax.swing.JLabel tile11_0;
    private javax.swing.JLabel tile11_1;
    private javax.swing.JLabel tile11_10;
    private javax.swing.JLabel tile11_11;
    private javax.swing.JLabel tile11_12;
    private javax.swing.JLabel tile11_13;
    private javax.swing.JLabel tile11_14;
    private javax.swing.JLabel tile11_15;
    private javax.swing.JLabel tile11_2;
    private javax.swing.JLabel tile11_3;
    private javax.swing.JLabel tile11_4;
    private javax.swing.JLabel tile11_5;
    private javax.swing.JLabel tile11_6;
    private javax.swing.JLabel tile11_7;
    private javax.swing.JLabel tile11_8;
    private javax.swing.JLabel tile11_9;
    private javax.swing.JLabel tile12_0;
    private javax.swing.JLabel tile12_1;
    private javax.swing.JLabel tile12_10;
    private javax.swing.JLabel tile12_11;
    private javax.swing.JLabel tile12_12;
    private javax.swing.JLabel tile12_13;
    private javax.swing.JLabel tile12_14;
    private javax.swing.JLabel tile12_15;
    private javax.swing.JLabel tile12_2;
    private javax.swing.JLabel tile12_3;
    private javax.swing.JLabel tile12_4;
    private javax.swing.JLabel tile12_5;
    private javax.swing.JLabel tile12_6;
    private javax.swing.JLabel tile12_7;
    private javax.swing.JLabel tile12_8;
    private javax.swing.JLabel tile12_9;
    private javax.swing.JLabel tile13_0;
    private javax.swing.JLabel tile13_1;
    private javax.swing.JLabel tile13_10;
    private javax.swing.JLabel tile13_11;
    private javax.swing.JLabel tile13_12;
    private javax.swing.JLabel tile13_13;
    private javax.swing.JLabel tile13_14;
    private javax.swing.JLabel tile13_15;
    private javax.swing.JLabel tile13_2;
    private javax.swing.JLabel tile13_3;
    private javax.swing.JLabel tile13_4;
    private javax.swing.JLabel tile13_5;
    private javax.swing.JLabel tile13_6;
    private javax.swing.JLabel tile13_7;
    private javax.swing.JLabel tile13_8;
    private javax.swing.JLabel tile13_9;
    private javax.swing.JLabel tile14_0;
    private javax.swing.JLabel tile14_1;
    private javax.swing.JLabel tile14_10;
    private javax.swing.JLabel tile14_11;
    private javax.swing.JLabel tile14_12;
    private javax.swing.JLabel tile14_13;
    private javax.swing.JLabel tile14_14;
    private javax.swing.JLabel tile14_15;
    private javax.swing.JLabel tile14_2;
    private javax.swing.JLabel tile14_3;
    private javax.swing.JLabel tile14_4;
    private javax.swing.JLabel tile14_5;
    private javax.swing.JLabel tile14_6;
    private javax.swing.JLabel tile14_7;
    private javax.swing.JLabel tile14_8;
    private javax.swing.JLabel tile14_9;
    private javax.swing.JLabel tile15_0;
    private javax.swing.JLabel tile15_1;
    private javax.swing.JLabel tile15_10;
    private javax.swing.JLabel tile15_11;
    private javax.swing.JLabel tile15_12;
    private javax.swing.JLabel tile15_13;
    private javax.swing.JLabel tile15_14;
    private javax.swing.JLabel tile15_15;
    private javax.swing.JLabel tile15_2;
    private javax.swing.JLabel tile15_3;
    private javax.swing.JLabel tile15_4;
    private javax.swing.JLabel tile15_5;
    private javax.swing.JLabel tile15_6;
    private javax.swing.JLabel tile15_7;
    private javax.swing.JLabel tile15_8;
    private javax.swing.JLabel tile15_9;
    private javax.swing.JLabel tile1_0;
    private javax.swing.JLabel tile1_1;
    private javax.swing.JLabel tile1_10;
    private javax.swing.JLabel tile1_11;
    private javax.swing.JLabel tile1_12;
    private javax.swing.JLabel tile1_13;
    private javax.swing.JLabel tile1_14;
    private javax.swing.JLabel tile1_15;
    private javax.swing.JLabel tile1_2;
    private javax.swing.JLabel tile1_3;
    private javax.swing.JLabel tile1_4;
    private javax.swing.JLabel tile1_5;
    private javax.swing.JLabel tile1_6;
    private javax.swing.JLabel tile1_7;
    private javax.swing.JLabel tile1_8;
    private javax.swing.JLabel tile1_9;
    private javax.swing.JLabel tile2_0;
    private javax.swing.JLabel tile2_1;
    private javax.swing.JLabel tile2_10;
    private javax.swing.JLabel tile2_11;
    private javax.swing.JLabel tile2_12;
    private javax.swing.JLabel tile2_13;
    private javax.swing.JLabel tile2_14;
    private javax.swing.JLabel tile2_15;
    private javax.swing.JLabel tile2_2;
    private javax.swing.JLabel tile2_3;
    private javax.swing.JLabel tile2_4;
    private javax.swing.JLabel tile2_5;
    private javax.swing.JLabel tile2_6;
    private javax.swing.JLabel tile2_7;
    private javax.swing.JLabel tile2_8;
    private javax.swing.JLabel tile2_9;
    private javax.swing.JLabel tile3_0;
    private javax.swing.JLabel tile3_1;
    private javax.swing.JLabel tile3_10;
    private javax.swing.JLabel tile3_11;
    private javax.swing.JLabel tile3_12;
    private javax.swing.JLabel tile3_13;
    private javax.swing.JLabel tile3_14;
    private javax.swing.JLabel tile3_15;
    private javax.swing.JLabel tile3_2;
    private javax.swing.JLabel tile3_3;
    private javax.swing.JLabel tile3_4;
    private javax.swing.JLabel tile3_5;
    private javax.swing.JLabel tile3_6;
    private javax.swing.JLabel tile3_7;
    private javax.swing.JLabel tile3_8;
    private javax.swing.JLabel tile3_9;
    private javax.swing.JLabel tile4_0;
    private javax.swing.JLabel tile4_1;
    private javax.swing.JLabel tile4_10;
    private javax.swing.JLabel tile4_11;
    private javax.swing.JLabel tile4_12;
    private javax.swing.JLabel tile4_13;
    private javax.swing.JLabel tile4_14;
    private javax.swing.JLabel tile4_15;
    private javax.swing.JLabel tile4_2;
    private javax.swing.JLabel tile4_3;
    private javax.swing.JLabel tile4_4;
    private javax.swing.JLabel tile4_5;
    private javax.swing.JLabel tile4_6;
    private javax.swing.JLabel tile4_7;
    private javax.swing.JLabel tile4_8;
    private javax.swing.JLabel tile4_9;
    private javax.swing.JLabel tile5_0;
    private javax.swing.JLabel tile5_1;
    private javax.swing.JLabel tile5_10;
    private javax.swing.JLabel tile5_11;
    private javax.swing.JLabel tile5_12;
    private javax.swing.JLabel tile5_13;
    private javax.swing.JLabel tile5_14;
    private javax.swing.JLabel tile5_15;
    private javax.swing.JLabel tile5_2;
    private javax.swing.JLabel tile5_3;
    private javax.swing.JLabel tile5_4;
    private javax.swing.JLabel tile5_5;
    private javax.swing.JLabel tile5_6;
    private javax.swing.JLabel tile5_7;
    private javax.swing.JLabel tile5_8;
    private javax.swing.JLabel tile5_9;
    private javax.swing.JLabel tile6_0;
    private javax.swing.JLabel tile6_1;
    private javax.swing.JLabel tile6_10;
    private javax.swing.JLabel tile6_11;
    private javax.swing.JLabel tile6_12;
    private javax.swing.JLabel tile6_13;
    private javax.swing.JLabel tile6_14;
    private javax.swing.JLabel tile6_15;
    private javax.swing.JLabel tile6_2;
    private javax.swing.JLabel tile6_3;
    private javax.swing.JLabel tile6_4;
    private javax.swing.JLabel tile6_5;
    private javax.swing.JLabel tile6_6;
    private javax.swing.JLabel tile6_7;
    private javax.swing.JLabel tile6_8;
    private javax.swing.JLabel tile6_9;
    private javax.swing.JLabel tile7_0;
    private javax.swing.JLabel tile7_1;
    private javax.swing.JLabel tile7_10;
    private javax.swing.JLabel tile7_11;
    private javax.swing.JLabel tile7_12;
    private javax.swing.JLabel tile7_13;
    private javax.swing.JLabel tile7_14;
    private javax.swing.JLabel tile7_15;
    private javax.swing.JLabel tile7_2;
    private javax.swing.JLabel tile7_3;
    private javax.swing.JLabel tile7_4;
    private javax.swing.JLabel tile7_5;
    private javax.swing.JLabel tile7_6;
    private javax.swing.JLabel tile7_7;
    private javax.swing.JLabel tile7_8;
    private javax.swing.JLabel tile7_9;
    private javax.swing.JLabel tile8_0;
    private javax.swing.JLabel tile8_1;
    private javax.swing.JLabel tile8_10;
    private javax.swing.JLabel tile8_11;
    private javax.swing.JLabel tile8_12;
    private javax.swing.JLabel tile8_13;
    private javax.swing.JLabel tile8_14;
    private javax.swing.JLabel tile8_15;
    private javax.swing.JLabel tile8_2;
    private javax.swing.JLabel tile8_3;
    private javax.swing.JLabel tile8_4;
    private javax.swing.JLabel tile8_5;
    private javax.swing.JLabel tile8_6;
    private javax.swing.JLabel tile8_7;
    private javax.swing.JLabel tile8_8;
    private javax.swing.JLabel tile8_9;
    private javax.swing.JLabel tile9_0;
    private javax.swing.JLabel tile9_1;
    private javax.swing.JLabel tile9_10;
    private javax.swing.JLabel tile9_11;
    private javax.swing.JLabel tile9_12;
    private javax.swing.JLabel tile9_13;
    private javax.swing.JLabel tile9_14;
    private javax.swing.JLabel tile9_15;
    private javax.swing.JLabel tile9_2;
    private javax.swing.JLabel tile9_3;
    private javax.swing.JLabel tile9_4;
    private javax.swing.JLabel tile9_5;
    private javax.swing.JLabel tile9_6;
    private javax.swing.JLabel tile9_7;
    private javax.swing.JLabel tile9_8;
    private javax.swing.JLabel tile9_9;
    private javax.swing.JPanel tilePanel;
    private javax.swing.JScrollPane tileScrollPane;
    private javax.swing.JButton up;
    private javax.swing.JMenuItem version;
    // End of variables declaration//GEN-END:variables
}
