package com.yichin.leetcode.D_hard.P297_SerializeAndDeserializeBinaryTree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    /*
    Print the tree in pre-order traversal and use “X” to denote null node and split node with “,”. 
    We can use a StringBuilder for building the string on the fly. 
    
    or deserializing, we use a Queue to store the pre-order traversal and since we have “X” as null node, 
    we know exactly how to where to end building subtress.
    */
    
    private final static String NN = "X";
    private final static String spliter = ",";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    private void buildString(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append(NN).append(spliter);
            return;
        } else {
            // pre-order
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right, sb); 
        }
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 要記得這個屌用法...
    	// dequeue + Arrays.asList
        Deque<String> nodes = new LinkedList<String>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }
    
    private TreeNode buildTree(Deque<String> nodes) {
        String nodeVal = nodes.remove();
        if(nodeVal.equals("X"))    return null;
        else{
            TreeNode node = new TreeNode(Integer.parseInt(nodeVal));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
                    return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
