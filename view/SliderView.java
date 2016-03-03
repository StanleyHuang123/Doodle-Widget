package view;
import model.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.*;

public class SliderView extends JPanel{
	private DoodleModel model;
	private JSlider slider = new JSlider(0, 1000, 1000);
	private Boolean normal_change = false;
	public SliderView(DoodleModel aModel){
		super();
		this.model = aModel;
		this.layoutView();
		this.model.addView(new IView(){
			public void updateView(){
				//Color_d = model.getColor();
				slider.setMajorTickSpacing(model.tickGap());
				//System.out.println("here is " + model.numLines() * model.tickGap());
				//System.out.println("it is " + model.tickGap() * slider.getMajorTickSpacing());
				//if(model.numLines() != 0){
				//	slider.setValue(model.numLines() * model.tickGap());
				//	normal_change = true;
				//}


				//slider.setValue(100);
				// int number = slider.getValue() / model.tickGap();
	 		// 	System.out.println("number is " + number);
	 		// 	model.setLineTriggered(number);
	 		// 	int remainder = slider.getValue() % model.tickGap();
	 			
	 			//slider.repaint();
	 			slider.setValue(model.getSliderPos());
	 			repaint();
			}
		});
	}
	private void layoutView(){
		JPanel jp = new JPanel();
		slider.addChangeListener(new sliderListener());
		//slider.setMajorTickSpacing(33);
		slider.setPaintTicks(true);
		jp.add(slider);
		this.add(jp);
	}
	 private class sliderListener implements ChangeListener{
	 	public void stateChanged(ChangeEvent evt){
	 		//tell model that slider has been triggered.
	 		//System.out.println("enter here");
	 		//if(model.getPlay()){
	 		//	slider.setValue(model.getSliderPos());
	 		//}
	 		model.setSliderPos(slider.getValue());
	 		int acc_val = model.numLines() * model.tickGap();
	 		if(slider.getValue() >= acc_val){
	 			model.setlastLine(true);
	 		}
	 		else{
	 			model.setlastLine(false);
	 		}
	 		//if(slider.getValue() <= acc_val && normal_change == false){
	 		//if(normal_change == true && slider.getValue() < acc_val){
	 		//	normal_change = false;
	 		//}
	 		//if(slider.getValue() < acc_val){
	 		//System.out.println("slider value is " + slider.getValue());
	 			model.setSliderTrigger(true);
	 			//System.out.println("value is " + slider.getValue() + " and acc_val is " + acc_val);
	 			//int number = slider.getValue() / model.tickGap();
	 			//System.out.println("number is " + number);
	 			model.setLineTriggered(slider.getValue(), model.tickGap());
	 			//int remainder = slider.getValue() % model.tickGap();
	 			//System.out.println("remainder is " + remainder);
	 			model.setPointTriggered(slider.getValue(), model.tickGap());
	 		//}
	 			// System.out.println("value is " + slider.getValue());
	 			// int number = slider.getValue() / model.tickGap();
	 			// System.out.println("number is " + number);
	 			// model.setLineTriggered(number);
	 			// int remainder = slider.getValue() % model.tickGap();
	 			// model.setPointTriggered(remainder);
	 		
	 		// repaint();
	 	}
	 }
}