package view;
import model.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JPanel;

import java.util.Enumeration;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.event.*;
import javax.swing.colorchooser.*;
import java.awt.Dimension;

public class ColorView extends JPanel{
	private DoodleModel model;
	private ButtonGroup rbGroup = new ButtonGroup();
	// private JColorChooser cl_chooser = new JColorChooser();
	public ColorView(DoodleModel aModel){
		super();
		this.model = aModel;
		this.layoutView();
		this.model.addView(new IView(){
			public void updateView(){
				//System.out.println("oh Color changed");
				repaint();
			}
		});
	}

	private void layoutView(){
		//this.add(rbGroup);
		//JPanel t_jp = new JPanel(new GridLayout(1, 2));
		JPanel radioPanel = new JPanel(new GridLayout(6, 2));
		for(String s: new String[] {"Black", "Green", "Red", "Blue", "Yellow", "Pink"}){
			JRadioButton rb = new JRadioButton();

			rb.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Color radio_c;
					switch(s){
						case "Green":
							radio_c = Color.GREEN;
							break;
						case "Red":
							radio_c = Color.RED;
							break;
						case "Blue":
							radio_c = Color.BLUE;
							break;
						case "Yellow":
							radio_c = Color.YELLOW;
							break;
						case "Pink":
							radio_c = Color.PINK;
							break;
						default:
							radio_c = Color.BLACK;
							break;
					}
					model.setColor(radio_c);
				}
			});
			//rb.setBackground(Color.YELLOW);
			rbGroup.add(rb);
			JPanel jp = new JPanel();
			jp.setSize(100, 100);
			Color radio_cp;
					switch(s){
						case "Green":
							radio_cp = Color.GREEN;
							break;
						case "Red":
							radio_cp = Color.RED;
							break;
						case "Blue":
							radio_cp = Color.BLUE;
							break;
						case "Yellow":
							radio_cp = Color.YELLOW;
							break;
						case "Pink":
							radio_cp = Color.PINK;
							break;
						default:
							radio_cp = Color.BLACK;
							break;
					}
			jp.setBackground(radio_cp);
			radioPanel.add(rb);
			radioPanel.add(jp);
		}
		this.add(radioPanel);
		//JColorChooser cl_chooser = new JColorChooser();
		// JPanel jp = new JPanel();
		// jp.setPreferredSize(new Dimension(200, 200));
		// cl_chooser.getSelectionModel().addChangeListener(new cl_chooseListener());
		// jp.add(cl_chooser);
		// t_jp.add(jp);
		// this.add(t_jp);
		
	}

	// private class cl_chooseListener implements ChangeListener{
	// 	public void stateChanged(ChangeEvent evt){
	// 		model.setColor(cl_chooser.getColor());
	// 	}
	// }
}


