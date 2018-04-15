package com.yichin.leetcode.D_hard.P146_LRUCache;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/
//import java.util.LinkedList;
import java.util.List;
import java.util.Hashtable;

/*
class Node{
    int val;
    public Node(int val){
        this.val=val;
    }
}
*/




public class LRUCache{
	// 用inner class
	class DLNode{
	    int key;
	    int val;
	    
	    DLNode prev;
	    DLNode next;
	    
	    public DLNode(int key, int val){
	        this.key = key;
	        this.val = val;
	        this.prev = null;
	        this.next = null;
	    }
	}

	void addNode(DLNode node){
	    // add next to dummy head
	    
	    // make code easy
	    DLNode n = head.next;
	    
	    head.next = node;
	    node.next = n;
	    node.prev = head;
	    n.prev = node;
	}

	DLNode popTail(){
	    if(tail.prev == head)    return null;
	    
	    // make code easy
	    DLNode pop = tail.prev;
	    
	    DLNode p = tail.prev.prev;
	    tail.prev = p;
	    p.next = tail;
	    
	    return pop;
	}

	void removeNode(DLNode node){
	    DLNode p = node.prev;
	    DLNode n = node.next;
	    
	    p.next = n;
	    n.prev = p;
	}

	void moveToHead(DLNode node){
	    removeNode(node);
	    addNode(node);
	}
	
    // 正規一點的作法... 不要抄捷徑
    // https://leetcode.com/discuss/20139/java-hashtable-double-linked-list-with-touch-of-pseudo-nodes
    // 利用HashTable (因為synchroized) 跟 double linked list
	
	// 上面的方法是moveToHead的cost是O(1), 跟用LinkedList的cost O(n)有差距
	private Hashtable<Integer, DLNode> cache;
	private int count;
	private int capacity;
	private DLNode head, tail;
    public LRUCache(int capacity) {
        cache = new Hashtable<Integer, DLNode>();
        this.capacity = capacity;
        this.count = 0;
        
        // initialize dummy head and tail
        head = new DLNode(0,0);
        tail = new DLNode(0,0);
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
    }
    
    public int get(int key) {
        DLNode node = cache.get(key);
        if(node != null){
            int ret = node.val;
            
            // move to head
            moveToHead(node);
            return ret;
        }
        
        return -1;
    }
    
    public void set(int key, int value) {
        DLNode node = cache.get(key);
        
        if(node != null){  // update
            node.val = value;
            moveToHead(node); // set 也要重新update...要注意!!不是只有get要move to head
        }else{
            DLNode newNode = new DLNode(key, value);
            if(count >= capacity){
                DLNode pop = popTail();
                cache.remove(pop.key);
                
                addNode(newNode);
                cache.put(key, newNode);
            }else{  // purely add
                addNode(newNode);
                cache.put(key, newNode);
                count++;
            }
        }
    }	
    
    
	/*
    // 直接用LinkedList (Java)提供的函數. 缺點是remove的cost為O(n)
    // add(E e): 加到tail
    // peek(): remove the head
    // remove(E e)
    private int capacity;
    private List<Node> list;
    private Hashtable<Integer, Integer> cache;
    private int count;
    public LRUCache(int capacity) {
        list = new LinkedList<Node>();
        cache = new Hashtable<Integer, Integer>();
        this.capacity = capacity;
        this.count = 0;
    }
    
    public int get(int key) {
        if( cache.containsKey(key)){
            int result = cache.get(key);
            
            // move to tail
            list.remove(new Node(key));
            list.add(new Node(key));
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(cache.containsKey(new Node(key))){
            // update value
            cache.put(key, value);
            
            // move to tail
            list.remove(new Node(key));
            list.add(new Node(key));
        }else{
            if(count >= capacity){
                // remove head
                list.remove(new Node(key));
                cache.remove(key);
                list.add(new Node(key));
                cache.put(key, value);
            }else {
                // purely add
                list.add(new Node(key));
                cache.put(key, value);
                count++;
            }
        }
    }
    */
}
