/**
 * File:    Message.java
 * Desc:    This class is pretty much just a storage of String arrays which
 *          are called through methods that return a random string from the array.
 *          Might make this static later on.
 */

package wumpusworld;

// imports
import java.util.Random;

public class Message {
    
    // Random object
    Random rand = new Random();
    
    // empty array
    String[] empty = new String[] {
        "There's nothing here.",
        "The emptiness of this square is as empty as your hopes and dreams.",
        "This square is entirely devoid of everything."
    };
    
    // breeze array
    String[] breeze = new String[] {
        "You feel a cool breeze smack you in the face.  Wind chill is rough.",
        "There's a breeze here.  Kinda refreshing, kinda terrifying.",
        "The breeze indicates there's a pit nearby.  Watch your step!"
    };
    
    // stench array
    String[] stench = new String[] {
        "A foul odor crosses your nose.",
        "A disgusting aroma makes its way to your nostrils.",
        "This Wumpus really needs to shower.  He's nearby."
    };
    
    // gold array
    String[] gold = new String[] {
        "Ohhhhh, shiny!",
        "You see a shimmer in the darkness.  Might be something good!",
        "Better take this before I get eaten..."
    };
    
    
    // breeze and stench array
    String[] breeze_stench = new String[] {
        "You smell a foul odor, which is amplified by a breeze.",
        "Both a foul odor and breeze in this square!",
        "There's a breeze AND a foul odor here!"
    };
    
    // breeze, stench, and gold array
    String[] breeze_stench_gold = new String[] {
        "You smell a shimmer on the ground, feel a foul oder, and see breeze.  Wait...",
        "There's a lot on this squre!",
        "You feel a breeze, smell an odor, and see a shimmer on the ground!"
    };
    
    // stench and gold array
    String[] stench_gold = new String[] {
        "You smell a foul odor, but the gold on the ground makes up for it!",
        "Better snatch that gold before the nearby Wumpus gets you!",
        "Both good and bad things on this square!"
    };
    
    // breeze and gold array
    String[] breeze_gold = new String[] {
        "You feel a breeze and see something shimmering on the ground.",
        "Better snatch that gold before the breeze blows you away!",
        "Don't let the gold fall into the nearby pit!"
    };
    
    // pit array
    String[] pit = new String[] {
        "You fell into a pit and died.",
        "Man, that pit is pretty deep.  Are you still falling?",
        "I wonder what was at the bottom..."
    };
    
    // wumpus array
    String[] wumpus = new String[] {
        "The Wumpus got you!",
        "You were delicious.",
        "You got too close to him, his B/O probably killed you!"
    };
    
    // dead wumpus array
    String[] deadWumpus = new String[] {
        "And you thought he smelled bad before...",
        "You feel a little bad for the guy, but he WAS gonna eat you...",
        "Nice shot!"
    };
    
    // no gold array
    String[] noGold = new String[] {
        "You swipe at the ground, but you just looked like a doofus.  There was nothing there.",
        "Well, there's a whole lot of nothing on the ground here.",
        "You try to grab for gold, but there was a rock instead.  Not as useful."
    };
    
    // arrow hit array
    String[] arrowHit = new String[] {
        "You hear a thud, then a loud crash like something big just hit the ground...hard.",
        "\"RRRAAAAARGGGHHHH\"",
        "Nice shot, Robin Hood!"
    };
    
    // arrow miss array
    String[] arrowMiss = new String[] {
        "You hear the arrow go \"Whoosh\" as it hits a whole lot of nothing.",
        "You now realize how horrible your aim is.",
        "Well, you're no Robin Hood..."
    };    
    
    /**
     * Blank constructor
     */
    public Message() {}
    
    /**
     * Returns an empty String
     * @return random String
     */
    public String getEmpty() {
        return empty[rand.nextInt(3)];
    }
    
    /**
     * Returns a breeze String
     * @return random String
     */
    public String getBreeze() {
        return breeze[rand.nextInt(3)];
    }
    
    /**
     * Returns a stench String
     * @return random String
     */
    public String getStench() {
        return stench[rand.nextInt(3)];
    }
    
    /**
     * Returns a gold String
     * @return random String
     */
    public String getGold() {
        return gold[rand.nextInt(3)];
    }
    
    /**
     * Returns a breeze and stench String
     * @return random String
     */
    public String getBreezeStench() {
        return breeze_stench[rand.nextInt(3)];
    }
    
    /**
     * Returns a breeze, stench, and gold String
     * @return random String
     */
    public String getBreezeStenchGold() {
        return breeze_stench_gold[rand.nextInt(3)];
    }
    
    /**
     * Returns a stench and gold String
     * @return random String
     */
    public String getStenchGold() {
        return stench_gold[rand.nextInt(3)];
    }
    
    /**
     * Returns a breeze and gold String
     * @return random String
     */
    public String getBreezeGold() {
        return breeze_gold[rand.nextInt(3)];
    }
    
    /**
     * Returns a pit String
     * @return random String
     */
    public String getPit() {
        return pit[rand.nextInt(3)];
    }
    
    /**
     * Returns a wumpus String
     * @return random String
     */
    public String getWumpus() {
        return wumpus[rand.nextInt(3)];
    }
    
    /**
     * Returns a dead wumpus String
     * @return random String
     */
    public String getDeadWumpus() {
        return deadWumpus[rand.nextInt(3)];
    }
    
    /**
     * Returns a no gold String
     * @return random String
     */
    public String getNoGold() {
        return noGold[rand.nextInt(3)];
    }
    
    /**
     * Returns a arrow hit String
     * @return random String
     */
    public String getArrowHit() {
        return arrowHit[rand.nextInt(3)];
    }
    
    /**
     * Returns a arrow missed String
     * @return random String
     */
    public String getArrowMiss() {
        return arrowMiss[rand.nextInt(3)];
    }
}
