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

				slider.setMajorTickSpacing(model.tickGap());
			
	 			slider.setValue(model.getSliderPos());
	 			repaint();
			}
		});
	}
	private void layoutView(){
		JPanel jp = new JPanel();
		slider.addChangeListener(new sliderListener());

		slider.setPaintTicks(true);
		jp.add(slider);
		this.add(jp);
	}
	 private class sliderListener implements ChangeListener{
	 	public void stateChanged(ChangeEvent evt){
	 	
	 		model.setSliderPos(slider.getValue());
	 		int acc_val = model.numLines() * model.tickGap();
	 		if(slider.getValue() >= acc_val){
	 			model.setlastLine(true);
	 		}
	 		else{
	 			model.setlastLine(false);
	 		}
	
	 			model.setSliderTrigger(true);

	 			model.setLineTriggered(slider.getValue(), model.tickGap());

	 			model.setPointTriggered(slider.getValue(), model.tickGap());
	
	 	}
	 }
}