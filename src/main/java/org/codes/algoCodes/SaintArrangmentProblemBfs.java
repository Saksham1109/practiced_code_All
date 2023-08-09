package org.codes.algoCodes;

import java.io.*;
import java.util.*;

public class SaintArrangmentProblemBfs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st
                = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long min = -2000000001;
        long max = 2000000001;
        HashSet<Long> temples = new HashSet<>();
        LinkedHashSet<Long> saints = new LinkedHashSet<>();
        Queue<long[]> q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
        {
            long temple = Long.parseLong(st.nextToken());
            temples.add(temple);
            q.add(new long[]{temple,0});
        }

        long distance=0;
        while(m!=0)
        {
            long node[] = q.poll();
            long pos = node[0];
            long dist = node[1];
            long l = pos-1;
            long r = pos+1;
            if(!temples.contains(l)&&!saints.contains(l)&&l>min)
            {
                saints.add(l);
                q.add(new long[]{l,dist+1});
                distance+=(dist+1);
                --m;
            }
            if(!temples.contains(r)&&!saints.contains(r)&&r<max)
            {
                saints.add(r);
                q.add(new long[]{r,dist+1});
                distance+=(dist+1);
                --m;
            }
        }
        BufferedWriter output = new BufferedWriter(
                new OutputStreamWriter(System.out));
        output.write(distance + "\n");
        for(Long saint:saints)
            output.write(saint + " ");
        output.flush();
    }
}
