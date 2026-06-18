package abstraction;

public class Main {

	public static void main(String[] args) {
		
		Shape [] shapes = {
				
				new Rectangle(6, 8, "Blue")
		};
		
		for(Shape s : shapes) {
			System.out.println(s);
		}
	}

}
