/*
Given a gym with k pieces of equipment and some obstacles.  We bought a chair and wanted to put this chair into the gym such that  the sum of the shortest path cost from the chair to the k pieces of equipment is minimal. The gym is represented by a char matrix, ¡®E¡¯ denotes a cell with equipment, ¡®O¡¯ denotes a cell with an obstacle, 'C' denotes a cell without any equipment or obstacle. You can only move to neighboring cells (left, right, up, down) if the neighboring cell is not an obstacle. The cost of moving from one cell to its neighbor is 1. You can not put the chair on a cell with equipment or obstacle.

Assumptions

There is at least one equipment in the gym
The given gym is represented by a char matrix of size M * N, where M >= 1 and N >= 1, it is guaranteed to be not null
It is guaranteed that each 'C' cell is reachable from all 'E' cells.
If there does not exist such place to put the chair, just return {-1, -1}
Examples

{ { 'E', 'O', 'C' },

  {  'C', 'E',  'C' },

  {  'C',  'C',  'C' } }

we should put the chair at (1, 0), so that the sum of cost from the chair to the two equipment is 1 + 1 = 2, which is minimal.
https://app.laicode.io/app/problem/195
 */
public class Solution {

	class Position {
		int x;
		int y;

		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public List<Integer> putChair(char[][] gym) {
		// corner case
		if (gym.length == 1 && gym[0].length == 1)
			return Arrays.asList(-1, -1);

		// compute the cost from each equipment to every avaiable nodes in the gym
		int height = gym.length;
		int width = gym[0].length;
		int[][] cost = new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (gym[i][j] == 'E') {
					boolean canReach = computeCosts(cost, gym, i, j);
					if (!canReach)
						return Arrays.asList(-1, -1);
				}
			}
		}

		// compare the costs and find the minimal one
		int globalMinCost = Integer.MAX_VALUE;
		int globalX = -1;
		int globalY = -1;
		// if the gym is like {E, E}, then there still don't have any option to put the
		// chair
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (gym[i][j] != 'E' && gym[i][j] != 'O') {
					if (globalMinCost > cost[i][j]) {
						globalMinCost = cost[i][j];
						globalX = i;
						globalY = j;
					}
				}
			}
		}
		List<Integer> result = new ArrayList<>();
		result.add(globalX);
		result.add(globalY);
		return result;
	}

	public boolean computeCosts(int[][] cost, char[][] gym, int row, int col) {
		// for each equipment, find it's avaiable neighbors and expand them to their
		// neighbors
		int height = gym.length;
		int width = gym[0].length;
		boolean[][] visited = new boolean[height][width];
		Queue<Position> queue = new LinkedList<>();

		visited[row][col] = true;
		queue.offer(new Position(row, col));
		int size = queue.size();
		int pathCost = 1;
		while (size != 0) {
			for (int i = 0; i < size; i++) {
				Position cur = queue.poll();
				List<Position> neighbors = findNeighbors(gym, cur);
				for (Position neighbor : neighbors) {
					if (!visited[neighbor.x][neighbor.y]) {
						visited[neighbor.x][neighbor.y] = true;
						cost[neighbor.x][neighbor.y] += pathCost;
						queue.offer(neighbor);
					}
				}
			}
			size = queue.size();
			pathCost++;
		}
		// if there is a equipment that not reachable
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (!visited[i][j] && gym[i][j] == 'E')
					return false;
			}
		}

		return true;
	}

	public List<Position> findNeighbors(char[][] gym, Position cur) {
		List<Position> neighbors = new ArrayList<>();
		int row = cur.x;
		int col = cur.y;
		// up
		if (row > 0 && gym[row - 1][col] != 'O') {
			neighbors.add(new Position(row - 1, col));
		}
		// down
		if (row < gym.length - 1 && gym[row + 1][col] != 'O') {
			neighbors.add(new Position(row + 1, col));
		}
		// left
		if (col > 0 && gym[row][col - 1] != 'O') {
			neighbors.add(new Position(row, col - 1));
		}
		// right
		if (col < gym[0].length - 1 && gym[row][col + 1] != 'O') {
			neighbors.add(new Position(row, col + 1));
		}
		return neighbors;
	}
}
