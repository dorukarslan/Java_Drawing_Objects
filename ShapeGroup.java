import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class ShapeGroup {

	

	ArrayList<Shape> list = new ArrayList<Shape>();
	public Point shapeleftTop;
	public double totalPer;
	public ShapeGroup(){
		
	}
	
	public double totalper() {
		totalPer = 0;
		for(Shape sekil : list) {
			totalPer += sekil.calculatePerimeter();
		}
		return totalPer;
	}
	public void addShape(Shape newS) {
		list.add(newS);
	}
	public void removeShape(int idx) {
		list.remove(idx);
	}
	
	public  void moveGroup(int newx,int newy) {
		int a = shapeleftTop.x-newx;
		int b = newy-shapeleftTop.y;
		shapeleftTop = new Point(newx,newy);
		for(Shape hsekil : list) {
			hsekil.move(hsekil.leftTop.x-a,hsekil.leftTop.y+b);
		}
	}
	public Shape getShape(int idx) {
		return list.get(idx);
	}
	public void findLeftTop() {
		int enkucukx = list.get(0).leftTop.x ;
		int enkucuky = list.get(0).leftTop.y;
		for(Shape sekil : list) {
			if(sekil.leftTop.x <enkucukx) {
				enkucukx = sekil.leftTop.x;
				
			}
			if(sekil.leftTop.y < enkucuky) {
				enkucuky = sekil.leftTop.y;
			}
		}
		shapeleftTop = new Point(enkucukx,enkucuky);
		
	}
	
}