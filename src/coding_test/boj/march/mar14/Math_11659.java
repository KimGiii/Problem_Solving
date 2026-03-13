package coding_test.boj.march.mar14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n + 1];
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int curr = Integer.parseInt(st.nextToken());
            sum += curr;
            numbers[i] = sum;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int ans = numbers[end] - numbers[start - 1];

            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
