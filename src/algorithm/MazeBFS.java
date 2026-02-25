package algorithm;
import java.util.LinkedList;
import java.util.Queue;

public class MazeBFS {
    // 상, 하, 좌, 우 이동을 위한 암시적 간선 규칙
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    // 큐에 넣을 좌표(r, c)와 현재까지의 이동 거리(dist)를 저장하는 클래스
    static class Point {
        int r, c, dist;
        public Point(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    public static int bfs(int[][] maze, int startR, int startC, int targetR, int targetC) {
        int rows = maze.length;
        int cols = maze[0].length;

        // 무한 루프(사이클) 방지를 위한 방문 체크 배열
        boolean[][] visited = new boolean[rows][cols];
        // BFS를 위한 큐 생성
        Queue<Point> queue = new LinkedList<>();

        // 1. 시작점 큐에 삽입 및 방문 처리
        queue.offer(new Point(startR, startC, 1)); // 시작 칸도 거리에 포함 (1부터 시작)
        visited[startR][startC] = true;

        // 2. 큐가 빌 때까지 탐색 반복
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            // 목적지에 도착했다면 현재까지 누적된 최단 거리 반환
            if (current.r == targetR && current.c == targetC) {
                return current.dist;
            }

            // 4방향 (상, 하, 좌, 우) 암시적 간선 탐색
            for (int i = 0; i < 4; i++) {
                int nextR = current.r + dr[i];
                int nextC = current.c + dc[i];

                // 조건 1: 미로의 범위를 벗어나지 않는가?
                if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols) {
                    // 조건 2: 갈 수 있는 길(1)이며, 조건 3: 아직 방문하지 않은 곳인가?
                    if (maze[nextR][nextC] == 1 && !visited[nextR][nextC]) {
                        visited[nextR][nextC] = true; // 방문 처리 (큐에 중복으로 들어가는 것 방지)
                        queue.offer(new Point(nextR, nextC, current.dist + 1)); // 거리 1 증가시켜 큐에 삽입
                    }
                }
            }
        }
        // 큐를 다 비웠는데도 목적지에 도달하지 못했다면 길이 없는 것
        return -1;
    }

    public static void main(String[] args) {
        // 1: 이동 가능한 길, 0: 벽
        int[][] maze = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };

        // (0, 0)에서 출발하여 (4, 4)까지 가는 최단 거리 찾기
        int shortestPath = bfs(maze, 0, 0, 4, 4);

        if (shortestPath != -1) {
            System.out.println("도착점까지의 최단 거리: " + shortestPath + "칸");
        } else {
            System.out.println("도착점까지 갈 수 있는 길이 없습니다.");
        }
    }
}