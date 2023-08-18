package org.codes.algoCodes.DynamicProgramming;


import java.util.*;


public class WaysOfBuilding {
    static final int MOD = 1000000007;
    static int H;
    static int N;
    static int[] building_blocks;
    static int[][] dp;

    static List<Integer> resultList=new ArrayList<>();

    public static int building_combinations(int index, int currHeight) {
        if(currHeight < 0 || index == -1)
            return 0;
        if(dp[index][currHeight] != -1)
        {
            return dp[index][currHeight];
        }
        if(currHeight == 0)
            return dp[index][currHeight] = 1;

        return dp[index][currHeight] = (building_combinations(index, currHeight-building_blocks[index])% MOD + building_combinations(index-1, currHeight)% MOD)% MOD;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int k = 0 ; k < tc ; k++)
        {
            N = sc.nextInt();
            H = sc.nextInt();
            dp = new int[N+1][H + 1];
            for(int m = 0 ; m <= N ; m++)
                for(int n = 0 ; n <= H ; n++)
                    dp[m][n] = -1;

            building_blocks = new int[N];
            for (int i = 0; i < N; i++)
            {
                building_blocks[i] = sc.nextInt();
            }
            resultList.add(building_combinations(N-1,H)%MOD);
        }
        resultList.forEach(result1->
                System.out.println(result1%MOD));
    }
}