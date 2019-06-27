/*
Make a deep copy of an undirected graph, there could be cycles in the original graph.

Assumptions

The given graph is not null
https://app.laicode.io/app/problem/132
 */

/*
* class GraphNode {
*   public int key;
*   public List<GraphNode> neighbors;
*   public GraphNode(int key) {
*     this.key = key;
*     this.neighbors = new ArrayList<GraphNode>();
*   }
* }
*/
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    Map<GraphNode, GraphNode> map = new HashMap<>();

    // for each node in this graph, find its neighbors and copy to the new one
    for(GraphNode node : graph){
      if(!map.containsKey(node)){    
        map.put(node, new GraphNode(node.key));
        GraphNode newNode = map.get(node);
        findNeighbors(map, node, newNode);
      }
      
    }
    return new ArrayList<GraphNode>(map.values());
  }

  public void findNeighbors(Map<GraphNode, GraphNode> map, GraphNode node, GraphNode newNode){
    // base case
    if(node == null) return;

    List<GraphNode> neighbors = node.neighbors;
    for(GraphNode neighborNode : neighbors){   
      if(!map.containsKey(neighborNode)){
        map.put(neighborNode, new GraphNode(neighborNode.key));
        findNeighbors(map, neighborNode, map.get(neighborNode));
      }
      newNode.neighbors.add(map.get(neighborNode));
      }
  }
}
