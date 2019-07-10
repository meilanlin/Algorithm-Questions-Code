/*
Given three arrays sorted in ascending order. Pull one number from each array to form a coordinate <x,y,z> in a 3D space. Find the coordinates of the points that is k-th closest to <0,0,0>.

We are using euclidean distance here.

Assumptions

The three given arrays are not null or empty, containing only non-negative numbers
K >= 1 and K <= a.length * b.length * c.length
Return

a size 3 integer list, the first element should be from the first array, the second element should be from the second array and the third should be from the third array
Examples

A = {1, 3, 5}, B = {2, 4}, C = {3, 6}

The closest is <1, 2, 3>, distance is sqrt(1 + 4 + 9)

The 2nd closest is <3, 2, 3>, distance is sqrt(9 + 4 + 9)
https://app.laicode.io/app/problem/194
 */
public class Solution {
  public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
    Set<List<Integer>> set = new HashSet<>();
    PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(k, new Comparator<List<Integer>>(){
      @Override
      public int compare(List<Integer> p1, List<Integer> p2){
        long d1 = getDistance(p1, a, b, c);
        long d2 = getDistance(p2, a, b, c);
        if(d1 == d2) return 0;
        return d1 < d2 ? -1 : 1;
      }
    });

    // initial state
    List<Integer> initial = Arrays.asList(0, 0, 0);
    minHeap.offer(initial);
    set.add(initial);

    for(int i = 1; i < k; i++){
      List<Integer> point = minHeap.poll();
      // extend
      List<Integer> next = Arrays.asList(point.get(0) + 1, point.get(1), point.get(2));
      if(point.get(0) + 1 < a.length && !set.contains(next)){
        minHeap.offer(next);
        set.add(next);
      }
      next = Arrays.asList(point.get(0), point.get(1) + 1, point.get(2));
      if(point.get(1) + 1 < b.length && !set.contains(next)){
        minHeap.offer(next);
        set.add(next);
      }
      next = Arrays.asList(point.get(0), point.get(1), point.get(2) + 1);
      if(point.get(2) + 1 < c.length && !set.contains(next)){
        minHeap.offer(next);
        set.add(next);
      }
    }
    List<Integer> point = minHeap.peek();
    List<Integer> result = Arrays.asList(a[point.get(0)], b[point.get(1)], c[point.get(2)]);
    return result;
  }

  public long getDistance(List<Integer> point, int[] a, int[] b, int[] c){
    long product = 0;
    product += a[point.get(0)] * a[point.get(0)];
    product += b[point.get(1)] * b[point.get(1)];
    product += c[point.get(2)] * c[point.get(2)];
    return product;
  }
}
