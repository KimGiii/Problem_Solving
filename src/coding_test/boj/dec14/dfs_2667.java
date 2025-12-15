package coding_test.boj.dec14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class dfs_2667 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                // ASCII 코드 - '0'을 계산해 실제 계산에 사용할 수 있는 정수 타입으로 변환
                map[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> complexSizes = new ArrayList<>();
        int totalComplexes = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    totalComplexes++;
                    complexSizes.add(dfs(i, j));
                }
            }
        }

        sort(complexSizes);

        System.out.println(totalComplexes);
        for (int size : complexSizes) {
            System.out.println(size);
        }
    }

    public static int dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N || map[x][y] == 0 || visited[x][y]) {
            return 0;
        }

        visited[x][y] = true;
        int count = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            count += dfs(nx, ny);
        }

        return count;
    }
}