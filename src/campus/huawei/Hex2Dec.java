package campus.huawei;

import java.util.Scanner;

public class Hex2Dec {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String hex = sc.nextLine();
			System.out.println(Integer.parseInt(hex.substring(2, hex.length()), 16));
		}
		
	}

}
