package fractionCalc;

import java.util.Scanner;

public class FractionCalculator extends slash   {

	public static void main(String[] args) {
System.out.println("This is fraction calculator.");
System.out.println("You can add,subtract, multiply, divide and compare fractions." );	
System.out.println("Enter your fraction in the form a/b, where a and b are integers.");
System.out.println("Press q to quit.");
Scanner sc=new Scanner(System.in);
boolean flag=true;
while(flag) {
String x= getOperation(sc);
if(!x.equals("q")) {
	Fraction f=getFraction(sc);
	Fraction d=getFraction(sc);;
switch (x){
case "+":
	System.out.println(f+"+"+d+"="+f.add(d));
	break;
case "-":
	System.out.println(f+"-"+d+"="+f.subtract(d));
	break;
case "*":
	System.out.println(f+"*"+d+"="+f.multiply(d));
	break;
case "/":
	System.out.println(f+"/"+d+"="+f.divide(d));
	break;
case "=":
	if(f.equals(d)) {
	System.out.println(f+" equals to "+d);
	}System.out.println(f+" doesn't equal to "+d);
	break;
default:
	System.out.println("Invalid input.");
}
}else break;
}
		}
	public  static String getOperation(Scanner sc) {
		boolean flag=true;
		String s="";
		while(flag) {
		System.out.println("Please enter an operation (+,-,/,*,= or q to quit).");
		s=sc.nextLine();
		if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")||s.equals("=")){
			flag=false;
			return s;
		}else if(s.equals("q")||s.equals("Q")) {
			flag=false;
			return "q";
		}else 
			System.out.println("Invalid input.");
		
		}
		return s;

	}
	public static boolean validFraction(String s) {
		
		if(isNumber(beforeSlash(s))&&isNumber(afterSlash(s))||isNumber(s)) {
			if((Integer.parseInt(afterSlash(s))<1)) {
				System.out.println("Valid fraction");
				return false;
			}
			return true;
		}
		System.out.println("Valid fraction");
		return false;
	}
	public static Fraction getFraction(Scanner sc) {
		Fraction f=new Fraction();
		boolean flag=true;
		while(flag) {
		System.out.println("Please enter a fraction (a/b) or integer (a):");
		String s=sc.nextLine();
		if(validFraction(s)) {
			if(isNumber(s)) {
				Fraction z=new Fraction(Integer.parseInt(s));
				return z;
						}
			Fraction ff=new Fraction(Integer.parseInt(beforeSlash(s)),Integer.parseInt(afterSlash(s)));
			flag=false;
			return ff;
		}
		}return f;
	}
}
