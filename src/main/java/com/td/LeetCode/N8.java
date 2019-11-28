package com.td.LeetCode;

import org.junit.Test;

/**
 * 字符串转换整数 (atoi)
 */
public class N8 {
    @Test
    public void test() {
        char c = '4';
        int i = c - '0';
        System.out.println(i);
    }

    public int myAtoi(String str) {
        str = str.trim(); // 去除字符串左右空格
        if (str == null || str.length() == 0) // 不符合条件的直接 return 0;
            return 0;
        char firstChar = str.charAt(0); // 截取第一个字符
        int sign = 1; // sign 是符号位
        int start = 0; // start 指针指向第一个数字的位置,如果第一位为数字,则 sign = 1,start = 0,
        if (firstChar == '+') { // 若第一个字符为 "+"
            sign = 1; // 符号位为 1
            start++;
        } else if (firstChar == '-') { // 若第一个字符为 "-"
            sign = -1; // 符号位为 -1
            start++;
        }
        long res = 0; // res 为无符号结果
        // 从字符串第一个为数字的位置开始遍历
        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) { // 如果遍历到不为数字的字符,则直接返回目前已经转换了的值;
                return (int) res * sign;
            }
            res = res * 10 + str.charAt(i) - '0'; // 字符转数字
            if (sign == 1 && res > Integer.MAX_VALUE) // 如果 res 大于 Integer 最大值且 sign = 1,输出 Integer 的最大值,
                return Integer.MAX_VALUE;
            if (sign == -1 && res > Integer.MAX_VALUE) // 反之输出 Integer 最小值
                return Integer.MIN_VALUE;
        }
        return (int) res * sign; // 如果遍历时该字符串未超范围,且无非数字字符,则返回计算符号位后的结果
    }

}
