package coding_test.boj.march.mar05;

import java.util.*;
import java.io.*;

public class BFS_1926 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count++;
                    maxArea = Math.max(maxArea, bfs(i, j));
                }
            }
        }

        System.out.println(count);
        System.out.println(maxArea);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int area = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            area++;

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                // 범위 체크 및 방문 여부, 그림 유무 확인
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return area;
    }
}
