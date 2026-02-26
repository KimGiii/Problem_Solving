package coding_test.boj.Feb26;

import java.io.*;
import java.util.*;

public class Impl_1138 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int leftCount = Integer.parseInt(st.nextToken());

            int count = 0;
            for (int j = 0; j < N; j++) {
                if (result[j] == 0) {
                    if (count == leftCount) {
                        result[j] = i;
                        break;
                    }
                    count++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(i == N - 1 ? "" : " ");
        }
        System.out.println(sb);
    }
}
