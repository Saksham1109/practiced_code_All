package org.codes.algoCodes;

import java.util.*;

public class AlgoLandRetry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Map<String,Integer>> arr =new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            arr.add(new HashMap<>());
        }
        HashMap<String,Integer> hm = new HashMap<>();
        int count=0;
        for(int i=0;i<m;i++)
        {
            String u = sc.next();
            String v = sc.next();
            String l = sc.next();
            int a =0;
            int b =0;

            if(hm.containsKey(u))
            {
                a= hm.get(u);

            }
            else
            {
                a=count++;
                hm.put(u,a);
            }

            if(hm.containsKey(v))
            {
                b= hm.get(v);
            }
            else
            {
                b=count++;
                hm.put(v,b);
            }
            arr.get(a).put(l,b);
        }

        String src= sc.next();
        String dest=sc.next();

        int s=hm.get(src);
        int d=hm.get(dest);


        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        String[] visited  = new String[n];
        int[] visited2 = new int[n];

        visited[s]="";
        visited2[s]=0;

        while (!queue.isEmpty())
        {
            int current= queue.poll();

            for( Map.Entry<String,Integer> entry : arr.get(current).entrySet())
            {
                if(visited[entry.getValue()]== null)                {
                    queue.add(entry.getValue());
                    visited[entry.getValue()]= visited[current] + "\n" + entry.getKey();
                    visited2[entry.getValue()] = visited2[current] + 1;
                }
            }
        }
        if(null ==  visited[d])
        {
            System.out.println("Impossible");
        }
        else
        {
            System.out.println(visited2[d] + "\n" + visited[d]);
        }
    }
}
