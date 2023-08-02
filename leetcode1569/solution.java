package leetcode.leetcode1569;

import java.util.ArrayList;



 
class Solution {
    static int exp = 1000000007;
    public static int numOfWays(int[] nums) {
        ArrayList<Integer> numlist = new ArrayList<Integer>(nums.length);
        for (int value : nums) {
            numlist.add(value);
        }
        return (int)((LeftRight(numlist)-1)%exp);
    }
    public static int LeftRight(ArrayList<Integer> nums) {
        if(nums.size() == 0) return 1;
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        for(int i=1; i < nums.size() ; i++)
        {
            if(nums.get(i) < nums.get(0))
            {
                left.add(nums.get(i));
            }
            else
            {
                right.add(nums.get(i));
            }
        }
        int l=LeftRight(left)%exp;
        
        int r = LeftRight(right)%exp;
        long com = (calculateCombination(nums.size() - 1, left.size()));
        int result = (int) (com * (l % exp) % exp * (r % exp) % exp);
        System.out.println("right:"+r);
        System.out.println("left:"+l);
        System.out.println("left*r:"+l*r);
        System.out.println("com:"+com);
        System.out.println("result:"+result);
        return result;
    }
    public static long calculateCombination(int n, int r) {
        return (factorial(n) / (factorial(r) * factorial(n - r)));
    }
    public static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    public class Main {
        
        public static void main(String[] args) {
            int[] nums = {31,23,14,24,15,12,25,28,5,35,17,6,9,11,1,27,18,20,2,3,33,10,13,4,7,36,32,29,8,30,26,19,34,22,21,16};
        
            int result = numOfWays(nums);
            System.out.println(result);
        }
    }
}