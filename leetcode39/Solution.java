package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;



class Solution {
	public List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	result = new Stack<List<Integer>>();
    	List<Integer> current = new Stack<Integer>();
        List<Integer> remain = new ArrayList<Integer>();
        for (int var : candidates) 
        {
        	remain.add(var);
        }
    	helper(current,0,remain,target);
		return result;
    }
    
    public void helper(List<Integer> current, int current_sum,List<Integer> candidates, int target){
    	
    	if(current_sum == target) {
    		List<Integer> ans = new ArrayList<Integer>();
    		ans.addAll(current);
    		result.add(ans);
    		return ;
    	}
    	if(current_sum >= target) {
    		return ;
    	}
    	List<Integer> remain = new ArrayList<Integer>();
        remain.addAll(candidates);
        for (int var : candidates) 
        {
            current.add(var);
            helper(current,current_sum+var,remain,target);
            remain.remove(0);
            current.remove(current.size()-1);
        }
        return ;
    }
}