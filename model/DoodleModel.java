package model;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.BasicStroke;

public class DoodleModel extends Object{
	private ArrayList<IView> views = new ArrayList<IView>();
	private Color cur_Color = Color.BLACK;
	private int stroke_pix = 2;
	private Boolean timer_b = false;
	private Boolean slider_trigger = false;
	private int cur_line_triggered = 0;
	private int percept_point_triggered = 0;
	private Boolean lastLine = false;
	private int slider_pos = 1000;
	private Timer timer;
	private Boolean setPlay_c = false;
	ArrayList<MyLine> total_line = new ArrayList<>();
	public DoodleModel(){
		timer = new Timer();
		int m = double_int((double)1000/40);
		timer.schedule(new TimerTask(){
			public void run(){
				timer_b = true;
			}
		}, m, m);
	}
	public void addView(IView view){
		this.views.add(view);
		view.updateView();
	}
	public void removeView(IView view){
		this.views.remove(view);
	}
	private void updateAllViews(){
		for(IView view: this.views){
			view.updateView();
		}
	}
	public void setStroke(int stroke_p){
		this.stroke_pix = stroke_p;
		this.updateAllViews();
	}
	public void setColor(Color c){
		this.cur_Color = c;
		this.updateAllViews();
	}
	public Color getColor(){
		return this.cur_Color;
	}
	public int getStroke(){
		return this.stroke_pix;
	}
	public void setTimerB(Boolean s){
		timer_b = s;
	}
	public Boolean getTimerB(){
		return this.timer_b;
	}
	public void setSliderTrigger(Boolean s){
		this.slider_trigger = s;
		this.updateAllViews();
	}
	public Boolean getSliderTrigger(){
		return this.slider_trigger;
	}
	public void setLineTriggered(int m, int n){
		//int abc = m / n;
		cur_line_triggered = m / n;
	}
	public int getLineTriggered(){
		return this.cur_line_triggered;
	}
	public void setPointTriggered(int m, int n){
		percept_point_triggered = m % n;
	}
	public int getPointTriggered(){
		return this.percept_point_triggered;
	}
	public void setlastLine(Boolean s){
		this.lastLine = s;
	}
	public Boolean getlastLine(){
		return this.lastLine;
	}
	public void setSliderPos(int n){
		this.slider_pos = n;
		this.updateAllViews();
	}
	public int getSliderPos(){
		return this.slider_pos;
	}
	public void setPlay(Boolean s){
		setPlay_c = s;
	}
	public Boolean getPlay(){
		return setPlay_c;
	}

	private class MyPoint{
		Point p = new Point();
		Boolean flag = false;
		MyPoint(Point p, Boolean flag){
			this.p = p;
			this.flag = flag;
		}
		private void setPointFlag(Boolean s){
			this.flag = s;
		}
		private Boolean getFlag(){
			return this.flag;
		}
	}

	private class MyLine{
		int stroke = 32;
		Color line_color = Color.BLACK;
		int bp = 0;
		ArrayList<MyPoint> line = new ArrayList<>();
		MyLine(int stroke, Color line_color){
			this.stroke = stroke;
			this.line_color = line_color;
		}
		private void inc_bp(){
			this.bp++;
		}
		private void dec_bp(){
			this.bp--;
		}
		private int get_bp(){
			return this.bp;
		}
		private void addPoint(MyPoint p){
			if(p.getFlag()){
				this.inc_bp();
			}
			line.add(p);
		}
		private int getLineSize(){
			return this.line.size();
		}
		private MyPoint getPoint(int k){
			return line.get(k);
		}
		private Color getLineColor(){
			return this.line_color;
		}
		private int getLineStroke(){
			return this.stroke;
		}
		private void remove_p(int i){
			if(getPoint(i).getFlag()){
				this.dec_bp();
			}
			this.line.remove(i);
		}
	}

	public int sizeTotal(){
		return total_line.size();
	}
	public void addLine(){
		MyLine myLine = new MyLine(this.getStroke(), this.getColor()); 

		total_line.add(myLine);
		this.updateAllViews();
	}
	public void addLinePoint(Point p, Boolean flag){
		MyPoint mp = new MyPoint(p, flag);
		int counter = total_line.size() - 1;
		total_line.get(counter).addPoint(mp);
	}

	public void remove(int n){
		int l = n / tickGap();
		if(n > numLines() * tickGap()){
			l--;
		}

		int r = n % tickGap();
		int tmp = l;
		tmp++;
		double t = (double)r / (double)tickGap();
		int size = total_line.get(l).getLineSize();
		double tmp_size = (double)size * t;
		int tt = (int)tmp_size;
	
		for(int i = total_line.get(l).getLineSize() - 1; i > tt;i--){
			total_line.get(l).line.remove(i);			
		}

		for(int j = total_line.size() - 1; j >= tmp; j--){
			total_line.remove(j);
		}
		
	}







	public int double_int(double b){
		int val = (int)b;
		
		if(b - val >= 0.5){
			val++;
		}
		return val;
	}
	public double line_point_triggered(int n, int value){
		double tmp = (double)value / (double)tickGap();
		int size = total_line.get(n).getLineSize();
		double tmp_size = (double)size * tmp;
		
		return tmp_size;
	}
	public void over_paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		int tmp_size;
		if(getSliderTrigger()){
			if(getlastLine()){
		
				tmp_size = getLineTriggered();
			}
			else{
			
				tmp_size = getLineTriggered() + 1;
			}
		}
		else{
	
			tmp_size = total_line.size();
		}


		if(!getSliderTrigger()){
			for(int i = 0; i < total_line.size(); i++){
				
			}
		}







		for(int i = 0; i < tmp_size; i++){
			GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, total_line.get(i).getLineSize());
			polyline.moveTo(total_line.get(i).getPoint(0).p.x, total_line.get(i).getPoint(0).p.y);

			if(!getSliderTrigger()){
				for(int j = 0; j < total_line.get(i).getLineSize(); j++){
					polyline.lineTo(total_line.get(i).getPoint(j).p.x, total_line.get(i).getPoint(j).p.y);
				}
			
			}
			else{
		
					if(!getlastLine()){
						double sdd = line_point_triggered(i, getPointTriggered());
						int sd = double_int(sdd);
				
						if(i == tmp_size - 1){
							for(int j = 0; j < sd; j++){
				
								polyline.lineTo(total_line.get(i).getPoint(j).p.x, total_line.get(i).getPoint(j).p.y);
							}
						}
						else{
							for(int j = 0; j < total_line.get(i).getLineSize(); j++){
								polyline.lineTo(total_line.get(i).getPoint(j).p.x, total_line.get(i).getPoint(j).p.y);
							}
						}
					}
					else{
						for(int j = 0; j < total_line.get(i).getLineSize(); j++){
							polyline.lineTo(total_line.get(i).getPoint(j).p.x, total_line.get(i).getPoint(j).p.y);
						}
					}
				
			}
			g2.setStroke(new BasicStroke(total_line.get(i).getLineStroke()));
			g2.setColor(total_line.get(i).getLineColor());
			g2.draw(polyline);
		}
	}
	public int numLines(){
		return total_line.size();
	}
	public int tickGap(){
		
		if(total_line.size() == 0){
			return 1000;
		}
		else{
			return 1000/total_line.size();
		}
	}
	public double playimage(int val){
		//int pos = getSliderPos();
		int l = val / tickGap();
		
		double gg = 0;
		if(val < numLines() * tickGap()){
			int num_f = total_line.get(l).get_bp();
			gg = (double)tickGap() / num_f;
		}
		if(gg == 0){
			gg = 1;
		}
		return gg;


	}

}