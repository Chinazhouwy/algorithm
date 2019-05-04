package com.Chinazhouwy.leetcode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * 
 * 示例:
 * 
 * 输入: 1->2->6->3->4->5->6, val = 6 输出: 1->2->3->4->5
 * 
 * @author 18217
 *
 *         Definition for singly-linked list. public class ListNode { int val;
 *         ListNode next; ListNode(int x) { val = x; } }
 */
class Solution203 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
		
		ListNode(int[] nums){
			this.val = nums[0];
			ListNode cur = this;
			for(int i = 1; i<nums.length ; i++) {
				cur.next = new ListNode(nums[i]);
				cur = cur.next;
			}
		}
		
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append(val);
			ListNode prev = this;
			while(prev.next != null) {
				sb.append("->");
				sb.append(prev.next.val);
				prev = prev.next;
			}
			return sb.toString();
		}
	}

	public ListNode removeElements(ListNode head, int val) {
		// 找到第一个非val的节点
		while (head != null && head.val == val) {
			head = head.next;
		}
		if (head == null) {
			return head;
		}

		ListNode prev = head;

		while (prev.next != null) {
			if (prev.next.val == val) {
				prev.next = prev.next.next;
			} else {
				prev = prev.next;
			}
		}

		return head;

	}

	public ListNode removeElements2(ListNode head, int val) {
		// 找到第一个非val的节点
		ListNode dummyHead = new ListNode(-1);

		dummyHead.next = head;

		ListNode prev = dummyHead;

		while (prev.next != null) {
			if (prev.next.val == val) {
				prev.next = prev.next.next;
			} else {
				prev = prev.next;
			}
		}

		return dummyHead.next;

	}
	
	
	public ListNode removeElements3(ListNode head, int val) {
		if(head == null) {
			return null;
		}
		ListNode res = removeElements3(head.next,val);
		System.out.println("[head:"+head+" head.val:"+head.val+" head.next:"+head.next+" res:"+res+"]");
		if(head.val == val) {
			return res;
		}else {
			head.next = res;
			return head;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9,10};
		ListNode node = new ListNode(nums);
		System.out.println(node);
		ListNode listNode = new Solution203().removeElements3(node,6);
		System.out.println(listNode);
	}
}
