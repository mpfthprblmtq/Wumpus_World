/**
 * File:    IO.java
 * Desc:    This class prints out the board in a text file representation
 */

// package
package wumpusworld;

// imports
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class IO
 */
public class IO {

    /**
     * Iterates through the board to make the text file representation of the board
     * @param tiles, the board
     */
    public static void outBoard(Tile[][] tiles) {
        
        // some variables
        int length = tiles.length;
        int total = length * length;
        String line = "";
        int i = 0;
        int j = 0;
        
        // iterate through the board to make the line string
        for (int k = 0; k < total; k++) {
            
            line += getTile(tiles[i][j]) + " ";
            j++;
            if(j == length) {
                i++;
                j = 0;
            } else {
                
            }
        }
        
        // write to file
        try (PrintWriter writer = new PrintWriter("boardOut.txt", "UTF-8")) {
            writer.println(line);
            writer.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
    /**
     * Function that tests the tile for stuff
     * @param tile, the tile to check
     * @return the string representation of the tile
     */
    public static String getTile(Tile tile) {
        String str = "";
        
        if(tile.hasBreeze()) {
            str += "B";
        }
        
        if (tile.hasGold()) {
            str += "G";
        }
        
        if (tile.hasPit()) {
            str += "P";
        }
        
        if (tile.hasStench()) {
            str += "S";
        }
        
        if (tile.hasWumpus()) {
            str += "W";
        }
        
        if(!tile.hasBreeze() &&
                !tile.hasGold() &&
                !tile.hasPit() &&
                !tile.hasStench() &&
                !tile.hasWumpus()) {
            str += "E";
        }
        return str;
    }
    
    /**
     * Function that prints out the current position and tile stuff
     * @param tile, the tile to print
     * @param currX, the x position to 
     * @param currY
     * @param size
     */
    public static void outTile(Tile tile, int currX, int currY, int size) {
        
        // String to print
        //String str = "";
        
        // add size
        //str += size;
        
        // add current position
        //str += currX + " " + currY;
        
        // check tile for stuff
        //str += getTile(tile);
        
        // write to file
        try (PrintWriter writer = new PrintWriter("current.txt", "UTF-8")) {
            writer.println(size);
            writer.println(currX + " " + currY);
            writer.println(getTile(tile));
            writer.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
    public static void outTile(int currX, int currY, int size) {
        
        // String to print
        //String str = "";
        
        // add size
        //str += size;
        
        // add current position
        //str += currX + " " + currY;
        
        // check tile for stuff
        //str += getTile(tile);
        
        // write to file
        try (PrintWriter writer = new PrintWriter("current.txt", "UTF-8")) {
            writer.println(size);
            writer.println(currX + " " + currY);
            writer.println("R");
            writer.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
