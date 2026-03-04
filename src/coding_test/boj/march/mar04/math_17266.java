package coding_test.boj.march.mar04;

import java.util.*;
import java.io.*;

/**
 * 백준 17266 : 어두운 굴다리
 *
 * 알고리즘 : 수학 (이진 탐색 없이 선형 탐색으로 풀이)
 * 가로등 높이 H는 다음 세 가지 경우의 최댓값입니다.
 * 1. 첫 번째 가로등이 시작점(0)을 밝히기 위해 필요한 높이: lampLocation[0] - 0
 * 2. 마지막 가로등이 끝점(N)을 밝히기 위해 필요한 높이: N - lampLocation[M-1]
 * 3. 인접한 두 가로등 사이의 중앙을 밝히기 위해 필요한 높이: (gap + 1) / 2
 */

public class math_17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 굴다리 길이
        int M = Integer.parseInt(br.readLine()); // 가로등 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] lampLocation = new int[M];
        for (int i = 0; i < M; i++) {
            lampLocation[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 시작점(0)부터 첫 번째 가로등까지의 거리
        int maxH = lampLocation[0];

        // 2. 가로등 사이의 간격 중 가장 큰 값의 절반 (올림 처리)
        for (int i = 1; i < M; i++) {
            int gap = lampLocation[i] - lampLocation[i - 1];
            int requiredH;
            if (gap % 2 == 0) {
                requiredH = gap / 2;
            } else {
                requiredH = gap / 2 + 1;
            }
            maxH = Math.max(maxH, requiredH);
        }

        // 3. 마지막 가로등부터 끝점(N)까지의 거리
        maxH = Math.max(maxH, N - lampLocation[M - 1]);

        System.out.println(maxH);
    }
}
