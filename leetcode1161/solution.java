package leetcode.leetcode1161;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;


 
class Solution {
    public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    }
    ArrayList<Integer> levelsum = new ArrayList<Integer>();
    int max;
    public int maxLevelSum(TreeNode root) {
        max=0;
        travel(root,0);
        for(int i=0; i< levelsum.size();i++)
        {
            if(levelsum.get(max)< levelsum.get(i)){
                max = i;
            }
        }
        return max+1;
    }

    public void travel(TreeNode node,int level)
    {
        if(levelsum.size() < level+1)
        {
            levelsum.add(level, node.val);
        }
        else
        {
            levelsum.set(level,node.val+levelsum.get(level));
        }
        
        travel(node.left,level+1);
        travel(node.right,level+1);
    }
}