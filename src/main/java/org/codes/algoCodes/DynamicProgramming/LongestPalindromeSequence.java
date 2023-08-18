package org.codes.algoCodes.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestPalindromeSequence {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        int n = string.length();
        dp = new int[n][n];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);

        System.out.println(lps(string));
    }

    private static int lps(String string) {
        String R
                = new StringBuilder(string).reverse().toString();

        // dp[i][j] will store the length of the longest
        // palindromic subsequence for the substring
        // starting at index i and ending at index j
        dp = new int[string.length() + 1][R.length() + 1];

        // Filling up DP table based on conditions discussed
        // in above approach
        for (int i = 1; i <= string.length(); i++) {
            for (int j = 1; j <= R.length(); j++) {
                if (string.charAt(i - 1) == R.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1],
                            dp[i - 1][j]);
            }
        }

        // At the end DP table will contain the LPS
        // So just return the length of LPS
        return dp[string.length()][R.length()];
    }
}

