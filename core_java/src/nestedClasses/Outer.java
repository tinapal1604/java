package nestedClasses;

public class Outer {
	
	static int outerStatic = 10;
	int outerInstance = 11;
	
	static class StaticNested {
		void display() {
			System.out.println(outerStatic);
		}
	}

}
