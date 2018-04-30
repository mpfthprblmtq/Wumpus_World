# WumpusWorld
A game I made in Java to prove to my Artificial Intelligence professor that I could do it.  All of this is made from scratch.

## To build in NetBeans
Build a blank NetBeans project.  Clone the repo into the "src" folder.  The src folder will now have a "WumpusWorld" folder in it.  Take the contents of that WumpusWorld folder, and move them up a level.  Delete the now empty WumpusWorld folder.

Your folder heirarchy should look something like this:

>build

>nbproject

>src

>>img

>>wumpusworld

And you should be good!

### Changelog/Version History
4 April 2017 - Version 1.0 - Bare Bones
>Main functionality of the game is there.  Must use buttons to navigate.

7 April 2017 - Version 1.0.1 - No More Buttons
>Added keyboard functionality.  Now you don't have to ever press a button!

8 April 2017 - Version 1.1 - Cheat Mode
>Added a feature called Cheat Mode, which lets you flip all tiles over, showing you where everything is.

?? April 2017 - Version 1.2 - More Boards!
>????

## Idea for AI
1.  Board populates like normal depending on the size of the board (4x4, 8x8, 16x16)
2.  When the board is made, it prints out a text file with letters to represent the tiles.  So a tile with Breeze and Stench would be "BS" or similar.
3.  Just like the Reversi interface, it would load up an .exe (for c++) or .jar (for java), since both languages would work.
4.  The Agent that students would program to play would read in the text file representation of the board and build the board based on that.
5.  The Agent would then moved based on the perceptions it finds in the current position.  For instance, if the current position's tile contains Stench, it knows that one of the blocks has stench, so don't go that way.  (It's a little more complext than that, but you get the idea)
6.  The goal would be to find the gold and get back to the starting point.
