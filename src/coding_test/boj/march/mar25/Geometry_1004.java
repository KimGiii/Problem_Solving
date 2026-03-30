package coding_test.boj.march.mar25;
/*
* 백준 1004 : 어린 왕자
*
* 알고리즘 : Geometry
 */

import java.io.*;
import java.util.*;

public class Geometry_1004 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());
            int ax = Integer.parseInt(st.nextToken());
            int ay = Integer.parseInt(st.nextToken());

            int planets = Integer.parseInt(br.readLine());
            for (int j = 0; j < planets; j++) {
                st = new StringTokenizer(br.readLine());
                int px = Integer.parseInt(st.nextToken());
                int py = Integer.parseInt(st.nextToken());
                int pr = Integer.parseInt(st.nextToken());

                if (dy - ay > py + pr || dy - ay < py - pr) {
                    
                }
            }

        }

    }
}
