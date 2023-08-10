package org.codes.algoCodes;

import java.util.ArrayList;
import java.util.Scanner;

public class CompanyHierarchy {
    static ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    static ArrayList<Integer> distance=new ArrayList<>();
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr= new int[n];

        for(int i=0;i<n+1;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=2;i<n;i++)
        {
            arr[i]=sc.nextInt();
            addEdge(i,arr[i]);
        }

        for(int i=1;i<=n;i++)
        {
            dfs(adj,i);
        }

        

    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, int i) {
        boolean[] visited=new boolean[i];

        for(int j=0;j<i;j++)
        {
            if(!visited[j])
            {
                dfsRec(j,visited);
            }
        }
    }

    private static void dfsRec(int j, boolean[] visited) {
        visited[j]=true;

        adj.get(j).forEach(child->
        {
            if(!visited[child])
            {
                dfsRec(child,visited);
            }
        });

    }

    private static void addEdge(int i, int i1) {
        adj.get(i1).add(i);
    }
}
