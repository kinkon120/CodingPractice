package com.yichin.leetcode.D_easy.P021_MergeTwoSortedLists;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode ln = s.mergeTwoLists(null, new ListNode(0));
		System.out.println(ln.val);
	}

}
