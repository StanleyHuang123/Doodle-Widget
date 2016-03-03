package view;
import model.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.event.*;

public class StartView extends JPanel{
	private DoodleModel model;
	public StartView(DoodleModel aModel){
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
		JButton je = new JButton("Start");
		je.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				model.setSliderPos(0);
			}
		});
		this.add(je);
	}
}