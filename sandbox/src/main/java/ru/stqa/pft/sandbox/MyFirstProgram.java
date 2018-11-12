package ru.stqa.pft.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {
		hello("World");

		Square s = new Square(5);
		System.out.println("Area of square with edge lenght " + s.l + " = " + s.area());

		Rectangle r = new Rectangle(4, 6);
		System.out.println("Area of rectangle with edges lenght " + r.a + " and " + r.b + " = " + r.area());
	}

	public static void hello(String somebody) {
		System.out.println("Hello " + somebody + "!");
	}
}
