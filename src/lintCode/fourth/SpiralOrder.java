package lintCode.fourth;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
	
	public  static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		int row = matrix.length;
		int col ;
		if(row > 0)  col = matrix[0].length;
		else return list;
		int [] begin = {0,0};
		int [] end = {row - 1,col-1};
		int i =0 , j = 0;
		while(begin[0] < end[0] && begin[1] < end[1]){
			while(i+j <= end[0]+end[1]){
				list.add(matrix[i][j]);
				if(j < end[1]){
					j++;
				}else if(i < end[0]){
					i++;
				}else{
					break;
				}
			}
			j--;
			while(i+j > begin[0]+begin[1]){
				list.add(matrix[i][j]);
				if(j > begin[1]){
					j--;
				}else if(i> begin[0]){
					i--;
				}
			}
			begin[0] += 1;
			begin[1] += 1;
			end[0] -= 1;
			end[1] -= 1;
			if(begin[0] > end[0] || begin[1] > end[0]){
				break;
			}
			i = begin[0];
			j = begin[1];
			
		}
		if(begin[0] == end[0] && begin[1] == end[1]){
			list.add(matrix[i][j]);
		}
		if(begin[0] < end[0] && begin[1] == end[1]){
			for(int k = begin[0];k<=end[0];k++){
				list.add(matrix[k][j]);
			}
		}
		if(begin[1] < end[1] && begin[0] == end[0]){
			for(int k = begin[1] ; k<=end[1];k++){
				list.add(matrix[i][k]);
			}
		}
 		return list;
	}
	
	public static void main(String[] args) {
		int [][] a = {{1,2,3,4,5},{6,7,8,9,10}};
		for(Integer i :spiralOrder(a)){
			System.out.print(i+" ");
		}
	}

}
