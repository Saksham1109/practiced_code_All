package org.codes.algoCodes.DynamicProgramming;

import java.math.BigInteger;
import java.util.Scanner;

public class LadiesAndGentlemen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.close();

        BigInteger NG= BigInteger.valueOf(1);
        BigInteger NB= BigInteger.valueOf(0);
        long MOD = 1000000007;

        for(long i = 1L; i<n; i++)
        {
            if(i%2==1)
            {
                NB=NB.add(NG).add(BigInteger.valueOf(1));
            }
            else
            {
                NG=NG.add(NB).add(BigInteger.valueOf(1));
            }
        }
        System.out.println(NG.add(NB).mod(BigInteger.valueOf(MOD)));

    }
}
