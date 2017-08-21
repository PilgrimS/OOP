package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Scanner ii = new Scanner(System.in);
		int n,m = 0;
		do{
			n = ii.nextInt();
		}while(n<=0||n>=30000);
		do{
			m = ii.nextInt();
		}while(m<=0||m>=5000);
		int arr[] = new int[n+1];
		arr[0] = 0;
		for(int i = 1;i<n+1;i++){
			arr[i] = ii.nextInt();
		}
		List <List> list = new ArrayList<List>();
		
		for (int i=0;i<m;i++){
			String temp = s.nextLine();
			String [] str = temp.split(" ");
			List temList = new ArrayList();
			temList.add(str[0]);
			temList.add(Integer.parseInt(str[1]));
			temList.add(Integer.parseInt(str[2]));
			list.add(temList);
		}
		for(int i = 0; i<m ;i++){
			List temp = list.get(i);
			handle(temp,arr);
			
		}
		for(int i = 1 ; i<n+1 ; i++){
			System.out.print(arr[i]);
		}
		
	}
	public static void handle(List temp,int []arr){
		String c = (String) temp.get(0);
		int a = (int) temp.get(1);
		int b = (int) temp.get(2);
		if("U".equals(c)){
			arr[a] = b;
		}
		if("Q".equals(c)){
			int max = arr[a] ;
			for(int i = a;i<=b;i++){
				if(arr[i]>max){
					max = arr[i];
				}
			}
		}
	}

}
