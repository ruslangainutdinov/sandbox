package sandbox.sorting;

import java.util.Arrays;

/**
 * @author Ruslan Gainutdinov
 *
 */
public class QuickSort {
	
	public static void main(String[] args) {

		QuickSort quickSort = new QuickSort();
		int[] arrayOfInt = new int[] { -1, -18, 215, 8, 89, 4, 7,0, 33, 32, 199, 112, 11, 6, 4, 3, 77 };
		
		//int [] arrayOfInt= new int[] {7,4};
		
		System.out.println("Before result: " + Arrays.toString(arrayOfInt));
		
		quickSort.process(arrayOfInt);
		
		System.out.println("Actual result: " + Arrays.toString(arrayOfInt));

	}

	/**
	 * processing actual sorting
	 * @param arrayOfInt
	 */
	private void process(int[] arrayOfInt) {

		sort(arrayOfInt, 0, arrayOfInt.length - 1);

	}

	/** Sort the input array using partition method
	 * @param arrayOfInt
	 * @param startPoint
	 * @param endPoint
	 */
	private void sort(int[] arrayOfInt, int startPoint, int endPoint) {
		if(startPoint<endPoint) {
			int pivot = partition(arrayOfInt,startPoint,endPoint);
			
			sort(arrayOfInt,startPoint,pivot-1);
			sort(arrayOfInt,pivot+1,endPoint);
		}
	}
	/**
	 * @param arrayOfInt
	 * @param startPoint
	 * @param endPoint
	 * @return pivot index
	 */
	private int partition(int[] arrayOfInt, int startPoint, int endPoint) {
		int pivotElement = arrayOfInt[endPoint];
		int pivotIndex = startPoint;
		for(int i=startPoint; i<endPoint; i++) {
			if(pivotElement>arrayOfInt[i]) {
				swap(arrayOfInt,pivotIndex++,i);
			}
		}
		swap(arrayOfInt,pivotIndex,endPoint);
		System.out.println("Temporal result: " + Arrays.toString(arrayOfInt));
		return pivotIndex;
	}

	/**
	 * @param arrayOfInt
	 * @param firstToSwap
	 * @param secondToSwap
	 */
	private void swap(int[] arrayOfInt, int firstToSwap, int secondToSwap) {
		int temp = arrayOfInt[firstToSwap];
		arrayOfInt[firstToSwap] = arrayOfInt[secondToSwap];
		arrayOfInt[secondToSwap] = temp;
	}
}
