package coding_test.boj.dec15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class dfs_11725 {
    static int n;
    static boolean[] visited;
    static List<Integer>[] graph;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        // n을 읽은 후 자료구조 초기화
        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // n-1개의 간선 정보 입력받기
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향으로 간선 추가
            graph[u].add(v);
            graph[v].add(u);
        }

        // 루트 노드인 1에서부터 DFS 시작
        dfs(1);

        // 2번 노드부터 부모 노드 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int node) {
        visited[node] = true; // 현재 노드 방문 처리

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) { // 인접 노드가 아직 방문하지 않았다면
                parent[neighbor] = node; // 현재 노드가 인접 노드의 부모가 됨
                dfs(neighbor); // 자식 노드로 재귀 호출
            }
        }
    }
}
