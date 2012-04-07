class Surcharge {
	int n;
	double x;

	Surcharge() {
		n = 1;
		x = 3.5;
	}

	Surcharge(int n, double x) {
		this.n = n;
		this.x = x;
	}

	int operation(int p) {
		return 10*p + n;
	}

	double operation(double y, int p) {
		return x*p + y;
	}

	double operation(int p, double y) {
		return (double)n/p + y;
	}
}

class EssaiSurcharge {
	public static void main(String[] arg) {
		Surcharge surcharge; 
		surcharge = new Surcharge();
		System.out.println(surcharge.operation(2));
		System.out.println(surcharge.operation(1.5, 4));
		System.out.println(surcharge.operation(4, 1.5));
		surcharge = new Surcharge(7, 2.0);
		System.out.println(surcharge.operation(2));
	}
}
