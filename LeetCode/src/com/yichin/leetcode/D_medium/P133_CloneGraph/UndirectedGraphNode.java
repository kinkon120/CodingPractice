package com.yichin.leetcode.D_medium.P133_CloneGraph;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	public UndirectedGraphNode(int x) { 
		label = x; 
		neighbors = new ArrayList<UndirectedGraphNode>(); 
	}
	
	public List<UndirectedGraphNode> getNeighors(){
		return neighbors;
	}
}

