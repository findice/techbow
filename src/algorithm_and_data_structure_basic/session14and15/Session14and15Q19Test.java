package algorithm_and_data_structure_basic.session14and15;

import java.util.Arrays;
import java.util.List;

public class Session14and15Q19Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 5, 7, 9, 10, 13, 15 };
		int[] arr2 = { 6, 7, 11, 13, 15 };
		int[] arr3 = { 2 };
		int[] arr4 = { 5, 6 };
		test(arr1, arr2);
		test(arr3, arr4);
	}

	public static void test(int[] arr1, int[] arr2) {
		System.out.println("Original array1: " + Arrays.toString(arr1));
		System.out.println("Original array2: " + Arrays.toString(arr2));

		List<Integer> result1 = Session14and15Q19.twoPointersFindCommon(arr1, arr2);
		System.out.println("find common elements by 2 pointers: " + result1);
		
		List<Integer> result2 = Session14and15Q19.twoPointersFindCommon(arr1, arr2);
		System.out.println("find common elements by 2 pointers: " + result2);
		
		List<Integer> result3 = Session14and15Q19.twoPointersFindCommon(arr1, arr2);
		System.out.println("find common elements by 2 pointers: " + result3);
		System.out.println();

	}
}
