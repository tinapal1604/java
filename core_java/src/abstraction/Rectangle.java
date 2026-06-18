package abstraction;

public class Rectangle extends Shape{
	int l;
	int w;
	
	public Rectangle(int len, int bred, String color) {
		this.l = len;
		this.w = bred;
		setColor(color);
		
	}

	@Override
	protected double area() {
		// TODO Auto-generated method stub
		return l*w;
	}

	@Override
	protected double perimeter() {
		// TODO Auto-generated method stub
		return 2*(l+w);
	}

}
