package coding_test.boj.Feb10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Implement_20125 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cookiesBodyParts = new int[] {0, 0, 0, 0, 0};
        int heartI = 0;
        int heartJ = 0;
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        outerLoop:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == '*') {
                    heartI = i + 1;
                    heartJ = j;
                    System.out.println((heartI + 1) + " " + (heartJ + 1));
                    break outerLoop;
                }
            }
        }

        // 왼쪽 팔 구하기
        for (int i = heartJ-1; i >= 0; i--) {
            if (arr[heartI][i] == '*') {
                cookiesBodyParts[0]++;
            }
        }

        // 오른쪽 팔 구하기
        for (int i = heartJ+1; i < N; i++) {
            if (arr[heartI][i] == '*') {
                cookiesBodyParts[1]++;
            }
        }

        // 허리 구하기
        for (int i = heartI+1; i < N; i++) {
            if (arr[i][heartJ] == '*') {
                cookiesBodyParts[2]++;
            }
        }

        // 왼쪽 다리 구하기
        for (int i = heartI+1; i < N; i++) {
            if (arr[i][heartJ-1] == '*') {
                cookiesBodyParts[3]++;
            }
        }

        // 오른쪽 다리 구하기
        for (int i = heartI+1; i < N; i++) {
            if (arr[i][heartJ+1] == '*') {
                cookiesBodyParts[4]++;
            }
        }

        System.out.println(cookiesBodyParts[0] + " " + cookiesBodyParts[1] + " " + cookiesBodyParts[2] + " " + cookiesBodyParts[3] + " " + cookiesBodyParts[4]);

    }
}
