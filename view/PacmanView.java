package view;
import model.PacmanModel;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.net.URL;
import javax.imageio.ImageIO;
import java.io.IOException;

import controller.PacmanController;

public class PacmanView {
    PacmanController controller;
    PacmanModel model;
    HashMap<String, BufferedImage> img;
    JFrame window;
    MyDrawingPanel drawingPanel;
    final int myRow = 20;
    final int myCol = 20;
    
    public PacmanView(PacmanController c){
        img = new HashMap<String, BufferedImage>();
        //fillHashMap();
        controller = c;
        
        window = new JFrame("Pacman");
        window.setBounds(100, 100, 480, 480); //same dimensions as panel in level editor
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        drawingPanel = new MyDrawingPanel();
        drawingPanel.setBounds(20, 20, 480, 480);
        drawingPanel.setBorder(BorderFactory.createEtchedBorder());
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        
        mainPanel.add(drawingPanel);    
        window.getContentPane().add(mainPanel);

        //Set visibility
        window.setVisible(true);        
    }
    
    private class MyDrawingPanel extends JPanel {
        static final long serialVersionUID = 1234567890L;
        
        public void paintComponent(Graphics g) {
            drawCellContents(g);
        }
        
        public void drawCellContents(Graphics g){         
            for(int i = 0; i < myRow; i++){
                for(int j = 0; j < myCol; j++){
                    g.drawImage(controller.getCellContents(i, j), j * 20, 
                            i * 20, 20, 20, null);
                }
            }
        }
    }
    
    
    public void addCustomMouseListener(MouseListener m){
        drawingPanel.addMouseListener(m);
    }
    
    public void addCustomKeyListener(KeyListener l){
        window.addKeyListener(l);
    }
    
    public void updateView(){
        drawingPanel.repaint();
    }
    
    
    /*
    public BufferedImage getCellContents(int y, int x)  {
        String image = model.getImgTitle(y, x);
        if (image == null)  {
            //System.out.println("PICNAME(" + y + ", " + x + ") = NULL");
        }
        return imageLoad(image);
    }
    
    public BufferedImage imageLoad(String picName)  {
       
        try {
            URL url = getClass().getClassLoader().getResource(picName);
            if (url == null)  {
                Thread.dumpStack();
                System.out.println("NULL URL, picName = " + picName);
            }
            return ImageIO.read(url);
        }
        catch (IOException e)  {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    private void fillHashMap()  {
        img.put("barrier", imageLoad("images/barrier.png"));
        img.put("blank", imageLoad("images/blank.png"));
        img.put("dot", imageLoad("images/dot.png"));
        img.put("pacman", imageLoad("images/pacman.png"));
    }
    */
}
