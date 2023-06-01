import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n)
    {
        
        List<int[]> queens;
        for(int i = 0; i <n; i++)
        {
            backTrackAdd(i,0,queens,n);
        }
        return result;
    }
    //queens.add(new int[]{x,y});
    private void backTrackAdd(int row, int col ,List<int[]> queens,int n)
    {
        //print result
        if(queens.size() == n)
        {
            List<String> answer = new ArrayList<String>();
            for(int[] i: queens)
            {
                String dots = ".".repeat(i[1]);
                String generatedString = dots + "Q" + ".".repeat(7 - i[1]);
                answer.add(generatedString);
            }
            return ;
        }
        else
        {
            if(queenOk(row,col,queens))
            {
                queens.add(new int[]{row,col});
            }
            else
            {
                return;
            }
            for(int i = 0; i <n; i++)
            {
                backTrackAdd(row+1,col,queens,n);
            }
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
}