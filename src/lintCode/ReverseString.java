package lintCode;

public class ReverseString {
	public static String reverseWords(String s) {
		if (s == "") return "";
		StringBuilder sb = new StringBuilder();
		char[] c = s.toCharArray();
		int i = 0;
		int j = c.length-1;
		while(i <= j && c[i] == ' '){
			i++;
		}
		while(j>=0 && c[j] == ' '){
			j--;
		}
		if(i == c.length-1 || j == 0) return "";
		for(int x = j ; x >= i; x--){
			if(c[x] == ' '){
				if(c[x+1] != ' '){
					int tem = x+1;
					while(tem <= j && c[tem]!= ' '){
						sb.append(c[tem]);
						tem++;
					}
					sb.append(' ');
				}else{
					
				}
			}else if(c[x] != ' ' && x== i){
				int tem = x;
				while(tem <= j && c[tem]!= ' '){
					sb.append(c[tem]);
					tem++;
				}
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("saasd ");
		System.out.println(reverseWords(" "));
	}

}
