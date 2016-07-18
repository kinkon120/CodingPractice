package com.yichin.leetcode.string.E165_CompareVersionNumbers;
/*
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
*/
public class Solution {
    public int compareVersion(String version1, String version2) {
        // https://leetcode.com/discuss/19118/accepted-small-java-solution
        // 他的假設比較好...沒有的話代表0
        
        String [] lv1 = version1.split("\\.");   // 不能用split(".");
        String [] lv2 = version2.split("\\.");
        
        int len = lv1.length > lv2.length ? lv1.length : lv2.length;
        for(int i=0;i<len;i++){
            Integer v1 = i < lv1.length ? Integer.parseInt(lv1[i]) : 0;
            Integer v2 = i < lv2.length ? Integer.parseInt(lv2[i]) : 0;
            
            if(v1.compareTo(v2)!=0)    return v1.compareTo(v2);
        }
        return 0;
    }
}