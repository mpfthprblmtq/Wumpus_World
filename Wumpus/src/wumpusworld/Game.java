/**
 * File:    Game.java
 * Desc:    This class is the object class for a game, which includes populating
 *          the board, setting the status of the player, and globals for the game.
 */

// package
package wumpusworld;

// imports
import java.util.Random;

/**
 * Game class
 */
public class Game {
    
    // some global variables
    int size;
    Tile[][] board;
    int currX;
    int currY;
    
    int moves = 0;
    int score = 0;
    boolean killedAllWumpus = false;
    int numWumps = 0;
    int numGold = 0;
    int numArrows = 0;
    int wumpiKilled = 0;
    
    String death = "greatsuccess";
    
    boolean firingArrow = false;
    boolean gameEnded = false;
    boolean gameReset = false;
    
    // B-Random
    Random rand = new Random();
    
    /**
     * Game constructor that sets the dimensions of the board
     * @param size, the size to set
     */
    public Game(int size) {
        this.size = size;
        board = new Tile[size][size];
    }
    
    /**
     * Returns the board object
     * @return the board object
     */
    public Tile[][] getBoard() {
        return board;
    }
    
    /**
     * Populates the board with a Wumpus, two pits, and a gold bar
     * populateTiles() actually does the picture changing based on the board
     */
    public void populate() {
        // populate the board with blank tiles
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Tile();
            }
        }
        
        // fill wumpus
        putWumpus();

        // fill pits
        putPits();

        // fill gold
        putGold();
    }
    
    /**
     * Places 1 Wumpus on the board in a random position that isn't the starting position
     */
    public void putWumpus() {
        
        // function variables
        boolean wumpusPut = false;
        int col, row;
        
        int wumpi;
        int count = 0;
        
        if(size > 4) {
            wumpi = (size/4) + (size % 6);
        } else {
            wumpi = size/4;
        }

        // while the wumpus is not put yet
        while (!wumpusPut) {
            
            // randomize the location
            col = rand.nextInt(size);
            row = rand.nextInt(size);

            // if he's at the starting position
            if (row == size-1 && col == 0) {
                // start over
            
            } else {
                // put him there
                board[row][col].setWumpus(true);
                
                // increase the number of wumpi
                count++;
                numWumps++;
                
                // put stench around him
                putStench(row, col);
                
                if (count == wumpi) {
                    // break out of the while loop
                    wumpusPut = true;
                }
            }
        }
        
        // set the number of arrows to the number of wumpuseseses
        numArrows = numWumps;
    }

    /**
     * Places * pits on the board in random positions that aren't the starting position
     */
    public void putPits() {
        
        // function variables
        boolean pitsPut = false;
        int col, row;
        
        int count = 0;
        int pits;
        
        if(size > 4) {
            pits = (size/2) + (size % 6);
        } else {
            pits = size/2;
        }

        // while the pits are not put yet
        while (!pitsPut) {
            
            // randomize the location
            col = rand.nextInt(size);
            row = rand.nextInt(size);

            // if they are at the starting position
            if (row == size-1 && col == 0) {
                // start over
                
            // else if there's already a pit or wumpus there
            } else if (board[row][col].hasWumpus() || board[row][col].hasPit()) {
                // start over
                
            // all is well
            } else {
                // put the pit there
                board[row][col].setPit(true);
                
                // increase the number of pits
                count++;
                
                // put breezes around the pit
                putBreeze(row, col);
                
                // if that was the second pit, break out of the loop
                if (count == pits) {
                    pitsPut = true;
                }
            }
        }
    }

    /**
     * Places 1 Gold on the board in a random position that isn't the starting position
     */
    public void putGold() {
        
        // function variables
        boolean goldPut = false;
        int row, col;
        
        int golds;
        int count = 0;
        
        if(size > 4) {
            golds = (size/4) + (size % 6);
        } else {
            golds = size/4;
        }

        // while gold is not put
        while (!goldPut) {
            
            // randomize the location
            col = rand.nextInt(size);
            row = rand.nextInt(size);

            // if it is the starting lcoation
            if (row == size-1 && col == 0) {
                // start over
                
            // else if there's a wumpus or pit there
            } else if (board[row][col].hasWumpus() || board[row][col].hasPit()) {
                // start over
            
            // else all is well
            } else {
                // put it here
                board[row][col].setGold(true);
                
                // increase the number of golds
                count++;
                
                if(count == golds) {
                    // break out of the while loop
                    goldPut = true;
                }
            }
        }
    }
    
    /**
     * Places stenches around wumpus tile
     *
     * @param r, the row of the wumpus
     * @param c, the column of the wumpus
     */
    public void putStench(int r, int c) {
        if (r > 0) {
            board[r - 1][c].setStench(true);
        }
        if (c < size-1) {
            board[r][c + 1].setStench(true);
        }
        if (r < size-1) {
            board[r + 1][c].setStench(true);
        }
        if (c > 0) {
            board[r][c - 1].setStench(true);
        }
    }

    /**
     * Places breezes around the pit tiles
     *
     * @param r, the row of the pit
     * @param c, the column of the pit
     */
    public void putBreeze(int r, int c) {
        if (r > 0) {
            board[r - 1][c].setBreeze(true);
        }
        if (c < size-1) {
            board[r][c + 1].setBreeze(true);
        }
        if (r < size-1) {
            board[r + 1][c].setBreeze(true);
        }
        if (c > 0) {
            board[r][c - 1].setBreeze(true);
        }
    }
    
    /**
     * Returns the current X position of the player
     * @return the x position
     */
    public int getCurrX() {
        return currX;
    }
    
    /**
     * Returns the current Y position of the player
     * @return the y position
     */
    public int getCurrY() {
        return currY;
    }
    
    /**
     * Sets the current position of the player
     * @param x to set
     * @param y to set
     */
    public void setCurrent(int x, int y) {
        currX = x;
        currY = y;
    }
    
    public void incX() { currX++; }
    public void incY() { currY++; }
    public void decX() { currX--; }
    public void decY() { currY--; }
    
    /**
     * Returns the tile at the specified location
     * @param x
     * @param y
     * @return the tile at the specified location
     */
    public Tile getTileAt(int y, int x) {
        return board[x][y];
    }
    
    /**
     * Returns if the player is at the start
     * @return if the player is at the start
     */
    public boolean isAtStart() {
        return (currX == 0 && currY == size-1);
    }
    
    /**
     * Checks the tile for gold
     * @return if tile has gold
     */
    public boolean checkTileForGold() {
        return board[currY][currX].hasGold();
    }
    
    /**
     * Checks the tile for wumpus
     * @param c, the column position of the tile
     * @param r, the row position of the tile
     * @return if tile has wumpus
     */
    public boolean checkTileForWumpus(int c, int r) {
        return board[r][c].hasWumpus();
    }
    
    /**
     * Returns the number of wumpuses
     * @return the number of wumpuses
     */
    public int getNumWumps() {
        return numWumps;
    }
    
    /**
     * Decrements the number of Wumpuses when you kill one
     */
    public void decNumWumps() {
        numWumps--;
    }
    
    /**
     * Prints the current position on the board
     */
    public void printCurrent() {
        System.out.println(currX + ", " + currY);
    }
    
    /**
     * Sets the firing arrow boolean
     * @param b the boolean to set
     */
    public void setFiringArrow(boolean b) {
        firingArrow = b;
    } 
    
    /**
     * Sets the game ended boolean
     * @param b the boolean to set
     */
    public void setGameEnded(boolean b) {
        gameEnded = b;
    }
    
    /**
     * Sets the game reset boolean
     * @param b the boolean to set
     */
    public void setGameReset(boolean b) {
        gameReset = b;
    }
    
    /**
     * Returns the firing arrow boolean
     * @return firingArrow
     */
    public boolean getFiringArrow() {
        return firingArrow;
    }
    
    /**
     * Returns the game ended boolean
     * @return gameEnded
     */
    public boolean getGameEnded() {
        return gameEnded;
    }
    
    /**
     * Returns the game reset boolean
     * @return gameReset
     */
    public boolean getGameReset() {
        return gameReset;
    }
    
    /**
     * Increments the number of wumpuses killed
     */
    public void incWumpiKilled() {
        wumpiKilled++;
    }
    
    
    /**
     * Increase the total moves by one
     */
    public void incMoves() {
        moves++;
    }
    
    /**
     * Return the moves
     * @return moves
     */
    public int getMoves() {
        return moves;
    }
    
    /**
     * Returns the number of arrows
     * @return the number of arrows
     */ 
    public int getNumArrows() {
        return numArrows;
    }
    
    /**
     * Decrements the number of arrows by 1
     */
    public void decNumArrows() {
        numArrows--;
    }
    
    /**
     * Increments the number of gold
     */
    public void incGold() {
        numGold++;
    }
    
    /**
     * Returns gold
     * @return gold
     */
    public int getNumGold() {
        return numGold;
    }
    
    /**
     * set the death string
     * @param s the String to set
     */
    public void setDeath(String s) {
        death = s;
    }
    
    /**
     * Returns death
     * @return death
     */
    public String getDeath() {
        return death;
    }
    
    /**
     * Ends the game
     * @param result, if you died or survived
     */
    public void endGame(boolean result) {
        // set image based on method of death or success
        String image = "src//img//" + getDeath() + ".png";
        
        // int array of scores
        int[] s = new int[4];
        
        // title of ScoreBoard frame
        String header;

        // how much gold was attained
        s[0] = numGold * 1000;

        // how many wumpi were killed
        if(size == 4) {
            s[1] = ((size/4) - numWumps) * 1000;
        } else {
            s[1] = (((size/4)+2) - numWumps) * 1000;
        }

        // set moves
        s[2] = 0 - getMoves();

        // determines header and some other stuff based on result of game
        if (result) {
            
            // you won
            header = "You won!  :D";
            s[3] = s[0] + s[1] + s[2];
            
            // You climbed out without doing ANYTHING.  Loser.
            if (s[0] == 0 && s[1] == 0) {
                header = "You Escaped!";
                s[3] = 0;
            }
           
        // you died
        } else {
            header = "You died!  D:";
            s[3] = 0;
        }
        
        // open the ScoreBoard
        Main.openScoreBoard(s, image, header);
    }
}