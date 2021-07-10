import java.awt.Point;

public class Rectangle extends Shape{
	private int heig;
	private int wid;
	public Rectangle(int x,int y,int height , int width) {
		super();
		leftTop = new Point(x,y);
		heig = height;
		wid = width;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void calculatePoints() {
		Point RightT;
		Point RightB;
		Point LeftB;
		RightT = new Point(leftTop.x+ wid,leftTop.y);
		RightB = new Point(leftTop.x+wid,leftTop.y+heig);
		LeftB = new Point (leftTop.x,leftTop.y+heig);
		points.add(leftTop);
		points.add(RightT);
		points.add(RightB);
		points.add(LeftB);
		
	}

	
	
	@Override
	public double calculateArea() {
		area = heig*wid;
		return area;
	}
	
	
	@Override
	public double calculatePerimeter() {
		perimeter = (2*heig) + (2*wid);
		return perimeter;
		
	}
	
	@Override
	public void move(int newx, int newy) {
		leftTop = new Point(newx,newy);
		Point RightT;
		Point RightB;
		Point LeftB;
		RightT = new Point(leftTop.x+ wid,leftTop.y);
		RightB = new Point(leftTop.x+wid,leftTop.y+heig);
		LeftB = new Point (leftTop.x,leftTop.y+heig);
		points.set(0, leftTop);
		points.set(1, RightT);
		points.set(2, RightB);
		points.set(3, LeftB);
		
		
		
		
	}

	@Override
	public String toString() {
		 String point1 = "("+ points.get(0).x +"," + points.get(0).y+")";
		 String point2 = "("+ points.get(1).x +"," + points.get(1).y+")";
		 String point3 = "("+ points.get(2).x +"," + points.get(2).y+")";
		 String point4 = "("+ points.get(3).x +"," + points.get(3).y+")";
		 String point5 = "Points["+point1+point2+point3+point4+"]";
		return "Rectangle[h="+heig+",w="+wid+"]"+"\n"+point5+"\n"+"Area="+area+"\n"+"Perimeter="+perimeter;
	}




	
}
