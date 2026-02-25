package coding_test.boj.Feb25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Topo_2252 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new ArrayList[N];
        int[] indegree = new int[N];
        for (int i = 0; i < adj.length; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a-1].add(b-1);
            indegree[b-1]++;
        }

        solveByIndegree(adj, indegree);

    }

    private static void solveByIndegree(List<Integer>[] adj, int[] indegree) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < adj.length; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur+1).append(" ");
            for (int next : adj[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) queue.add(next);
            }
        }
        System.out.println(sb);
    }
}
