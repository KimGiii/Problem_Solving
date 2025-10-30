package coding_test.종만북.분할정복;

import java.util.ArrayList;

public class 쿼드트리뒤집기_분할정복 {
    private static final int MAX_SIZE = 20;
    private char[][] decompressed;
    private String s;
    private int index;

    public char[][] decompress(String compressed, int size) {
        this.s = compressed;
        this.index = 0;
        this.decompressed = new char[MAX_SIZE][MAX_SIZE];

        decompressHelper(0, 0, size);
        return decompressed;
    }
    private void decompressHelper(int y, int x, int size) {
        char head = s.charAt(index++);

        if (head == 'b' || head == 'w') {
            for (int dy = 0; dy < size; dy++) {
                for (int dx = 0; dx < size; dx++) {
                    decompressed[y + dy][x + dx] = head;
                }
            }
        } else {
            int half = size / 2;
            // x인 경우 4조각으로 분할
            decompressHelper(y, x, half);
            decompressHelper(y, x + half, half);
            decompressHelper(y + half, x, half);
            decompressHelper(y + half, x + half, half);
        }
    }

    // 뒤집기
    public String reverse(String compressed) {
        this.s = compressed;
        this.index = 0;
        return reverseHelper();
    }

    private String reverseHelper() {
        char head = s.charAt(index++);

        if (head == 'b' || head == 'w') {
            return String.valueOf(head);
        }

        // x를 만나면 네 부분으로 된 하나의 덩어리 발견
        String upperLeft = reverseHelper();
        String upperRight = reverseHelper();
        String lowerLeft = reverseHelper();
        String lowerRight = reverseHelper();

        // 위 조각들과 아래 조각들의 위치 변경
        return "x" + lowerLeft + lowerRight + upperLeft + upperRight;
    }

    // 2차원 배열 출력 헬퍼 메서드
    private static void printBoard(char[][] board, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        쿼드트리뒤집기_분할정복 qt = new 쿼드트리뒤집기_분할정복();

        System.out.println("=== 예제 1: 간단한 4x4 이미지 ===");
        String s1 = "xbwwb";
        System.out.println("압축 문자열: " + s1);

        // 압축 해제
        char[][] board1 = qt.decompress(s1, 4);
        System.out.println("\n원본 이미지:");
        printBoard(board1, 4);

        // 뒤집기
        String reversed1 = qt.reverse(s1);
        System.out.println("\n뒤집은 압축 문자열: " + reversed1);

        // 뒤집은 것을 다시 압축 해제
        char[][] board1_reversed = qt.decompress(reversed1, 4);
        System.out.println("\n뒤집은 이미지:");
        printBoard(board1_reversed, 4);

        System.out.println("\n=== 예제 2: 복잡한 8x8 이미지 ===");
        String s2 = "xxwwwbxwxwbbbwwxxxwwbbbwwwwbb";
        System.out.println("압축 문자열: " + s2);

        // 압축 해제
        char[][] board2 = qt.decompress(s2, 8);
        System.out.println("\n원본 이미지:");
        printBoard(board2, 8);

        // 뒤집기
        String reversed2 = qt.reverse(s2);
        System.out.println("\n뒤집은 압축 문자열: " + reversed2);

        // 뒤집은 것을 다시 압축 해제
        char[][] board2_reversed = qt.decompress(reversed2, 8);
        System.out.println("\n뒤집은 이미지:");
        printBoard(board2_reversed, 8);
    }
}
