package algoritm;

public class KMP {
	public static int kmp(String source, String pattern){
		char [] s = source.toCharArray();
		char [] p = pattern.toCharArray();
		int plen = p.length;
		int slen = s.length;
		int[] next = getNext(pattern);
		int j = 0,i=0;
		 while (i < slen && j < plen) {
             // 如果j = -1,或者当前字符匹配成功(src[i] = ptn[j]),都让i++,j++
             if (j == -1 || s[i] == p[j]) {
                 i++;
                 j++;
             } else {
                 // 如果j!=-1且当前字符匹配失败,则令i不变,j=next[j],即让pattern模式串右移j-next[j]个单位
                 j = next[j];
             }
         }
         if (j == plen)
             return i - j;
         return -1;

		
	}
	
	public static int[] getNext(String pattern){
		char[] p= pattern.toCharArray(); 
		int pLen = p.length;
         int[] next = new int[pLen];
         int k = -1;
         int j = 0;
         next[0] = -1; // next数组中next[0]为-1
         while (j < pLen - 1) {
             if (k == -1 || p[j] == p[k]) {
                 k++;
                 j++;
                 next[j] = k;
             } else {
                 k = next[k];
             }
         }
         return next;
	}
	
	
	public static int[] genNext(String pattern) {
		int n = pattern.length();
		char [] ca = pattern.toCharArray();
		int q,k;
		int[] next = new int[n];
		next[0] = 0;
		for(q= 1,k=0; q < n ; q++){
			while(k > 0 && ca[q] != ca[k]){
				k = next[k-1];
			}
			if(ca[q] == ca[k]){
				k++;
			}
			next[q] = k;
		}
		return next;
	}
	
	public static void main(String[] args) {
		//int [] next = genNext("agctagcagctagctg");
		int []next = getNext("agctagc");
		for(int i : next){
			System.out.print(i+"  ");
		}
		System.out.println("KMP:"+kmp("agctaaagctagctc","agctagc"));
	}
	
}
