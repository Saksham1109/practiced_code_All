package org.codes.algoCodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PrisonBreak {
     public  static int[] dX={1,-1,0,0};
     public static int[] dY={0,0,1,-1};

     public static String dirs="DURL";

     public static int N,M;

    public static void main(String[] args) throws IOException {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) { grid[i] = br.readLine().toCharArray(); }

        int[][] dist = new int[N][M];
        boolean[][] visited= new boolean[N][M];


        Queue<Point> q = new LinkedList<>();

        Point start = new Point(-1,-1);

        // processing the grid
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(grid[i][j] == 'M')
                {
                    q.add(new Point(i,j));
                    dist[i][j]=0;
                    visited[i][j]=true;
                }
                if(grid[i][j] == 'A')
                {
                    start = new Point(i,j);
                }
            }
        }


        while (!q.isEmpty())
        {
            Point current=q.poll();
            int x=current.x;
            int y=current.y;
            for(int i=0;i<4;i++)
            {
                int x1=x+dX[i];
                int y1=y+dY[i];
                if(onGrid(x1,y1) && !visited[x1][y1] && grid[x1][y1]!='#')
                {
                    visited[x1][y1]=true;
                    dist[x1][y1]=dist[x][y]+1;
                    q.add(new Point(x1,y1));
                }
            }
        }

        q = new LinkedList<>();
        q.add(new Point(start.x, start.y));
        int[][] dist1= new int[N][M];
        dist1[start.x][start.y]=0;

        boolean[][] visited1=new boolean[N][M];
        visited1[start.x][start.y]=true;

        char[][] step= new char[N][M];
        Point[][] prevLoc = new Point[N][M];
        prevLoc[start.x][start.y] = new Point(-1, -1);


        while (!q.isEmpty())
        {
            Point current = q.poll();
            int x = current.x;
            int y = current.y;

            for(int i=0;i<4;i++)
            {
                int x1=x+dX[i];
                int y1=y+dY[i];

                char d = dirs.charAt(i);

                if(!onGrid(x1,y1)) {
                    System.out.println("YES");


                    while (x != -1) {
                        int tmp = x;
                        x = prevLoc[x][y].x;
                        y = prevLoc[tmp][y].y;
                    }
                    return;
                }

                if(!visited1[x1][y1] && grid[x1][y1] !='#')
                {
                    if(visited[x1][y1] && dist[x1][y1] <= dist1[x][y]+1)
                    {
                        continue;
                    }
                    visited1[x1][y1]=true;
                    dist1[x1][y1] = dist1[x][y] + 1;
                    q.add(new Point(x1, y1));
                    prevLoc[x1][y1] = new Point(x, y);
                    step[x1][y1] = d;
                }

            }
        }
        System.out.println("NO");

    }

    private static boolean onGrid(int x, int y) {
        return (x>=0 && x<N && y>=0 && y<M);
    }

    private static class Point {
        public  int x;
        public  int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
