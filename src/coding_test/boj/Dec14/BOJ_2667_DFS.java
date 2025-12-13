package coding_test.boj.Dec14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2667_DFS {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1}; // for traversing neighbors
    static int[] dy = {1, -1, 0, 0}; // for traversing neighbors

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> complexSizes = new ArrayList<>();
        int totalComplexes = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // If it's a house and not visited yet, it's a new complex
                if (map[i][j] == 1 && !visited[i][j]) {
                    totalComplexes++;
                    complexSizes.add(dfs(i, j));
                }
            }
        }

        // Sort the sizes in ascending order
        Collections.sort(complexSizes);

        // Print the result
        System.out.println(totalComplexes);
        for (int size : complexSizes) {
            System.out.println(size);
        }
    }

    public static int dfs(int x, int y) {
        // Base case for recursion: check for bounds, if it's not a house, or already visited
        if (x < 0 || y < 0 || x >= N || y >= N || map[x][y] == 0 || visited[x][y]) {
            return 0;
        }

        // Mark as visited
        visited[x][y] = true;

        // Count the current house
        int count = 1;

        // Visit all four neighbors
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            count += dfs(nx, ny);
        }

        return count;
    }
}