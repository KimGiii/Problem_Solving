package coding_test.boj.march.mar14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int M = Integer.parseInt(br.readLine());
        int bitset = 0;
        
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x = 0;
            
            // all과 empty는 x가 주어지지 않으므로 예외 처리
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }
            
            switch (command) {
                case "add":
                    bitset |= (1 << x);
                    break;
                case "remove":
                    bitset &= ~(1 << x);
                    break;
                case "check":
                    sb.append((bitset & (1 << x)) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    bitset ^= (1 << x);
                    break;
                case "all":
                    // 1부터 20까지의 비트를 모두 1로 설정
                    bitset = (1 << 21) - 1;
                    break;
                case "empty":
                    bitset = 0;
                    break;
            }
        }
        System.out.print(sb);
    }
}
