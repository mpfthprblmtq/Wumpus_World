/**
 * File:    Debugger.java
 * Desc:    This class provides some advanced debugging functions, such as
 *          finding the elements of the board.
 *          Might be split included in a Game class if necessary.
 */

package wumpusworld;

public class Debugger {
    
    public Debugger() {
        // empty constructor
    }
    
    public void findWumpus(Tile[][] b) {
        System.out.println("Wumpus Finder:");
        System.out.println("-----------------");
        System.out.println("| " + w(b[0][0]) + " | " + w(b[0][1]) + " | " + w(b[0][2]) + " | " + w(b[0][3]) + " |");
        System.out.println("-----------------");
        System.out.println("| " + w(b[1][0]) + " | " + w(b[1][1]) + " | " + w(b[1][2]) + " | " + w(b[1][3]) + " |");
        System.out.println("-----------------");
        System.out.println("| " + w(b[2][0]) + " | " + w(b[2][1]) + " | " + w(b[2][2]) + " | " + w(b[2][3]) + " |");
        System.out.println("-----------------");
        System.out.println("| " + w(b[3][0]) + " | " + w(b[3][1]) + " | " + w(b[3][2]) + " | " + w(b[3][3]) + " |");
        System.out.println("-----------------");
        System.out.println("");
    }
    
    public String w(Tile b) {
        if(b.hasWumpus()) {
            return "W";
        } else {
            return " ";
        }
    }
    
    public void findPit(Tile[][] b) {
        System.out.println("Pit Finder:");
        System.out.println("-----------------");
        System.out.println("| " + p(b[0][0]) + " | " + p(b[0][1]) + " | " + p(b[0][2]) + " | " + p(b[0][3]) + " |");
        System.out.println("-----------------");
        System.out.println("| " + p(b[1][0]) + " | " + p(b[1][1]) + " | " + p(b[1][2]) + " | " + p(b[1][3]) + " |");
        System.out.println("-----------------");
        System.out.println("| " + p(b[2][0]) + " | " + p(b[2][1]) + " | " + p(b[2][2]) + " | " + p(b[2][3]) + " |");
        System.out.println("-----------------");
        System.out.println("| " + p(b[3][0]) + " | " + p(b[3][1]) + " | " + p(b[3][2]) + " | " + p(b[3][3]) + " |");
        System.out.println("-----------------");
        System.out.println("");
    }
    
    public String p(Tile b) {
        if(b.hasPit()) {
            return "P";
        } else {
            return " ";
        }
    }
    
    public void findGold(Tile[][] b) {
        System.out.println("Gold Finder:");
        System.out.println("-----------------");
        System.out.println("| " + g(b[0][0]) + " | " + g(b[0][1]) + " | " + g(b[0][2]) + " | " + g(b[0][3]) + " |");
        System.out.println("-----------------");
        System.out.println("| " + g(b[1][0]) + " | " + g(b[1][1]) + " | " + g(b[1][2]) + " | " + g(b[1][3]) + " |");
        System.out.println("-----------------");
        System.out.println("| " + g(b[2][0]) + " | " + g(b[2][1]) + " | " + g(b[2][2]) + " | " + g(b[2][3]) + " |");
        System.out.println("-----------------");
        System.out.println("| " + g(b[3][0]) + " | " + g(b[3][1]) + " | " + g(b[3][2]) + " | " + g(b[3][3]) + " |");
        System.out.println("-----------------");
        System.out.println("");
    }
    
    public String g(Tile b) {
        if(b.hasGold()) {
            return "G";
        } else {
            return " ";
        }
    }
    
    public void findEverything(Tile[][] b) {
        System.out.println("Everything Finder:");
        System.out.println("-----------------");
        System.out.println("| " + e(b[0][0]) + " | " + e(b[0][1]) + " | " + e(b[0][2]) + " | " + e(b[0][3]) + " |");
        System.out.println("-----------------");
        System.out.println("| " + e(b[1][0]) + " | " + e(b[1][1]) + " | " + e(b[1][2]) + " | " + e(b[1][3]) + " |");
        System.out.println("-----------------");
        System.out.println("| " + e(b[2][0]) + " | " + e(b[2][1]) + " | " + e(b[2][2]) + " | " + e(b[2][3]) + " |");
        System.out.println("-----------------");
        System.out.println("| " + e(b[3][0]) + " | " + e(b[3][1]) + " | " + e(b[3][2]) + " | " + e(b[3][3]) + " |");
        System.out.println("-----------------");
        System.out.println("");
    }
    
    public String e(Tile b) {
        if(b.hasWumpus()) {
            return "W";
        } else if(b.hasPit()){
            return "P";
        } else if (b.hasGold()) {
            return "G";
        } else {
            return " ";
        }
    }
    
    public void findStench(Tile[][] b) {
        System.out.println("Stench Finder:");
        System.out.println("-----------------");
        System.out.println("| " + s(b[0][0]) + " | " + s(b[0][1]) + " | " + s(b[0][2]) + " | " + s(b[0][3]) + " |");
        System.out.println("-----------------");
        System.out.println("| " + s(b[1][0]) + " | " + s(b[1][1]) + " | " + s(b[1][2]) + " | " + s(b[1][3]) + " |");
        System.out.println("-----------------");
        System.out.println("| " + s(b[2][0]) + " | " + s(b[2][1]) + " | " + s(b[2][2]) + " | " + s(b[2][3]) + " |");
        System.out.println("-----------------");
        System.out.println("| " + s(b[3][0]) + " | " + s(b[3][1]) + " | " + s(b[3][2]) + " | " + s(b[3][3]) + " |");
        System.out.println("-----------------");
        System.out.println("");
    }
    
    public String s(Tile b) {
        if(b.hasStench()) {
            return "S";
        } else {
            return " ";
        }
    }
    
    public void findBreeze(Tile[][] b) {
        System.out.println("Breeze Finder:");
        System.out.println("-----------------");
        System.out.println("| " + b(b[0][0]) + " | " + b(b[0][1]) + " | " + b(b[0][2]) + " | " + b(b[0][3]) + " |");
        System.out.println("-----------------");
        System.out.println("| " + b(b[1][0]) + " | " + b(b[1][1]) + " | " + b(b[1][2]) + " | " + b(b[1][3]) + " |");
        System.out.println("-----------------");
        System.out.println("| " + b(b[2][0]) + " | " + b(b[2][1]) + " | " + b(b[2][2]) + " | " + b(b[2][3]) + " |");
        System.out.println("-----------------");
        System.out.println("| " + b(b[3][0]) + " | " + b(b[3][1]) + " | " + b(b[3][2]) + " | " + b(b[3][3]) + " |");
        System.out.println("-----------------");
        System.out.println("");
    }
    
    public String b(Tile b) {
        if(b.hasBreeze()) {
            return "B";
        } else {
            return " ";
        }
    }
    
}
