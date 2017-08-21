package algoritm;

public class Sort {
	/*
	 * 插入排序
	 */
	public static <AnyType extends Comparable<? super AnyType>> 
	void insertionSort(AnyType [] a ){
		int j;
		for(int p = 1; p < a.length ; p++){
			AnyType temp = a[p];
			for(j = p ; j>0 && temp.compareTo(a[j-1])<0 ; j--){
				a[j] = a[j-1];
			}
			a[j] = temp;
		}
	}
	/*
	 * 希尔排序
	 */
	public static <AnyType extends Comparable<? super AnyType>>
	void shellSort(AnyType [] a){
		int j ; 
		for( int gap = a.length/2 ; gap > 0 ;gap /= 2){
			for(int i = gap ; i < a.length ; i ++ ){
				AnyType temp = a[i];
				for(j = i ; j >= gap && temp.compareTo(a[j -gap]) < 0 ; j -= gap){
					a[j] = a[j -gap];
				}
				a[j] = temp;
			}
		}
	}
	
	/*
	 * 堆排序
	 */
	private static  int leftChild(int i){
		return 2 * i + 1 ;
	}
	/*
	 * i the position from which to percolate down 
	 * n the logical size of the binary heap  
	 */
	private static <AnyType extends Comparable<? super AnyType>>
	void percDown(AnyType [] a ,int i , int n){
		int child ;
		AnyType tmp;
		for (tmp = a[i] ; leftChild(i)<n; i= child){
			child = leftChild(i);
			if(child != n-1 && a[child].compareTo(a[child +1])< 0)
				child ++;
			if(tmp.compareTo(a[child])< 0)
				a[i] = a [child];
			else 
				break;
		}
		a[i] = tmp;
	}
	public static <AnyType extends Comparable<? super AnyType>> 
	void swapReferences(AnyType [] a ,int start ,int end){
		AnyType temp = a[start];
		a[start] = a[end];
		a[end] = a[start];
		
	}
	public static <AnyType extends Comparable<? super AnyType>>
	void heapSort(AnyType [] a){
		for (int i = a.length/2 ;i >= 0 ; i--){
			percDown(a, i, a.length);
		}
		for(int i = a.length -1 ; i > 0 ; i--){
			swapReferences(a,0,i);
			percDown(a, 0, i);
		}
	}
	
	private static <AnyType extends Comparable<? super AnyType>>
	void mergeSort(AnyType [] a, AnyType [] tmpArray, int left, int right){
		if(left < right){
			int center = (left + right) /2;
			mergeSort(a,tmpArray,left,center);
			mergeSort(a,tmpArray,center+1,right);
			merge(a,tmpArray,left,center+1,right);
		}
	}
	private static <AnyType extends Comparable<? super AnyType>>
	void merge(AnyType [] a,AnyType [] tmpArray,int left, int center, int right){
		int leftEnd = center -1;
		int tmpPos = left;
		int num = right - left + 1 ;
		while(left <= leftEnd && center <= right){
			if(a[left].compareTo(a[center]) <= 0){
				tmpArray[tmpPos++] = a[left++];
			}else{
				tmpArray[tmpPos++] = a[center++];
			}
		}
		while(left <= leftEnd){
			tmpArray[tmpPos++] = a[left++];
		}
		while(center <= right){
			tmpArray[tmpPos++] = a[center++];
		}
		
		for(int i = 0 ; i < num ; i++,right --){
			a[right] = tmpArray[right];
		}	
	}
	public static <AnyType extends Comparable<? super AnyType>>
	void mergeSort(AnyType [] a){
		AnyType [] tmpArray = (AnyType[]) new Comparable[a.length];
		mergeSort(a,tmpArray,0,a.length-1);
	}
	
	
	
	
	
	
	
	
	
	
}
