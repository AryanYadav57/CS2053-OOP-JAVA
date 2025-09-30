package lab004;
class Complex {
	int real, image;
	Complex() {
		real = 0;
		image = 0;
	}
	Complex(int r, int i) {
		real= r;
		image= i;
	}
	Complex add(Complex c) {
        return new Complex(real + c.real, image + c.image);
    }

    Complex add(int r, int i) {
        return new Complex(real + r, image + i);
    }

    void show() {
        System.out.println(real + " + " + image + "i");
    }
}
class ComplexSub extends Complex {
    ComplexSub(int r, int i) {
        super(r, i);
    }

    Complex sub(Complex c) {
        return new Complex(real - c.real, image - c.image);
    }
}
public class costructor_demo {
	public static void main(String[] args) {
        Complex c1 = new Complex(4, 3);  
        Complex c2 = new Complex(2, 1);  

        Complex sum = c1.add(c2);
        System.out.print("Sum: ");
        sum.show();

        Complex sum2 = c1.add(5, 2);
        System.out.print("Sum with values: ");
        sum2.show();

        ComplexSub c3 = new ComplexSub(4, 3);
        Complex diff = c3.sub(c2);
        System.out.print("Difference: ");
        diff.show();
    }
} 
