package lab004;
class X{
	X() {
		System.out.println("Hello I am A. ");
	}
}
class Y extends X{
	Y() {
		System.out.println("Hello I am B. ");
	}
}
class Z extends Y{
	Z() {
		System.out.println("Hello I am C. ");
	}
}
public class demo {
	public static void main(String[] args) {
	new Z();
	}

}
