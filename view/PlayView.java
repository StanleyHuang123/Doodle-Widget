package view;
import model.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.event.*;

import java.util.Timer;
import java.util.TimerTask;

public class PlayView extends JPanel{
	private DoodleModel model;
	private Timer playtimer;
	public PlayView(DoodleModel aModel){
		super();
		this.model = aModel;
		this.layoutView();
		this.model.addView(new IView(){
			//repaint();
			public void updateView(){
				repaint();
			}
		});
	 }
	private void layoutView(){
		JButton jb = new JButton("Play");
	 jb.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			//model.playimage(model.getSliderPos());
			model.setPlay(true);
			playtimer = new Timer();
			int m = model.double_int((double)1000/40);
			playtimer.schedule(new TimerTask(){
				public void run(){
					if(model.getSliderPos() >= (model.numLines() * model.tickGap())){
						playtimer.cancel();
						playtimer.purge();
					}
					//System.out.println("current pos is " + model.getSliderPos());
					int val = model.double_int(model.playimage(model.getSliderPos()));
					//System.out.println("val is " + val);
					if(val == 0){
						val++;
					}
					model.setSliderPos(model.getSliderPos() + val);
				}
			}, m, m);
		}
	});
		//jb.addActionListener(new PlayListener());
		this.add(jb);
	}
}


// private class PlayListener implements ActionListener{
// 	public void actionPerformed(ActionEvent evt){
// 		playtimer = new Timer();
// 			int m = model.double_int((double)1000/40);
// 			playtimer.schedule(new TimerTask(){
// 				public void run(){
// 					if(model.getSliderPos() >= (model.numLines() * model.tickGap())){
// 						playtimer.cancel();
// 						playtimer.purge();
// 					}
// 					int val = model.double_int(model.playimage(model.getSliderPos()));
// 					model.setSliderPos(model.getSliderPos() + val);
// 				}
// 			}, m, m);
// 	}
// }