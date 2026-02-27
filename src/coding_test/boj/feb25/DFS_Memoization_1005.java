package coding_test.boj.feb25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1005 - ACM Craft
 * 알고리즘: DFS + Memoization
 */
public class DFS_Memoization_1005 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int[] cost;     // 각 건물의 순수 건설 시간
    static int[] memo;     // 각 건물의 완공 시간을 저장 (메모이제이션)
    static List<Integer>[] reverseAdj; // 역방향 그래프 (나를 짓기 위해 필요한 건물들)

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            cost = new int[N + 1];
            memo = new int[N + 1];
            Arrays.fill(memo, -1); // 메모이제이션 배열 초기화 (-1은 아직 계산 안 됨을 의미)

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }

            // 역방향 그래프 초기화
            reverseAdj = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) reverseAdj[i] = new ArrayList<>();

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                // b를 짓기 위해 a가 필요하므로, b -> a 로 연결 (역방향)
                reverseAdj[b].add(a);
            }

            int W = Integer.parseInt(br.readLine());

            // 목표 건물 W부터 역으로 탐색 시작
            sb.append(getCompletionTime(W)).append(" ");
        }
        System.out.print(sb);
    }

    private static int getCompletionTime(int node) {
        // 1. 이미 계산된 적이 있다면 그 값을 즉시 반환 (메모이제이션)
        if (memo[node] != -1) {
            return memo[node];
        }

        // 2. 나보다 먼저 지어져야 할 건물들 중 가장 늦게 끝나는 시간을 찾음
        int maxPrevTime = 0;
        for (int prev : reverseAdj[node]) {
            maxPrevTime = Math.max(maxPrevTime, getCompletionTime(prev));
        }

        // 3. 결과 저장: (선행 건물 중 최대 시간) + (내 건설 시간)
        return memo[node] = maxPrevTime + cost[node];
    }
}
