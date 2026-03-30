package coding_test.boj.march.mar30;

/*
* 백준 2468 - 안전영역
*
* 알고리즘 - BFS
 */

import java.io.*;
import java.util.*;

public class BFS_2468 {
    static int n;
    static int maxHeight = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > maxHeight) {
                    maxHeight = map[i][j];
                }
            }
        }

        int maxSafeArea = 1;

        for (int h = 1; h <= maxHeight; h++) {
            visited = new boolean[n][n];
            int currentAreaCount = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > h && !visited[i][j]) {
                        bfs(i, j, h);
                        currentAreaCount++;
                    }
                }
            }
            maxSafeArea = Math.max(maxSafeArea, currentAreaCount);
        }

        System.out.println(maxSafeArea);
    }

    private static void bfs(int startX, int startY, int h) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nx][ny] > h && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
