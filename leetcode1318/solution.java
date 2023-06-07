package leetcode.leetcode1318;

class Solution {
    public int minFlips(int a, int b, int c) {
        int max = Math.max(a, b);
        max = Math.max(max, c);
        int flips = 0;
        for(int i=0; i<Math.ceil(Math.sqrt(max))+1;i++)
        {
            int a1 = a%2;
            int b1 = b%2;
            int c1 = c%2;
            if(c1 == 0)
            {
                if(a1 == 1 && b1 == 1)
                {
                    flips+=2;
                }
                else{
                    if(a1 == 1 || b1 == 1)
                    {
                        flips+=1;
                    }
                }
            }
            else
            {
                if(a1 == 0 && b1 == 0)
                {
                    flips+=1;
                }
            }
            a/=2;
            b/=2;
            c/=2;
        }
        return flips;
    }
}