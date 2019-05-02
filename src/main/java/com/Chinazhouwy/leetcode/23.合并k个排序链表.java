import java.util.Comparator;
import java.util.PriorityQueue;


/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (44.41%)
 * Total Accepted:    19.5K
 * Total Submissions: 43.9K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,
        new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
        });  
        for(ListNode node : lists){
            queue.offer(node);
        } 
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(!queue.isEmpty()){
            ListNode temp = queue.poll();
            if(temp != null){
                cur.next = temp;
                queue.offer(temp);
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}

