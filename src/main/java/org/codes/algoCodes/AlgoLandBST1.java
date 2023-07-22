package org.codes.algoCodes;

import java.util.*;

public class AlgoLandBST1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m=sc.nextInt();

        HashMap<String, ArrayList<ArrayList<String>>> graph=new HashMap<>();
        for(int i=0;i<m;i++)
        {
            String u= sc.next();
            String v= sc.next();
            String r= sc.next();
            ArrayList<String> dest=new ArrayList<>();
            dest.add(v);
            dest.add(r);
            ArrayList<ArrayList<String>> des2=new ArrayList<>();
            des2.add(dest);
            if(!graph.containsKey(u))
            {
                graph.put(u,des2);
            }
            else
            {
                ArrayList<ArrayList<String>> res1= graph.get(u);
                res1.add(dest);
                graph.put(u,res1);
            }
        }
        String src= sc.next();
        String target=sc.next();
        System.out.println();

        graph.forEach((g,v)->
        {
            System.out.println(g+"    -    >   ||"+v);
        });
    }
}
