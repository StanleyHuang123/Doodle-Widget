package view;
import model.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.event.*;

public class EndView extends JPanel{
	private DoodleModel model;
	public EndView(DoodleModel aModel){
		super();
		this.model = aModel;
		this.layoutView();
		this.model.addView(new IView(){
			public void updateView(){
				repaint();
			}
		});
	}
	private void layoutView(){
		JButton je = new JButton("End");
		je.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				model.setSliderPos(model.numLines() * model.tickGap());
			}
		});
		this.add(je);
	}
}