package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PacmanModel {
	int myRow;
	int myCol;
	
	String blank = "blank.png";
	String food = "dot.png";
	String barrier = "barrier.png";
	String imageDir = "images/";
	
	String [][] board;
	String [][] walkable;
	
	Scanner input;
	
	public PacmanModel(String level, int row, int col){
		myRow = row;
		myCol = col;
		board = new String[myRow][myCol];
		walkable = new String[myRow][myCol];
		setAllBlank();
		printBoard();
		readFile(level);
	}
	
	void setAllBlank()  {
	    for (int i = 0; i < myRow; i++)  {
	        for (int j = 0; j < myCol; j++)  {
	            board[i][j] = imageDir + blank;
	        }
	    }
	}
	
	void printBoard()  {
	    for (int i = 0; i < myRow; i++)  {
	        for (int j = 0; j < myCol; j++)  {
	            System.out.println(board[i][j] + " ");
	        }
	        System.out.println();
	    }
	}
	   
	boolean canVisit(int y, int x)  {
	    if (y < 0 || y >= myRow || x < 0 || x >= myRow)  {
	        return false;
	    }
	    return true;
	}
	
	public String getImgTitle(int y, int x)  {
	    if (canVisit(y, x))  {
System.out.println("getImgTitle(" + y + ", " + x + ") = " + 
board[y][x]);
	        return board[y][x];
	    }
	    return null;
	}
	
	void readFile(String level){
		int iBoard = 0; 		//row
		int jBoard = 0;			//col
		int iWalkable = 0;		//row
		int jWalkable = 0;		//col
		try{
			input = new Scanner(new File(level));
			while(input.hasNext()){
				String curr = input.next();
				if(curr.charAt(0) == '['){
					// board[iBoard][jBoard] = curr.substring(1);
					if(jBoard< myCol - 1) {
						jBoard++;
					}else{
						iBoard++;
						jBoard = 0;
					}
				}
				if(curr.charAt(curr.length() - 1)== ']'){
					walkable[iWalkable][jWalkable] = curr.substring(0, curr.length() - 1);
					if(jWalkable < myCol - 1){
						jWalkable++;
					} else{
						iWalkable++;
						jWalkable = 0;
					}
				}
			}
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
	
	void eatFood(int row, int col){
		board[row][col] = blank;
	}
	
	boolean walkable(int row, int col){
		if(walkable[row][col] == "true")
			return true;
		return false;
	}
}
