package leetcode.leetcode1502;

import java.util.Arrays;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[0]-arr[1];
        for(int i =1; i< arr.length ; i++)
        {
            if(arr[i-1]-arr[i] != diff){
                return false;
            }
        }
        return true;
    }
}