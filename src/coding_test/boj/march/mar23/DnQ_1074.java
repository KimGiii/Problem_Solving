package coding_test.boj.march.mar23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DnQ_1074 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = (1 << n);

        solve(size, r, c);
        System.out.println(count);
    }

    private static void solve(int size, int r, int c) {
        if (size == 1) {
            return;
        }

        int half = size / 2;

        // 1사분면 (왼쪽 위)
        if (r < half && c < half) {
            solve(half, r, c);
        }
        // 2사분면 (오른쪽 위)
        else if (r < half && c >= half) {
            count += half * half;
            solve(half, r, c - half);
        }
        // 3사분면 (왼쪽 아래)
        else if (r >= half && c < half) {
            count += half * half * 2;
            solve(half, r - half, c);
        }
        // 4사분면 (오른쪽 아래)
        else {
            count += half * half * 3;
            solve(half, r - half, c - half);
        }
    }
}
