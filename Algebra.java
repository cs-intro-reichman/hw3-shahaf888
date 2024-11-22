// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
		System.out.println(plus(-2,-3));   // -2 + (-3)
		System.out.println(plus(2,-3));   // 2 + (-3)
		System.out.println(plus(-2,3));   // -2 + (3)
		System.out.println(plus(-7,-4));
		System.out.println(plus(-7,4));
		System.out.println(plus(4,plus(4,4)));
		System.out.println("minus");
		System.out.println(plus(-4,plus(-4,-4)));
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
		System.out.println(minus(-2,7));  // -2 - 7
		System.out.println(minus(-2,-7));  // -2 -(-7)
		System.out.println(minus(-7,-2));
		System.out.println("times");
 		System.out.println(times(3,4));  // 3 * 4
		System.out.println(times(-3,4));  // -3 * 4
		System.out.println(times(1,-1));
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
		System.out.println("power");
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
		System.out.println(pow(-3,5));
		System.out.println("divider");
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
		System.out.println(div(7,25));   // 7 / 25
		System.out.println(div(7,4));   // 7 / 4    
   		System.out.println(div(7,-4));    // 7 / -4  
   		System.out.println(div(-7,-4));   // -7 / -4
		System.out.println(div(-7,4));   // -7 / 4
		System.out.println(div(-4,7));
		System.out.println(div(-4,-7));
		System.out.println(div(4,-7));
		System.out.println("mod");
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
		System.out.println(mod(7,-4));
		System.out.println(7%-4);
		System.out.println(mod(-7,-4));
		System.out.println(-7%-4);
		System.out.println(mod(-7,4));
		System.out.println(-7%4);
		System.out.println(mod(4,7));
		System.out.println(4%7);
		System.out.println(mod(4,-7));
		System.out.println(4%-7);
		System.out.println(mod(-4,-7));
		System.out.println(-4%-7);
		System.out.println("abs");
		System.out.println(abs(-4));
		System.out.println("sqrt");
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
		System.out.println(sqrt(7));
	}  

	// Returns x1 + x2
	//this is the not good one
	public static int plus1(int x1, int x2) {
		if (x2 >= 0){
			for (int i = 1; i <= x2; i++ ){
				x1++;
			}
		}
		else{
			x1 = minus(x1, x2);
		}
		
		return x1;
	}
	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		while (x2 != 0){

			if(x2 == 0){
				return x1;
			}

			if (x2 > 0){
				x1++;
				x2--;

			}
			else{
				x1--;
				x2++;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	//this is the not good one
	public static int minus1(int x1, int x2) {
		for (int i = 1; i <= x2; i++ ){
			x1--;
		}
		return x1;
	}
	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2 == 0){
			return x1;
		}
		while (x2!=0) { 
			if(x2 > 0){
				x1--;
				x2--;
			}
			else{
				x1++;
				x2++;
			}
			
		}
		return x1;
	}

	// Returns x1 * x2
	// i can replace with plus function
	public static int times1(int x1, int x2) {
		int x = x1;
		for (int i = 1; i < x2; i++){
			for (int j = 1; j <= x; j++ ){
				x1++;
			}

		}
		return x1;
	}

	public static int times(int x1, int x2) {
		int original = x1;
		if (x2 == 0 || x1 == 0){
			return 0;
		}
		else if (x2 == 1){
			return x1;
		}
		else {
			if (x1 > 0 && x2 >0){
				x2--;
				while(x2 != 0){
					x1 = plus (x1, original);
					x2--;
				}
			}
			//maybe i can put together
			else if (x1 < 0 && x2 > 0) {
				x2--;
				while (x2 != 0){
					x1 = plus (x1, original);
					x2--;
				}
				
			}
			else if (x1 > 0 && x2 < 0){
				x2--;
				while (x2 != 0){
					x1 = minus(x1, original);
					x2++;
				}
			}
			else {
				x2--;
				while (x2 != 0){
					x1 = minus(x1, original);
					x2++;
				}
			}
		}
		return x1;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n == 0){
			return 1;
		}
		int original = x;
		for (int i = 1; i < n; i++){
			x = times(x, original);
		}
		return x;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int x = 0;
		int counter = 0;
		if(x1 == 0){
			return 0;
		}
		
		if (x2 == 1){
			return x1;
		}
		if (x1 > 0 && x2 > 0){
			while(x1 > 0){
				x1 = minus(x1, x2);
				counter++;
			}
			if (x1 < 0){
				counter--;
			}
		}
		else if (x1 > 0 && x2 < 0){
			while(x1 > 0){
				x1 = plus(x1, x2);
				counter--;
			}
			if (x1 < 0){
				counter++;
			}
		}
		else if (x1 < 0 && x2 > 0){
			while(x1 < 0){
				x1 = plus(x1, x2);
				counter--;
			}
			if (x1 > 0){
				counter++;
			}
		}
		else if (x1 < 0 && x2 < 0){
			while(x1 < 0){
				x1 = minus(x1, x2);
				counter++;
			}
			if (x1 > 0){
				counter--;
			}
		}
		
		return counter;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int divider = 0;
		divider = div(x1, x2);
		int mod = 0;
		mod = minus(x1, times(x2,div(x1, x2)));
		return mod;
	}	

	//return the abs of int
	public static int abs(int x){
		if (x >= 0){
			return x;
		}
		else{
			x = times(x,-1);
			return x;
		}
	}

	// Returns the integer part of sqrt(x) 
	public static int sqrt1(int x) {
		if (x == 0){
			return 0;
		}
		else if (x <0){

		}
		else{
			double epsilon = 0.01;
			int g = x;
			while(abs(minus(times(g,g),x)) > epsilon){
				g = minus(g,div(minus(times(g,g),x), times(2,g)));

			}
			return g;

		}
		return 0;
	}	  
	public static int sqrt(int x){
		
		if (x < 2){
			return x;
		}
		int low = 0;
		int high = x;

		while (low <= high){
			int mid = div(plus(low,high),2);
			if(times(mid,mid) == x)
			{
				return mid;
			}
			else if(times(mid,mid) < x){
				low = plus(mid,1);
			}
			else{
				high = minus(mid,1);
			}
		}
		return high;


	}
	
	
}