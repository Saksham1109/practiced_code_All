package org.codes.algoCodes.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class shortestSubsequence {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String string1=reader.readLine();
        String string2=reader.readLine();
        int m=string1.length();
        int n=string2.length();
        System.out.println(m+n-lcsshortest(string1,string2,m,n));
    }

    private static int lcsshortest(String string1, String string2, int m, int n) {

        dp=new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;

                else if (string1.charAt(i - 1) == string2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                else
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
            }
        }

        // L[m][n] contains length of LCS
        // for X[0.n - 1] and Y[0.m - 1]
        return dp[m][n];

    }
}
