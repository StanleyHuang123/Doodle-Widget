import javax.swing.JFrame;

import java.awt.BorderLayout;
import view.*;
import model.DoodleModel;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JSlider;




public class main{
	public static void main(String[] args){
		model.DoodleModel model = new DoodleModel();
		FileView vFile = new FileView(model);
		SizeView vSize = new SizeView(model);
		ColorView vColor = new ColorView(model);
		ColorChooseView vChoose = new ColorChooseView(model);
		StrokeView vStroke = new StrokeView(model);
		PlayView vPlay = new PlayView(model);
		SliderView vSlider = new SliderView(model);
		StartView vStart = new StartView(model);
		EndView vEnd = new EndView(model);

		DrawView vDraw = new DrawView(model);





		JFrame frame = new JFrame("Doodle");
		frame.setSize(800, 600);
		frame.setLayout(new BorderLayout());


		Box b_top = Box.createHorizontalBox();
		b_top.add(vFile);
		b_top.add(vSize);
		frame.add(b_top, BorderLayout.NORTH);
		
		Box b_bot = Box.createHorizontalBox();
		b_bot.add(vPlay);
		b_bot.add(vSlider);
		b_bot.add(vStart);
		b_bot.add(vEnd);
		frame.add(b_bot, BorderLayout.SOUTH);



		
		Box b_left = Box.createVerticalBox();
		
		b_left.add(vColor);
		b_left.add(vChoose);
		
		b_left.add(vStroke);
		frame.add(b_left, BorderLayout.WEST);
		
		frame.add(vDraw, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
