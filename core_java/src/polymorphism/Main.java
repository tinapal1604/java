package polymorphism;

public class Main {

	public static void main(String[] args) {
		
		//Compile time polymorphism 
		Calculator cal = new Calculator();
		System.out.println(cal.add(4.5, 5.5));
		System.out.println(cal.add(5, 6));
		
		//Runtime polymorphism
		Animal a;
		a= new Dog();
		a.makeSound();
		a = new Cat();
		a.makeSound();
		Dog d = new Dog();
		
		//Up casting
		Animal an = d;
		an.makeSound();
		Animal anm = new Dog();
		Dog d0 = (Dog) anm;
		d0.makeSound();
		Cat c = (Cat) anm;
		c.makeSound();
		
	}

}
