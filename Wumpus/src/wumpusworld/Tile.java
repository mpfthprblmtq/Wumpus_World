/**
 * File:    Tile.java
 * Desc:    This class is the object class for Tile, which makes up a Board.
 */

package wumpusworld;

public class Tile {
    
    // ivars
    private boolean pit;
    private boolean breeze;
    private boolean wumpus;
    private boolean stench;
    private boolean gold;
    private boolean deadWumpus;
    
    private boolean discovered;
    
    private String uncoveredImg;
    private String uncoveredImg_p;

    /**
     * Loaded constructor for class Tile
     * @param pit
     * @param breeze
     * @param wumpus
     * @param stench
     * @param gold 
     */
    public Tile(boolean pit, boolean breeze, boolean wumpus, boolean stench, boolean gold) {
        this.pit = pit;
        this.breeze = breeze;
        this.wumpus = wumpus;
        this.stench = stench;
        this.gold = gold;
    }
    
    /**
     * Empty constructor
     */
    public Tile() {
        setPit(false);
        setBreeze(false);
        setWumpus(false);
        setStench(false);
        setGold(false);
        setDeadWumpus(false);
    }
    
    /**
     * Sets the images on the tile
     * @param s, the string path of the image to set
     * @param size, the size of the board
     */
    public void setImages(String s, int size) {
        
        // determine what board is being used
        switch (size) {
            case 4:
                uncoveredImg = "src//img//" + s + ".png";
                uncoveredImg_p = "src//img//" + s + "_p.png";
                break;
            case 8:
                uncoveredImg = "src//img//" + s + ".png";
                uncoveredImg_p = "src//img//" + s + "_p.png";
                break;
            case 16:
                uncoveredImg = "src//img//scaled//" + s + ".png";
                uncoveredImg_p = "src//img//scaled//" + s + "_p.png";
                break;
            default:
                break;
        }
        
    }
    
    /**
     * @return the discovered
     */
    public boolean isDiscovered() {
        return discovered;
    }
    
    /**
     * @param d the discovered to set
     */
    public final void setDiscovered(boolean d) {
        this.discovered = d;
    }
    
    /**
     * @return the uncoveredImage
     */
    public String getUncoveredImage() {
        return uncoveredImg;
    }
    
    /**
     * @param s the uncoveredImage to set
     */
    public final void setUncoveredImage(String s) {
        switch (Main.size) {
            case 4:
                uncoveredImg = "src//img//" + s + ".png";
                break;
            case 8:
                uncoveredImg = "src//img//" + s + ".png";
                break;
            case 16:
                uncoveredImg = "src//img//scaled//" + s + ".png";
                break;
            default:
                break;
        }
    }
    
    /**
     * @return the uncoveredImage_p
     */
    public String getUncoveredImage_p() {
        return uncoveredImg_p;
    }
    
    /**
     * @param s the uncoveredImage_p to set
     */
    public final void setUncoveredImage_p(String s) {
        switch (Main.size) {
            case 4:
                uncoveredImg_p = "src//img//" + s + "_p.png";
                break;
            case 8:
                uncoveredImg_p = "src//img//" + s + "_p.png";
                break;
            case 16:
                uncoveredImg_p = "src//img//scaled//" + s + "_p.png";
                break;
            default:
                break;
        }
    }

    /**
     * @return the pit
     */
    public boolean hasPit() {
        return pit;
    }

    /**
     * @param pit the pit to set
     */
    public final void setPit(boolean pit) {
        this.pit = pit;
    }

    /**
     * @return the breeze
     */
    public boolean hasBreeze() {
        return breeze;
    }

    /**
     * @param breeze the breeze to set
     */
    public final void setBreeze(boolean breeze) {
        this.breeze = breeze;
    }

    /**
     * @return the wumpus
     */
    public boolean hasWumpus() {
        return wumpus;
    }

    /**
     * @param wumpus the wumpus to set
     */
    public final void setWumpus(boolean wumpus) {
        this.wumpus = wumpus;
    }
    
    /**
     * @return the deadWumpus
     */
    public boolean hasDeadWumpus() {
        return deadWumpus;
    }

    /**
     * @param deadWumpus
     */
    public final void setDeadWumpus(boolean deadWumpus) {
        this.deadWumpus = deadWumpus;
    }

    /**
     * @return the stench
     */
    public boolean hasStench() {
        return stench;
    }

    /**
     * @param stench the stench to set
     */
    public final void setStench(boolean stench) {
        this.stench = stench;
    }

    /**
     * @return the gold
     */
    public boolean hasGold() {
        return gold;
    }

    /**
     * @param gold the gold to set
     */
    public final void setGold(boolean gold) {
        this.gold = gold;
    }
    
    /**
     * Returns String representation of Tile class
     * @return String representation of Tile object
     */
    @Override
    public String toString() {
        return "Tile{" + "pit=" + pit + ", breeze=" + breeze + ", wumpus=" + wumpus + ", stench=" + stench + ", gold=" + gold + '}';
    }
}
