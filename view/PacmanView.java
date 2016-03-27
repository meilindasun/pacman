package view;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.PacmanController;

public class PacmanView {
	PacmanController controller;
	
	JFrame window;
	MyDrawingPanel drawingPanel;
	
	public PacmanView(PacmanController c){
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
			for(int i = 0; i < 20; i++){
				for(int j = 0; j < 20; j++){
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
	
}
