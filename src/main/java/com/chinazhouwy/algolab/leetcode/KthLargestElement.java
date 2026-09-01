package com.chinazhouwy.algolab.leetcode;

import java.util.PriorityQueue;

class KthLargestElement {

    final PriorityQueue<Integer> queue ;
    final int k;
    public KthLargestElement(int k, int[] nums) {
       this.queue = new PriorityQueue<Integer>(k);
       this.k = k;
       for(int num : nums){
            add(num);
       }
    }
    
    public int add(int val) {
        if(queue.size() < k){
        	queue.offer(val);	
        }else {
        	if(queue.peek() < val) {
        		queue.poll();
        		queue.offer(val);
        	}
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4,5,8,2};
        KthLargestElement kthLargest = new KthLargestElement(3, arr);
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8
    }  


}
