package org.codes.algoCodes;

import java.util.ArrayList;
import java.util.List;

public class g4g {
    public static void main(String[] args) {
        int ans=uniqueSolution("FFFF",2);
        System.out.println(ans);
    }

    private static int uniqueSolution(String moves, int k) {
        int realNumber=0;
        List<Integer> realList=new ArrayList<>();
        char[] charArr=moves.toCharArray();
        realList.add(realNumber);
        for(int i=0;i<charArr.length;i++)
        {
            if(charArr[i]=='F')
            {
                realNumber++;
            }
            else
            {
                realNumber--;
            }
            realList.add(realNumber);
        }
        return realList.stream().distinct().toArray().length;
    }
}
