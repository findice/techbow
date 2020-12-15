package algorithm_and_data_structure_basic.session14and15;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Session14and15Q20 {
	// Solution 1: 3 pointers to find common elements
	public static int[] threePointersFindCommon(int[] arr1, int[] arr2, int[] arr3) {
		// corner case
		if (arr1 == null || arr2 == null || arr3 == null || arr1.length == 0 || arr2.length == 0
				|| arr3.length == 0) {
			return null;
		}

		// general case
		List<Integer> list = new ArrayList<>();
		int i = 0, j = 0, k = 0;
		int len1 = arr1.length;
		int len2 = arr2.length;
		int len3 = arr3.length;
		while (i < len1 && j < len2 && k < len3) {
			int min = Math.min(arr1[i], Math.min(arr2[j], arr3[k]));
			if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
				list.add(Integer.valueOf(arr1[i]));
				i++;
				j++;
				k++;
			} else if (arr1[i] == min) {
				i++;
			} else if (arr2[j] == min) {
				j++;
			} else { // arr3[k] 是arr1[i]， arr2[j]，arr3[k]中最小的
				k++;
			}
		}
		int[] result = new int[list.size()];
		for (int l = 0; l < list.size(); l++) {
			result[l] = list.get(l);
		}
		return result;
	}

	// Solution 2: minHeap to find the common elements
	public static int[] minHeapFindCommon(int[] arr1, int[] arr2, int[] arr3) {
		// corner case
		if (arr1 == null || arr2 == null || arr3 == null || arr1.length == 0 || arr2.length == 0
				|| arr3.length == 0) {
			return null;
		}

		// general case
		List<Integer> list = new ArrayList<>();
		int i = 0, j = 0, k = 0;
		PriorityQueue<Cell20> minHeap = new PriorityQueue<>(3, (o1, o2) -> o1.val - o2.val);
		minHeap.offer(new Cell20(1, 0, arr1[i]));
		minHeap.offer(new Cell20(2, 0, arr2[j]));
		minHeap.offer(new Cell20(3, 0, arr3[k]));
		while (i < arr1.length && j < arr2.length && k < arr3.length && !minHeap.isEmpty()) {
			if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
				list.add(arr1[i]);
				i++;
				j++;
				k++;
			}
			Cell20 temp = minHeap.poll();
			int r = temp.row;
			int c = temp.col;
			if (r == 1 && i < arr1.length - 1) {
				i = c + 1;
				minHeap.offer(new Cell20(r, i, arr1[i]));
			} else if (r == 2 && j < arr2.length - 1) {
				j = c + 1;
				minHeap.offer(new Cell20(r, j, arr2[j]));
			} else if (r == 3 && k < arr3.length - 1) {
				k = c + 1;
				minHeap.offer(new Cell20(r, k, arr3[k]));
			}
		}
		int[] result = new int[list.size()];
		for (int l = 0; l < list.size(); l++) {
			result[l] = list.get(l);
		}
		return result;
	}

	// Solution 3: use binary reduction to find the common elements
	public static int[] binaryReductionFindCommon(int[] arr1, int[] arr2, int[] arr3) {
		// corner case
		if (arr1 == null || arr2 == null || arr3 == null || arr1.length == 0 || arr2.length == 0
				|| arr3.length == 0) {
			return null;
		}
		int[] list = twoPointersFindCommon(arr1, arr2);
		int[] result = twoPointersFindCommon(list, arr3);
		return result;
	}

	private static int[] twoPointersFindCommon(int[] arr1, int[] arr2) {
		// corner case
		if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) {
			return null;
		}

		// general case
		int i = 0, j = 0;
		List<Integer> list = new ArrayList<>();

		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] == arr2[j]) {
				list.add(arr1[i]);
				i++;
				j++;
			} else if (arr1[i] > arr2[j]) {
				j++;
			} else {
				i++;
			}
		}
		int[] result = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			result[k] = list.get(k);
		}
		return result;

	}
}

class Cell20 {
	int row;
	int col;
	int val;

	public Cell20(int row, int col, int val) {
		this.row = row;
		this.col = col;
		this.val = val;
	}
}
