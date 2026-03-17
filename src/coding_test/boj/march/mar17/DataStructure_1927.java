package coding_test.boj.march.mar17;

/*
* 백준 1927 : 최소 힙
*
* 알고리즘 : Data Structure
 */

import java.io.*;
import java.util.*;

public class DataStructure_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                minHeap.add(x);
            } else {
                if (minHeap.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(minHeap.poll()).append('\n');
                }
            }
        }

        System.out.println(sb);
    }
}
