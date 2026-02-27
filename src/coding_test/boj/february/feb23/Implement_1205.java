package coding_test.boj.february.feb23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Implement_1205 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int taesooScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(1);
            return;
        }

        int[] scores = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        if (N == P && taesooScore <= scores[N - 1]) {
            System.out.println(-1);
            return;
        }

        int taesooRank = 1;
        for (int i = 0; i < N; i++) {
            if (taesooScore < scores[i]) {
                taesooRank++;
            } else {
                break;
            }
        }

        System.out.println(taesooRank);
    }
}
