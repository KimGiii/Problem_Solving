package coding_test.boj.march.mar03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * 백준 9017 : 크로스 컨트리
 *
 * 알고리즘 : Implementation
 */

public class Impl_9017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCases = parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            int playerCount = parseInt(br.readLine());
            int[] completedOrder = new int[playerCount];
            int[] teamSize = new int[1001]; // 팀별 인원수 확인

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < playerCount; j++) {
                int teamId = parseInt(st.nextToken());
                completedOrder[j] = teamId;
                teamSize[teamId]++;
            }

            int[] scoreSum = new int[1001];    // 상위 4명 점수 합
            int[] fifthRank = new int[1001];   // 5번째 주자의 점수
            int[] memberCount = new int[1001]; // 현재까지 합산된 팀원 수

            int rank = 1;
            for (int teamId : completedOrder) {
                // 6명이 참가한 팀만 점수 계산
                if (teamSize[teamId] == 6) {
                    memberCount[teamId]++;

                    // 상위 4명까지만 점수 합산
                    if (memberCount[teamId] <= 4) {
                        scoreSum[teamId] += rank;
                    }
                    // 5번째 주자의 점수 기록
                    else if (memberCount[teamId] == 5) {
                        fifthRank[teamId] = rank;
                    }

                    // 실질적인 등수 기록
                    rank++; 
                }
            }

            int minScore = Integer.MAX_VALUE;
            int minFifth = Integer.MAX_VALUE;
            int winner = -1;

            for (int j = 1; j <= 1000; j++) {
                // 6명이 다 찬 팀만 후보
                if (teamSize[j] == 6) {
                    if (scoreSum[j] < minScore) {
                        minScore = scoreSum[j];
                        minFifth = fifthRank[j];
                        winner = j;
                    } else if (scoreSum[j] == minScore) {
                        if (fifthRank[j] < minFifth) {
                            minFifth = fifthRank[j];
                            winner = j;
                        }
                    }
                }
            }
            sb.append(winner).append("\n");
        }
        System.out.print(sb);
    }
}
