package com.problems;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author kpandya
 */
public class WarmupQuestion1 {

    // solution doesn't handle duplicates; could use Set to avoid duplicates in priority queue
    public static int[] topKLargestElements(int[] arr, int k) {
        int[] result = new int[k];
        if(arr == null || arr.length==0 || arr.length < k) return result;

        PriorityQueue<Integer> pq = new PriorityQueue<>(k); // min-heap of size k
        for(int i : arr) {
            pq.offer(i);
            if(pq.size() > k) { // ensuring we have evicted all smaller elements if the size grows greater than k
                pq.poll();
            }
        }
        int i=k-1;
        while (!pq.isEmpty()) {
            result[i] = pq.poll();
            i--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,1,2,4,9,3,10,12,6,8,12,12,15,13,2,1,1,1,14,4,5};
        int[] res = topKLargestElements(arr, 5);
        Arrays.stream(res).forEach(i-> System.out.print(i +" "));
    }
}
