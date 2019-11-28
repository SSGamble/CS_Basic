package com.td.常见算法.动态规划;

import java.util.Scanner;

/**
 * 最长公共子序列
 */
public class LCS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str1 = scanner.nextLine().toLowerCase();
            String str2 = scanner.nextLine().toLowerCase();
            System.out.println(findLCS(str1, str1.length(), str2, str2.length()));
        }
    }

    // 最长公共子序列
    public static int findLCS(String A, int n, String B, int m) {
        // 初始化 dp 表
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = 0;
            }
        }
        // 遍历 dp 表
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) { // 依次比较字符,当A[i] == B[j]时，dp[i][j] = dp[i-1][j-1] + 1;
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else { // 否则，dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                    dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }
}