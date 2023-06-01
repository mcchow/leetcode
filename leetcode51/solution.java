package leetcode.leetcode51;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> result = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n)
    {
        
        List<int[]> queens = new ArrayList<int[]>();
        for(int i = 0; i <n; i++)
        {
            backTrackAdd(0,i,queens,n);
        }
        return result;
    }
    //queens.add(new int[]{x,y});
    private void backTrackAdd(int row, int col ,List<int[]> queens,int n)
    {
        //print result
        if(queenOk(row,col,queens))
        {
            queens.add(new int[]{row,col});
            if(queens.size() == n)
            {
                List<String> answer = new ArrayList<String>();
                for(int[] i: queens)
                {
                    String dots = ".".repeat(i[1]);
                    String generatedString = dots + "Q" + ".".repeat(n - i[1]-1);
                    answer.add(generatedString);
                }
                result.add(answer);
            }
            else
            {
                for(int i = 0; i <n; i++)
                {
                    backTrackAdd(row+1,i,queens,n);
                }
            }
            queens.remove(queens.size()-1);
        }
        else
        {
            return;
        }
        return;
    }


    private boolean queenOk(int row, int col , List<int[]> queens)
    {
        for(int[] queen : queens)
        {
            int dx = Math.abs(queen[0]-row);
            int dy = Math.abs(queen[1]-col);
            if(queen[0] == row || queen[1] == col || dx == dy)
            {
                return false;
            }
        }
        return true;
    }
    public class Main {
        public static void main(String[] args) {
            int n = 4; // Set the value of n as per your requirement
        
            Solution solution = new Solution();
            List<List<String>> result = solution.solveNQueens(n);
        
            // Print the result
            for (List<String> board : result) {
                for (String row : board) {
                    System.out.println(row);
                }
            System.out.println();
        }
    }
}
}
