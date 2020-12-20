package algorithm_and_data_structure_basic.session14and15;

//Project: techbow
//Package: algorithm_and_data_structure_basic.session14and15
//ClassName: Q22FindKthSmallestElementsIn2SortedArray
//Author: Zeshi(Jesse) Yang
//Date: 2020-12-19 星期六 23:22
public class Q22FindKthSmallestElementsIn2SortedArray {
	
	public int kth(int[] a, int[] b, int k) {
		//assume a， b is not null， at least one of them is not empty，
		return kth(a, 0, b, 0, k);
	}
	
	//in the subarray of a starting from index aleft，and subarray of b starting from index bleft。
	//find the kth smalleset element among these two subarray
	private int kth(int[] a, int aleft, int[] b, int bleft, int k) {
		//the reason for this base case is in teh following logic we nned k >= 2 to make it work.
		if (aleft >= a.length) {
			return b[bleft + k - 1];
		}
		if (bleft >= b.length) {
			return a[aleft + k - 1];
		}
		if (k == 1) {
			return Math.min(a[aleft], b[bleft]);
		}
		//compare the k/2 th element in a's subarray
		//and the k/2 th element in b's subarray
		//to determine whick k/2 partition can be surely included in the smllest k elments.
		int amid = aleft + k / 2 - 1;
		int bmid = bleft + k / 2 - 1;
		int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
		int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
		if (aval <= bval) {
			return kth(a, amid + 1, b, bleft, k - k / 2);
		} else {
			return kth(a, aleft, b, bmid + 1, k - k / 2);
		}
	}
	
}