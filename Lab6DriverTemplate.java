import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

//Draws simple shapes
public class Lab6DriverTemplate {
	
	public static void main(String[] args) {
		//TODO: Implement your own Shape class according to the Lab3 description
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		ArrayList<ShapeGroup> shapegroups = new ArrayList<ShapeGroup>();
		ArrayList<Shape>Drawshapes = new ArrayList<Shape>();
		//GRAPHICS: The next line will be removed or commented out before submission to Moodle, we will provide
		//and talk about the DrawingTool class during lab hours to introduce graphics support
		DrawingTool window = new DrawingTool(Drawshapes);
		ShapeGroup universalShapes = new ShapeGroup();
		shapegroups.add(universalShapes);
		
		Scanner scan = new Scanner(System.in);
		String userCommand = "";
		
		while (! userCommand.equalsIgnoreCase("exit")) {
			System.out.println("Enter the command: ");
			userCommand = scan.nextLine();

			String [] parameters = userCommand.split(" ");
			String command = parameters[0];
			
			if (command.equals("addR")) {
				//TODO: Read parameters and create a Rectangle object
				int x = Integer.parseInt(parameters[1]);
				int y = Integer.parseInt(parameters[2]);
				int h = Integer.parseInt(parameters[3]);
				int w = Integer.parseInt(parameters[4]);
				
				Shape dort = new Rectangle(x,y,h,w);
				dort.calculatePoints();
				dort.calculateArea();
				dort.calculatePerimeter();
				//TODO: Add the object to the shapes list
				shapes.add(dort);
				Drawshapes.add(dort);
				//TODO: Print the object
				System.out.println(dort);
			}
			else if (command.equals("addS")) {
				//TODO: Read parameters and create a Square object
				int x = Integer.parseInt(parameters[1]);
				int y = Integer.parseInt(parameters[2]);
				int e = Integer.parseInt(parameters[3]);
				
				Shape kare = new Square(x,y,e);
				kare.calculatePoints();
				kare.calculateArea();
				kare.calculatePerimeter();
				//TODO: Add the object to the shapes list
				shapes.add(kare);
				Drawshapes.add(kare);
				//TODO: Print the object
				System.out.println(kare);
			}
			else if (command.equals("addC")) {
				//TODO: Read parameters and create a Circle object
				int x = Integer.parseInt(parameters[1]);
				int y = Integer.parseInt(parameters[2]);
				int r = Integer.parseInt(parameters[3]);
				//TODO: Add the object to the shapes list
				Shape cem = new Circle(x,y,r);
				
				cem.calculatePoints();
				cem.calculateArea();
				cem.calculatePerimeter();
				shapes.add(cem);
				Drawshapes.add(cem);
				//TODO: Print the object	
				System.out.println(cem);
				
				
			}
			else if (command.equals("move")) {
				//Read parameters
				int shapeNo = Integer.parseInt(parameters[1]);
				int x = Integer.parseInt(parameters[2]);
				int y = Integer.parseInt(parameters[3]);
				
				//TODO: Implement your own Movable interface according to the Lab4 example
				Movable sm = shapes.get(shapeNo-1);
				
				//TODO: Move the object by calling the move method				
				sm.move(x, y);
				//TODO: Print the object
				System.out.println(sm);
				
				shapes.get(shapeNo-1).leftTop = new Point(x,y);
				shapes.get(shapeNo-1).calculatePoints();
				
				//TODO: Print the object
				
				
			}
			else if (command.equals("createEmptyGroup")) {
				ShapeGroup yenigrup = new ShapeGroup();
				shapegroups.add(yenigrup);
				System.out.println("New Group Added.");
			}
			else if (command.equals("addToGroup")) {
				int gno = Integer.parseInt(parameters[1]);
				int usn = Integer.parseInt(parameters[2]);
				shapegroups.get(gno).addShape(shapes.get(usn-1));
				shapes.remove(usn-1);
				shapegroups.get(gno).findLeftTop();
				System.out.println("Left Top Point: x: "+shapegroups.get(gno).shapeleftTop.x+", y: "+shapegroups.get(gno).shapeleftTop.y);
				System.out.println("Total Perimeter: "+ shapegroups.get(gno).totalper());
				for (int i =0 ; i< shapegroups.get(gno).list.size();i ++) {
					int kac =i+1;
					if(shapegroups.get(gno).list.get(i).shapeNo == 0) {
						shapegroups.get(gno).list.get(i).shapeNo = kac;
					}
					System.out.println("Shape "+ shapegroups.get(gno).list.get(i).shapeNo +":");
					System.out.println(shapegroups.get(gno).list.get(i));
				}

				
			}
			else if(command.equals("moveGroup")) {
				int gno = Integer.parseInt(parameters[1]);
				int newx = Integer.parseInt(parameters[2]);
				int newy = Integer.parseInt(parameters[3]);
				shapegroups.get(gno).moveGroup(newx, newy);
				System.out.println("Left Top Point: x: "+shapegroups.get(gno).shapeleftTop.x+", y: "+shapegroups.get(gno).shapeleftTop.y);
				System.out.println("Total Perimeter: "+shapegroups.get(gno).totalper());
				for (int i =0 ; i< shapegroups.get(gno).list.size();i ++) {
					int kac =i+1;
					System.out.println("Shape "+ kac +":");
					System.out.println(shapegroups.get(gno).list.get(i));
				}
			}
			else if(command.equals("switchGroup")) {
				int eskino = Integer.parseInt(parameters[1]);
				int yenino = Integer.parseInt(parameters[2]);
				int sno = Integer.parseInt(parameters[3]);
				
				shapegroups.get(yenino).addShape(shapegroups.get(eskino).list.get(sno-1));
				
				shapegroups.get(eskino).list.remove(sno-1);
				shapegroups.get(yenino).findLeftTop();
				shapegroups.get(eskino).findLeftTop();
				System.out.println("Left Top Point: x: "+ shapegroups.get(yenino).shapeleftTop.x +", y: "+ shapegroups.get(yenino).shapeleftTop.y);
				System.out.println("Total Perimeter: "+shapegroups.get(yenino).totalper());
				for(Shape sekil : shapegroups.get(yenino).list) {
					System.out.println("Shape " + sekil.shapeNo+":");
					System.out.println(sekil);
				}
				System.out.println("Left Top Point: x: "+ shapegroups.get(eskino).shapeleftTop.x +", y: "+ shapegroups.get(eskino).shapeleftTop.y);
				System.out.println("Total Perimeter: "+shapegroups.get(eskino).totalper());
				for( Shape digersekil : shapegroups.get(eskino).list) {
					System.out.println("Shape " + digersekil.shapeNo+":");
					System.out.println(digersekil);
				}
			}
			
			else if(command.equals("mergeGroups")) {
				
				int nobir = Integer.parseInt(parameters[1]);
				int noiki = Integer.parseInt(parameters[2]);
				
				
				if(shapegroups.get(nobir).list.size() > shapegroups.get(noiki).list.size()) {
					for( Shape sekil : shapegroups.get(noiki).list) {
						shapegroups.get(nobir).list.add(sekil);
						
					}
					shapegroups.remove(noiki);
					shapegroups.get(nobir).findLeftTop();
					System.out.println("Left Top Point: x: "+ shapegroups.get(nobir).shapeleftTop.x +", y: "+ shapegroups.get(nobir).shapeleftTop.y);
					System.out.println("Total Perimeter: "+shapegroups.get(nobir).totalper());
					for ( int x = 0; x< shapegroups.get(nobir).list.size(); x++) {
						System.out.println("Shape " + (x+1)+":");
						System.out.println(shapegroups.get(nobir).list.get(x));
					}
				
				}
				else {
					for(Shape sekil : shapegroups.get(nobir).list) {
						shapegroups.get(noiki).list.add(sekil);
					}
					
					shapegroups.remove(nobir);
					shapegroups.get(noiki).findLeftTop();
					System.out.println("Left Top Point: x: "+ shapegroups.get(noiki).shapeleftTop.x +", y: "+ shapegroups.get(noiki).shapeleftTop.y);
					System.out.println("Total Perimeter: "+shapegroups.get(noiki).totalper());
					for ( int a = 0; a< shapegroups.get(noiki).list.size(); a++) {
						System.out.println("Shape " + (a+1)+":");
						System.out.println(shapegroups.get(noiki).list.get(a));
					}
				}
				
				
			} 
			

			else if (command.equals("x")) {
				for(Shape shape : shapes) {
					System.out.println(shape.toString());
				}
			}
			
			
			//GRAPHICS: The next line will be removed or commented out before submission to Moodle
			window.repaint();
			
		}		
		scan.close();
		System.exit(0);
	}

}
