package coding_test.boj.february.feb25;

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

        // 1-based indexing을 위해 크기를 N+1로 설정
        List<Integer>[] adj = new ArrayList[N + 1];
        int[] indegree = new int[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            indegree[b]++;
        }

        solveByIndegree(adj, indegree);
    }

    private static void solveByIndegree(List<Integer>[] adj, int[] indegree) {
        // LinkedList 대신 ArrayDeque 사용으로 성능 최적화
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i < adj.length; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : adj[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) queue.add(next);
            }
        }
        System.out.println(sb);
    }
}
