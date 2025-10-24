package coding_test.종만북;

import java.util.List;

public class 시계맞추기_완전탐색 {
    static int MAX = Integer.MAX_VALUE;
    static int switchesNumber = 10;
    static int clocksNumber = 16;

    // linked[i][j] == 0이면, i번 스위치와 j번 시계가 연결되어 있지 않다.
    // linked[i][j] == 1이면, i번 스위치와 j번 시계가 연결되어 있다.
    static int[][] linked = new int[][] {
            {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
            {1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0}
    };

    private static boolean isAligned(int[] clocks) {
        for (int clock : clocks) {
            if (clock != 12) return false;
        }
        return true;
    }

    // switchIndex번 스위치를 누렀을 때, 시계의 값을 계산
    private void push(int[] clocks, int switchIndex) {
        for (int clock = 0; clock < clocksNumber; clock++) {
            if (linked[switchIndex][clock] == 1) {
                clocks[clock] += 3;
                if (clocks[clock] == 15) clocks[clock] = 3;
            }
        }
    }

    // @clocks : 현재 시계들의 상태
    // @switchIndex : 이번에 누를 스위치 번호
    // 이때, 남은 스위치를 눌러 clocks를 12시로 맞출 수 있는 최소 횟수를 반환
    // 만약 불가능하다면 MAX 반환
    private int solve(int[] clocks, int switchIndex) {
        if (switchIndex == switchesNumber) return isAligned(clocks) ? 0 : MAX;

        int ret = MAX;
        for (int count = 0; count < 4; count++) {
            ret = Math.min(ret, count + solve(clocks, switchIndex + 1));
            push(clocks, switchIndex);
        }

        // push가 네번 호출 되어 clocks는 원래와 같은 상태가 된다.
        return ret;
    }
}
