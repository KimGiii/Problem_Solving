package coding_test.boj.february.feb10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DataStructure_25757 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        String gameType = st.nextToken();
        
        Map<String, Integer> gamePlayerCount = new HashMap<>();
        gamePlayerCount.put("Y", 1);
        gamePlayerCount.put("F", 2);
        gamePlayerCount.put("O", 3);

        Set<String> participants = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String participant = br.readLine();
            participants.add(participant);
        }

        switch (gameType) {
            case "Y":
            case "F":
            case "O":
                answer = participants.size() / gamePlayerCount.get(gameType);
                break;
            default:
                break;
        }

        System.out.println(answer);

    }
}
