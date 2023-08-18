package org.codes.algoCodes.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class printingLcs {

    static int dp[][];
    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str1= reader.readLine();
        String str2= reader.readLine();
        int m = str1.length();
        int n = str2.length();

        printlcs(str1,str2,m,n);
    }

    private static void printlcs(String str1, String str2, int m, int n) {

        dp=new int[m+1][n+1];

        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j]=0;
                }
                else if(str1.charAt(i-1) == str2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        int index=dp[m][n];
        int temp=index;

        StringBuilder buf=new StringBuilder();

        int i=m;
        int j=n;

        while (i>0 && j>0)
        {
            if(str1.charAt(i-1)==str2.charAt(j-1))
            {
                buf.append(str1.charAt(i-1));

                i--;
                j--;
                index--;
            }
            else if (dp[i-1][j]>dp[i][j-1])
            {
                i--;
            }
            else
            {
                j--;
            }
        }
        System.out.println(buf.reverse());

    }
}
