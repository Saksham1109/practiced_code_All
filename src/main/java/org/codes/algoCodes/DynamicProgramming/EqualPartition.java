package org.codes.algoCodes.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EqualPartition {
    private static int N;
    private static List<String> answer=new ArrayList<>();
    private static Boolean[][] dp;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            String[] arrInput = br.readLine().split(" ");
            int totalSum=0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(arrInput[i]);
                totalSum +=arr[i];
            }
            if(totalSum%2==1)
            {
                answer.add("NO");
                continue;
            }
            if(N==1)
            {
                answer.add("NO");
                continue;
            }



            dp = new Boolean[N][totalSum/2 +1];
            for (Boolean[] ints : dp) {
                Arrays.fill(ints, false);
            }
            answer.add(solver(0, totalSum / 2) ?"YES":"NO");
        }
        answer.forEach(System.out::println);

    }

    private static Boolean solver(int index, int sum) {
        if(sum==0)
        {
            return true;
        }
        if(index>=N)
        {
            return false;
        }
        if(dp[index][sum])
        {
            return false;
        }

        dp[index][sum]=true;
        if(arr[index] <= sum && solver(index+1,sum-arr[index]))
        {
            return true;
        }

        return solver(index+1,sum);
    }
}
