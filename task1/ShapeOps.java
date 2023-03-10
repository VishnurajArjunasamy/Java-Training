package task1;
import java.util.Scanner;

abstract class  Shape{
	
}

interface CalcArea{
	public double area();
}

interface CalcVolume{
	public double volume();
}

class Circle implements CalcArea{
	public double radius;
	final static double PI=3.14;
	
	Circle(double radius){
		this.radius=radius;
	}
	
	public double area() {
		return PI*radius*radius;
	}
}

class Square implements CalcArea{
	double side;
	
	Square(double side){
		this.side=side;
	}
	
	public double area() {
		return side*side;
	}
}

class Triangle implements CalcArea{
	double a,b,c;
	
	public Triangle(double a,double b,double c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	public double area() {
		return  (a+b+c)/2;
	}
	
}

class Sphere extends Circle implements CalcVolume{
	
	Sphere(double radius) {
		super(radius);
	}
	
	public double volume() {
		return (4/3)*PI*radius*radius*radius;
	}
}

class Cuboid extends Square implements CalcVolume{
	public Cuboid(double side) {
		super(side);
	}
	
	public double volume() {
		return side*side*side;
	}
}



public class ShapeOps {
	
	public static void main(String[] args) {
		Circle cir = new Circle(10);
		System.out.println(cir.area());
		
		Sphere sp = new Sphere(3);
		Cuboid cb =new Cuboid(10);
		System.out.println(cb.area());
		System.out.println(cb.area());
		
	}
}
