package com.td.剑指Offer;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为 We Are Happy. 则经过替换之后的字符串为 We%20Are%20Happy。
 */
public class Test5 {
    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("We Are Happy.")));
    }

    public static String replaceSpace(StringBuffer str) {
        String str1 = str.toString();
        if (str1.equals(""))
            return str1;
        char[] strArray = str1.toCharArray(); // 把字符串转换成字符数组
        // 计算有多少个空格
        int i = 0;
        int lengthSpace = 0;
        while (i < strArray.length) {
            if (strArray[i] == ' ')
                lengthSpace++;
            i++;
        }
        // 计算新的字符数组的长度（每有一个空格，长度增加2）
        int newStrLength = strArray.length + lengthSpace * 2;
        char[] newStr = new char[newStrLength];
        int j = newStrLength - 1;
        i = strArray.length - 1;
        // 复制过程
        while (i >= 0) {
            if (strArray[i] != ' ') // 如果原来的旧的字符数组不是空格这个字符，那么新数组与旧数组的值一样；
            {
                newStr[j--] = strArray[i--];
            } else { // 如果旧的字符数组是空格，那么新的字符数组这时候就得把 j,j-1,j-2 这三个位置变成 0,2,%
                newStr[j--] = '0';
                newStr[j--] = '2';
                newStr[j--] = '%';
                i--;
            }
        }
        return new String(newStr);
    }
}
