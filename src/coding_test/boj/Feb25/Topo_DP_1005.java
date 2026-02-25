package coding_test.boj.Feb25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1005 - ACM Craft
 * 알고리즘: Topological Sort + DP
 */
public class Topo_DP_1005 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 건물의 개수
            int K = Integer.parseInt(st.nextToken()); // 건설 순서 규칙의 개수

            // 1. 각 건물의 건설 비용(시간) 입력 (1번부터 사용하기 위해 N+1 크기)
            int[] cost = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                cost[j] = Integer.parseInt(st.nextToken());
            }

            // 2. 그래프 및 진입 차수 배열 초기화
            List<Integer>[] adj = new ArrayList[N + 1];
            int[] indegree = new int[N + 1];
            for (int j = 1; j <= N; j++) adj[j] = new ArrayList<>();

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
                indegree[b]++; // b번 건물의 선행 건물 개수 증가
            }

            // 3. 목표 건물 번호 입력
            int W = Integer.parseInt(br.readLine());

            // 4. 위상 정렬 및 결과 계산 호출
            solveByIndegree(adj, indegree, cost, W, N);
        }

        // 모든 결과 한 번에 출력
        System.out.print(sb);
    }

    private static void solveByIndegree(List<Integer>[] adj, int[] indegree, int[] cost, int W, int N) {
        Queue<Integer> q = new ArrayDeque<>();

        // result[i]는 i번 건물이 완공되는 시점의 누적 시간을 저장
        int[] result = new int[N + 1];

        // 5. 초기 설정: 진입 차수가 0인 건물(선행 조건 없는 건물)을 큐에 삽입
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                result[i] = cost[i]; // 자기 자신의 건설 시간이 곧 완공 시간
            }
        }

        // 6. 위상 정렬 시작
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == W) break;

            // 현재 건물(cur)에서 나가는 모든 간선 확인
            for (int next : adj[cur]) {
                /**
                 * next 건물을 짓기 시작할 수 있는 시간은 모든 선행 건물이 끝난 '후'
                 * 즉, 여러 선행 건물 중 가장 늦게 끝나는 건물의 완료 시점에 맞춤
                 * result[next] = max(기존 저장된 완료 시간, 현재 선행 건물 cur의 완료 시간 + next 자신의 건설 시간)
                 */
                result[next] = Math.max(result[next], result[cur] + cost[next]);

                // 선행 작업 하나를 완료했으므로 진입 차수 감소
                indegree[next]--;

                // 모든 선행 작업이 완료되었다면(진입 차수가 0이 되면) 큐에 추가
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        // 7. 목표 건물 W의 누적 완공 시간을 StringBuilder에 추가
        sb.append(result[W]).append("\n");
    }
}
