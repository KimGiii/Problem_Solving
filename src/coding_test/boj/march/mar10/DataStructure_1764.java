package coding_test.boj.march.mar10;

import java.io.*;
import java.util.*;

public class DataStructure_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 1. 듣도 못한 사람을 HashSet에 저장 (검색 속도 O(1))
        HashSet<String> unheardSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            unheardSet.add(br.readLine());
        }

        // 2. 보도 못한 사람을 입력받으며 교집합 확인
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String unseenName = br.readLine();
            if (unheardSet.contains(unseenName)) {
                result.add(unseenName);
            }
        }

        // 3. 사전순 정렬
        Collections.sort(result);

        // 4. 결과 출력 (수 + 명단)
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (String name : result) {
            sb.append(name).append("\n");
        }

        System.out.print(sb);
    }
}
