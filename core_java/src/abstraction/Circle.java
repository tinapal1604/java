package abstraction;

public class Circle extends Shape{
	
	private int radius;

	public Circle(String color, int radius) {
		setColor(color);
		this.radius = radius;
		
	}
	
	protected double area() {
		return Math.PI*radius*radius;
	}

	protected double perimeter() {
		// TODO Auto-generated method stub
		return 2*Math.PI*radius;
	}

}
