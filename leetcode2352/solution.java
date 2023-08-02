package leetcode.leetcode2352;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public static int countEqualRowColumnPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;
        HashMap<int[], Integer> hash= new HashMap<int[], Integer>();
        for (int i = 0; i < n; i++) {
            int[] row = grid[i];
            hash.put(row, 0);
        }
        for (int i = 0; i < n; i++) {
            int[] column = getColumn(grid, i);
            if(hash.containsKey(column))
            {
                count++;
            }
        }

        return count;
    }

    private static int[] getColumn(int[][] grid, int columnIndex) {
        int n = grid.length;
        int[] column = new int[n];
        for (int i = 0; i < n; i++) {
            column[i] = grid[i][columnIndex];
        }
        return column;
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