package org.codes.algoCodes.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class mimicString {
    static String str1;
    static String str2;

    static List<Integer> answer=new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // Number of test cases
        scanner.nextLine(); // Consume the newline

        while (t-- > 0) {
            int len1 = scanner.nextInt();
            int len2 = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            str1 = scanner.nextLine();
            str2 = scanner.nextLine();
            char[] charArray1 = str1.toCharArray();
            char[] charArray2 = str2.toCharArray();
            // To convert 1 -> 2
            int[][] dp = new int[len1][len2];
            for (int[] ints : dp) {
                Arrays.fill(ints, -1);
            }
            answer.add(edit(charArray1,charArray2,len1-1,len2-1,dp));
        }
        answer.forEach(System.out::println);

        scanner.close();
    }

    private static Integer edit(char[] charArray1, char[] charArray2, int len1, int len2, int[][] dp) {
        if(dp[len1][len2]!=-1)
        {
            return dp[len1][len2];
        }
        if(len1==0)
        {
            return dp[len1][len2]=len2;
        }
        if(len2==0)
        {
            return dp[len1][len2]=len1;
        }
        if(charArray1[len1-1]==charArray2[len2-1])
        {
            return dp[len1][len2]=edit(charArray1,charArray2,len1-1,len2-1,dp);
        }
        else
        {
            int min = Math.min(edit(charArray1,charArray2,len1-1,len2,dp),edit(charArray1,charArray2,len1,len2-1,dp));
            int min1=Math.min(edit(charArray1,charArray2,len1-1,len2-1,dp),min);
            return dp[len1][len2]=1+min1;
        }

    }
}
