package abstraction;

public abstract class Shape {
	private String color;

	
	public void  setColor(String color) {
		this.color = color;
	}
	
	String getColor() {
		return color;
	}
	
	protected abstract double area();
	protected abstract double perimeter();
	
	@Override
	public String toString() {
		return "Color: "+ color+" | Area: "+ area();
	}
	

}
