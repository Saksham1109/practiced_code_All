package org.codes.algoCodes.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JumpPossibility {

    static int N;
    static int S;

    static List<String> ans=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc=sc.nextInt();
        while (tc-->0)
        {
            N= sc.nextInt();
            S= sc.nextInt();
            int[] arr= new int[N];
            for(int i=0;i<arr.length;i++)
            {
                arr[i]=sc.nextInt();
            }
            Boolean[][] dp = new Boolean[N+1][S+1];
            for (Boolean[] ints : dp) {
                Arrays.fill(ints, false);
            }
            if(helper(arr,S,0,dp))
            {
                ans.add("YES");
            }
            else
            {
                ans.add("NO");
            }
        }
        ans.forEach(System.out::println);
    }

    private static boolean helper(int[] arr, int sum, int index, Boolean[][] dp) {
        if(sum==0)
        {
            return dp[index][sum]=true;
        }
        if(index>= arr.length)
        {
            return false;
        }
        if(dp[index][sum])
        {
            return dp[index][sum];
        }
        Boolean notTake=helper(arr,sum,index+1,dp);
        Boolean take=false;
        if(arr[index]>=sum)
        {
            take=helper(arr,sum-arr[index],index+1,dp);
        }
        return dp[index][sum]= notTake || take;
    }

}
