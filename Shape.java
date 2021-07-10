import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
public abstract class Shape implements Movable {
	protected Point leftTop;
	protected List<Point> points;
	protected double area;
	protected double perimeter;
	protected boolean isCircular;
	protected int shapeNo ;
	public Shape () {
		shapeNo = 0;
		isCircular = false;
		points = new ArrayList<>();
	}
	
	
	public  abstract void calculatePoints();
	public abstract double calculateArea();
	public abstract double calculatePerimeter();
	
	
	

	@Override
	public abstract String toString();

}