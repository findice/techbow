package silentwing算法冲刺.session07_TrieAndLinkedList;

import dependentClass.ListNode;
import java.util.PriorityQueue;

//Project: techbow
//Package: silentwing算法冲刺.session07_TrieAndLinkedList
//ClassName: MergeKSortedLists
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-03 星期日 16:25

/*
多个 sorted好的ListNode链表，merge them
 */
public class MergeKSortedLists {
	
	// S1: Recursion, binary reduction
	// time = O(nlogk), space = O(1)  k: number of LinkedLists, n: number of nodes
	public ListNode mergeKLists1(ListNode[] lists) {
		// corner case
		if (lists == null || lists.length == 0) {
			return null;
		}
		
		return sort(lists, 0, lists.length - 1);
	}
	
	private ListNode sort(ListNode[] lists, int start, int end) {
		if (start >= end) {
			return lists[start];
		}
		int mid = start + (end - start) / 2;
		ListNode left = sort(lists, start, mid);
		ListNode right = sort(lists, mid + 1, end);
		return merge(left, right);
	}
	
	private ListNode merge(ListNode h1, ListNode h2) {
		if (h1 == null) {
			return h2;
		}
		if (h2 == null) {
			return h1;
		}
		
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		
		while (h1 != null && h2 != null) {
			if (h1.val < h2.val) {
				cur.next = h1;
				h1 = h1.next;
			} else {
				cur.next = h2;
				h2 = h2.next;
			}
			cur = cur.next;
		}
		if (h1 != null) {
			cur.next = h1;
		}
		if (h2 != null) {
			cur.next = h2;
		}
		return dummy.next;
	}
	
	// S2: Priority Queue
	// time = O(nklogk)， space = O(k)
	public ListNode mergeKLists2(ListNode[] lists) {
		// corner case
		if (lists == null || lists.length == 0) {
			return null;
		}
		
		PriorityQueue<ListNode> heap = new PriorityQueue<>((o1, o2) -> (o1.val - o2.val));
		
		for (ListNode node : lists) {   // O(klogk)
			if (node != null) {
				heap.offer(node);
			}
		}
		
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		
		while (!heap.isEmpty()) {
			cur.next = heap.poll();
			cur = cur.next;
			if (cur.next != null) {
				heap.offer(cur.next);
			}
		}
		return dummy.next;
	}
	
}
