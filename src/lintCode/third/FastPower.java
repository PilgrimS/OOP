package lintCode.third;

public class FastPower {
	
	public static int fastPower1(int a, int b, int n) {
		boolean log = false;
		int pre = 0;
		int now = a%b;
		int count = 1;
		while(!log){
			if(now < pre){
				log = true;
			}else{
				if(count > n) return (int)Math.pow(a, n)%b;
				else{
					count ++;
					pre = now;
					now = (int)Math.pow(a,count)%b;
				}
				
			}
		}
		int left = n%count;
		int result = fastPower1(now,b,n/count)*(int)Math.pow(a, left)%b;
		return result;
	}
	public static int fastPower(int a, int b, int n) {
		if(a == 0) return 0;
		if(a == 1) return 1%b;
		if(n == 0) return 1%b;
		if(n == 1) return a%b;
		long result = fastPower(a, b, n/2);
		result *= result;
		result %= b;
		if(n%2 == 1) result *= a%b;
		result %= b;
		return (int)result;
	}
	
	public static void main(String[] args) {
		System.out.println(fastPower(27123,5201314,78965412));
	}

}
