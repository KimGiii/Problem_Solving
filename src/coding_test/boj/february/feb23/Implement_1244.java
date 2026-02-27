package coding_test.boj.february.feb23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Implement_1244 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        /*
         * 스위치는 켜져 있거나 꺼져 있는 상태, 1은 스위치가 켜져 있음을 0은 스위치가 꺼져 있음을 나타낸다.
         * 학생중 몇 명을
         * 남학생은 자기가 받은 수의 배수에 해당하는 모든 스위치의 상태를 바꾼다.
         * 여학생은 자기가 받은 수를 중심으로 대칭을 이루는 최대 구간의 모든 스위치의 상태를 바꾼다.
         */
        int switchNum = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] switchStatus = new int[switchNum];
        for (int i = 0; i < switchNum; i++) {
            switchStatus[i] = Integer.parseInt(st.nextToken());
        }

        int studentNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int gotSwitch = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int j = 0; j < switchNum; j++) {
                    if ((j + 1) % gotSwitch == 0) {
                        if (switchStatus[j] == 0) {
                            switchStatus[j] = 1;
                        } else {
                            switchStatus[j] = 0;
                        }
                    }
                }
            } else {
                int center = gotSwitch - 1;

                switchStatus[center] = 1 - switchStatus[center];

                int left = center - 1;
                int right = center + 1;

                while (left >= 0 && right < switchNum && switchStatus[left] == switchStatus[right]) {
                    switchStatus[left] = 1 - switchStatus[left];
                    switchStatus[right] = 1 - switchStatus[right];

                    left--;
                    right++;
                }
            }
        }

        for (int i = 0; i < switchNum; i++) {
            sb.append(switchStatus[i]);

            if (i < switchNum - 1) {
                if ((i + 1) % 20 == 0) {
                    sb.append("\n");
                } else {
                    sb.append(" ");
                }
            }
        }

        System.out.println(sb.toString());

    }
}
