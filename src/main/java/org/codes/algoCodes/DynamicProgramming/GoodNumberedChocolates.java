package org.codes.algoCodes.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GoodNumberedChocolates {

    static int N;
    static List<Integer> answer=new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine()); // Number of test cases

        while(tc-->0)
        {
            N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine()); // Array elements input
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N+1][N+1];

            // Initialize the array with -1 using Arrays.fill()
            for (int i = 0; i < N+1; i++) {
                Arrays.fill(dp[i], -1);
            }

            answer.add(maxChocolates(0,N,dp,arr));
        }
        answer.forEach(System.out::println);


    }

    private static Integer maxChocolates(int currentIndex, int target, int[][] dp, int[] arr) {
        //Base case
        if(currentIndex>=target)
        {
            return 0;
        }
        if(dp[currentIndex][target]!=-1)
        {
            return dp[currentIndex][target];
        }

        int consider=arr[currentIndex]+maxChocolates(currentIndex,target-(currentIndex+1),dp,arr);
        int notConsider=maxChocolates(currentIndex+1,target,dp,arr);
        int answer=Math.max(consider,notConsider);
        return dp[currentIndex][target]=answer;

    }
}
