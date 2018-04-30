/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Agent {

    private static int size;
    private static int currX;
    private static int currY;
    private static String currGraphic;
    private static boolean up = false;
    private static boolean down = false;
    private static boolean left = false;
    private static boolean right = false;
    private static String nextMove = "";

    public static void main(String args[]) {
        readCurrentFile(); //Reads the current file
        if (!createDiscoverBoard()){//Creates a new discover board if it does not exist
            fillDiscoverBoard();
            createStackFile();
        }
        String[][] board = new String[size][size]; //Creates a new board 2d array
        readDiscoverBoard(board); //Reads the discover board from a file
        printNewDiscoverBoard(board); //Prints the new discovered board
        makeMove(); //Makes a random move
        if (!currGraphic.contains("R"))
            addToStack(); //Appends to the stack.txt
        else
            removeFromStack();
        printNextMove(); //Prints next move to nextMove.txt
    }

    /**
     * This function calls all of the utility functions and makes a random move.
     */
    private static void makeMove() {
        getAvailiableDirections();
        if (!nextMove.contains("grab") && !currGraphic.contains("R")){
            randomMove();
        }
    }

    /**
     * Reads the current.txt file and sets the size, currX, currY, 
     * and currGraphic
     */
    private static void readCurrentFile() {
        try (Scanner currScanner = new Scanner(new File("current.txt"))) {
            size = currScanner.nextInt();
            currY = currScanner.nextInt();
            currX = currScanner.nextInt();
            currGraphic = currScanner.next();
            //is this where I update probablility of danger on surrounding undiscovered squares?
            
            currScanner.close();
        } catch (FileNotFoundException e) {
            System.exit(1);
        }
        
        if (currGraphic.contains("G"))
        {
            nextMove = "grab";
        }
    }

    /**
     * Gets the avaliable directions based on the input file
     */
    private static void getAvailiableDirections() {
        if (currY == 0) {
            left = false;
        } else {
            left = true;
        }
        if (currY == size - 1) {
            right = false;
        } else {
            right = true;
        }
        if (currX == 0) {
            up = false;
        } else {
            up = true;
        }
        if (currX == size - 1) {
            down = false;
        } else {
            down = true;
        }
    }
    
    /**
     * Function for making a random move based on if a direction is avaliable
     * or not.
     */
    private static void randomMove() {
        Random random = new Random();
        boolean move = false;
        String direction = "";

        while (move == false) {
            int dir = random.nextInt(4);
            switch (dir) {
                case 0:
                    if (up == true) {
                        direction = "up";
                        move = true;
                    }
                    break;
                case 1:
                    if (down == true) {
                        direction = "down";
                        move = true;
                    }
                    break;
                case 2:
                    if (left == true) {
                        direction = "left";
                        move = true;
                    }
                    break;
                case 3:
                    if (right == true) {
                        direction = "right";
                        move = true;
                    }
                    break;
            }
        }
        nextMove = direction;
    }
    
    private static void createStackFile(){
        File file = new File("stack.txt");
        try{
            file.createNewFile();
        } catch (IOException e)
        {
            System.out.println("Damn dude, do you even Java?");
        }
        try (PrintWriter writer = new PrintWriter("stack.txt")){
            writer.println("climb");
        }
        catch (FileNotFoundException e){
            System.out.println("Could not find file.  Do you even Java bro?");
        }
    }
    
    private static boolean createDiscoverBoard()
    {
        Path p = Paths.get("discoveredBoard.txt");
        return Files.exists(p);
    }
    
    private static void fillDiscoverBoard(){
        try (PrintWriter writer = new PrintWriter("discoveredBoard.txt", "UTF-8")) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    writer.print("U ");
                }
                writer.println();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Done messed up A A RON");
        }
    }
    
    private static void readDiscoverBoard(String board[][])
    {
        try (Scanner scanner = new Scanner(new File("discoveredBoard.txt"))){
            for (int i = 0; i < size; i++){
                for (int j = 0; j < size; j++){
                    board[i][j] = scanner.next();
                }
            }
            board[currX][currY] = "+" + currGraphic;
        } catch (FileNotFoundException e){
            System.out.println("Done messed up A A RON");
        }
        calcDeathProb(board);
    }
    
    //increments danger on surrounding undiscovered tiles for breeze/stench
    private static void calcDeathProb(String board[][]){
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                //if tile hsa breeze AND stench, increment int in unexp adj. twice
                if(board[i][j].contains("B") && board[i][j].contains("S")){
                   //see if left is available and unexplored,then increment int * 2
                   if(j > 0 && !board[i][j-1].contains("+")){
                       //see if string has an int at the head
                       char c = board[i][j-1].charAt(0);
                       if(Character.isDigit(c)){
                           board[i][j-1].replace('1', '2');
                       }else{
                           board[i][j-1] = 2 + board[i][j-1];
                       }
                       
                   }
                   //see if right " " " "  " " " 
                   if(j < 3 && !board[i][j+1].contains("+")){
                       //see if string has an int at the head
                       char c = board[i][j+1].charAt(0);
                       if(Character.isDigit(c)){
                           board[i][j+1].replace('1', '2');
                       }else{
                           board[i][j+1] = 2 + board[i][j+1];
                       }
                       
                   }
                   //see if up blah
                   if(i > 0 && !board[i-1][j].contains("+")){
                       //see if string has an int at the head
                       char c = board[i-1][j].charAt(0);
                       if(Character.isDigit(c)){
                           board[i-1][j].replace('1', '2');
                       }else{
                           board[i-1][j] = 2 + board[i-1][j];
                       }
                       
                   }
                   //see if down blah
                   if(i < 3 && !board[i+1][j].contains("+")){
                       //see if string has an int at the head
                       char c = board[i+1][j].charAt(0);
                       if(Character.isDigit(c)){
                           board[i+1][j].replace('1', '2');
                       }else{
                           board[i+1][j] = 2 + board[i+1][j];
                       }
                       
                   }
                }else if(board[i][j].contains("B") || board[i][j].contains("S")){
                   //see if left is available and unexplored,then increment int
                   if(j > 0 && !board[i][j-1].contains("+")){
                       //see if string has an int at the head
                       Character c = board[i][j-1].charAt(0);
                       if(Character.isDigit(c)){
                           int d = (int)c++;
                           board[i][j-1].replace(c,(char)d );
                       }else{
                           board[i][j-1] = 1 + board[i][j-1];
                       }
                       
                   }
                   //see if right " " " "  " " " 
                   if(j < 3 && !board[i][j+1].contains("+")){
                       //see if string has an int at the head
                       Character c = board[i][j+1].charAt(0);
                       if(Character.isDigit(c)){
                           int d = (int)c++;
                           board[i][j+1].replace(c, (char)d);
                       }else{
                           board[i][j+1] = 1 + board[i][j+1];
                       }
                       
                   }
                   //see if up blah
                   if(i > 0 && !board[i-1][j].contains("+")){
                       //see if string has an int at the head
                       Character c = board[i-1][j].charAt(0);
                       if(Character.isDigit(c)){
                           int d = (int)c++;
                           board[i-1][j].replace(c, (char)d);
                       }else{
                           board[i-1][j] = 1 + board[i-1][j];
                       }
                       
                   }
                   //see if down blah
                   if(i < 3 && !board[i+1][j].contains("+")){
                       //see if string has an int at the head
                       Character c = board[i+1][j].charAt(0);
                       if(Character.isDigit(c)){
                           int d = (int)c++;
                           board[i+1][j].replace(c, (char)d);
                       }else{
                           board[i+1][j] = 1 + board[i+1][j];
                       }
                   }
                }
            }
        }
    }
    
    private static void printNextMove()
    {
        try (PrintWriter writer = new PrintWriter("nextMove.txt")){
            writer.println(nextMove);
        }
        catch (FileNotFoundException e){
            System.out.println("Could not fine file");
        }
    }
    
    private static void addToStack()
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("stack.txt", true))){
            if (!nextMove.contains("grab")){
                writer.write(nextMove + "\n");
            }
        }
        catch (IOException e){
            System.out.println("Could not find file");
        }
    }
    
    private static boolean removeFromStack()
    {
        boolean flag = false;
        ArrayList<String> list = new ArrayList<>();
        try (Scanner reader = new Scanner(new File("stack.txt"))){
            while (reader.hasNext()){
                list.add(reader.next());
                flag = true;
            }
            switch (list.get(list.size() - 1)){
                case "up":
                    nextMove = "down";
                    break;
                case "down":
                    nextMove = "up";
                    break;
                case "left":
                    nextMove = "right";
                    break;
                case "right":
                    nextMove = "left";
                    break;
                case "climb":
                    nextMove = "climb";
                    break;
            }
            list.remove(list.size() - 1);
            writeStack(list);
        }catch (IOException e){
            
        }
        return flag;
    }
    
    private static void writeStack(ArrayList<String> list){
        try (PrintWriter writer = new PrintWriter("stack.txt")){
            for (int i = 0; i < list.size(); i++){
                writer.write(list.get(i) + "\n");
            }
        }catch (FileNotFoundException e){
            
        }
    }
    
    private static void printNewDiscoverBoard(String board[][])
    {
        try (PrintWriter writer = new PrintWriter("discoveredBoard.txt")){
            for (int i = 0; i < size; i++){
                for (int j = 0; j < size; j++){
                    writer.print(board[i][j] + " ");
                }
                writer.println();
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Could not find file");
        }
    }
}