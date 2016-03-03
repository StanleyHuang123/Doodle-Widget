package view;
import model.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.event.*;
import java.util.Enumeration;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.event.*;
import javax.swing.colorchooser.*;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JButton;

import javax.swing.JPanel;

public class ColorChooseView extends JPanel{
	private DoodleModel model;

	public ColorChooseView(DoodleModel aModel){
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
		
		JButton jb_ch = new JButton("More Color");
		jb_ch.addActionListener(new ColorChooseAction());
		this.add(jb_ch);
	}

	private class ColorChooseAction implements ActionListener{
		JColorChooser cl_chooser = new JColorChooser();
		public void actionPerformed(ActionEvent evt){
			JFrame jf = new JFrame("ColorChooser");
			jf.setSize(600, 500);
			JPanel jp = new JPanel();
			jf.setContentPane(jp);

			cl_chooser.getSelectionModel().addChangeListener(new cl_chooseListener());
			jp.add(cl_chooser);

			jf.setVisible(true);
		}
		private class cl_chooseListener implements ChangeListener{
			public void stateChanged(ChangeEvent evt){
				model.setColor(cl_chooser.getColor());
			}
		}
	}
}