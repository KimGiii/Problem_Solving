package coding_test.종만북.무식하게풀기;

import java.util.ArrayList;
import java.util.List;

public class 외판원문제_재귀호출 {
    static int n;  // 도시의 수
    static double[][] dist;  // 두 도시간 거리를 저장하는 배열
    static double INF = Double.POSITIVE_INFINITY;  // 초기화를 위한 매우 큰 값

    // @path : 지금까지 만든 경로
    // @visited : 각 도시의 방문 여부
    // @currentLength : 지금까지 만든 경로의 길이
    // 나머지 도시를 모두 방문하는 경로 중 가장 짧은 것의 길이를 반환
    private double shortestPath(List<Integer> path, boolean[] visited, double currentLength) {
        // 기저 사례 : 모든 도시를 다 방문했을 때, 시작 도시로 돌아가고 종료
        if (path.size() == n) {
            return currentLength + dist[path.getFirst()][path.getLast()];
        }

        double ret = INF;
        int here = path.getLast();
        // 다음 방문할 도시를 전부 시도
        for (int next = 0; next < n; next++) {
            if (visited[next]) continue;
            visited[next] = true;
            path.add(next);
            // 나머지 경로를 재귀 호출을 통해 완성, 가장 짧은 경로의 길이 얻는다.
            double candidate = shortestPath(path, visited, currentLength + dist[here][next]);
            ret = Math.min(ret, candidate);
            path.removeLast();
            visited[next] = false;
        }
        return ret;
    }

    private double solve(int s) {
        boolean[] visited = new boolean[n];
        List<Integer> path = new ArrayList<>();
        path.add(s);
        visited[s] = true;
        return shortestPath(path, visited, 0.0);
    }
}
