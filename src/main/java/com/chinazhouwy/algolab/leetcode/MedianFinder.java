package com.chinazhouwy.algolab.leetcode;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 *
 * https://leetcode-cn.com/problems/find-median-from-data-stream/description/
 *
 * algorithms
 * Hard (34.00%)
 * Total Accepted:    2.3K
 * Total Submissions: 6.8K
 * Testcase Example:  '["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]\n[[],[1],[2],[],[3],[]]'
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 
 * 例如，
 * 
 * [2,3,4] 的中位数是 3
 * 
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 
 * 设计一个支持以下两种操作的数据结构：
 * 
 * 
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 
 * 
 * 示例：
 * 
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3) 
 * findMedian() -> 2
 * 
 * 进阶:
 * 
 * 
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 
 * 
 */
class MedianFinder {

    /** initialize your data structure here. */

    final PriorityQueue<Integer> maxQueue = new PriorityQueue<>(10,new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    final PriorityQueue<Integer> minQueue = new PriorityQueue<>();


    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(maxQueue.size() != 0 && num <= maxQueue.peek()){
            maxQueue.offer(Integer.valueOf(num));
            if(maxQueue.size()-minQueue.size() > 1){
                Integer val = maxQueue.poll();
                minQueue.offer(val);
            }
        }else{
            minQueue.offer(Integer.valueOf(num));
            if(minQueue.size()-maxQueue.size() > 1){
                Integer val = minQueue.poll();
                maxQueue.offer(val);
            }
        }
    }
    
    public double findMedian() {
        if(maxQueue.size() > minQueue.size()){
            return maxQueue.peek();
        }else if(maxQueue.size() < minQueue.size()){
            return minQueue.peek();
        }else{
            return (maxQueue.peek() + minQueue.peek())/2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder aa = new MedianFinder();
        aa.addNum(-1);
        aa.addNum(-2);
        System.out.println(aa.findMedian());
        aa.addNum(-3);
        System.out.println(aa.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

