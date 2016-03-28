package controller;
import java.util.HashMap;

import javax.imageio.ImageIO;

import model.PacmanModel;
import view.PacmanView;

public class PacmanController {
    PacmanModel myModel;
    PacmanView myView;
    String level = "level1";
    final int row = 10;
    final int col = 10;
    
    BufferedImage blank, food, barrier;
    
    public PacmanController()  {
        myModel = new PacmanModel("level1", row, col); //Need to find the right file
        myView = new PacmanView(this);
        
        try{
        	blank = ImageIO.read(new File("blank.png"));
        	food = ImageIO.read(new File("dot.png"));
        	barrier = ImageIO.read(new File("barrier.png"));
        }catch(IOException e){
        	System.out.println(e.getStackTrace());
        }
        
    }
    
    public BufferedImage getCellContents(int row, int col){
    	if(myModel.getImgTitle(row, col) == "blank.png"){
    		return blank;
    	}else if(myModel.getImgTitle(row, col) == "dot.png"){
    		return food;
    	}else{
    		return barrier;
    	}
    }
}

}
