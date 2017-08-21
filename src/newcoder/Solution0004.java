package newcoder;

public class Solution0004 {
	public static void getOut(){
		//初始化
		Boolean [] crowd = new Boolean[30];
		int len = crowd.length;
		for(int i = 0 ; i < len ; i++) crowd[i] = true;
		
		int index = 0;
		int outCount = 0;
		while(outCount < 15 ){
			int count = 1 ;
			while(count <9){
				if(crowd[index] == true){
					count ++ ;
					if(index == len-1){
						index = 0 ;
					}else{
						index ++;
					}
				}else{
					if(index == len-1){
						index = 0;
					}else{
						index ++;
					}
				}
			}
			crowd[index] = false;
			outCount ++;
		}
		for(int i = 0 ; i < len ; i++) if(crowd[i] == true) System.out.println(i);;
		
	}
	public static void main(String[] args) {
		getOut();
	}
}
