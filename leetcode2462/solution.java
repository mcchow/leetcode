package leetcode.leetcode2462;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.logging.Level;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> minHeapL = new PriorityQueue<>();
        PriorityQueue<Integer> minHeapR = new PriorityQueue<>();
        int left=candidates;
        int right=Math.max(candidates, costs.length-candidates);
        long result =0;
        for(int i=0;i<candidates;i++)
        {
            minHeapL.add(costs[i]);
        }
        for(int i=Math.max(candidates, costs.length-candidates);i<costs.length;i++)
        {
            minHeapR.add(costs[i]);
        }
        for(int i=0;i<k;i++)
        {
            if(minHeapR.size() == 0 || minHeapL.size() == 0)
            {
                if(minHeapR.size() == 0)
                {
                    result+=minHeapL.poll();
                }
                else
                {
                    result+=minHeapR.poll();
                }
            }
            else
            {
                if(minHeapR.peek() < minHeapL.peek())
                {
                    result+=minHeapR.poll();
                    right--;
                    if(right>left)
                    {
                        minHeapR.add(right);
                    }
                }
                else
                {
                    result+=minHeapL.poll();
                    left++;
                    if(left<right)
                    {
                        minHeapL.add(left);
                    }
                }
            }
            
        }
        return result;
    }
}