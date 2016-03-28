package controller;
import java.util.HashMap;
import model.PacmanModel;
import view.PacmanView;

public class PacmanController {
    PacmanModel myModel;
    PacmanView myView;
    String level = "level1";
    final int row = 20;
    final int col = 20;
    public PacmanController()  {
        myModel = new PacmanModel(level, row, col); 
        myView = new PacmanView(this, myModel);
    }
}
