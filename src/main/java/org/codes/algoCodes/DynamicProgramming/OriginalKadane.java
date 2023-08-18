package org.codes.algoCodes.DynamicProgramming;

import java.util.Scanner;

public class OriginalKadane {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the value of N
        int N = scanner.nextInt();

        // Input the array elements
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        // Calculate maximum contiguous subarray sum using Kadane's algorithm
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < N; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        // Output the result
        System.out.println(maxSoFar);

        scanner.close();
    }
}
