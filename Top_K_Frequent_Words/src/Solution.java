import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Given a composition with different kinds of words, return a list of the top K most frequent words in the composition.

Assumptions

the composition is not null and is not guaranteed to be sorted
K >= 1 and K could be larger than the number of distinct words in the composition, in this case, just return all the distinct words
Return

a list of words ordered from most frequent one to least frequent one (the list could be of size K or smaller than K)
Examples

Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [¡°b¡±, ¡°c¡±]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [¡°b¡±, ¡°c¡±, "a", "d"]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [¡°b¡±, ¡°c¡±, "a", "d"]
https://app.laicode.io/app/problem/67
 */

public class Solution {
	  public static String[] topKFrequent(String[] combo, int k) {
	    // corner case
	    if(combo == null || combo.length <= 1){
	      return combo;
	    }
	    
	    // use hash map to record the frequency of each word
	    Map<String, Integer> map = new HashMap<String, Integer>();
	    for(String word : combo){
	      if(map.containsKey(word)){
	        int curValue = map.get(word);
	        map.put(word,curValue + 1);
	      }else{
	        map.put(word,1);
	      }
	    }
	    
	    // matain a minimum heap to sort the top k most frequent words
	    PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){
	      @Override
	      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
	        int v1 = o1.getValue();
	        int v2 = o2.getValue();
	        
	        if(v1 == v2) return 0;
	        return v1 > v2 ? 1:-1;
	      }
	    });
	    
	    // find the top k most frequent words
	    for(Map.Entry<String, Integer> set : map.entrySet()){
	      // do not use if(k != 0), because the following need use k to create an array and store elements in it
	      if(minHeap.size() != k){
	        minHeap.offer(set);
	      }else{
	        int value = set.getValue();
	        if(value > minHeap.peek().getValue()){
	          minHeap.poll();
	          minHeap.offer(set);
	        }
	      }
	    }

	    // store the solution in an array
	    int size = minHeap.size();
	    String[] result = new String[size];
	    for(int i = size - 1; i >= 0; i--){
	      result[i] = minHeap.poll().getKey();
	    }

	    return result;
	  }
	}