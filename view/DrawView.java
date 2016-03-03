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
		//this.setPreferredSize(new Dimension(500, 400));
		//this.setVisible(true);
		//this.setBackground(Color.YELLOW);
		//this.setBorder(
          //  BorderFactory.createLineBorder(Color.black));
		
		
		this.model.addView(new IView(){
			public void updateView(){
				//Color_d = model.getColor();
				repaint();
			}
		});
	}

	private void layoutView(){

		//JPanel canvas = new JPanel();
		//this.setPreferredSize(new Dimension(500, 400));
		//this.setLayout(new GridLayout(1, 0));

		this.setVisible(true);
		
		this.setBorder(
            BorderFactory.createLineBorder(Color.black));
		//this.setBackground(Color.YELLOW);
		// this.addMouseMotionListener(new MouseAdapter(){
		// 	public void mouseMoved(MouseEvent e){
		// 		mouseX = e.getX();
		// 		mouseY = e.getY();
		// 		repaint();
		// 	}
		// });
		//this.add(canvas);
		
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//System.out.println("color is " + Color_d);
		//g2.drawLine(mouseX, mouseY, mouseX, mouseY);
		//String label = "Mouse at (" + mouseX + ", " + mouseY + ")";
		//System.out.println(label);
        
        //System.out.println("here");
	   // g2.drawString(label, 140, 150);
	    //System.out.println("there");
	    model.over_paint(g);
	}

	private void addDraw(){
		this.addMouseListener(new MouseAdapter(){
    		public void mousePressed(MouseEvent e){
                //System.out.println("max is " + model.tickGap() + " and " + model.numLines() * model.tickGap());
                if(model.getSliderPos() < (model.numLines() * model.tickGap())){
                    int tmp = model.getSliderPos();
                    model.setSliderPos(1000);
                    model.remove(tmp);
                    //System.out.println("tmp is " + tmp);
                    //model.setSliderPos(1000);
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
    			// ArrayList<Point> ps = new ArrayList<Point>();
    			// ps.add(p);
    			// lines.add(ps);
    			// System.out.println("now the size is " + lines.size());

    			// painted = true;
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