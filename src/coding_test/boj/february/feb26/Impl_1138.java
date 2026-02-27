package coding_test.boj.february.feb26;

import java.io.*;
import java.util.*;

public class Impl_1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        // 키가 큰 사람부터 역순으로 리스트에 삽입
        // 리스트의 인덱스가 곧 "자신의 왼쪽에 있는 나보다 큰 사람의 수"가 됨
        List<Integer> result = new ArrayList<>();
        for (int i = n; i >= 1; i--) {
            result.add(input[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result.get(i)).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
