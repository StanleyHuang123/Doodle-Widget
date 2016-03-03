package view;
import model.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.event.*;
import java.awt.GridLayout;
import java.awt.BasicStroke;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.Image;

public class StrokeView extends JPanel{
	private DoodleModel model;
	private ButtonGroup rbGroup = new ButtonGroup();
	public StrokeView(DoodleModel aModel){
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
		JPanel jp = new JPanel(new GridLayout(2, 1));
	
		try{
		Image img_f = ImageIO.read(getClass().getResource("strokeThin.png"));
		Image img_fs = img_f.getScaledInstance(80, 40, java.awt.Image.SCALE_SMOOTH);
		Image img_s = ImageIO.read(getClass().getResource("strokeThick.png"));
		Image img_ss = img_s.getScaledInstance(80, 40, java.awt.Image.SCALE_SMOOTH);
		JRadioButton rb_f = new JRadioButton();
		JRadioButton rb_s = new JRadioButton();
		rb_f.setIcon(new ImageIcon(img_fs));
		rb_s.setIcon(new ImageIcon(img_ss));
		rb_f.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				model.setStroke(2);
			}
		});
		rb_s.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				model.setStroke(6);
			}
		});
		rbGroup.add(rb_f);
		rbGroup.add(rb_s);

		jp.add(rb_f);
		jp.add(rb_s);
		this.add(jp);
		}
		catch(IOException e){
			System.exit(2);
		}
	}
}