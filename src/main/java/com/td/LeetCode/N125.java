package com.td.LeetCode;

/**
 * Created by TravelerTD on 2019/5/18. 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 
 * 示例 1: 输入: "A man, a plan, a canal: Panama" 输出: true
 * 
 * 示例 2: 输入: "race a car" 输出: false -------------------------- 思路：
 * 先将字符串转换为全小写的字符数组，定义首尾两个指针，一起向中间移动（遇到不合法的输入就跳过，继续向下移动），
 * 比较两个指针指向的字符是否相等，不相等就直接返回 false， 如果一直到首指针移动到尾指针后面（表明已经比较完了），返回 true。
 */
public class N125 {

    public static boolean isPalindrome(String s) {

        char[] lowerArr = s.toLowerCase().toCharArray(); // 先将字符串转成小写的字符数组
        int i = 0, len = lowerArr.length - 1;

        while (i < len) {
            // 排除所有非字母或数字的字符
            while (i < len && !isAlNum(lowerArr[i]))
                i++;
            while (i < len && !isAlNum(lowerArr[len]))
                len--;
            // 比较
            if (lowerArr[i++] != lowerArr[len--])
                return false;
        }
        return true;
    }

    // 输入的字符是字母或数字
    public static boolean isAlNum(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        if (isPalindrome("A man, a plan, a canal: Panama")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        if (isPalindrome("race a car")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
