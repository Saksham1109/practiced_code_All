package org.codes.algoCodes.DynamicProgramming;

import java.util.Scanner;

public class circularKadane {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the value of N
        int N = scanner.nextInt();

        // Input the array elements
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        if(arr.length==0)
        {
            System.out.println(0);
        }
        int kadane1=kadane(arr);
        int y=0;
        for(int i=1;i<arr.length;i++)
        {
            y+=arr[i];
            arr[i] *=-1;
        }
        int kadane2=kadane(arr);
        if(y+kadane2==0)
        {
            System.out.println(kadane1);
        }
        else
        {
            System.out.println(Math.max(kadane1,y+kadane2));
        }

    }

    private static int kadane(int[] arr) {
        int n =arr.length;
        int sum=arr[0], answer=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            sum+=arr[i];
            if(sum<arr[i])
            {
                sum=arr[i];
            }
            answer=Math.max(answer,sum);
        }
        return answer;
    }
}
