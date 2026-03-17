package coding_test.boj.march.mar17;

/*
 * 백준 2630 : 색종이 만들기
 *
 * 알고리즘 : Divide and Conquer (분할 정복)
 */

import java.io.*;
import java.util.*;

public class DivideAndConquer_2630 {
    static int white = 0;
    static int blue = 0;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void partition(int row, int col, int size) {
        // 1. 현재 영역이 모두 같은 색상인지 확인
        if (colorCheck(row, col, size)) {
            if (board[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        // 2. 색상이 같지 않다면 4등분으로 분할 (Divide)
        int newSize = size / 2; // 절반 크기

        partition(row, col, newSize);                                   // 왼쪽 위
        partition(row, col + newSize, newSize);                     // 오른쪽 위
        partition(row + newSize, col, newSize);                    // 왼쪽 아래
        partition(row + newSize, col + newSize, newSize);      // 오른쪽 아래
    }

    // 현재 영역의 모든 색상이 같은지 체크
    public static boolean colorCheck(int row, int col, int size) {
        int color = board[row][col]; // 첫 번째 칸의 색상을 기준으로 설정

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                // 하나라도 색상이 다르면 false 반환
                if (board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
