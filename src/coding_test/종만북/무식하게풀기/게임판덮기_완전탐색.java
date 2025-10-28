package coding_test.종만북.무식하게풀기;

public class 게임판덮기_완전탐색 {
    public static int[][][] coverType = new int[][][] {
            {{0, 0}, {0, 1}, {1, 0}}, // ┏
            {{0, 0}, {0, 1}, {1, 1}}, // ┓
            {{0, 0}, {1, 0}, {1, 1}}, // ┗
            {{0, 0}, {1, 0}, {1, -1}} // ┛
    };

    // 게임판을 벗어나면 false
    // 겹치거나, 검은 판을 덮으면 false
    // delta가 1이면 덮고, -1이면 치우기
    private boolean set(int[][] board, int y, int x, int type, int delta) {
        boolean possible = true;
        for (int i = 0; i < 3; i++) {
            int newY = y + coverType[type][i][0];
            int newX = x + coverType[type][i][1];
            if (newY < 0 || newY >= board.length || newX < 0 || newX >= board[0].length) {
                possible = false;
                continue;
            }

            if (board[newY][newX] == 1) possible = false;
            board[newY][newX] +=  delta;
        }
        return possible;
    }

    // board의 모든 빈 칸을 덮을 수 있는 경우의 수 return
    // board[i][j] == 1이면 이미 덮인 혹은 검은 칸
    // board[i][j] == 0이면 아직 덮이지 않은 칸
    private int cover(int[][] board) {
        int y = -1;
        int x = -1;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    y = i;
                    x = j;
                    break;
                }
            }
            if (y != -1) break;
        }

        // 기저 사례 : 모든 칸을 채웠으면 1 반환
        if (y == -1) return 1;

        // 블록을 덮는 4가지 방법 시도
        int ret = 0;
        for (int type = 0; type < 4; type++) {
            // 현 위치를 type 형태로 덮을 수 있으면 재귀 호출
            if (set(board, y, x, type, 1)) {
                ret += cover(board);
            }
            // 덮었던 블록 제거
            set(board, y, x, type, -1);
        }
        return ret;
    }
}
