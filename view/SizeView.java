package view;
import model.*;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JButton;

public class SizeView extends JPanel{
	private DoodleModel model;
	public SizeView(DoodleModel aModel){
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
		JPanel temp = new JPanel();
		temp.add(new JButton("Size"));
		this.add(temp);
	}
}