package leetcode.leetcode2090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k==0)
        {
            k=1;
        }
        int[] result = new int[nums.length];
        int[] sums = new int[nums.length];
        int sum =0;
        sums[0]=0;
        for(int i=0; i< nums.length;i++)
        {
            sum +=nums[i];
            sums[i+1] = sum;
        }
        for(int i=0; i< nums.length;i++)
        {
            if(i<k || i > nums.length-k)
            {
                result[i]=-1;
            }
            else
            {
                result[i]=(sums[i-k]-sums[i+k])/k;
                sum-=result[i-k];
            }
        }
        return result;
    }
}