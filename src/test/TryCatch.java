package test;

public class TryCatch {
	public static void main(String[] args) {
		int a = 0 ;
		try{
			 a = 1/0;
		}catch(Exception e){
			e.toString();
		}
		a=1;
		System.out.println(a);
		
	}
}
