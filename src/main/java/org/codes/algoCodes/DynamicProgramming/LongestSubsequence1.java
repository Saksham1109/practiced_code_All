package org.codes.algoCodes.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class LongestSubsequence1 {

    static int[][] dp;
    static String answerString="";
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] Str1=reader.readLine().toCharArray();
        char[] Str2=reader.readLine().toCharArray();
        int answer=0;
        int m=Str1.length;
        int n=Str2.length;
        dp=new int[m+1][n+1];
        for(int[] a:dp)
        {
            Arrays.fill(a,-1);
        }

        System.out.println(m+n-lcs(Str1,Str2,m,n));
        //System.out.println(answerString);
    }

    private static int lcs(char[] str1, char[] str2, int m, int n) {

        if(dp[m][n]!=-1)
        {
            return dp[m][n];
        }

        if(m==0 || n==0)
        {
            return dp[m][n]=0;
        }

        if(str1[m-1]==str2[n-1])
        {
            answerString=answerString.concat(String.valueOf(str1[m-1]));
            return dp[m][n]=1+lcs(str1,str2,m-1,n-1);

        }
        else
        {
            return dp[m][n]=Math.max(lcs(str1,str2,m-1,n),lcs(str1,str2,m,n-1));
        }
    }
}
