import java.util.ArrayList;
import java.util.List;

/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums toT. The same repeated number may be chosen from C unlimited number of times.

All numbers (including target) will be positive integers.

Elements in a combination (a1, a2, бн , ak) must be in non-descending order.

The solution set must not contain duplicate combinations.

Example

given candidate set 2,3,6,7 and target 7,

A solution set is:
     [7]
     [2, 2, 3]
https://app.laicode.io/app/problem/232
 */
public class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    // corner case 
    List<List<Integer>> result = new ArrayList<>();
    if(candidates.length == 0 || target == 0) return result;
    
    List<Integer> way = new ArrayList<Integer>();
    int level = 0;
    
    findPermutation(candidates, target, level, way, result);
    
    return result;
  }
  
  public void findPermutation(int[] candidates, int curTarget,int level, List<Integer> way, List<List<Integer>> result){
    // base case
    if(level == candidates.length - 1){
      int curNum = candidates[level];
      // check if there is a solution
      if(curTarget%curNum == 0){
        // find how many number should be used and add it to the list.
        int count = curTarget/curNum;
        for(int i = 0; i < count; i++){
          way.add(curNum);
        }
        // remember cannot use result.add(way)
        result.add(new ArrayList<Integer>(way));
        for(int i = 0; i< count; i++){
          way.remove(way.size() - 1);
        }
      }
      return;
    }
    
    int curNum = candidates[level];
    int count = curTarget/curNum; // this variable represents how many possiable solutions based on current number
    
    for(int curNumCount = 0; curNumCount <= count; curNumCount++){
      // add the corresponding number of elements to the array
      for(int j = 0; j < curNumCount; j++){
        way.add(curNum);
      }
      // Calculate the new target amount after subtracting the current number
      int nextTarget = curTarget - curNum * curNumCount;
      findPermutation(candidates, nextTarget, level + 1, way, result);
      // delete the elements added on the beginning of the loop, so the array can be ready for the next loop
      for(int j = 0; j < curNumCount; j++){
        way.remove(way.size() - 1);
      } 
      
     }
    }
  }


