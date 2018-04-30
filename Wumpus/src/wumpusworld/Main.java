/**
 * File:    Main.java
 * Desc:    This class is the main control class.  It controls the Swing 
 *          Components and their opening and closing.
 */

package wumpusworld;

import java.io.File;

/**
 * Main
 */
public class Main {

    // global variables
    static Intro intro;
    static Board16 board16;
    static Board64 board64;
    static Board256 board256;
    static Board16AI board16AI;
    static Board64AI board64AI;
    static Board256AI board256AI;
    static ScoreBoard scoreboard;
    static boolean AI;
    
    static int size;
    
    /**
     * If you're reading this, you probably know what main does
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // open the intro frame
        openIntro();
    }
    
    public int getSize() {
        return size;
    }
    
    /**
     * Opens the Intro frame to determine which game to play
     */
    public static void openIntro() {
        intro = new Intro();        
        intro.setLocationRelativeTo(null);
        intro.setVisible(true);
    }
    
    /**
     * Disposes the Intro frame
     */
    public static void closeIntro() {
        intro.dispose();
    }
    
    /**
     * Opens the game board JFrame with the proper attributes
     */
    public static void openBoard16() {
        size = 4;
        AI = false;
        board16 = new Board16();        
        board16.setLocationRelativeTo(null);
        board16.setVisible(true);
    }
    
    /**
     * Disposes the game board JFrame
     */
    public static void closeBoard16() {
        board16.dispose();
    }
    
    /**
     * Opens the game board JFrame with the proper attributes
     */
    public static void openBoard64() {
        size = 8;
        AI = false;
        board64 = new Board64();        
        board64.setLocationRelativeTo(null);
        board64.setVisible(true);
    }
    
    /**
     * Disposes the game board JFrame
     */
    public static void closeBoard64() {
        board64.dispose();
    }
    
    /**
     * Opens the game board JFrame with the proper attributes
     */
    public static void openBoard256() {
        size = 16;
        AI = false;
        board256 = new Board256();        
        board256.setLocationRelativeTo(null);
        board256.setVisible(true);
    }
    
    /**
     * Disposes the game board JFrame
     */
    public static void closeBoard256() {
        board256.dispose();
    }
    
    /**
     * Opens the game board JFrame with the proper attributes
     */
    public static void openBoard16AI() {
        cleanFiles();
        size = 4;
        AI = true;
        board16AI = new Board16AI();        
        board16AI.setLocationRelativeTo(null);
        board16AI.setVisible(true);
    }
    
    /**
     * Disposes the game board JFrame
     */
    public static void closeBoard16AI() {
        board16AI.dispose();
    }
    
    /**
     * Opens the game board JFrame with the proper attributes
     */
    public static void openBoard64AI() {
        size = 8;
        AI = true;
        board64AI = new Board64AI();        
        board64AI.setLocationRelativeTo(null);
        board64AI.setVisible(true);
    }
    
    /**
     * Disposes the game board JFrame
     */
    public static void closeBoard64AI() {
        board64AI.dispose();
    }
    
    /**
     * Opens the game board JFrame with the proper attributes
     */
    public static void openBoard256AI() {
        size = 16;
        AI = true;
        board256AI = new Board256AI();        
        board256AI.setLocationRelativeTo(null);
        board256AI.setVisible(true);
    }
    
    /**
     * Disposes the game board JFrame
     */
    public static void closeBoard256AI() {
        board256AI.dispose();
    }
    
    /**
     * Opens the score board JFrame with all the proper parameters
     * @param score, the score array to display
     * @param image, the image to display on the frame
     * @param header, the title of the score board
     */
    public static void openScoreBoard(int[] score, String image, String header) {
        scoreboard = new ScoreBoard();
        scoreboard.initializeScoreBoard(score, image, header);
        scoreboard.setLocationRelativeTo(null);
        scoreboard.setVisible(true);
    }
    
    /**
     * Disposes the score board JFrame
     */
    public static void closeScoreBoard() {
        scoreboard.dispose();
    }
    
    public static void cleanFiles()
    {
                try{
            File f = new File ("current.txt");
            f.delete();
        }catch (Exception e){
            
        }
        try{
            File f = new File ("discoveredBoard.txt");
            f.delete();
        }catch (Exception e){
            
        }
        try{
            File f = new File ("nextMove.txt");
            f.delete();
        }catch (Exception e){
            
        }try{
            File f = new File ("stack.txt");
            f.delete();
        }catch (Exception e){
            
        }
    }
}
