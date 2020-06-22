package sandbox.sorting;

import java.util.Arrays;

/**
 * @author Ruslan Gainutdinov
 *
 */
public class MergeSort {
	public static void main(String[] args) {		
		MergeSort mergeSort = new MergeSort();
		int [] arrayOfInt= new int[] {-1,-18,215,8,5,9,7,32,32,48,199,5,112,11,6,3,0,2,4,3,77};
	//	int [] arrayOfInt= new int[] {7,4};

		mergeSort.process(arrayOfInt);
		System.out.println("Actual result: "+Arrays.toString(arrayOfInt));

	}
	public void process(int [] array) {
		sort(array,0,array.length-1);
	}
	
	void sort(int [] array, int start, int end) {
		if(start<end) {
		int middle=(end+start)/2;
		
			//first half
			sort(array,start,middle);
		
			//second half
			sort(array,middle+1,end);
			
			merge(array,start,end,middle);
		
		}
	}
	
	void merge(int [] array, int start, int end, int middle) {
		System.out.println("***************STARTING MERGING*******************");
		printArray(array,start,end);
		System.out.println("Start: "+start+ " end: "+end+" middle: "+middle);
		int merger = start;
		int firstArraySize = middle-start+1;
		int secondArraySize = end-middle;
		
		System.out.println(">>>Size of first temporal array: "+firstArraySize);
		System.out.println(">>>Size of second temporal array: "+secondArraySize);

		int [] firstTempArray = new int[firstArraySize];
		int [] secondTempArray = new int[secondArraySize];
		
		for(int i = 0; i<firstTempArray.length; i++) {
			firstTempArray[i]=array[start++];
		}
		for(int i = 0; i<secondTempArray.length; i++) {
			secondTempArray[i]=array[++middle];
		}
		
		System.out.println("*******************");
		System.out.println("First "+Arrays.toString(firstTempArray));
		System.out.println("Second "+Arrays.toString(secondTempArray));
		System.out.println("*******************");
		
		int kFirst = 0;
		int kSecond = 0;
		
		while(kFirst<firstArraySize&&kSecond<secondArraySize) {
			if (firstTempArray[kFirst]<secondTempArray[kSecond]) {
				array[merger++]=firstTempArray[kFirst];
				kFirst++;
			}else {
				array[merger++]=secondTempArray[kSecond];
				kSecond++;
			}
		}
		while(kFirst<firstArraySize) {
			array[merger++]=firstTempArray[kFirst];
			kFirst++;
		}
		while(kSecond<secondArraySize) {
			array[merger++]=secondTempArray[kSecond];
			kSecond++;
		}
		System.out.println("~~~~~~~~~~~~~");
		System.out.println(Arrays.toString(array));
		System.out.println("~~~~~~~~~~~~~");
	}
	void printArray(int [] array, int start, int end) {
		for(int i=start;i<=end;i++) {
			System.out.println("Index: "+i+" Element: "+array[i]);
		}
		System.out.println(">>>>>>End of Array");
	}
}
