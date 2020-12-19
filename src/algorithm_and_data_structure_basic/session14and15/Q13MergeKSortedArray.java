package algorithm_and_data_structure_basic.session14and15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*Merge K sorted array*/
public class Q13MergeKSortedArray {

	// Solution 1: use minHeap to find the min in the k nums
	public static int[] mergeKSortedArrayByMinHeap(int[][] nums) {
		if (nums == null || nums.length == 0 || nums[0] == null || nums[0].length == 0) {
			return new int[] {};
		}

		PriorityQueue<Cell> minHeap = new PriorityQueue<>(nums.length, new MyComparator());

		int rows = 0;
		for (int i = 0; i < nums.length; i++) {
			rows += nums[i].length;
			if (nums[i] != null && nums[i].length != 0) {
				minHeap.offer(new Cell(i, 0, nums[i][0]));
			}
		}
		int[] res = new int[rows];
		int curIndex = 0;
		while (!minHeap.isEmpty()) {
			Cell curCell = minHeap.poll();
			res[curIndex++] = curCell.val;
			if (curCell.col + 1 < nums[curCell.row].length) {
				minHeap.offer(new Cell(curCell.row, curCell.col + 1,
						nums[curCell.row][curCell.col + 1]));
			}
		}
		return res;
	}

	// Solution 2: use binary merge to form the merged int[][]
	public static int[] mergeKSortedArrayByBinaryMerge(int[][] nums) {
		if (nums == null || nums.length == 0)
			return null;
		return mergeKSortedArray2(nums, 0, nums.length - 1);
	}

	private static int[] mergeKSortedArray2(int[][] nums, int start, int end) {
		if (nums.length == 1) {
			int[] arr = nums[0].clone();
			return arr;
		}

		int[][] mergedNums = new int[(nums.length + 1) / 2][];

		for (int i = 0; i < (nums.length + 1) / 2; i++) {
			int[] res = merge(nums, start, end);
			mergedNums[i] = res;
			start++;
			end--;
		}
		return mergeKSortedArray2(mergedNums, 0, mergedNums.length - 1);
	}

	private static int[] merge(int[][] nums, int start, int end) {
		if (start == end) {
			return nums[start];
		}
		int[] nums1 = nums[start];
		int[] nums2 = nums[end];
		int[] temp = new int[nums1.length + nums2.length];
		int cur1 = 0;
		int cur2 = 0;
		int cur = 0;
		while (cur1 < nums1.length && cur2 < nums2.length) {
			if (nums1[cur1] < nums2[cur2]) {
				temp[cur] = nums1[cur1++];
			} else {
				temp[cur] = nums2[cur2++];
			}
			cur++;
		}
		while (cur1 < nums1.length) {
			temp[cur++] = nums1[cur1++];
		}
		while (cur2 < nums2.length) {
			temp[cur++] = nums2[cur2++];
		}
		return temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums1 = { { 1, 4, 8 }, { 3, 10, 100, 101, 102 }, { 2, 3, 4 }, { 9, 65, 78 },
				{ 22, 23, 54, 76 } };
		int[][] nums2 = { { 1, 5, 6 }, { 2, 8, 9, 10 }, { 64, 19, 20, 30 }, { 345, 135, 289 } };
		test(nums1);
		test(nums2);
		return;
	}
	
	private static void test(int[][] nums) {
		int[] res1 = mergeKSortedArrayByMinHeap(nums);
		System.out.println("Original arrays: " + Arrays.deepToString(nums));
		System.out.println("Merged Arrays Solution 1: " + Arrays.toString(res1));
		int[] res2 = mergeKSortedArrayByBinaryMerge(nums);
		System.out.println("Merged Arrays Solution 2: " + Arrays.toString(res2));
		System.out.println();
	}
	
	static class Cell {
		int row;
		int col;
		int val;
	
		public Cell(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}
	
	static class MyComparator implements Comparator<Cell> {
		public int compare(Cell c1, Cell c2) {
			return c1.val - c2.val;
		}
	}
}

