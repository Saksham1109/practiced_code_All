package org.codes.algoCodes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class GoodLuckPathProblemPart2 {
    public static void bfs(ArrayList<ArrayList<Integer>> adj, Pair[][] par, HashSet<ArrayList<Integer>> triplets, int n) {
        Queue<Pair> queue = new LinkedList<>();

        HashSet<ArrayList<Integer>> vis = new HashSet<>();
        queue.add(new Pair(1, 1));
        ArrayList<Integer> initial = new ArrayList<>();
        initial.add(1);
        initial.add(1);
        vis.add(initial);

        while (!queue.isEmpty()) {
            Pair p = queue.peek();
            queue.remove();
            int vf = p.first; //parent of vs i.e. vf -> vs
            int vs = p.second; //child of vs
            for (int child : adj.get(vs)) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(vf);
                temp.add(vs);
                temp.add(child);
                if (triplets.contains(temp))
                    continue;
                ArrayList<Integer> temp1 = new ArrayList<>();
                temp1.add(vs);
                temp1.add(child);
                if (vis.contains(temp1))
                    continue;

                par[vs][child] = p;
                queue.add(new Pair(vs, child));
                vis.add(temp1);

                if (child == n)
                    return;
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().trim().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Pair[][] par = new Pair[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] s1 = bf.readLine().trim().split(" ");
            adj.get(Integer.parseInt(s1[0])).add(Integer.parseInt(s1[1]));
            adj.get(Integer.parseInt(s1[1])).add(Integer.parseInt(s1[0]));
        }

        HashSet<ArrayList<Integer>> triplets = new HashSet<>();

        for (int i = 0; i < k; i++) {
            String[] s1 = bf.readLine().trim().split(" ");
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(Integer.parseInt(s1[0]));
            temp.add(Integer.parseInt(s1[1]));
            temp.add(Integer.parseInt(s1[2]));
            triplets.add(temp);
        }

        bfs(adj, par, triplets, n);

        for (int i = 1; i <= n; i++) {
            if (par[i][n] != null) {
                ArrayList<Integer> path = new ArrayList<>();
                Pair current = par[i][n];
                path.add(n);
                while (current != null) {
                    int vf = current.first;
                    int vs = current.second;
                    path.add(vs);
                    current = par[vf][vs];
                }
                System.out.println(path.size() - 1);
                int pathLength = path.size() - 1;
                for (int j = pathLength; j >= 0; j--) {
                    System.out.print(path.get(j) + " ");
                }
                return;
            }
        }
        System.out.println(-1);
    }

    public static class Pair {
        int first;
        int second;

        public Pair(int f, int s) {
            first = f;
            second = s;
        }
    }
}
