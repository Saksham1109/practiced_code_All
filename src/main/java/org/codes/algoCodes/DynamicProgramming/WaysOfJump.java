package org.codes.algoCodes.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaysOfJump {

    static int N;
    static int S;
    static final int MOD = 1000000007;

    static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            S = Integer.parseInt(input[1]);
            int[] arr = new int[N];
            String[] arrInput = br.readLine().split(" ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(arrInput[i]);
            }
            int[][] dp = new int[N + 1][S + 1];
            for (int[] ints : dp) {
                Arrays.fill(ints, -1);
            }
            ans.add(helper(arr, S, N - 1, dp));
        }
        for (int a : ans) {
            System.out.println(a);
        }
    }

    private static int helper(int[] arr, int sum, int index, int[][] dp) {
        if (sum < 0 || index == -1) {
            return 0;
        }
        if (dp[index][sum] != -1) {
            return dp[index][sum];
        }
        if (sum == 0) {
            return dp[index][sum] = 1;
        }
        return dp[index][sum]= ((helper(arr, sum - arr[index], index, dp) % MOD) + (helper(arr, sum, index - 1, dp) % MOD)) % MOD;
    }
}
