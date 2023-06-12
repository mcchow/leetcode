package leetcode.leetcode228;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> output = new ArrayList<String>();
        if(nums.length == 0)
        {
            return output;
        }
        if(nums.length == 1)
        {
            output.add(Integer.toString(nums[0]));
            return output;
        }
        int start=0;
        int count=1;
        for(int i=0; i < nums.length-1; i++)
        {
            if(nums[i]+1 != nums[i+1]){
                if(count == 1)// only 1 number
                {
                    output.add(Integer.toString(nums[start]));
                    start=start+1;
                }
                else // a range
                {
                    output.add(String.format("%d->%d", nums[start],nums[i]));
                    start=i+1;
                }
                count=0;
            }
            count++;
        }

        if(start==nums.length-1)
        {
            output.add(Integer.toString(nums[start]));
        }
        else
        {
            output.add(String.format("%d->%d", nums[start],nums[nums.length-1]));
        }
        return output;
    }
}
    public List<String> summaryRanges(int[] nums) {
        List<String> output = new ArrayList<String>();
        if(nums.length == 1)
        {
            output.add(Integer.toString(nums[0]));
            return output;
        }
        int pre=nums[0];
        int start=0;
        int count=1;
        for(int i=1; i < nums.length; i++)
        {
            if(pre+1 != nums[i]){
                if(count == 1)// only 1 number
                {
                    output.add(Integer.toString(nums[start]));
                    start=start+1;
                }
                else // a range
                {
                    output.add(String.format("%d->%d", nums[start],nums[i]));
                    start=i+1;
                }
                count=0;
            }
            count++;
        }
        return output;
        
    }
}