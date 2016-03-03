package view;
import model.*;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import javax.swing.JButton;
import java.awt.GridLayout;

public class DrawView extends JPanel{
	private DoodleModel model;
	private int mouseX, mouseY;
	private String Color_d = "Black";
	private Boolean dragged = false;
	public DrawView(DoodleModel aModel){
		super();
		this.model = aModel;
		this.layoutView();
		this.addDraw();

		
		
		this.model.addView(new IView(){
			public void updateView(){
		
				repaint();
			}
		});
	}

	private void layoutView(){



		this.setVisible(true);
		
		this.setBorder(
            BorderFactory.createLineBorder(Color.black));

		
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
	
	    model.over_paint(g);
	}

	private void addDraw(){
		this.addMouseListener(new MouseAdapter(){
    		public void mousePressed(MouseEvent e){
             
                if(model.getSliderPos() < (model.numLines() * model.tickGap())){
                    int tmp = model.getSliderPos();
                    model.setSliderPos(1000);
                    model.remove(tmp);
                 
                }

    			model.setSliderTrigger(false);
    			model.addLine();
    			Point p = new Point(e.getX(), e.getY());
    			Boolean tmp;
    			if(model.getTimerB()){
    				tmp = model.getTimerB();
    				model.setTimerB(false);
    			}
    			else{
    				tmp = false;
    			}
    			model.addLinePoint(p, tmp);
    			
    			 dragged = true;


    		}
    	});

    	this.addMouseListener(new MouseAdapter(){
    		public void mouseReleased(MouseEvent e){
    			model.setSliderTrigger(false);
    			Point p = new Point(e.getX(), e.getY());
    			//ps.add(p);

    			dragged = false;
    			Boolean tmp;
    			if(model.getTimerB()){
    				tmp = model.getTimerB();
    				model.setTimerB(false);
    			}
    			else{
    				tmp = false;
    			}

    			model.addLinePoint(p, tmp);

    			//line_num++;
 
    			repaint();

    		}
    	});

    	this.addMouseMotionListener(new MouseMotionAdapter(){
    		public void mouseDragged(MouseEvent e){
    			if(dragged){
    				model.setSliderTrigger(false);
    				Point p = new Point(e.getX(), e.getY());
    				Boolean tmp;
    			if(model.getTimerB()){
    				tmp = model.getTimerB();
    				model.setTimerB(false);
    			}
    			else{
    				tmp = false;
    			}
    				model.addLinePoint(p, tmp);
    				repaint();
    			}
    		}
    	});
	}
}