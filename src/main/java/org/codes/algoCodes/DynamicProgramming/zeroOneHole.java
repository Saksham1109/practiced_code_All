package org.codes.algoCodes.DynamicProgramming;

import java.util.Scanner;

public class zeroOneHole {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the value of N
        int N = scanner.nextInt();



        // Input the array elements
        int[] arr = new int[N];
        int[] dpPrev=new int[N];
        int[] dpSuff=new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        dpPrev[0]=arr[0];
        int answer=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            dpPrev[i]=Math.max(dpPrev[i-1]+arr[i],arr[i]);
            answer=Math.max(answer,dpPrev[i]);
        }

        dpSuff[N-1]=arr[N-1];
        for(int i=N-2;i>=0;i--)
        {
            dpSuff[i]=Math.max(dpSuff[i+1]+arr[i],arr[i]);
        }
        for(int i=1;i<N-1;i++)
        {
            answer=Math.max(answer,dpPrev[i-1]+dpSuff[i+1]);
        }
        System.out.println(answer);
    }
}
