package campus.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SoftDrink {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		while(sc.hasNext()){
			int temp = sc.nextInt();
			if(temp == 0 || temp < 1 || temp > 100) break;
			list.add(temp);
		}
		for(int i = 0 ; i < list.size() ;i++){
			int temp = list.get(i);
			int count = 0;
			while(temp / 3 > 0){
				count = count + temp / 3;
				temp = temp / 3 + temp % 3;
			}
			if(temp == 2) count += 1;
			System.out.println(count);
		}
	}
}


/*public class Main {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            if(num == 0 || num < 1 || num > 100)
                break;
            int m = num / 3;
            int n = num % 3;
            int count = m;
            while(m > 0){
                int temp1 = m;
                int temp2 = n;
                m = (temp1 + temp2) / 3;
                n = (temp1 + temp2) % 3;
                count += m;
            }
            if(m == 0 && n == 2)
                count++;
            System.out.println(count);
        }
        sc.close();
    }
}*/
