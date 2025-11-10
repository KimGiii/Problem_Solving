package coding_test.종만북.동적계획법;

public class TRIANGLEPATH_dp {
    private static final int MAX_NUMBER = Integer.MAX_VALUE;
    private int n;
    private int[][] triangle;
    static int[][][] cache = new int[100][100][MAX_NUMBER * 100 + 1];

    private int path1(int y, int x, int sum) {
        // 기저 사례: 맨 아래줄까지 도달했을 경우
        if (y == n - 1) {
            return sum + triangle[y][x];
        }

        // 메모이제이션
        int ret = cache[y][x][sum];
        if (ret != -1) {
            return ret;
        }
        sum +=  triangle[y][x];
        return ret = Math.max(path1(y+1, x+1, sum), path1(y+1, x, sum + triangle[y][x]));
    }

    private int[][] cache2;

    private int path2(int y, int x) {
        if (y == n - 1) {
            return triangle[y][x];
        }

        // 메모이제이션
        int ret = cache2[y][x];
        if (ret != -1) {
            return ret;
        }

        return ret = Math.max(path2(y+1, x), path2(y+1, x+1)) +  triangle[y][x];
    }
}
