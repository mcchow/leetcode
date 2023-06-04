package leetcode.leetcode547;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count =0;
        int[] arr = new int[isConnected.length];
        for(int i=0;i<isConnected.length;i++)
        {
            if(arr[i] == 0)
            {
                count++;
                updateConnect(i,arr,isConnected);
            }
        }
        return count;
    }
    private void updateConnect(int index,int[] exist, int[][] isConnected)
    {
        exist[index]=1;
        for(int i=0;i<isConnected.length;i++)
        {
            if(exist[i] != 1 && isConnected[index][i] == 1)
            {
                exist[index]=1;
                updateConnect(i,exist,isConnected);
            }
        }
    }
}
