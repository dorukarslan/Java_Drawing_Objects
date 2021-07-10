import java.awt.Point;


public class Square extends Shape{
	private int edge;
	
	public Square(int x,int y,int edge) {
		super();
		this.edge = edge;
		leftTop = new Point(x,y);
		// TODO Auto-generated constructor stub
	}
	 
	@Override
	public void calculatePoints() {
		Point RightT;
		Point RightB;
		Point LeftB;
		RightT = new Point(leftTop.x+edge,leftTop.y);
		RightB = new Point(leftTop.x+edge,leftTop.y+edge);
		LeftB = new Point (leftTop.x,leftTop.y+edge);
		points.add(leftTop);
		points.add(RightT);
		points.add(RightB);
		points.add(LeftB);
			
		
	}
	@Override
	public double calculateArea() {
		area = edge*edge;
		return area;
	}
	
	
	@Override
	public double calculatePerimeter() {
		perimeter = 4* edge;
		return perimeter;
		
	}
	
	
	@Override
	public String toString() {
		 String point1 = "("+ points.get(0).x +"," + points.get(0).y+")";
		 String point2 = "("+ points.get(1).x +"," + points.get(1).y+")";
		 String point3 = "("+ points.get(2).x +"," + points.get(2).y+")";
		 String point4 = "("+ points.get(3).x +"," + points.get(3).y+")";
		 String point5 = "Points["+point1+point2+point3+point4+"]";
		return "Square[e="+edge+"]"+"\n"+point5+"\n"+"Area="+area+"\n"+"Perimeter="+perimeter;
			
		
	}

	
	@Override
	public void move(int newx, int newy) {
		leftTop = new Point(newx,newy);
		Point RightT;
		Point RightB;
		Point LeftB;
		RightT = new Point(leftTop.x+edge,leftTop.y);
		RightB = new Point(leftTop.x+edge,leftTop.y+edge);
		LeftB = new Point (leftTop.x,leftTop.y+edge);
		points.set(0, leftTop);
		points.set(1, RightT);
		points.set(2, RightB);
		points.set(3, LeftB);
		
	}

}
