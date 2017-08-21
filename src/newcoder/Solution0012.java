package newcoder;

public class Solution0012 {
	public static String replaceSpace(StringBuffer str) {
    	/*String [] s = str.toString().split(" ");
    	s[0].r
    	str.delete(0, str.length());
		for(int i = 0 ; i < s.length-1 ; i++){
			str.append(s[i]).append("%20");
		}
		str.append(s[s.length-1]);*/
		
		String s = str.toString();
		s.replaceAll("\\s", "%20");
		
		return s;
    }
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("hello world");
		System.out.println(replaceSpace(str));
	}
}
