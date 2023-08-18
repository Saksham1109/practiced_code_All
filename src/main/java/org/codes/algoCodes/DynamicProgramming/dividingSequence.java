package org.codes.algoCodes.DynamicProgramming;

import java.util.Scanner;

public class dividingSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the value of N
        int N = scanner.nextInt();
        // Input the array elements
        int[] arr = new int[N];
        int[] dp=new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        dp[0]=1;
        int taken=1;
        for(int i=1;i<N;i++)
        {
            dp[i]=1;
            for(int j=i-1;j>=0;j--)
            {
                if(arr[i]%arr[j]==0)
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            taken=Math.max(taken,dp[i]);
        }
        System.out.println(taken);

    }
}
