package com.yichin.leetcode.C_dfs.M133_CloneGraph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    Map<UndirectedGraphNode, UndirectedGraphNode> map;
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;        
        map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>(); // source to clone
        return dfs(node);
    }
    
    public UndirectedGraphNode dfs(UndirectedGraphNode node) {
        // check duplicate
        if (map.containsKey(node))  return map.get(node);
        
        
        // clone the node
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);        
        map.put(node, clone);
        List<UndirectedGraphNode> neighbors = node.getNeighors();
        for(UndirectedGraphNode neighbor : neighbors ) {
            UndirectedGraphNode clonedNeighbor = dfs(neighbor);
            clone.neighbors.add(clonedNeighbor);
        }            
        return clone;
    }
}