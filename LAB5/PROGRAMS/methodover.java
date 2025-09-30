package lab004;
class A{
	public int add(int a, int b) {
		return a + b;
	}
	public double add(double a, double b) {
		return a + b;
	}
}

class B extends A {
	public String add(String s1, String s2) { 
		return s1 + s2;
	}
}

public class methodover {
	public static void main(String[] args) {
		B obj = new B();
		
		System.out.println("Sum of 2 integer: " + obj.add(13,89));
		System.out.println("Sum of 2 double integer: " + obj.add(23.98, 45.09));
		System.out.println("Sum of 2 String: " + obj.add("Hello ", "I am class C"));
	}

}
