package coding_test.boj.march.mar04;

import java.util.*;
import java.io.*;

/**
 * 백준 17266 : 어두운 굴다리
 *
 * 알고리즘 : 이진 탐색 (Parametric Search)
 */

public class BinarySearch_17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 굴다리 길이
        int M = Integer.parseInt(br.readLine()); // 가로등 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] lampLocation = new int[M];
        for (int i = 0; i < M; i++) {
            lampLocation[i] = Integer.parseInt(st.nextToken());
        }

        int low = 1;
        int high = N;
        int result = N;

        // 이진 탐색 시작
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(mid, lampLocation, N)) {
                result = mid; // 가능한 경우, 더 작은 높이가 있는지 확인
                high = mid - 1;
            } else {
                low = mid + 1; // 불가능한 경우, 높이를 키움
            }
        }

        System.out.println(result);
    }

    /**
     * 가로등 높이가 H일 때, 0부터 N까지 모든 구간이 밝혀지는지 확인
     */
    private static boolean check(int H, int[] lampLocation, int N) {
        int lastCovered = 0; // 현재까지 밝혀진 구간의 끝 지점

        for (int location : lampLocation) {
            // 현재 가로등이 비추는 범위: [location - H, location + H]
            // 이전까지 밝혀진 끝 지점보다 현재 가로등의 시작 범위가 더 멀면 빈틈 발생
            if (location - H > lastCovered) {
                return false;
            }
            // 밝혀진 구간 업데이트
            lastCovered = location + H;
        }

        // 마지막 가로등이 비추는 범위가 굴다리 끝(N)에 도달했는지 확인
        return lastCovered >= N;
    }
}
