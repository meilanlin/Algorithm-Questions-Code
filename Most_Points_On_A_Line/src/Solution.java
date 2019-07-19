/*
Given an array of 2D coordinates of points (all the coordinates are integers), 
find the largest number of points that can be crossed by a single line in 2D space.

Assumptions
The given array is not null and it has at least 2 points

Examples
<0, 0>, <1, 1>, <2, 3>, <3, 3>
the maximum number of points on a line is 3(<0, 0>, <1, 1>, <3, 3> are on the same line)
https://app.laicode.io/app/problem/216
 */

/*
* class Point {
*   public int x;
*   public int y;
*   public Point(int x, int y) {
*     this.x = x;
*     this.y = y;
*   }
* }
*/
public class Solution {
	public int most(Point[] points) {
		// corner case
		if (points.length == 2) return 2;

		// go through every point
		int globalMax = 0;
		for (int i = 0; i < points.length; i++) {
			// 当我们确定了一个点，那么只需要找和它有相同斜率的线就好，不用再考虑截距了，因为截距已经被确定了
			Point point1 = points[i];
			Map<Double, Integer> linesMap = new HashMap<>();
			int same = 0;
			int vertical = 0;
			int curMax = 0;
			for (int j = i + 1; j < points.length; j++) {
				Point point2 = points[j];
				if (point1.x == point2.x && point1.y == point2.y) {
					same++; // when the two points are same
				} else if (point1.x != point2.x) {
					double k = (double) (point2.y - point1.y) / (point2.x - point1.x);
					int count = 2;
					if (linesMap.containsKey(k)) {
						count = linesMap.get(k) + 1;
					}
					curMax = Math.max(curMax, count);
					linesMap.put(k, count);
				} else {
					vertical++; // when x1=x2 && y1!=y2
				}
			}
			curMax = Math.max(curMax, vertical);
			curMax = curMax + same;
			globalMax = Math.max(globalMax, curMax);
		}
		return globalMax;
	}
}