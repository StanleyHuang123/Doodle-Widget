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
		//DrawBoardView vDBoard = new DrawBoardView(model);
		//ScrollView vScroll = new ScrollView(model);
		//DrawTopView vDTop = new DrawTopView(model);
		DrawView vDraw = new DrawView(model);
/*
		JFrame frame = new JFrame("Doodle");
		//frame.setBackground(Color.YELLOW);
		frame.setSize(800, 600);		
		frame.setBackground(Color.YELLOW);
		
		frame.getContentPane().setLayout(new BorderLayout());

		Box b_top = Box.createHorizontalBox();
		b_top.add(vFile);
		//b_top.add(vSize);
		frame.getContentPane().add(b_top, BorderLayout.NORTH);

		Box b_left = Box.createVerticalBox();
		
		b_left.add(vColor);
		
		//b_left.add(vStroke);
		frame.getContentPane().add(b_left, BorderLayout.WEST);
	

		frame.getContentPane().add(vDraw, BorderLayout.CENTER);
/*
		Box b_bot = Box.createHorizontalBox();
		b_bot.add(vPlay);
		b_bot.add(vSlider);
		b_bot.add(vStart);
		b_bot.add(vEnd);
		frame.getContentPane().add(b_bot, BorderLayout.SOUTH);*/
		//frame.pack();
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setVisible(true);



		//new LayoutFrame("Doodle", new Demo());
		JFrame frame = new JFrame("Doodle");
		frame.setSize(800, 600);
		frame.setLayout(new BorderLayout());
		//frame.add(new JButton("North"), BorderLayout.NORTH);

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



		//this.add(new JButton("East"), BorderLayout.EAST);
		//frame.add(new JButton("South"), BorderLayout.SOUTH);
		
		// Layouts can be nested
		// Box is an easy-to-create panel with a BoxLayout
		//Box b = Box.createVerticalBox();
		//b.add(new JButton("Box this!"));
		//b.add(new JButton("Box that!"));
		//b.add(Box.createVerticalGlue());
		//b.add(new JButton("Box whatever"));
		//frame.add(b, BorderLayout.WEST);
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
/*
class LayoutFrame extends JFrame{
	public LayoutFrame(String title, Demo contents){
		super(title);
		this.setContentPane(contents);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

class Demo extends JPanel{
	public Demo() {
		super();
		this.setLayout(new BorderLayout());
		this.add(new JButton("North"), BorderLayout.NORTH);
		this.add(new JTextField("South"), BorderLayout.SOUTH);
		//this.add(new JButton("East"), BorderLayout.EAST);
		this.add(new JButton("South"), BorderLayout.SOUTH);
		
		// Layouts can be nested
		// Box is an easy-to-create panel with a BoxLayout
		Box b = Box.createVerticalBox();
		b.add(new JButton("Box this!"));
		b.add(new JButton("Box that!"));
		b.add(Box.createVerticalGlue());
		b.add(new JButton("Box whatever"));
		this.add(b, BorderLayout.WEST);
		
		this.add(new JTextField("Center"), BorderLayout.CENTER);
	}
}*/