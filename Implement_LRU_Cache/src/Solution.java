/*
Implement a least recently used cache. It should provide set(), get() operations. 
If not exists, return null (Java), false (C++), -1(Python).
https://app.laicode.io/app/problem/205
 */
public class Solution<K, V> {
  class Node<K, V>{
    Node<K, V> prev;
    Node<K, V> next;
    K key;
    V value;
    Node(K key, V value){
      this.key = key;
      this.value = value;
    }
    
    void update(K key, V value){
      this.key = key;
      this.value = value;
    }
  }

  private final int limit;
  private Node<K,V> head;
  private Node<K,V> tail;
  private Map<K, Node<K,V>> map;

  // limit is the max capacity of the cache
  public Solution(int limit) {
    this.limit = limit;
    map = new HashMap<>();
  }
  
  public void set(K key, V value) {
    Node<K,V> node = null;
    if(map.containsKey(key)){
      node = map.get(key);
      node.value = value;
      remove(node);
    }else if(map.size() < limit){
      node = new Node<K,V>(key, value);
    }else{
      node = tail;
      remove(node);
      node.update(key, value);
    }
    append(node);
  }
  
  public void remove(Node<K,V> node){
    map.remove(node.key);
    if(node.prev != null){
      node.prev.next = node.next;
    }
    if(node.next != null){
      node.next.prev = node.prev;
    }
    if(head == node){
      head = head.next;
    }
    if(tail == node){
      tail = tail.prev;
    }
    node.next = null;
    node.prev = null;
  }

  public void append(Node<K,V> node){
    map.put(node.key, node);
    if(head == null){
      head = node;
      tail = head;
    }else{
      node.next = head;
      head.prev = node;
      head = node;
    }
    
  }

  public V get(K key) {
    if(map.containsKey(key)){
      Node<K,V> node = map.get(key);
      remove(node);
      append(node);
      return node.value;
    }
    return null;
  }
}
