package coding_test.boj.april.april07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Impl_10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int caseNum = Integer.parseInt(st.nextToken());
            int[] students = new int[20];
            int changeCount = 0;
            for (int j = 0; j < 20; j++) {
                students[j] = Integer.parseInt(st.nextToken());
                for (int k = j - 1; k >= 0; k--) {
                    if (students[k] > students[k + 1]) {
                        swap(students, k, k + 1);
                        changeCount++;
                    } else {
                        break;
                    }
                }
            }
            sb.append(caseNum).append(" ").append(changeCount).append("\n");
        }

        System.out.print(sb);
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
