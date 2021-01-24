package algorithm_and_data_structure_basic.session02_sort_algorithm;

//Project: techbow
//Package: algorithm_and_data_structure_basic.session02_sort_algorithm
//ClassName: MergeSort
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-22 星期五 23:41
public final class MergeSort {
    
    public int[] sortArray(int[] nums) {
        // corner case
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int len = nums.length;
        int[] helper = new int[len];
        mergeSort(0, len - 1, nums, helper);
        return nums;
    }
    
    // merge sort the nums[start] to nums[end]
    private void mergeSort(int start, int end, int[] nums, int[] helper) {
        if (start == end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(start, mid, nums, helper);
        mergeSort(mid + 1, end, nums, helper);
        merge(start, mid, end, nums, helper);
    }
    
    // merge robFrom nums[start]- nums[mid], and nums[mid + 1] to nums[end]
    private void merge(int start, int mid, int end, int[] nums, int[] helper) {
        int index = start;
        int left = start;
        int right = mid + 1;
        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                helper[index++] = nums[left++];
            } else {
                helper[index++] = nums[right++];
            }
        }
        // left will reach to mid + 1 or right will reach to end + 1, only need to sort
        
        while (left <= mid) {
            helper[index++] = nums[left++];
        }
        // option 1
        /*System.arraycopy(helper, start, nums, start, right - start);
        return;*/
        //option 2
        while (right <= end) {
            helper[index++] = nums[right++];
        }
        System.arraycopy(helper, start, nums, start, end - start + 1);
    }
    
}
