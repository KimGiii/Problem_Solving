package coding_test.boj.march.mar16;

import java.io.*;
import java.util.*;

public class BOJ_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력되는 좌표의 개수를 읽어옵니다.
        int n = Integer.parseInt(br.readLine());

        // 원본 배열과 정렬된 배열을 저장할 공간을 생성합니다.
        int[] origin = new int[n];
        int[] sorted = new int[n];

        // 공백을 기준으로 좌표들을 입력받아 배열에 저장합니다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        // 배열을 오름차순으로 정렬합니다.
        Arrays.sort(sorted);

        // 정렬된 배열을 순회하면서, 중복되지 않는 값들에 대해 순위를 매겨 HashMap에 저장합니다.
        // 순위가 곧 자신보다 작은 값의 개수(압축된 좌표)를 의미합니다.
        HashMap<Integer, Integer> rankingMap = new HashMap<>();
        int rank = 0;
        for (int value : sorted) {
            // 아직 map에 존재하지 않는 값인 경우에만 순위를 매깁니다.
            if (!rankingMap.containsKey(value)) {
                rankingMap.put(value, rank);
                rank++; // 다음 순위를 위해 1 증가시킵니다.
            }
        }

        // 원본 배열의 각 원소에 대해 매겨진 순위(압축된 값)를 찾아 StringBuilder에 기록합니다.
        StringBuilder sb = new StringBuilder();
        for (int key : origin) {
            sb.append(rankingMap.get(key)).append(' ');
        }

        System.out.println(sb.toString().trim());
    }
}