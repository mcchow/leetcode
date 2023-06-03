package leetcode.leetcode1376;

import java.util.ArrayList;
import java.util.List;

class Solution {
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            int max=informTime[headID];
            for(int i=0; i<n;i++)
            {
                if(informTime[i] == 0)
                {
                    continue;
                }
                max = Math.max(max, findpath(i,manager,informTime));
            }
            return max;
        }
        private int findpath(int n,int[] manager, int[] informTime)
        {
            int result=informTime[n];//6
            int position = n;
            while(manager[position] != -1)
            {
                position = manager[position];
                result+=informTime[position];
            }
            informTime[n]= result;
            manager[n] = -1;
            return result;
        }
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test case
        int n = 6;
        int headID = 2;
        int[] manager = {1,2,3,4,5,6,-1};
        int[] informTime = {0,6,5,4,3,2,1};
        int result = solution.numOfMinutes(n, headID, manager, informTime);
        System.out.println("Time taken to inform all employees: " + result + " minutes");
    }
}