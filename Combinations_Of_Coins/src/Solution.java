import java.util.ArrayList;
import java.util.List;
/*
Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents), get all the possible ways to pay a target number of cents.

Arguments
coins - an array of positive integers representing the different denominations of coins, there are no duplicate numbers and the numbers are sorted by descending order, eg. {25, 10, 5, 2, 1}
target - a non-negative integer representing the target number of cents, eg. 99

Assumptions
coins is not null and is not empty, all the numbers in coins are positive
target >= 0
You have infinite number of coins for each of the denominations, you can pick any number of the coins.

Return
a list of ways of combinations of coins to sum up to be target.
each way of combinations is represented by list of integer, the number at each index means the number of coins used for the denomination at corresponding index.

Examples
coins = {2, 1}, target = 4, the return should be

[
  [0, 4],   (4 cents can be conducted by 0 * 2 cents + 4 * 1 cents)
  [1, 2],   (4 cents can be conducted by 1 * 2 cents + 2 * 1 cents)
  [2, 0]    (4 cents can be conducted by 2 * 2 cents + 0 * 1 cents)
]
https://app.laicode.io/app/problem/73
 */
public class Solution {
	  public List<List<Integer>> combinations(int target, int[] coins) {
	    // Write your solution here
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    List<Integer> way = new ArrayList<Integer>();
	    //corner case
	    if(target == 0){
	      result.add(way);
	      return result;
	    }
	    int level = 0;
	    findComb(target, coins, result, way, level);
	    return result;
	  }
	  
	  public void findComb(int curTarget, int[] coins, List<List<Integer>> result, List<Integer> way, int level){
	    //base case
	    // 有时候level不在最底层时就已经找到了解法，怎么办？
	    // 不用担心，因为找到解法后，下一层的curTarget会成为0，所以实际上没有影响
	    if(level == coins.length - 1){
	      int curCoin = coins[level];
	      // if there is possiable to find the solution
	      if(curTarget % curCoin == 0){
	        // find how many coins needed
	        int coinsNeed = curTarget/curCoin;
	        way.add(coinsNeed);
	        // do not use result.add(way). the value will changed
	        result.add(new ArrayList<Integer>(way));
	        //delete the element just added to the way, save the space for the other solutions
	        way.remove(way.size() - 1);
	      }
	      return;
	    }
	    
	    int curCoin = coins[level];
	    // i is the number of the current coin
	    for(int i = 0; i <= curTarget/curCoin; i++){
	      int curMoney = i * curCoin;
	      way.add(i);
	      int nextTarget = curTarget - curMoney;
	      findComb(nextTarget, coins, result, way, level + 1);
	      way.remove(way.size() - 1);
	    }
	  }
	}

