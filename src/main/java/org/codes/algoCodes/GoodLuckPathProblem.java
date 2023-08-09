package org.codes.algoCodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GoodLuckPathProblem {
    static HashMap<List<Integer>,List<Integer>> nodes = new HashMap<>();
    static HashSet<List<Integer>> superstition = new HashSet<>();
    static List<List<Integer>>adj = new ArrayList<>();
    static List<Integer> nthNode;
    static void bfs(int n)
    {
        Queue<List<Integer>>q = new LinkedList<>();
        List<Integer>src = Arrays.asList(-1,1);
        q.add(src);
        nodes.put(src,null);
        while(!q.isEmpty())
        {
            List<Integer>item = q.poll();
            int parent = item.get(0);
            int node = item.get(1);
            if(node==n)
            {
                nthNode = item;
                break;
            }
            List<Integer>list = adj.get(node);
            for(int i=0;i<list.size();i++)
            {
                int child = list.get(i);
                if(!superstition.contains(Arrays.asList(parent,node,child)))
                {
                    List<Integer>l = Arrays.asList(node,child);
                    if(!nodes.containsKey(l))
                    {
                        nodes.put(l,item);
                        q.add(l);
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int k = Integer.parseInt(arr[2]);
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<m;i++)
        {
            arr = br.readLine().split(" ");
            int u = Integer.parseInt(arr[0]);
            int v = Integer.parseInt(arr[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i=0;i<k;i++)
        {
            arr = br.readLine().split(" ");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            int z = Integer.parseInt(arr[2]);
            superstition.add(Arrays.asList(x,y,z));
        }
        bfs(n);
        StringBuilder sb = new StringBuilder();
        if(nthNode!=null)
        {
            int count = 0;
            while(nthNode!=null)
            {
                ++count;
                sb.append(" "+nthNode.get(1));
                nthNode = nodes.get(nthNode);
            }
            System.out.println(count-1);
            System.out.print(sb.reverse());
        }
        else
            System.out.print(-1);
    }
}
