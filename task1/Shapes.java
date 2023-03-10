//package task1;
//import java.util.Scanner;
//
//
//interface Area{
//	final static double PI=3.14;
//	double circle(double r);
//	double square(double a);
//	double triangle(double a,double b,double c);
//	double sphere (double r);
//	double cuboid(double  a);
//}
//
//interface Volume{
//	final static double PI=3.14;
//	double sphere (double r);
//	double cuboid(double  a);
//	
//}
//
//class CalcArea implements Area {
//	public  double circle(double r) {
//		return PI*r*r;
//	}
//	
//	public double square(double a) {
//		return a*a;
//	}
//	
//	public double triangle(double a,double b,double c) {
//		return (a+b+c)/2;
//	}
//	public double sphere(double r) {
//		return PI*r*r;
//	}
//	
//	public double cuboid(double a) {
//		return a*a;
//	}
//}
//
//class CalVolume implements Volume{
//	
//	public double sphere(double r) {
//		return (4/3)*PI*r*r*r;
//	}
//	
//	public double cuboid(double a) {
//		return a*a*a;
//	}
//}
//
//public class Shapes {
//	public static void main(String[] args) {
//		CalcArea area = new CalcArea();
//		CalVolume  volume =new CalVolume();
//		
//		Scanner inp = new Scanner(System.in);
//		
//		System.out.println("Enter operation: area or volume:");
//		String operation = inp.nextLine();
//	
//		if(operation.equals("area")){
//			System.out.println("Araea caluclation");
//			System.out.println("Enter shape");
//			String shape=inp.nextLine();
//			
//			switch(shape) {
//			case "circle":
//			case "sphere":{
//				System.out.println("Enter radius");
//				System.out.println(area.circle(inp.nextDouble()));};
//			break;
//			
//			case "square":
//			case "cuboid":{
//				System.out.println("Enter side");
//				System.out.println(area.square(inp.nextDouble()));};
//			  break;
//			  
//			case "triangle":{
//				System.out.println("Enter three sides");
//				System.out.println(area.triangle(inp.nextDouble(),inp.nextDouble(),inp.nextDouble()));};
//			  break;
//			
//			default:System.out.println("Shape not valid");
//			}
//		}
//		
//		if(operation.equals("volume")) {
//			System.out.println("Volume caluclation");
//			System.out.println("Enter shape");
//			String shape=inp.nextLine();
//			
//			switch(shape) {
//			
//			case "sphere":{
//				System.out.println("Enter radius");
//				System.out.println(volume.sphere(inp.nextDouble()));};
//			break;
//			
//			case "cuboid":{
//				System.out.println("Enter side");
//				System.out.println(volume.cuboid(inp.nextDouble()));};
//			break;
//			  
//			default:System.out.println("Shape not valid");
//			
//			}
//		}
//	}
//}
