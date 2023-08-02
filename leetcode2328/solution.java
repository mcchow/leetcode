package leetcode.leetcode2328;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;


 
class Solution {
    int[][] used;
    int exp = 1000000007;
    public int countPaths(int[][] grid) {
        int sum =0;
        used = new int[grid.length][grid[0].length];
        for(int x=0; x< grid.length; x++)
        {
            for(int y=0; y<grid[0].length;y++)
            {
                used[x][y] = -1;
            }
        }
        for(int x=0; x< grid.length; x++)
        {
            for(int y=0; y<grid[0].length;y++)
            {
                sum += dfs(x,y,grid);
            }
        }
        return sum;
    }

    public int dfs(int x, int y, int[][] grid)
    {
        int count=1;
        used[x][y]= -1;
        

        if(x+1 < grid.length)
        if(grid[x+1][y] > grid[x][y] && used[x+1][y]!= -1)
        {
            count+=dfs(x+1,y,grid);
            count%=exp;
        }

        if(x-1 > 0)
        if(grid[x-1][y] > grid[x][y] && used[x-1][y]!= -1)
        {
            count+=dfs(x-1,y,grid);
            count%=exp;
        }

        if(y+1 < grid[0].length)
        if(grid[x][y+1] > grid[x][y] && used[x][y+1]!= -1)
        {
            count+=dfs(x,y+1,grid);
            count%=exp;
        }

        if(y-1 > 0)
        if(grid[x][y-1] > grid[x][y] && used[x][y-1]!= -1)
        {
            count+=dfs(x,y-1,grid);
            count%=exp;
        }

        used[x][y]= 0;
        return count;
    }
}